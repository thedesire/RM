<%@ include file="sharefiles/header.jsp"%>
<body>
	<c:url value='/menuItem' var="getMenuItems" />
	<p>${getMenuItems}</p>
	<h2 style="text-align: center;">Landing Page</h2>
	<a style="border-left: '80%';" href="${getMenuItems}">Manage Menu
		Items</a>

</body>
<%@ include file="sharefiles/footer.jsp"%>

