import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.util.KeywordUtil

/**
 * TC05: Using Katalon built-in WS keywords + Object Repository
 */

// GET using object repository
def getResponse = WS.sendRequest(findTestObject('REST_API/GET_AllPosts'))

WS.verifyResponseStatusCode(getResponse, 200)
WS.verifyElementPropertyValue(getResponse, '[0].id', 1)
WS.verifyElementPropertyValue(getResponse, '[0].userId', 1)

// check response time is under 5 seconds
def responseTime = getResponse.getElapsedTime()
assert responseTime < 5000 : "Response too slow: ${responseTime}ms"
KeywordUtil.logInfo("GET /posts -> 200, ${responseTime}ms")

// POST using object repository
def postResponse = WS.sendRequest(findTestObject('REST_API/POST_CreatePost'))

WS.verifyResponseStatusCode(postResponse, 201)
WS.verifyElementPropertyValue(postResponse, 'title', 'IFG Test - Katalon as Producer')
WS.verifyElementPropertyValue(postResponse, 'userId', 1)

KeywordUtil.logInfo("POST /posts -> 201, created")

// check content-type header
def contentType = getResponse.getHeaderFields().get("Content-Type")
KeywordUtil.logInfo("Content-Type: ${contentType}")
