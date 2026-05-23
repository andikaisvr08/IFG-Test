<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description>POST Create New Post to JSONPlaceholder</description>
   <name>POST_CreatePost</name>
   <tag></tag>
   <elementGuidId>post-create-post-guid</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <smartLocatorEnabled>false</smartLocatorEnabled>
   <useRalativeImagePath>false</useRalativeImagePath>
   <autoUpdateContent>true</autoUpdateContent>
   <connectionTimeout>-1</connectionTimeout>
   <followRedirects>false</followRedirects>
   <httpBody>{
  &quot;title&quot;: &quot;IFG Test - Katalon as Producer&quot;,
  &quot;body&quot;: &quot;Post created by Katalon Studio via Object Repository&quot;,
  &quot;userId&quot;: 1
}</httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;{\n  \&quot;title\&quot;: \&quot;IFG Test - Katalon as Producer\&quot;,\n  \&quot;body\&quot;: \&quot;Post created by Katalon Studio via Object Repository\&quot;,\n  \&quot;userId\&quot;: 1\n}&quot;,
  &quot;contentType&quot;: &quot;text/plain&quot;,
  &quot;charset&quot;: &quot;UTF-8&quot;
}</httpBodyContent>
   <httpBodyType>text</httpBodyType>
   <httpHeaderProperties>
      <isSelected>false</isSelected>
      <matchCondition>equals</matchCondition>
      <type>Main</type>
      <webElementGuid>e087662d-de9e-4a55-aa44-5699ae6d07d1</webElementGuid>
   </httpHeaderProperties>
   <katalonVersion>10.4.3</katalonVersion>
   <maxResponseSize>-1</maxResponseSize>
   <migratedVersion>5.4.1</migratedVersion>
   <path></path>
   <restRequestMethod>POST</restRequestMethod>
   <restUrl>https://jsonplaceholder.typicode.com/posts</restUrl>
   <serviceType>RESTful</serviceType>
   <soapBody></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod></soapRequestMethod>
   <soapServiceEndpoint></soapServiceEndpoint>
   <soapServiceFunction></soapServiceFunction>
   <socketTimeout>-1</socketTimeout>
   <useServiceInfoFromWsdl>true</useServiceInfoFromWsdl>
   <verificationScript>import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS

WS.verifyResponseStatusCode(response, 201)
WS.verifyElementPropertyValue(response, 'title', 'IFG Test - Katalon as Producer')
WS.verifyElementPropertyValue(response, 'userId', 1)</verificationScript>
   <wsdlAddress></wsdlAddress>
</WebServiceRequestEntity>
