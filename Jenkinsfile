def version, helm_version, env_name, postgre_url, postgre_helm_release, shortCommitId

pipeline {
    agent any
    stages {
        stage('Clone repository') {
            steps {
                checkout scm
            }
        }

        stage('Pull images') {
            steps {
                script {
                    docker.withRegistry('https://dc2.srvhub.tools', 'docker-registry-shb-deploy-credentials-id') {
                        docker.image('dc2.srvhub.tools/shb/openjdk:11.0-jdk-slim').pull()
                    }
                }
            }
        }

        stage('Test and Build') {
            stage('Real build on postgres') {
                agent {
                    docker {
                        image 'dc2.srvhub.tools/shb/openjdk:11.0-jdk-slim'
                        args '-e JAVA_HOME=/usr/local/openjdk-11'
                    }
                }
                steps {
                    script {
                        try {
                            sh "./gradlew test "
                        } finally {
                            // Собираем результаты тестов
                            junit '**/build/test-results/test/*.xml'
                        }
                    }
                }
            }
        }
    }
}