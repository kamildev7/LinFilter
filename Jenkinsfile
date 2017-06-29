node {
    def mvnHome
    stage('Preparation') {
        git 'https://github.com/kamildev7/LinFilter'
        withCredentials([string(credentialsId: 'LinFIlter-appId', variable: 'APP_ID'), string(credentialsId: 'LinFilter-appSecret', variable: 'APP_SECRET')]) {
            if (isUnix()) {
                sh 'echo spring.social.facebook.appId=$APP_ID >> src/main/resources/application.properties'
                sh 'echo spring.social.facebook.appSecret=$APP_SECRET >> src/main/resources/application.properties'
            } else {
                bat 'echo spring.social.facebook.appId=$APP_ID >> src/main/resources/application.properties'
                bat 'echo spring.social.facebook.appSecret=$APP_SECRET >> src/main/resources/application.properties'
            }
        }
        mvnHome = tool 'M3'
    }
    stage('Package') {
        if (isUnix()) {
         sh "'${mvnHome}/bin/mvn' -DskipTests clean package"
        } else {
            bat '\'${mvnHome}/bin/mvn\' -DskipTests clean package'
        }
    }
    stage('Docker Image') {
        docker.build("tai/linfilter-pipeline:${env.BUILD_NUMBER}")
    }
    stage('Run App') {
        if (isUnix()) {
           sh "docker run -p 8080:8080 tai/linfilter-pipeline:${env.BUILD_NUMBER}"
        } else {
            bat 'docker run -p 8080:8080 tai/linfilter-pipeline:${env.BUILD_NUMBER}'
        }
    }
}