pipeline {
    agent any
    tools { 
      maven 'Apache Maven 3.9.6' 
      jdk 'jdk20' 
    }
    stages {
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
