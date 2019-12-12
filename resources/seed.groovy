import groovy.json.JsonSlurper

folder('POC') {
    description('Folder containing all jobs for folder-a')
}

def json = new JsonSlurper().parseText("${ntbfile}")
def imprt = json.cells.findAll{ it.metadata.tags.contains('imports')}
out.println(imprt)
