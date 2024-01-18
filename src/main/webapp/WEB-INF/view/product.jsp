<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>${product.modelName}</title>
</head>
<body>
<div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 g-3">
    <div>
        <h1>${product.modelName}</h1>
        <h3>${product.modelNumber}</h3>
        <div>${product.description}</div>
        <small class="text-bold">₩${product.unitCost}</small>
        <small class="text-muted">남은 수량 : ${product.quantity}</small>
        <svg class="bd-placeholder-img" width="100%" height="400" xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder: Thumbnail" preserveAspectRatio="xMidYMid slice" focusable="false">
            <title>Placeholder</title>
            <rect width="100%" height="100%" fill="#55595c"></rect>
            <image width="100%" height="400"></image>
        </svg>
        <div class="btn-group" style="margin-top: 50px">
            <button type="button" class="btn btn-sm btn-outline-secondary" onclick=location.href="/product/${product.productId}/buy">Buy</button>
            <form method="post" action="/product/${product.productId}/cart">
                <button type="submit" class="btn btn-sm btn-outline-secondary">Cart</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>
