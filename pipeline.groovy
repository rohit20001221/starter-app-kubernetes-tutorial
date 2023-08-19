pipeline {
    agent any
    
    stages {
        stage('Pull Repository') {
            steps {
                git credentialsId: 'GIT_HUB_CREDENTIAL', url: 'https://github.com/rohit20001221/starter-app-kubernetes-tutorial.git'
            }
        }
    
        stage('Run Unit Tests') {
            steps {
                sh '''python3 -m unittest'''
            }
        }
        
        stage('echo User') {
            steps {
                sh "echo $USER"
            }
        }
        
        stage('Build the Docker file.') {
            steps {
                sh "./build-docker.sh"    
            }
        }
        
        stage('Docker Hub Login') {
            steps {
                withCredentials([string(credentialsId: 'DOCKER_HUB_PASSWORD', variable: 'PASSWORD')]) {
                    sh 'docker login -u rohit20001221 -p $PASSWORD'
                }
            }
        }
        
        stage('Push the image to Docker hub') {
            steps {
                sh 'docker push rohit20001221/flask-starter'
            }
        }
        
        stage('Deploy') {
            steps {
                withCredentials([string(credentialsId: 'AWS_ACCESS_KEY_ID', variable: 'AWS_ACCESS_KEY_ID'), string(credentialsId: 'AWS_SECRET_ACCESS_KEY', variable: 'AWS_SECRET_ACCESS_KEY')]) {
                    sh 'kubectl apply -f ./k8s/flask-starter.yaml'        
                }
            }
        }
    }
}