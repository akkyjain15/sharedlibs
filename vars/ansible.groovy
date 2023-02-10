def clone(){
 git branch: 'main', url: 'https://gitlab.com/Akshay15jain/ansible.git'
}

def input(){
  input {
              message 'Want to execute playbook?'
       }
}

def PlaybookExecution(){
 ansiblePlaybook credentialsId: 'assignment6-ssh', disableHostKeyChecking: true, installation: 'ansible1', inventory: 'inv', playbook: 'role_jenkins.yml'
}

def slackSend(){

      aborted {
              slackSend channel: '#jenkinscicd',
              color: 'danger',
              message: " *${currentBuild.currentResult}:* \n *Job_Name:* '${JOB_NAME}' \n *USER:* '${USER}' \n *Stage_Name:* ${STAGE_NAME} \n *Build_Number:* '${BUILD_NUMBER}' \n *More info at:* '${BUILD_URL}'",
              teamDomain: 'ninja-gjj9738', tokenCredentialId: 'slack'
      }          
      success {
              slackSend channel: '#jenkinscicd',
              color: 'good',
              message: " *${currentBuild.currentResult}:* \n *Job_Name:* '${JOB_NAME}' \n *USER:* '${USER}' \n *Stage_Name:* ${STAGE_NAME} \n *Build_Number:* '${BUILD_NUMBER}' \n *More info at:* '${BUILD_URL}'",
              teamDomain: 'ninja-gjj9738', tokenCredentialId: 'slack'
      }
      failure {
              slackSend channel: '#jenkinscicd',
              color: 'danger',
              message: " *${currentBuild.currentResult}:* \n *Job_Name:* '${JOB_NAME}' \n *USER:* '${USER}' \n *Stage_Name:* ${STAGE_NAME} \n *Build_Number:* '${BUILD_NUMBER}' \n *More info at:* '${BUILD_URL}'",
              teamDomain: 'ninja-gjj9738', tokenCredentialId: 'slack'
      }
}
