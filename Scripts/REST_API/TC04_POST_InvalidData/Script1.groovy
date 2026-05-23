import com.kms.katalon.core.util.KeywordUtil
import groovy.json.JsonSlurper

/**
 * TC04: POST empty body - Negative Test
 */

def baseUrl = "https://jsonplaceholder.typicode.com"

// send empty body, see what server responds
def connection = new URL("${baseUrl}/posts").openConnection()
connection.setRequestMethod("POST")
connection.setDoOutput(true)
connection.setRequestProperty("Content-Type", "application/json")
connection.getOutputStream().write("{}".getBytes("UTF-8"))

def statusCode = connection.getResponseCode()
def response = new JsonSlurper().parseText(connection.getInputStream().getText("UTF-8"))

// server still returns 201 but title should be null since we didnt send it
assert statusCode == 201 : "Expected 201, got ${statusCode}"
assert response.id != null
assert response.title == null

KeywordUtil.logInfo("POST /posts (empty) -> ${statusCode}, id: ${response.id}, title: ${response.title}")
