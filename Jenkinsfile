pipeline {
    /* A Declarative Pipeline
    * The agent keyword could be included in the Stages also so different stages
    * are run on different stages
    * */

    //run on any agent
    agent any

    parameters {

        // test environment
        string(name: 'test_hostname', defaultValue: '192.168.33.14', description: 'hostname of the test environment')
        string(name: 'test_port', defaultValue: '8888', description: 'port of the test environment')
        string(name: 'test_username', defaultValue: 'tomcat', description: 'username of the test environment')
        string(name: 'test_password', defaultValue: 'tomcat', description: 'password of the test environment')

        // prod environment
        string(name: 'prod_hostname', defaultValue: '192.168.33.14', description: 'hostname of the test environment')
        string(name: 'prod_port', defaultValue: '9999', description: 'hostname of the test environment')
        string(name: 'prod_username', defaultValue: 'tomcat', description: 'hostname of the test environment')
        string(name: 'prod_password', defaultValue: 'tomcat', description: 'hostname of the test environment')
    }

    triggers {
        pollSCM('* * * * *')
    }

    // Pipeline stages
    stages {
        stage('Build with Unit Testing') {
            /* run the mvn package command to ensure build the app and run the unit  */
            steps {
                bat 'mvn clean package'
            }
            post {
                /* only run if the last step succeeds */
                success {
                    // print a message to screen that we're archiving
                    echo 'Now Archiving...'
                    // archive the artifacts so we can build once and then use them later to deploy
                    archiveArtifacts artifacts: '**/target/*.war'
                }

                always {
                    junit "**/target/surefire-reports/*.xml"
                }
            }
        }
        stage('Deploy to Test and Static Analysis') {
            parallel {
                stage('Static Analysis') {
                    /* run the mvn checkstyle:checkstyle command to run the static analysis. Can be
                    done in parallel to the Build and Unit Testing step. */
                    steps {
                        bat 'mvn checkstyle:checkstyle'
                    }
                    post {
                        success {
                            checkstyle canComputeNew: false, defaultEncoding: '', healthy: '', pattern: '', unHealthy: ''
                        }
                    }
                }
                stage('Deploy to Test') {
                    /* Deploy to the test environment so we can run our integration and BDD tests */
                    steps {
                        // This would be if you had the deploy job configured in Jenkins and weren't fully automating the
                        // build job: 'deploy-to-staging'

                        // deploy using the cargo plugin in the pom.xml maven file - see the profiles for details
                        bat "mvn cargo:redeploy -Dcargo.hostname=\"${params.test_hostname}\" -Dcargo.servlet.port=\"${params.test_port}\" -Dcargo.username=\"${params.test_username}\" -Dcargo.password=\"${params.test_password}\""
                    }
                }
            }
        }
        stage('Integration Tests') {
            /* run the mvn -Dtest=HelloIT verify -Durl=http://192.168.33.14" -Dport="8888" -Dpkg="safebear"
            tests to ensure that the rest API is working ok */
            steps {
                        bat 'mvn -Dtest=HelloIT verify -Durl="http://192.168.33.14" -Dport="8888" -Dpkg="safebear"'
            }
            post {
                always {
                    junit "**/target/failsafe-reports/*.xml"
                }
            }
        }
        stage('BDD Requirements Testing') {
            /* run the mvn -Dtest RunCukesTestIT verify -Durl="http://192.168.33.14" -Dport="8888" -Dpkg="safebear"
            tests to ensure that the app meets the requirements */
            steps {
                bat 'mvn -Dtest=RunCukesTestIT verify -Durl="http://192.168.33.14" -Dport="8888" -Dpkg="safebear"'
            }
            post {
                always {
                    publishHTML([
                            allowMissing         : false,
                            alwaysLinkToLastBuild: false,
                            keepAll              : false,
                            reportDir            : 'target/cucumber',
                            reportFiles          : 'index.html',
                            reportName           : 'BDD Report',
                            reportTitles         : ''])
                }
            }
        }
        stage('Deploy to Production') {
            /* must be a manual step
            deploys to the 9999 environment. */
            steps {

                timeout(time: 5, unit: 'DAYS') {
                    input message: 'Approve PRODUCTION deployment?', submitter: 'student'
                }

                // Deploy using jenkins project
                //build job: 'deploy-to-prod'

                // deploy using the cargo plugin in the pom.xml maven file - see the profiles for details
                bat "mvn cargo:redeploy -Dcargo.hostname=\"${params.prod_hostname}\" -Dcargo.servlet.port=\"${params.prod_port}\" -Dcargo.username=\"${params.prod_username}\" -Dcargo.password=\"${params.prod_password}\""
            }
            post {
                success {
                    echo 'Code deployed to Production'
                }
                failure {
                    echo "Deployment failed"
                }
            }

        }
    }
}