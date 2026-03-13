pipeline {
agent any

```
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
                bat 'mvn sonar:sonar -Dsonar.projectKey=%SONAR_PROJECT_KEY% -Dsonar.host.url=%SONAR_HOST_URL%'
            }
        }
    }

}

post {
    success {
        echo 'Build and SonarQube analysis completed successfully!'
    }
    failure {
        echo 'Pipeline failed. Check Jenkins console output.'
    }
}
```

}
