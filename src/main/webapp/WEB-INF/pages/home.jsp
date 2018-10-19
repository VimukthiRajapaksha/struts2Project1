<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Insert title here</title>
    </head>
    <body>
        <center>
            <h2>Welcome <i><s:property value="#session.uName" /></i></h2>
            <a href="user_create">Add New User</a>
            <table border="0" cellspacing="2%" cellpadding="10%">
                <tr>
                    <th>id</th>
                    <th>role</th>
                    <th>username</th>
                    <th>email</th>
                    <th>phone</th>
                </tr>
                
                <s:iterator value="users">
                    <tr>
                        <s:set var="var" value="user_id"></s:set>
                        <td><s:property value="#var"/></td>
                        <td><s:property value="role_name"/></td>
                        <td><s:property value="username"/></td>
                        <td><s:property value="email"/></td>
                        <td><s:property value="phone"/></td>
                    </tr>		
                </s:iterator>
            </table>
        </center>
    </body>
</html>