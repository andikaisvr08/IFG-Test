import com.kms.katalon.core.util.KeywordUtil
import groovy.json.JsonSlurper

//TC02: GET Single Post - Katalon sebagai Consumer
def baseUrl = "https://jsonplaceholder.typicode.com"

// GET post by ID
def connection = new URL("${baseUrl}/posts/1").openConnection()
connection.setRequestMethod("GET")

def statusCode = connection.getResponseCode()
def post = new JsonSlurper().parseText(connection.getInputStream().getText("UTF-8"))

// Validasi
assert statusCode == 200
assert post.id == 1
assert post.userId == 1
assert post.title != null
assert post.body != null

KeywordUtil.logInfo("GET /posts/1 -> ${statusCode}, title: ${post.title}")
KeywordUtil.logInfo("TC02 PASSED")
