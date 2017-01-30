<%@ include file="sharefiles/header.jsp"%>

<body>
	<c:url var="postMenuItem" value='/addNewMenuItem' />
	<c:url var="editMenuItem" value="/menuItem/edit" />
	<c:url var="deleteMenuItem" value="/menuItem/delete" />
	<h1 style="text-align: center;">Add Menu Items</h1>
	<div class="container">
		<div class="row">
			<div class="col-md-3">
				<form:form role="form" id="menuItemForm" action="${postMenuItem}"
					method="post" modelAttribute="menuItem">

					<div class="form-group">
						<form:label path="id" class="control-label">
							<spring:message text="ID" />
						</form:label>

						<c:choose>
							<c:when test="${!empty menuItem.id }">
								<form:input path="id" class="form-control" readonly="true" />
							</c:when>
							<c:otherwise>
								<form:input path="id" class="form-control" />
							</c:otherwise>
						</c:choose>
						<form:errors path="id" class="alert alert-danger" />
					</div>

					<div class="form-group">
						<form:label path="name" class="control-label">
							<spring:message text="Name" />
						</form:label>
						<form:input path="name" class="form-control" />
						<form:errors path="name" class="alert alert-danger" />
					</div>

					<div class="form-group">
						<form:label path="price" class="control-label">
							<spring:message text="Price" />
						</form:label>
						<form:input path="price" class="form-control" />
						<form:errors path="price" class="alert alert-danger" />
					</div>

					<%-- 					<div class="form-group">
						<form:label path="category" class="control-label">
							<spring:message text="Category" />
						</form:label>
						<form:select path="category.name" class="form-control">
							<form:option value="NONE" label="--- Select ---" />
							<form:options items="${categoryList}" itemValue="name"
								itemLabel="name" />
						</form:select>
						<form:errors path="category.name" class="alert alert-danger" />
					</div>
 --%>

					<div class="form-group">
						<c:choose>
							<c:when test="${!empty menuItem.name }">
								<input type="submit" class="btn btn-primary" value="UPDATE" />
							</c:when>
							<c:otherwise>
								<input type="submit" class="btn btn-primary" value="ADD ITEM" />
							</c:otherwise>
						</c:choose>
						<input type="reset" class="btn btn-primary" value="RESET" />
					</div>

				</form:form>
			</div>
			<div class="col-md-8">

				<table class="table table-responsive">
					<thead>
						<tr>
							<th>MENU ID</th>
							<th>MENU NAME</th>
							<th>PRICE</th>
							<th>EDIT</th>
							<th>DELETE</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${listOfItem}" var="item">
							<tr>

								<td>${item.id}</td>
								<td>${item.name}</td>
								<td>${item.price}</td>
								<td><a href="${editMenuItem}/${item.id}">EDIT</a></td>
								<td><a href="${deleteMenuItem}/${item.id}">DELETE</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>

			</div>
		</div>
	</div>
</body>
<%@ include file="sharefiles/footer.jsp"%>