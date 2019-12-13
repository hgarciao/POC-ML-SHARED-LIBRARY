pipeline {
    agent any

    environment {
        REPO = repository
    }

    parameters {
        choice name: "ENVIRONMENT", choices: environments
    }

    stages {
        stage('Deploy') {
            steps {
                echo "Deploying ${env.REPO} to ${params.ENVIRONMENT}..."
            }
        }
    }
}
