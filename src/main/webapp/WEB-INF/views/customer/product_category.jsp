<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<style>
.pagination {
  display: flex;
  justify-content: center;
}

.pagination a {
  color: black;
  float: left;
  padding: 8px 16px;
  text-decoration: none;
}

.pagination a.active {
  background-color: #4CAF50;
  color: white;
}

.pagination a:hover:not(.active) {background-color: #ddd;}
.category {
  display: flex;
  justify-content: space-between;
  align-items: center;
  margin-bottom: 20px;
}
</style>

</head>
<body>
<div class="tab-content">
					<div id="tab-1" class="tab-pane fade show p-0 active">
						<div class="row g-4">
							<c:forEach var="item" items="${ProductPaginate}" varStatus="i">
								<div class="col-xl-3 col-lg-4 col-md-6 wow fadeInUp"
									data-wow-delay="0.1s">
									<div class="product-item">
										<div class="position-relative bg-light overflow-hidden">
											<img class="img-fluid w-100"
												src="${item.img}"
												alt="">

										</div>
										<div class="text-center p-4">
											<a class="d-block h5 mb-2" href="">${item.product_name}</a> <span
												class="text-primary me-1">${item.price}</span>
										</div>
										<div class="d-flex border-top">
											<small class="w-50 text-center border-end py-2"> <a
												class="text-body" href=""><i
													class="fa fa-eye text-primary me-2"></i>View detail</a>
											</small> <small class="w-50 text-center py-2"> <a
												class="text-body" href=""><i
													class="fa fa-shopping-bag text-primary me-2"></i>Add to
													cart</a>
											</small>
										</div>
									</div>
								</div>
							</c:forEach>
						</div>

						<div class="pagination">
							<c:forEach var="item" begin="1" end="${pageinfo.totalPage}"
								varStatus="loop">
								<c:if test="${loop.index==pageinfo.currentPage}">
									<a class="active"
										href='<c:url value="/san-pham/${item_id}/${type_id}/${loop.index}"/>'>${loop.index}</a>
								</c:if>
								<c:if test="${loop.index!=pageinfo.currentPage}">
									<a href='<c:url value="/san-pham/${item_id}/${type_id}/${loop.index}"/>'>${loop.index}</a>
								</c:if>

							</c:forEach>
						</div>
					</div>
				</div>
</body>
</html>