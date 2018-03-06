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
                bat'mvn clean package'
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
                echo "static analysis..."
            }
        }
        stage('Integration Tests') {
            /* run the mvn -Dtest HelloIT verify -Durl 'http://192.168.33.14' -Dport="8888" -Dpkg="safebear"
            tests to ensure that the rest API is working ok */
            steps {
                echo "integration tests"
            }

        }
        stage('BDD Requirements Testing') {
            /* run the mvn -Dtest RunCukesTestIT verify -Durl 'http://192.168.33.14' -Dport="8888" -Dpkg="safebear"
            tests to ensure that the app meets the requirements */
            steps {
                echo "BDD cucumber tests"
            }

        }
        stage('Deploy to Production') {
            /* must be a manual step
            deploys to the 9999 environment. */
            steps {
                echo "Deploying to production"
            }

        }
    }
}