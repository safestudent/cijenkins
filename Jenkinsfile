pipeline {
    /* A Declarative Pipeline
    * The agent keyword could be included in the Stages also so different stages
    * are run on different stages
    * */

    //run on any agent
    agent any

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
            }
        }
        stage('Static Analysis') {
            /* run the mvn checkstyle:checkstyle command to run the static analysis. Can be
            done in parallel to the Build and Unit Testing step. */
            steps {
                bat 'mvn checkstyle:checkstyle'
            }
        }
        stage('Deploy to Test') {
            /* Deploy to the test environment so we can run our integration and BDD tests */
            steps {
                // This would be if you had the deploy job configured in Jenkins and weren't fully automating the
                build job: 'deploy-to-staging'
            }
        }

        stage('Integration Tests') {
            /* run the mvn -Dtest=HelloIT verify -Durl=http://192.168.33.14" -Dport="8888" -Dpkg="safebear"
            tests to ensure that the rest API is working ok */
            steps {
                bat 'mvn -Dtest=HelloIT verify -Durl="http://192.168.33.14" -Dport="8888" -Dpkg="safebear"'
            }

        }
        stage('BDD Requirements Testing') {
            /* run the mvn -Dtest RunCukesTestIT verify -Durl="http://192.168.33.14" -Dport="8888" -Dpkg="safebear"
            tests to ensure that the app meets the requirements */
            steps {
                bat 'mvn -Dtest=RunCukesTestIT verify -Durl="http://192.168.33.14" -Dport="8888" -Dpkg="safebear"'
            }

        }
        stage('Deploy to Production') {
            /* must be a manual step
            deploys to the 9999 environment. */
            steps {
                timeout(time: 5, unit: 'DAYS') {
                    input message: 'Approve PRODUCTION deployment?', submitter: 'student'
                }

                build job: 'deploy-to-prod'
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