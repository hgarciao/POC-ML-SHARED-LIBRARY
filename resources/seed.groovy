folder("${project}") {
    description('Folder containing all jobs for folder-a')
}

pipelineJob('job-name') {
  definition {
    cps {
      script('''
        pipeline {
            agent any
                stages {
                    stage('Stage 1') {
                        steps {
                            script{
                                for (int i = 0; i < 3; i++) {
                                    stage("Test ${i}") {
                                        sh "echo ${i}"
                                    }
                                }
                            }
                        }
                    }
                    stage('Stage 2') {
                        steps {
                            echo 'logic'
                        }
                    }
                }
            }
      '''.stripIndent())
      sandbox()     
    }
  }
}
