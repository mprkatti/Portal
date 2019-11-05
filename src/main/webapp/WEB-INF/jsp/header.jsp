<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>MPK Store</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

<!-- includes jQuery -->
<script src="http://code.jquery.com/jquery-3.2.1.min.js" crossorigin="anonymous"></script>

</head>
<body>
	<div class="container text-center">
		<h1>Welcome to Amzng' Store</h1>
		<p>
			<b>Browse our wowsome products and deals of the day</b>
		</p>
	</div>

	<nav class="navbar navbar-inverse" style="background-color: #333399;">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#myNavbar">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">AMAZNG</a>
			</div>
			<div class="collapse navbar-collapse" id="myNavbar">
				<ul class="nav navbar-nav">
					<li class="active"><a href="/portal"><b>Home</b></a></li>
					<li><a href="/portal/products"><b>Products</b></a></li>
					<li><a href="#"><b>Deals of the Day</b></a></li>
					<li><a href="#"><b>Stores</b></a></li>
					<li><a href="#"><b>Contact Us</b></a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">

					<li><a href="#" class="dropdown-toggle" data-toggle="dropdown"><i
							class="glyphicon glyphicon-user"></i> <b> Profile </b><b
							class="caret"></b></a>
						<ul class="dropdown-menu">
							<li><a href="/"><i class="glyphicon glyphicon-plus"></i>
									Account</a></li>
							<li><a href="/"><i class="glyphicon glyphicon-cog"></i>
									Settings</a></li>
							<li><a href="/"><i class="glyphicon glyphicon-comment"></i>
									Notifications</a></li>
						</ul></li>
					<li><a href="/portal/products/cart" id="shoppingbasket"><span
							class="glyphicon glyphicon-shopping-cart"></span> <b>Cart</b> <span
							id="count"></span></a></li>
					<li><a href="#"> <span class="glyphicon glyphicon-heart"></span> <b>Wishlist</b>
					</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<script type="text/javascript">
		var items =${itemCount};
		$(document).ready(function() {
			if (items != 0) {
				$("#count").append("(" + items + (")"));
			}
		});
	</script>