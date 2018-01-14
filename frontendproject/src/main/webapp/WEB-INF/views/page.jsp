<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url var="css" value="/resource/css" />
<spring:url var="js" value="/resource/js" />
<spring:url var="images" value="/resource/images" />

<!DOCTYPE html>
<html lang="en">


<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Shop Homepage - ${title}</title>
<script>
	window.menu = '${title}';
</script>

<!-- Bootstrap core CSS -->
<link href="${css}/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="${css}/myapp.css" rel="stylesheet">

<!-- bootstrap super hero theme -->
<link href="${css}/bootstrap-solar-theme.css" rel="stylesheet">

</head>

<body>

	<div class="wrapper">
		<!-- Navigation -->

		<%@include file="./shared/navbar.jsp"%>



		<div class="content">
			<!-- Page Content -->

			<!-- loading only when user click home -->
			<c:if test="${userClickHome == true}">
				<%@include file="home.jsp"%>
			</c:if>

			<!-- loading only when user click about -->
			<c:if test="${userClickAbout == true}">
				<%@include file="about.jsp"%>
			</c:if>

			<!-- loading only when user click contact -->
			<c:if test="${userClickContact == true}">
				<%@include file="contact.jsp"%>
			</c:if>

		<!-- loading only when user click All Products or user click category Product -->
			<c:if test="${userClickAllProducts == true}">
				<%@include file="listproduct.jsp"%>
			</c:if>

		</div>

		<!-- Footer -->
		<%@include file="./shared/footer.jsp"%>

		<!-- Bootstrap core JavaScript -->
		<script src="${js}.min.js"></script>
		<script src="${js}/bootstrap.bundle.min.js"></script>

		<!-- self coded javascript -->
		<script src="${js}/myapp.js"></script>


	</div>
</body>

</html>
