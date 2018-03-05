pipeline {
  agent any
  stages {
    stage('Build with Unit Testing') {
      steps {
        echo 'building and testing...'
      }
    }
    stage('Static Analysis') {
      steps {
        echo 'static analysis...'
      }
    }
    stage('Integration Tests') {
      steps {
        echo 'integration tests'
      }
    }
    stage('BDD Requirements Testing') {
      steps {
        echo 'BDD cucumber tests'
      }
    }
    stage('Deploy to Production') {
      steps {
        echo 'Deploying to production'
      }
    }
  }
}