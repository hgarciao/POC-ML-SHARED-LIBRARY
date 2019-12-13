folder("${project}") {
    description('Folder containing all jobs for folder-a')
}

pipelineJob("${project}/pipeline") {
  definition {
    cps {
      script('''
        pipeline {
            agent any
                stages {
                    stage('Stage 1') {
                        steps {
                            sh 'ls'
                            script{
                                ntbfile = readFile("./ntbs/POC_COMPLETO.ipynb") 
                                /*for (int i = 0; i < 3; i++) {
                                    stage("Test ${i}") {
                                        sh "echo ${i}"
                                    }
                                }*/
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
