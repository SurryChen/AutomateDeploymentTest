pipeline {
    agent any
    // 多阶段
    stages {
        // 第一步：使用Git更新或者下载代码
        stage('GetCode') {
            steps {
                git branch: 'master', url: 'https://github.com/yourusername/yourrepository.git'
            }
        }
        // 第二步，使用Maven编译项目
        stage('Build') {
            agent {
                docker {
                    image 'maven:3-alpine'
                    // 把容器中的本地仓库挂载到宿主机，这样，每次启动Maven镜像就不需要重新加载依赖文件了
                    args '-v /root/.m2:/root/.m2'
                }
            }
            steps {
                sh 'mvn -DskipTests clean package'
            }
        }
        // 第三步，使用JDK运行项目
        stage('Deploy') {
            steps {
                sh 'java -jar /target/auto.jar'
            }
        }
    }
}