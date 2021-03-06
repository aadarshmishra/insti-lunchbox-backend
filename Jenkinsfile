pipeline {
    agent any

    stages {
        stage('Git Pull') {
            steps {
                git branch: 'main', credentialsId: 'git-creds', url: 'https://github.com/aadarshmishra/insti-lunchbox-backend.git'
            }
        }
        stage('Build') {
            steps {
                sh "mvn clean install"
            }
        }
        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }

        stage('Prune Docker Data') {
            steps{
                 sh 'docker system prune -a --volumes -f'
            }
        }
        stage('Build Docker-Compose Image') {
            steps {
                sh 'docker build -t insti-lunchbox-backend_app .' 
            }
        }

        stage('Push Docker Image') {
            steps {
                withCredentials([usernamePassword(credentialsId: 'docker-hub', passwordVariable: 'dockerHubPassword', usernameVariable: 'dockerHubUser')]) {
                    sh "docker login -u ${env.dockerHubUser} -p ${env.dockerHubPassword}"
                    sh "docker tag insti-lunchbox-backend_app aadarsh96/insti-lunchbox-backend:latest"
                    sh 'docker push aadarsh96/insti-lunchbox-backend:latest'
                }
            }
        }
        stage('Ansible Pull and Run Docker Image') {
            steps {
                ansiblePlaybook becomeUser: null, colorized: true, disableHostKeyChecking: true, inventory: 'inventory', playbook: 'deploy-img.yml', sudoUser: null
            }
        }
    }
}
