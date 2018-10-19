<%-- 
    Document   : user_create
    Created on : Oct 17, 2018, 11:55:10 AM
    Author     : vimukthi_r
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

    <center>
        <h2>Welcome <i><s:property value="#session.uName" /></i></h2>
        <h1><u>Add User</u></h1>
        <s:form action="user_save">
            <s:bean name="com.intern.bean.UserBean" var="userBean" >
                <table>
                    <tr>
                        <td>Username :</td>
                        <td><s:textfield name="userBean.username">
                            </s:textfield>
                        </td>
                    </tr>
                    <tr>
                        <td>Password :</td>
                        <td><s:textfield name="userBean.password">
                            </s:textfield>
                        </td>
                    </tr>
                    <tr>
                        <td>Email :</td>
                        <td><s:textfield name="userBean.email">
                            </s:textfield>
                        </td>
                    </tr>
                    <tr>
                        <td>Phone :</td>
                        <td><s:textfield name="userBean.phone">
                            </s:textfield>
                        </td>
                    </tr>
                    <tr>
                        <td>User Role :</td>
                        <td><s:select list="roles" name="roleId" headerKey="-1" headerValue="Select a role" listKey="role_id" listValue="role_name"/>
                        </td>
                    </tr>
                    <tr>
                        <td></td>
                        <td>
                            <s:submit value="Save">
                            </s:submit>
                        </td>
                    </tr>
                </table>
            </s:bean>
        </s:form>
        <s:form action="users">
            <s:submit value="Back"></s:submit>
        </s:form>
        <s:property value="resultMsg" default=" "/>
    </center>
</body>
</html>
