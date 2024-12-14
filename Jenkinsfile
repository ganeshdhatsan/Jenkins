pipeline {
    agent any

    environment {
        REGION = ''
        ENVIRONMENT = ''
        TEST_TAG = ''
        TEST_REPORT_DIR = 'target/cucumber-reports'
        MAVEN_CMD = 'mvn'
    }

    parameters {
        choice(name: 'REGION', choices: ['Canada', 'Europe'], description: 'Select the region to run tests')
        choice(name: 'ENVIRONMENT', choices: ['dev', 'test', 'uat'], description: 'Select the environment to run tests')
        string(name: 'TEST_TAG', defaultValue: '@Smoke', description: 'Cucumber tag to execute specific tests (e.g., @Smoke, @Regression)')
    }

    options {
        timeout(time: 45, unit: 'MINUTES')
        timestamps()
    }

    stages {
        stage('Checkout Code') {
            steps {
                echo 'Checking out code from repository...'
                git branch: 'Main', url: 'https://github.com/ganeshdhatsan/Jenkins.git'
            }
        }

        stage('Setup Environment') {
            steps {
                echo 'Setting up environment...'
                sh '''
                    java -version || { echo "Java is not installed"; exit 1; }
                    ${MAVEN_CMD} --version || { echo "Maven is not installed"; exit 1; }
                '''
            }
        }

        stage('Run Tests') {
            steps {
                echo "Running tests for REGION=${params.REGION} and ENVIRONMENT=${params.ENVIRONMENT} with TAG=${params.TEST_TAG}"
                sh """
                    ${MAVEN_CMD} test \
                        -Denv=${params.ENVIRONMENT} \
                        -Dregion=${params.REGION} \
                        -Dcucumber.filter.tags=${params.TEST_TAG} \
                        -Dsurefire.suiteXmlFiles=src//test//resources//TestRunnerTestng.xml
                """
            }
        }

        stage('Generate Cucumber Report') {
            steps {
                echo 'Generating Cucumber HTML Reports...'
                sh """
                    ${MAVEN_CMD} cucumber-report:generate
                """
            }
        }

        stage('Publish Test Results') {
            steps {
                echo 'Publishing test results...'
                junit '**/target/cucumber-reports/TEST-*.xml'
            }
        }
      
        stage('Archive Artifacts') {
            steps {
                echo 'Archiving test reports and logs...'
                archiveArtifacts artifacts: "${TEST_REPORT_DIR}/**", allowEmptyArchive: true
            }
        }
    }

    post {
        always {
            echo 'Cleaning up workspace...'
            cleanWs()
        }
        success {
            echo 'Pipeline completed successfully!'
        }
        failure {
            echo 'Pipeline failed. Sending failure notification...'
                   }
    }
}
