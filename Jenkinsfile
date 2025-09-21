pipeline {
    agent any

    environment {
        REPO_URL = 'https://github.com/Xofty1/testDocker.git'
        BRANCH   = 'main'
    }

    stages {
        stage('Checkout') {
            steps {
                echo 'Клонирование исходного кода из GitHub...'
                git branch: "${BRANCH}", url: "${REPO_URL}"
            }
        }

        stage('Build') {
            steps {
                echo 'Сборка Kotlin проекта...'
                sh './gradlew clean build -x test'
            }
        }

        stage('Test') {
            steps {
                echo 'Запуск тестов...'
                sh './gradlew test'
                junit 'build/test-results/test/*.xml'
            }
        }

        stage('Archive Artifacts') {
            steps {
                echo 'Архивация артефактов...'
                archiveArtifacts artifacts: 'build/libs/*.jar', fingerprint: true
            }
        }

        stage('Deploy (Mock)') {
            steps {
                echo 'Эмуляция деплоя: копирование jar в папку deploy/'
                sh '''
                    mkdir -p deploy
                    cp build/libs/*.jar deploy/ || true
                '''
            }
        }
    }

    post {
        success {
            echo 'Сборка и деплой успешно завершены ✅'
        }
        failure {
            echo 'Сборка завершилась с ошибкой ❌'
        }
    }
}