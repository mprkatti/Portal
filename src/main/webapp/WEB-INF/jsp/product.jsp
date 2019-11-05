<%@ include file="header.jsp"%>

<div class="container">
	<div class="row">

		<div class="col-sm-4">
			<div class="panel panel-primary">
				<div class="panel-heading">${product.name}</div>
				<div class="panel-body">
					<p>Description : ${product.description}</p>
					<p>Price : ${product.price}</p>
					<p>Seller : ${product.seller}</p>
					<p>Image : ${product.imageUrl}</p>
				</div>
				<form action="/portal/products/${product.id}" method="POST">
					<div class="panel-footer">

						 
						<button type="submit" class="btn btn-primary btn-md"><b>Purchase</b></button>
					</div>
				</form>
			</div>
		</div>

	</div>
</div>
<br>

</body>
</html>