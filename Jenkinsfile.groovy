pipeline {
    agent any

    stages {
        stage('Клонирование репозитория') {
            steps {
                git branch: 'main', git 'https://github.com/M4mB14/Jenkins_test'
            }
        }

        stage('Выполнение на удалённой машине') {
            steps {
                sshPublisher(
                    publishers: [
                        sshPublisherDesc(
                            configName: 'Jenkins-agent-1', // Имя SSH-конфига, как ты настраивал ранее
                            transfers: [
                                sshTransfer(
                                    sourceFiles: 'script.sh',
                                    removePrefix: '',
                                    remoteDirectory: '/home/ubuntu/jenkins-deploy',
                                    execCommand: 'chmod +x script.sh && ./script.sh'
                                )
                            ],
                            usePromotionTimestamp: false,
                            verbose: true
                        )
                    ]
                )
            }
        }
    }
}
