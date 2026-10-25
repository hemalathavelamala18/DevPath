
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

        stage('Complete') {
            steps {
                echo 'DevPath build and Docker image completed successfully!'
            }
        }
    }
}
