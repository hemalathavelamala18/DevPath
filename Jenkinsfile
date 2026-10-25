
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
                bat 'docker build -t devpath-app .'
            }
        }

        stage('Complete') {
            steps {
                echo 'DevPath build and Docker image completed successfully!'
            }
        }
    }
}
