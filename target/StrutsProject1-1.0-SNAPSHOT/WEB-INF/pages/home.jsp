<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="sjg" uri="/struts-jquery-grid-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Insert title here</title>
        <sj:head jqueryui="true" jquerytheme="redmond" />
    </head>
    <body>
        <center>
            <h2>Welcome <i><s:property value="#session.uName" /></i></h2>
            <a href="user_create">Add New User</a>
            <s:url var="remoteurl" action="jsontable"/>
            <sjg:grid
                id="gridtable"
                caption="User Details"
                dataType="json"
                href="%{remoteurl}"
                pager="true"
                gridModel="users"
                rowList="10,15,20"
                rowNum="15"
                rownumbers="true"
                >
                <sjg:gridColumn name="user_id" index="user_id" title="User ID" formatter="integer" sortable="true"/>
                <sjg:gridColumn name="role_name" index="role_name" title="Role" sortable="false"/>
                <sjg:gridColumn name="username" index="username" title="Username" sortable="false"/>
                <sjg:gridColumn name="email" index="email" title="Email" sortable="false"/>
                <sjg:gridColumn name="phone" index="phone" title="Phone" sortable="false"/>
            </sjg:grid>
            <p>Total Users <i><s:property value="records" /></i></p>
        </center>
    </body>
</html>