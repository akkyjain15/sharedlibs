def clone(url){
 git branch: 'main', url: $url
}

def PlaybookExecution(){
 ansiblePlaybook credentialsId: 'assignment6-ssh', disableHostKeyChecking: true, installation: 'ansible1', inventory: 'inv', playbook: 'role_jenkins.yml'
}

def slackSend(String buildResult) {
  if ( buildResult == "SUCCESS" ) {
    slackSend channel: '#jenkinscicd',
    color: 'good',
    message: " *${currentBuild.currentResult}:* \n *Job_Name:* '${JOB_NAME}' \n *USER:* '${USER}' \n *Stage_Name:* ${STAGE_NAME} \n *Build_Number:* '${BUILD_NUMBER}' \n *More info at:* '${BUILD_URL}'",
    teamDomain: 'ninja-gjj9738', tokenCredentialId: 'slack'         
  }
  else if( buildResult == "FAILURE" ) { 
    slackSend channel: '#jenkinscicd',
    color: 'danger',
    message: " *${currentBuild.currentResult}:* \n *Job_Name:* '${JOB_NAME}' \n *USER:* '${USER}' \n *Stage_Name:* ${STAGE_NAME} \n *Build_Number:* '${BUILD_NUMBER}' \n *More info at:* '${BUILD_URL}'",
    teamDomain: 'ninja-gjj9738', tokenCredentialId: 'slack'      
  }
  else if( buildResult == "UNSTABLE" ) { 
    slackSend channel: '#jenkinscicd',
    color: 'warining',
    message: " *${currentBuild.currentResult}:* \n *Job_Name:* '${JOB_NAME}' \n *USER:* '${USER}' \n *Stage_Name:* ${STAGE_NAME} \n *Build_Number:* '${BUILD_NUMBER}' \n *More info at:* '${BUILD_URL}'",
    teamDomain: 'ninja-gjj9738', tokenCredentialId: 'slack'      
  }
  else {
    slackSend channel: '#jenkinscicd',
    color: 'danger',
    message: " *${currentBuild.currentResult}:* \n *Job_Name:* '${JOB_NAME}' \n *USER:* '${USER}' \n *Stage_Name:* ${STAGE_NAME} \n *Build_Number:* '${BUILD_NUMBER}' \n *More info at:* '${BUILD_URL}'",
    teamDomain: 'ninja-gjj9738', tokenCredentialId: 'slack'      
  }
}
