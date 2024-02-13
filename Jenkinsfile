pipeline {
    agent any
    parameters {
        choice(name: 'VERSION', choices: ['1.1.0', '1.2.0', '1.3.0'], description: '')
        booleanParam(name: 'executeTests', defaultValue: true, description: '')
    }
    stages{
        stage('build') {
            steps {
                echo 'build'
                sh 'mvn -B clean package'
            }
        }
        stage(test){
            when {
                expression {
                    params.executeTests
                }
            }
            steps {
                echo 'testing'
                sh 'make check || true'
                sh 'mvn:test'
                
            }
        }
        stage('deploy') {
            steps {
                echo 'deploy'
                echo "deployng version ${params.VERSION}"
            }
        }
    }
}
