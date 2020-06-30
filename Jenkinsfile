node {
 

        stage('Checkout') {
            git url: 'https://github.com/rahulishu/project-manager-fsd-api.git',  branch: 'master'
        }

        stage('Build') {
            sh 'mvn clean install'

            def pom = readMavenPom file:'pom.xml'
            print pom.version
            env.version = pom.version
        }

        /* stage('Image') {
            dir ('project-manager-fsd-api') {
                def app = docker.build "project-manager-fsd-api:${env.version}"
                app.push()
            }
        }

        stage ('Run') {
            docker.image("project-manager-fsd-api:${env.version}").run('-p 8081:8081 -h project-manager-fsd-api --name project-manager-fsd-api')
        }
		*/
    

}
