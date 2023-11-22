pipeline {
    agent none
    // 多阶段
    stages {
        // 第一步：使用Git更新或者下载代码
        stage('GetCode') {
            // 使用Docker部署Git获取代码
            agent {
                docker {
                    image 'git'
                }
            }
            // 如果已经有项目，那就更新，如果没有，那就克隆
            steps {
                sh 'if [ -d "AutomateDeploymentTest" ];  then cd AutomateDeploymentTest && git pull && git checkout master; else git clone https://github.com/SurryChen/AutomateDeploymentTest.git && git checkout master; fi'
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
                sh 'cd AutomateDeploymentTest && mvn -DskipTests clean package'
            }
        }
        // 第三步，使用JDK运行项目
        stage('Deploy') {
            agent {
                docker {
                    image 'openjdk:11'
                }
            }
            steps {
                sh 'cd AutomateDeploymentTest && java -jar /target/auto.jar'
            }
        }
    }
}