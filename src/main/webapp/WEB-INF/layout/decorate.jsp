<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="sitemeth" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <title>鸹貔网盘-<sitemeth:title/></title>
  <c:set var="BasePath" value="${pageContext.request.contextPath}"/>

  <%-- 加入标题栏的小图标 --%>
  <link href="${BasePath}/static/images/cloud_disk.ico" type="image/x-icon" rel="shortcut icon"/>

  <script type="text/javascript" src="${pageContext.request.contextPath}/static/vue/vue.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/static/vue/index.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/static/axios/axios.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery/jquery-3.3.1.min.js"></script>

  <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/static/vue/index.css">

  <sitemeth:head/>
</head>
<body>
  <sitemeth:body/>
</body>
</html>