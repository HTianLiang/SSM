<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<%--<script type="text/javascript" src="<%=basePath%>js/jquery.min.js"></script>--%>
<title>Java项目实践测试</title>
</head>

<script type="text/javascript">
function Validate(){
	var usercode = document.getElementById("userCode").value;
	var userpwd = document.getElementById("userPwd").value;
	if (usercode == ""){
	    alert("请输入用户名！");
	    document.getElementById("userCode").focus();
	    return;
    }
	if (userpwd == ""){
	    alert("请输入密码！");
        document.getElementById("userPwd").focus();
	    return;
    }


}
</script>
<script type="text/javascript">
    var tipInfo = ${tip};
    if (tipInfo!=null||tipInfo!=""){
        if (tipInfo==1){
            // alert("用户名或密码有误，请重新输入！");
            alert("登录失败！");
        }
    }

</script>

<body>
   <div style="height:150px">
   </div>
   <form action="${pageContext.request.contextPath}/login.action" method="post" >
   <div style="height:500px">
      <div>          
          <table width="419px;" border="0" cellspacing="0" cellpadding="0" align="center">
              <tr style="height:8px;">
                <td ></td>
                <td ></td>
                <td ></td>
                <td ></td>
                <td ></td>
                <td ></td>
              </tr>
              <tr style="height:50px;">
                <td ></td>
                <td >用&nbsp;&nbsp;&nbsp;&nbsp;户:</td>
                <td  colspan="2"><input type="text" name="userCode" id="userCode" value="" class="input1"/></td>
                <td ></td>
                <td></td>
              </tr>
              <tr style="height:50px;">
                <td ></td>
                <td >密&nbsp;&nbsp;&nbsp;&nbsp;码:</td>
                <td  colspan="2"><input type="password" name="userPwd" id="userPwd" value="" class="input1"/></td>
                <td ></td>
                <td></td>
              </tr>
              <tr style="height:50px;">
                <td align="center" colspan="3" rowspan="2" style="color: red"><input type="submit" value="登陆" onClick="Validate()"/>
                    &nbsp;&nbsp;${info}
                </td>
              </tr>
            </table>           
      </div>
   </div>
   </form>
   <div>
      <div id="copyright">
        <span style="line-height:110%;">Copyright &copy; 2015 - 2018 www.songshan.com.cn All rights reserved</span><br>
        <span style="line-height:100%;">Technical telephone: 0751-8936605</span>
      </div>
   </div>
</body>

</html>
