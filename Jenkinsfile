pipeline {
  agent any

  tools {
    jdk 'jdk17'
    maven 'maven'
  }

  stages {
    stage('Checkout') {
      steps {
        checkout scm
      }
    }

    stage('Build with Maven') {
      steps {
        sh 'mvn clean package -DskipTests'
      }
    }

    stage('Build Docker Image') {
      steps {
        sh 'docker build -t userservice-user-service .'
      }
    }

    stage('Test Git Clone') {
      steps {
        sh 'git clone https://github.com/xuefenghan1987/user-service.git'
      }
    }


    stage('Restart Container') {
      steps {
        // 停掉旧容器（如果存在）
        sh 'docker stop user-service || true'
        sh 'docker rm user-service || true'

        // 启动新容器
        sh 'docker run -d --name user-service -p 8082:8080 userservice-user-service'
      }
    }
  }
}
