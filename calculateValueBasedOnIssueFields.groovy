import com.atlassian.jira.component.ComponentAccessor
import org.apache.log4j.Level
import org.apache.log4j.Logger

// Get component
def customFieldManager = ComponentAccessor.getCustomFieldManager();

def log = Logger.getLogger(“pro.ravi.sr4j”)
log.setLevel(Level.DEBUG)

def id=issue.getId()

def cf1 = customFieldManager.getCustomFieldObject(“11”)
def cf2 = customFieldManager.getCustomFieldObject(“22”)

def a = Integer.parseInt((issue.getCustomFieldValue(cf1) ?: 0).toString().replaceAll(~/[.].*/, ""))
def b = Integer.parseInt((issue.getCustomFieldValue(cf2) ?: 0).toString().replaceAll(~/[.].*/, ""))

def sum = (a ?: 0) + (b ?: 0);

log.debug “sum = ${sum}”