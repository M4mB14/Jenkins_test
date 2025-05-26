pipeline {
    agent any

    stages {
        stage('Клонирование репозитория') {
            steps {
                // Явно указываем ветку main
                git branch: 'main', url: 'https://github.com/M4mB14/Jenkins_test'
            }
        }

        stage('Выполнение на удалённой машине') {
            steps {
                sshPublisher(
                    publishers: [
                        sshPublisherDesc(
                            configName: 'Jenkins-agent-1', // Имя SSH-конфига
                            transfers: [
                                sshTransfer(
                                    sourceFiles: 'script.sh',
                                    removePrefix: '',
                                    remoteDirectory: '.',
                                    execCommand: 'pwd && ls -la && chmod +x script.sh && ./script.sh'
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
