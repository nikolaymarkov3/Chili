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
                sh 'mvn'
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
                build job: '/QA/TestJob',
					parameters: [
						string(name: 'threadsCount', value: threadsCount),
						string(name: 'runId', value: runId),
						string(name: 'testList', value: testList)]
                
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
