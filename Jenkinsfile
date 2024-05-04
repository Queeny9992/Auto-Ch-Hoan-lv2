pipeline {
    agent any
    tools { 
      maven 'Apache Maven 3.9.6' 
     
    }
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
