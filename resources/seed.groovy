import groovy.json.JsonSlurper

folder('POC') {
    description('Folder containing all jobs for folder-a')
}

def string = readFileFromWorkspace("${ntbfile}")
def json = new JsonSlurper().parseText(string)
