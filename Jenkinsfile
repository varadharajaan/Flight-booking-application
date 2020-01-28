node {
    stage('Configure') {
        env.PATH = "${tool 'maven-3.5.0'}/bin:${env.PATH}"
        env.PATH = "${tool 'docker-latest'}/bin:${env.PATH}"
        version = '1.0.' + env.BUILD_NUMBER
        currentBuild.displayName = version

        properties([
                buildDiscarder(logRotator(artifactDaysToKeepStr: '', artifactNumToKeepStr: '', daysToKeepStr: '', numToKeepStr: '10')),
                disableConcurrentBuilds(), [$class: 'GithubProjectProperty', displayName: '',
                projectUrlStr: 'https://github.com/varadharajaan/inviagroup-flightbooking.git/'],
                pipelineTriggers([githubPush()])])
    }

    stage('Checkout'){
        checkout scm
    }

    stage('Docker') {
        sh 'mvn clean package docker:build'
    }
}