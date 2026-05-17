def sonarqubeScan(String projectKey, String projectName) {
    echo "Running SonarQube scan for project: ${projectName} with key: ${projectKey}..."
    //sh "exit 0" // Or exit 1 to breake the pipeline
    // Mock SonarQube scan logic here
}

def sonarCreateProject(String projectKey) {
        withSonarQubeEnv('SonarQubeScanner') {
            echo "creating project..."
            sh """
                curl -s -u ${env.SONAR_TOKEN}: \
               -X POST "${env.SONAR_HOST_URL}/api/projects/create" \
               -d "project=${projectKey}&name=${projectKey}"
            """
            echo "created"
        }
}
 
def sonarLocalScan() {
    def scannerHome = tool 'SonarQubeScanner'
    withSonarQubeEnv('SonarQubeScanner') {
        echo "scanning..."
        sh """
            ${scannerHome}/bin/sonar-scanner \
            -Dsonar.projectKey=${env.JOB_NAME} \
            -Dsonar.projectName=${env.JOB_NAME} \
            -Dsonar.sources=. \
            -Dsonar.sourceEncoding=UTF-8
        """
        echo "scan complete"
    }
}
