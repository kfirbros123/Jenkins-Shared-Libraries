def deploy(String name, String version) {
    echo "Now deploying the application: ${name}, version: ${version}..."
}

def pushToDockerHub(String name, String version) {
    echo "Pushing ${name}:${version} to Docker Hub..."
    // Mock push logic here
}