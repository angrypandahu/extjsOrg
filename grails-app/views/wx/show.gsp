<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="frame"/>
    <g:set var="entityName" value="${message(code: 'wx.label', default: 'WxApi')}"/>
    <title><g:message code="default.show.label" args="[entityName]"/></title>
</head>

<body>
<g:hiddenField name="apiAccount" value="${apiAccount.id}"/>
<g:wxForm apiOrg="${apiOrg}"/>
</body>
</html>
