<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>account_list.jsp</title>
</head>

<body>
    <form method="post" action="account_list">
        <input type="submit" value="查询" />
        <br>
        <s:iterator value="accounts">
            用户名：<s:property value="username" /><br>
            密码：<s:property value="password" /><br>
        </s:iterator>
        <s:debug>
        </s:debug>
    </form>
</body>
</html>
