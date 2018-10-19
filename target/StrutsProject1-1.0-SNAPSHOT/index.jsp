<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
    <head></head>
    <body>
        <s:form action="login">
            <s:textfield name="username" value="admin"/>
            <s:textfield name="password" value="admin"/>
            <s:submit value="LogIn"></s:submit>
        </s:form>
        <s:property value="error" />
    </body>
</html>
