pipeline {
    agent any
    
    options{
        timestamps()
    }
    parameters {
        choice(name: 'VERSION', choices: ['1.1.0', '1.2.0', '1.3.0'], description: '')
        booleanParam(name: 'executeTests', defaultValue: true, description: '')
    }
    stages{
        stage('build') {
            steps {
                
                echo 'build'
                cd src
                
                // mvn clean install
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
                mvn test
            }
        }
        stage('deploy') {
            steps {
                echo 'deploy'
                echo "deployng version ${params.VERSION}"
             }
        }
stage('Reports') {
        steps {
           allure([
      	   includeProperties: false,
      	   jdk: '',
      	   properties: [],
      	   reportBuildPolicy: 'ALWAYS',
      	   results: [[path: 'report']]
    	   ])
  	        }
        }


        
    }

}
