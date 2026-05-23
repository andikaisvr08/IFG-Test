import com.kms.katalon.core.util.KeywordUtil
import groovy.json.JsonSlurper

/**
 * TC02: GET Single Post + Negative test (invalid ID)
 */

def baseUrl = "https://jsonplaceholder.typicode.com"

// get post id 1
def connection = new URL("${baseUrl}/posts/1").openConnection()
connection.setRequestMethod("GET")

def statusCode = connection.getResponseCode()
def post = new JsonSlurper().parseText(connection.getInputStream().getText("UTF-8"))

assert statusCode == 200 : "Expected 200, got ${statusCode}"
assert post.id == 1
assert post.userId == 1
assert post.title != null && post.title.length() > 0
assert post.body != null && post.body.length() > 0

KeywordUtil.logInfo("GET /posts/1 -> ${statusCode}, title: ${post.title}")

// try invalid id, should return 404
def conn404 = new URL("${baseUrl}/posts/99999").openConnection()
conn404.setRequestMethod("GET")

def statusCode404 = conn404.getResponseCode()
assert statusCode404 == 404 : "Expected 404 for invalid ID, got ${statusCode404}"

KeywordUtil.logInfo("GET /posts/99999 -> ${statusCode404} (Not Found)")
