import groovy.json.JsonSlurper

folder('POC') {
    description('Folder containing all jobs for folder-a')
}

def jsn = new JsonSlurper().parseText("${ntbfile}")
out.println(jsn.get('cells'))
out.println(jsn.get('cells').getClass())
out.println(jsn.cells)
/*def imprt = json.cells.findAll{ it.metadata.tags.contains('imports')}
out.println(imprt)*/
