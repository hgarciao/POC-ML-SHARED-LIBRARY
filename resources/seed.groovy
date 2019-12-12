import groovy.json.JsonSlurper

folder('POC') {
    description('Folder containing all jobs for folder-a')
}

def jsn = new JsonSlurper().parseText("${ntbfile}")
def imprt = jsn.cells.findAll{ it.tags.contains('imports')}
out.println(imprt)
