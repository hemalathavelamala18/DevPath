
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
                bat 'call mvnw.cmd clean package'
            }
        }

        stage('Docker Build') {
            steps {
                bat '"C:\\Users\\hemal\\AppData\\Local\\Programs\\DockerDesktop\\resources\\bin\\docker.exe" build -t devpath-app .'
            }
        }

        stage('Deploy') {
            steps {
                bat '"C:\\Users\\hemal\\AppData\\Local\\Programs\\DockerDesktop\\resources\\bin\\docker.exe" rm -f devpath-jenkins-deploy'
                bat '"C:\\Users\\hemal\\AppData\\Local\\Programs\\DockerDesktop\\resources\\bin\\docker.exe" run -d --name devpath-jenkins-deploy -p 8083:8081 devpath-app:latest'
            }
        }

        stage('Complete') {
            steps {
                echo 'DevPath build, Docker image, and deployment completed!'
            }
        }
    }
}
