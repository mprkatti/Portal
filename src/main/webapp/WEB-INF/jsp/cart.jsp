<%@ include file="header.jsp"%>
<div class="container">
	<div class="row">

		<div class="col-sm-4">
			<div class="panel panel-primary">
				<div class="panel-heading">
					<b>Cart : ${cart.userName}</b>
				</div>
				<div class="panel-body">

					<p>Amount : ${cart.cartTotal}</p>

				</div>

				<div class="row">
					<c:forEach items="${cart.items}" var="item">

						<div class="panel panel-primary">
							<div class="panel-heading">${product.name}</div>
							<div class="panel-body">
								<p>Description : ${item.description}</p>
								<p>Quantity : ${item.quantity}</p>
								<p>Price : ${item.price}</p>
							</div>

						</div>
					</c:forEach>
				</div>
				<div class="panel-footer">
					<button type="button" class="btn btn-primary btn-md"
						onClick="location.href='/portal/products' ">Proceed to Payment</button>
				</div>
			</div>

		</div>
	</div>
</div>
<br>

</body>
</html>