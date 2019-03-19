<%--
  Created by IntelliJ IDEA.
  User: 张唯铭
  Date: 2019/3/19
  Time: 13:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
    <script type="text/javascript" src="js/jquery-3.3.1.js"></script>
    <script type="text/javascript">
      $(function () {
        $("a").click(function () {
          //浏览器带有缓存功能，不会多次请求相同数据
          $("img").attr("src", "validcode")
          return false;
        })
      })
    </script>
  </head>
  <body>
    <form action="" method="post">
      用户名：<input type="text" name="username"/><br/>
      密码：<input type="password" name="password/"><br/>
      验证码：<input type="text" size="3"/><img src="validcode" width="80" height="40"/><a href="">看不清</a> <br/>
      <input type="submit" value="登录"/><input type="reset" value="重置"/>
    </form>
  </body>
</html>
