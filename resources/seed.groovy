folder("${project}") {
    description('Folder containing all jobs for folder-a')
}

pipelineJob('job-name') {
  definition {
    cps {
      script(readFileFromWorkspace('pipeline.groovy'))
      sandbox()     
    }
  }
}
