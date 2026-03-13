pipeline {
    agent any

    tools {
        maven 'Maven'
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

    }
}