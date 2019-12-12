import groovy.json.JsonSlurper

folder('POC') {
    description('Folder containing all jobs for folder-a')
}

def jsn = new JsonSlurper().parseText("${ntbfile}")
def imprt = jsn.cells.findAll{ it.metadata.tags.contains('imports')}
out.println(imprt)
def imprt1 = jsn.get('cells').findAll{ it.metadata.tags.contains('imports')}
out.println(imprt1)
