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
                    bat 'mvn sonar:sonar -Dsonar.projectKey=springboot-ci-project -Dsonar.host.url=http://localhost:9000'
                }
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
