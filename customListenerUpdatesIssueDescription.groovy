import com.atlassian.jira.component.ComponentAccessor

// Get some components
def loggedInUser = ComponentAccessor.jiraAuthenticationContext.loggedInUser
def issueService = ComponentAccessor.issueService
def commentManager = ComponentAccessor.commentManager

// Set variables
def issue = event.issue
def issueId = issue.id
def comment = commentManager.getLastComment(issue)
def commentBody = comment.body

def issueInputParameters = issueService.newIssueInputParameters()
issueInputParameters.setDescription(commentBody);

def updateValidationResult = issueService.validateUpdate(loggedInUser, issueId, issueInputParameters)

assert updateValidationResult.isValid() : updateValidationResult.errorCollection

def issueResult = issueService.update(loggedInUser, updateValidationResult)

assert issueResult.isValid() : issueResult.errorCollection