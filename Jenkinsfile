
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

        stage('Complete') {
            steps {
                echo 'DevPath build completed successfully!'
            }
        }
    }
}
