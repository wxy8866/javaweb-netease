<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Add Product Form</title>
<style type="text/css">
@import url(css/main.css);
</style>
</head>
<body>
	<form method="post" action="save-product">
		<h1>
			Add Product <span>Please use this form to enter product details</span>
		</h1>
		<label> <span>Product Name :</span> <input id="name" type="text" name="name" placeholder="The complete product name" />
		</label> 
		<br/>
		<label> <span>Description :</span> <input id="description" type="text" name="description" placeholder="Product description" />
		</label>
		<br/>
		<label> <span>Price :</span> <input id="price" name="price" type="number" step="any" placeholder="Product price in #.## format" />
		</label>
		<br/> 
		<label> <span>&nbsp;</span> <input type="submit" />
		</label>
	</form>
</body>
</html>