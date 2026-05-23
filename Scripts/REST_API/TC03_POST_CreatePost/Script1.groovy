import com.kms.katalon.core.util.KeywordUtil
import groovy.json.JsonSlurper
import groovy.json.JsonOutput

//TC03: POST Create Post - Katalon sebagai Producer
def baseUrl = "https://jsonplaceholder.typicode.com"

// POST - create new post
def connection = new URL("${baseUrl}/posts").openConnection()
connection.setRequestMethod("POST")
connection.setDoOutput(true)
connection.setRequestProperty("Content-Type", "application/json")

def requestBody = JsonOutput.toJson([
    title: "IFG Test - Katalon as Producer",
    body: "Post created by Katalon Studio",
    userId: 1
])
connection.getOutputStream().write(requestBody.getBytes("UTF-8"))

def statusCode = connection.getResponseCode()
def created = new JsonSlurper().parseText(connection.getInputStream().getText("UTF-8"))

// Validasi
assert statusCode == 201 : "Expected 201, got ${statusCode}"
assert created.id != null
assert created.title == "IFG Test - Katalon as Producer"
assert created.userId == 1

KeywordUtil.logInfo("POST /posts -> ${statusCode}, created id: ${created.id}")
KeywordUtil.logInfo("TC03 PASSED")
