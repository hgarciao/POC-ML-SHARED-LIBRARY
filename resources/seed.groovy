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

def imprt = jsn.cells.each{ 
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
            preproc = preproc << it
        }
    }
}

out.println(imports)
out.println(parameters)
out.println(preproc)
out.println(preproc_test)
out.println(trainning)
out.println(trainning_test)
