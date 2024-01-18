<%@ page import="java.util.Objects" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="ko">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    <title>nhn아카데미 shopping mall</title>

</head>
<body>

<div class="mainContainer">
    <header class="p-3 bg-dark text-white">
        <div class="container">
            <div class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
                <ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
                    <li><a href="/" class="nav-link px-2 text-secondary">Home</a></li>
                    <li><a href="${mypage_link}" class="nav-link px-2 text-white">마이페이지</a></li>
                    <li><a href="${shoppingcart_link}" class="nav-link px-2 text-white">장바구니</a></li>
                </ul>

                <form class="col-12 col-lg-auto mb-3 mb-lg-0 me-lg-3" style="display: flex;align-items: center" method="get" action="/search">
                    <input type="search" id="keyword" name="keyword" class="form-control form-control-dark" placeholder="Search..." aria-label="Search" style="margin-right: 10px">
                    <button class="btn btn-sm btn-outline-secondary" style="width: 50px">검색</button>
                </form>
            </div>
        </div>
    </header>

    <main>
        <div class="album py-5 bg-light">
            <div class="container">
                <form action="/sort" method="get">
                    <select name="category" onchange="this.form.submit()">
                        <option value="" ${empty selected ? "selected" : ""}>전체</option>
                        <c:forEach var="category" items="${categories}">
                            <option value="${category}" ${category == selected ? "selected" : ""}>${category}</option>
                        </c:forEach>
                    </select>
                </form>
                <div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 g-3">
                    <c:forEach var="product" items="${products}">
                        <div class="col">
                            <div class="card shadow-sm">
                                <svg class="bd-placeholder-img card-img-top" width="100%" height="225" xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder: Thumbnail" preserveAspectRatio="xMidYMid slice" focusable="false">
                                    <title>Placeholder</title>
                                    <rect width="100%" height="100%" fill="#55595c"></rect>
                                    <image xlink:href="${img_link}" width="100%" height="225"></image>
                                </svg>

                                <div class="card-body">
                                    <p class="card-text">${product.modelName}</p>
                                    <div class="d-flex justify-content-between align-items-center">
                                        <div class="btn-group">
                                            <button type="button" class="btn btn-sm btn-outline-secondary" onclick=location.href="/product/ + ${product.productId}">View</button>
                                        </div>
                                        <small class="text-bold">₩${product.unitCost}</small>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>

                <span style="margin-top: 50px; height: 100%; display:flex; align-items: center; justify-content: center">
                    <c:if test="${prevPage != null}">
                        <a href="?page=${prevPage.pageNumber}" style="margin-right: 30px">Prev</a>
                    </c:if>
                    <c:forEach begin="1" end="${totalPage}" var="pageNumber">
                        <c:url var="pageURL" value="/">
                            <c:param name="page" value="${pageNumber - 1}" />
                        </c:url>
                        <a href="${pageURL}" style="margin-right: 5px">${pageNumber}</a>
                    </c:forEach>
                    <c:if test="${nextPage != null}">
                        <a href="?page=${nextPage.pageNumber}" style="margin-left: 30px">Next</a>
                    </c:if>
                </span>
            </div>
        </div>
    </main>

    <footer class="text-muted py-5">
        <div class="container">
            <p class="float-end mb-1">
                <a href="#">Back to top</a>
            </p>
            <p class="mb-1">shoppingmall example is © nhnacademy.com</p>
        </div>
    </footer>
</div>
</body>
</html>