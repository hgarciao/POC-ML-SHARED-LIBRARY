import groovy.json.JsonSlurper

folder('POC') {
    description('Folder containing all jobs for folder-a')
}

def jsn = new JsonSlurper().parseText("${ntbfile}")
def imports = []
def parameters = []
def preproc = []
def preproc_test = []
def trainning = []
def trainning_test = []
def results = []

def imprt = jsn.cells.each{ 
    if(it.metadata.tags){
        if( it.metadata.tags.contains('imports')) {
            imports = imports << it
        }else if(it.metadata.tags.contains('parameters')){
            parameters = parameters << it
        }else if(it.metadata.tags.contains('preproc')){
            if(it.metadata.tags.contains('test')){
                preproc_test = preproc_test << it
            }else{
                preproc = preproc << it
            }
        }else if(it.metadata.tags.contains('trainning')){
            if(it.metadata.tags.contains('test')){
                trainning_test = trainning_test << it
            }else{
                trainning = trainning << it
            }
        }else if(it.metadata.tags.contains('results')){
                results = results << it
        }
    }
}

pipelineJob('POC/job-name') {
  definition {
    cps {
      script('''
        pipeline {
            agent any
                stages {
                    stage('Stage 1') {
                        steps {
                            echo ${branch}
                        }
                    }
                    stage('Stage 2') {
                        steps {
                            echo 'logic'
                        }
                    }
                }
            }
        }
      '''.stripIndent())
      sandbox()     
    }
  }
}

