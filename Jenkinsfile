pipeline {
    // run on any agent
    agent { any }
    stages {
        stage('Build with Unit Testing') {
            // run the mvn package command to ensure build the app and run the unit tests
            steps {
                echo "building and testing..."
            }
        }
        stage('Static Analysis') {
            // run the mvn checkstyle:checkstyle command to run the static analysis. Can be
            // done in parallel to the Build and Unit Testing step.
            steps {
                echo "static analysis..."
            }
        }
        stage('Integration Tests') {
            // run the mvn -Dtest HelloIT verify -Durl 'http://192.168.33.14' -Dport="8888" -Dpkg="safebear"
            // tests to ensure that the rest API is working ok
            steps {
                echo "integration tests"
            }

        }
        stage('BDD Requirements Testing') {
            // run the mvn -Dtest RunCukesTestIT verify -Durl 'http://192.168.33.14' -Dport="8888" -Dpkg="safebear"
            // tests to ensure that the app meets the requirements
            steps {
                echo "BDD cucumber tests"
            }

        }
        stage('Deploy to Production') {
            // must be a manual step
            // deploys to the 9999 environment.
            steps {
                echo "Deploying to production"
            }

        }
    }
}