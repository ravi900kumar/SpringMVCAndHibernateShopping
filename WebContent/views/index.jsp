<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Index Page</title>
</head>
<body>
<center><h1>Spring MVC And Hibernate Shopping Cart</h1></center>

<table border="3" align="center" ><tr>
 
<td>Id</td>
<td>Photo</td>
<td>Name</td>
<td>Price</td>
<td>Quantity</td>
<td>Description</td>


</tr>

<c:forEach var="p" items="${listproduct}">


<tr>

<td>${p.id }</td>
<td>
<img alt="" src="${pageContext.request.contextPath}/images/${p.photo}" height="100px" width="100px">

</td>
<td>${p.name}</td>
<td>${p.price}</td>
<td>${p.quantity}</td>
<td>${p.description}</td>



<td><a href="${pageContext.request.contextPath}/shoppingcart/ordernow/${p.id }.html"  >OrderNow</a></td>

</tr>

</c:forEach>
</table>
</body>
</html>