<%--
  Created by IntelliJ IDEA.
  User: bingco
  Date: 2018/2/14
  Time: 17:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>多人在线聊天室登陆界面</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap-grid.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap-reboot.min.css">
  </head>
  <body class="d-flex align-items-center bg-light">

  <section class="container text-center">
    <div class="col-sm-5 mr-auto ml-auto">
      <form method="POST" action="${pageContext.request.contextPath}/user" class="was-validated">

        <p><img src="${pageContext.request.contextPath}/img/log.jpg" width="100" height="100" class="rounded" /></p>
        <h4 class="mt-4 mb-4">欢迎登陆聊天室</h4>

        <div class="form-group">
          <label for="cr-username" class="sr-only">username</label>
          <input type="text" class="form-control" id="cr-username" name="username" value="${username}" placeholder="username" required>
          <div><c:if test="${msg.code eq 1}">${msg.msg}</c:if></div>
        </div>

        <div class="form-group">
          <label for="cr-password" class="sr-only">Password</label>
          <input type="password" class="form-control" id="cr-password" name="password" value="${password}" placeholder="password" required>
          <div><c:if test="${msg.code eq 2}">${msg.msg}</c:if></div>
        </div>

        <div class="custom-control custom-checkbox float-right mt-2 mb-2">
          <input type="checkbox" class="custom-control-input" id="cr-remamber">
          <label class="custom-control-label text-muted" for="cr-remamber">Remamber me.</label>
        </div>

        <input hidden name="method" value="login" />
        <button type="submit" class="btn btn-primary form-control">确认</button>
        <p class="mt-4">© 2017-2018</p>

      </form>
    </div>
  </section>

  <footer>

  </footer>

  </body>
  <script type="text/javascript" src="${pageContext.request.contextPath}/bootstrap/js/jquery.min.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/bootstrap/js/popper.min.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
</html>
