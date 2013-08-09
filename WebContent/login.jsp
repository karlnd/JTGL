<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>JTGL</title>
<script type="text/javascript">
	function subLogin(){
		var fm=document.form1;
		fm.action="login.do";
		fm.submit();
	}
</script>
</head>
<body>
<center><br/><br/>
           <form name="form1" id="form1" method="post">
           用户名：<input type="text" name="username" id="username"/><br/><br/>
           密码：  <input type="password" name="password" id="password"/><br/><br/>
           <input type="submit" value="提交" onClick="subLogin();">
           </form>
</center>
</body>
</html>