<%--
  Created by IntelliJ IDEA.
  User: bingco
  Date: 2018/2/14
  Time: 17:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>多人在线聊天室</title>
    <meta class="serverPath" data="${pageContext.request.contextPath}"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap-grid.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap-reboot.min.css">
    <style type="text/css">
      .media > img {
        width: 60px;
      }
    </style>
  </head>
  <body>
  <nav class="navbar navbar-expand-lg navbar-light bg-light">
    <img src="${pageContext.request.contextPath}/img/log.jpg" class="rounded" width="35px" height="35px" />
    <h4 class="nav-link" href="#">多人在线聊天室<span class="sr-only">(current)</span></h4>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav mr-auto">
        <li class="nav-item">
          <a class="nav-link" href="#">sign out</a>
        </li>
      </ul>
    </div>
  </nav>

  <div class="jumbotron h-75" style="min-height: 500px; min-width: 1000px">

    <div class="float-left container bg-white h-100 cr-list" style="width: 25%">

        <div class="dropright">
            <div class="media mt-1 bg-light" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
              <img class="mr-3" src="data:image/svg+xml;charset=UTF-8,%3Csvg%20width%3D%2264%22%20height%3D%2264%22%20xmlns%3D%22http%3A%2F%2Fwww.w3.org%2F2000%2Fsvg%22%20viewBox%3D%220%200%2064%2064%22%20preserveAspectRatio%3D%22none%22%3E%3Cdefs%3E%3Cstyle%20type%3D%22text%2Fcss%22%3E%23holder_1619b8091bf%20text%20%7B%20fill%3Argba(255%2C255%2C255%2C.75)%3Bfont-weight%3Anormal%3Bfont-family%3AHelvetica%2C%20monospace%3Bfont-size%3A10pt%20%7D%20%3C%2Fstyle%3E%3C%2Fdefs%3E%3Cg%20id%3D%22holder_1619b8091bf%22%3E%3Crect%20width%3D%2264%22%20height%3D%2264%22%20fill%3D%22%23777%22%3E%3C%2Frect%3E%3Cg%3E%3Ctext%20x%3D%2213.5546875%22%20y%3D%2236.5%22%3E64x64%3C%2Ftext%3E%3C%2Fg%3E%3C%2Fg%3E%3C%2Fsvg%3E" alt="Generic placeholder image">
              <div class="media-body">
                <h6 class="mt-0">张三</h6>
                <span>Hello World Java.</span>
              </div>

                <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                    <a class="dropdown-item" href="#">私聊</a>
                    <a class="dropdown-item" href="#">添加好友</a>
                    <a class="dropdown-item signUp" data-id="" onclick="signUpBy(this);" href="#">踢下线</a>
                </div>
            </div>
        </div>

    </div>

    <div class="float-right h-100 ml-4" style="width: 70%">

      <div class="bg-white w-100" style="height: 70%; overflow: auto">
        <div class="cr-content">

            <div class="container cr-msg-to">
              <div class="media p-2">
                <img class="mr-3" src="data:image/svg+xml;charset=UTF-8,%3Csvg%20width%3D%2264%22%20height%3D%2264%22%20xmlns%3D%22http%3A%2F%2Fwww.w3.org%2F2000%2Fsvg%22%20viewBox%3D%220%200%2064%2064%22%20preserveAspectRatio%3D%22none%22%3E%3Cdefs%3E%3Cstyle%20type%3D%22text%2Fcss%22%3E%23holder_1619b8091bf%20text%20%7B%20fill%3Argba(255%2C255%2C255%2C.75)%3Bfont-weight%3Anormal%3Bfont-family%3AHelvetica%2C%20monospace%3Bfont-size%3A10pt%20%7D%20%3C%2Fstyle%3E%3C%2Fdefs%3E%3Cg%20id%3D%22holder_1619b8091bf%22%3E%3Crect%20width%3D%2264%22%20height%3D%2264%22%20fill%3D%22%23777%22%3E%3C%2Frect%3E%3Cg%3E%3Ctext%20x%3D%2213.5546875%22%20y%3D%2236.5%22%3E64x64%3C%2Ftext%3E%3C%2Fg%3E%3C%2Fg%3E%3C%2Fsvg%3E" alt="Generic placeholder image">
                <div class="media-body bg-light rounded text-left">
                  <h6 class="m-2">李四</h6>
                  <p class="font-weight-bold m-2" style="font-size: 14px;">你好啊世界!</p>
                </div>
              </div>
            </div>

            <div class="container cr-msg-from">
              <div class="media p-2">
                <div class="media-body bg-light rounded text-right">
                  <h6 class="m-2">王五</h6>
                  <p class="font-weight-bold m-2" style="font-size: 14px;">你好啊世界!</p>
                </div>
                <img class="ml-3" src="data:image/svg+xml;charset=UTF-8,%3Csvg%20width%3D%2264%22%20height%3D%2264%22%20xmlns%3D%22http%3A%2F%2Fwww.w3.org%2F2000%2Fsvg%22%20viewBox%3D%220%200%2064%2064%22%20preserveAspectRatio%3D%22none%22%3E%3Cdefs%3E%3Cstyle%20type%3D%22text%2Fcss%22%3E%23holder_1619b8091bf%20text%20%7B%20fill%3Argba(255%2C255%2C255%2C.75)%3Bfont-weight%3Anormal%3Bfont-family%3AHelvetica%2C%20monospace%3Bfont-size%3A10pt%20%7D%20%3C%2Fstyle%3E%3C%2Fdefs%3E%3Cg%20id%3D%22holder_1619b8091bf%22%3E%3Crect%20width%3D%2264%22%20height%3D%2264%22%20fill%3D%22%23777%22%3E%3C%2Frect%3E%3Cg%3E%3Ctext%20x%3D%2213.5546875%22%20y%3D%2236.5%22%3E64x64%3C%2Ftext%3E%3C%2Fg%3E%3C%2Fg%3E%3C%2Fsvg%3E" alt="Generic placeholder image">
              </div>
            </div>

        </div>
      </div>

      <div class="w-100" style="height: 25%; margin-top: 3%">
        <div class="form-group float-left" style="width: 90%">
          <textarea class="form-control h-100 w-100 cr-textarea"></textarea>
        </div>
        <div class="btn-group-vertical float-right h-100" style="width: 5%; min-width: 55px" role="group" aria-label="Basic example">
          <button type="button" class="btn btn-secondary" style="height: 33.33%">清空</button>
          <button type="button" class="btn btn-secondary" style="height: 33.33%">表情</button>
          <button type="button" class="btn btn-secondary" onclick="btmSend();" style="height: 33.33%">发送</button>
        </div>
      </div>

    </div>

  </div>

  <footer class="text-center"><p class="mt-4">© 2017-2018</p>聪哥出品, 必属精品.</footer>

  </body>
  <script type="text/javascript" src="${pageContext.request.contextPath}/bootstrap/js/jquery.min.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/bootstrap/js/popper.min.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/js/main.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/js/view.js"></script>
</html>
