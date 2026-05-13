def sonarqubeScan(String projectKey, String projectName) {
    echo "Running SonarQube scan for project: ${projectName} with key: ${projectKey}..."
    sh "exit 0" // Or exit 1 to breake the pipeline
    // Mock SonarQube scan logic here
}