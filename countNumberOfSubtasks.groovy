import com.atlassian.jira.issue.Issue
import org.apache.log4j.Level
import org.apache.log4j.Logger

def issue = event.issue
def issueId = issue.id

def log = Logger.getLogger(“pro.ravi.sr4j”)
log.setLevel(Level.DEBUG)

def subTaskSum = 0
if (!issue.isSubTask()) {
    issue.getSubTaskObjects()?.each { subtask ->
            subTaskSum++
    }
}

log.debug “There are ${subTaskSum} sub-tasks for issue ${issueId}”