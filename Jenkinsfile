pipeline {
    agent any

    stages {
     stage('Compile') {
            steps {
                sh 'mvn compile'
            }
            post {
                failure {
                    script {
                        currentBuild.result = 'FAILURE'
                        sh 'pkill -f "mvn compile"'
                    }
                }
            }
        }
        stage('Build') {
            steps {
                sh 'mvn -B -DskipTests clean package'
            }
        }
        stage('Test') { 
            steps {
                sh 'mvn test' 
            }
        }
    }
}
