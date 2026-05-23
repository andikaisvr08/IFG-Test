import com.kms.katalon.core.util.KeywordUtil
import groovy.json.JsonSlurper

//TC01: GET All Posts - Katalon sebagai Consumer
def baseUrl = "https://jsonplaceholder.typicode.com"

// GET all posts
def connection = new URL("${baseUrl}/posts").openConnection()
connection.setRequestMethod("GET")

def statusCode = connection.getResponseCode()
def body = new JsonSlurper().parseText(connection.getInputStream().getText("UTF-8"))

// Validasi
assert statusCode == 200 : "Expected 200, got ${statusCode}"
assert body instanceof List
assert body.size() == 100 : "Expected 100 posts"
assert body[0].containsKey('id')
assert body[0].containsKey('title')
assert body[0].containsKey('body')
assert body[0].containsKey('userId')

KeywordUtil.logInfo("GET /posts -> ${statusCode}, total: ${body.size()} posts")
KeywordUtil.logInfo("TC01 PASSED")
