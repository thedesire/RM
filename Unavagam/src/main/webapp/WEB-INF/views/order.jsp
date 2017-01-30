<%@ include file="sharefiles/header.jsp"%>
<body>
<h2 style="text-align: center;">Take Order</h2>
	
	<c:url var="editMenuItem" value="/menuItem/edit" />
	<c:url var="deleteMenuItem" value="/menuItem/delete" />
	<div class="container">
		<div class="row">
			<div class="col-md-3">
				<form:form role="form" id="orderForm" action="${takeOrder}"
					method="post" modelAttribute="order">

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
		</div>
	</div>
	</body>
<%@ include file="sharefiles/footer.jsp"%>