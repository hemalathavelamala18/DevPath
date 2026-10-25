
pipeline {
    agent any

    stages {

        stage('Checkout') {
            steps {
                echo 'DevPath source code is ready.'
            }
        }

        stage('Build') {
            steps {
                bat 'call mvnw.cmd package'
            }
        }

        stage('Test') {
            steps {
                bat 'call mvnw.cmd test'
            }
        }

        stage('Docker Build') {
            steps {
                bat '"C:\\Users\\hemal\\AppData\\Local\\Programs\\DockerDesktop\\resources\\bin\\docker.exe" build -t devpath-app:latest .'
            }
        }

        stage('Deploy') {
            steps {
                bat '"C:\\Users\\hemal\\AppData\\Local\\Programs\\DockerDesktop\\resources\\bin\\docker.exe" rm -f devpath-jenkins-deploy'
                bat '"C:\\Users\\hemal\\AppData\\Local\\Programs\\DockerDesktop\\resources\\bin\\docker.exe" run -d --name devpath-jenkins-deploy -p 8083:8081 -v devpath-data:/app/data devpath-app:latest'
            }
        }

        stage('Verify Deployment') {
            steps {
                retry(10) {
                    sleep(time: 3, unit: 'SECONDS')

                    bat 'curl.exe --fail --silent --show-error http://localhost:8083/'

                    bat 'curl.exe --fail --silent --show-error http://localhost:8083/courses'

                    bat 'curl.exe --fail --silent --show-error "http://localhost:8083/progress?learner=Learner"'
                }
            }
        }

        stage('Complete') {
            steps {
                echo 'SUCCESS: DevPath built, tested, containerized, deployed, and verified.'
                echo 'The Docker volume devpath-data preserves database files across container replacements.'
            }
        }
    }
}
