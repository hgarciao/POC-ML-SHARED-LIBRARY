import groovy.json.JsonSlurper

folder('POC') {
    description('Folder containing all jobs for folder-a')
}
def json = new JsonSlurper().parseText("${ntbfile")
