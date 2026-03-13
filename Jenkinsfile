pipeline {
    agent any

    tools {
        maven 'Maven'
    }

    environment {
        SONAR_HOST_URL = "http://localhost:9000"
        SONAR_PROJECT_KEY = "springboot-ci-project"
    }

    stages {

        stage('Build Project') {
            steps {
                bat 'mvn clean install'
            }
        }

        stage('Run Tests') {
            steps {
                bat 'mvn test'
            }
        }

        stage('SonarQube Analysis') {
            steps {
                withSonarQubeEnv('SonarQube') {
                    bat 'mvn sonar:sonar'
                }
            }
        }

        stage('Docker Build') {
            steps {
                bat 'docker build -t springboot-ci-app .'
            }
        }

    }

    post {
        success {
            echo 'Pipeline completed successfully'
        }
        failure {
            echo 'Pipeline failed'
        }
    }
}
