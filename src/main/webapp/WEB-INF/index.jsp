<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>HBG Discounting</title>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">

<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css">
</head>

<body role="document">
	<!-- Fixed navbar -->
	<div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		<div class="container">
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li class="active"><a href="<c:out value="/"/>">Home</a></li>

				</ul>
			</div>
		</div>
	</div>
	<div class="container theme-showcase" role="main">
		<div class="page-header">
			<h1>
				<!-- Intentionally left blank to give some leading space -->
			</h1>
		</div>
		<div class="page-header">
			<h2>HBG Discounting Application</h2>
		</div>
		<a href="<c:out value="/home"/>">Rule Engine Configuration</a>

		<%-- <c:choose>
			<c:when test="${!qualifiers.equals(' ')}">
				<div class="alert alert-success" role="alert">
					Rules qualified: <strong><c:out value="${qualifiers}" /></strong>
				</div>
			</c:when>
		</c:choose> --%>

		<%-- <c:choose>
			<c:when test="${!netOutput.equals(' ')}">
				<div class="alert alert-success" role="alert">
					Output: <strong><c:out value="${netOutput}" /></strong>
				</div>
			</c:when>
		</c:choose> --%>
		</div>

		<!-- Added Rules are displayed below -->

		<ul class="nav nav-tabs" role="tablist">
			<li class="active"><a href="#room" role="tab" data-toggle="tab">Rule
					Set</a></li>
			<li><a href="#orderLine" role="tab" data-toggle="tab">Order
					Lines</a></li>
			<li><a href="#standardRule" role="tab" data-toggle="tab">Standard
					Rule</a></li>
		</ul>

		<!-- Tab panes -->
		<div class="tab-content">
			<div class="tab-pane active" id="room">
				<div class="row">
					<div class="col-md-12">
						<table class="table table-striped">
							<thead>
								<tr>
									<th>Rule Number</th>
									<th>Rule Name</th>
									<th>Account</th>
									<th>FC</th>
									<th>DGP</th>
									<th>AT</th>
									<th>Isbn</th>
									<th>Discount</th>
									<th>Priority</th>
									<th>Terms</th>
									<th>Frieght Charge</th>
									<th>Combo</th>
									<th>Overriden Explicitly</th>
									<th>Hardcode</th>
									<th>Quantity Range1</th>
									<th>Discount Range1</th>
									<th>Quantity Range2</th>
									<th>Discount Range2</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="rulesetup" varStatus="item"
									items="${ruleSetUpList}">
									<tr>
										<td>${rulesetup.ruleNumber}</td>
										<td>${rulesetup.ruleName}</td>
										<td>${sprinkler.ruleSetup.account.accountNumber}</td>
										<td>${rulesetup.product.familyCode}</td>
										<td>${rulesetup.product.productGroupCode}</td>
										<td>${rulesetup.account.accountType}</td>
										<td>${rulesetup.product.isbn}</td>
										<td>${rulesetup.discount.percentage}</td>
										<td>${rulesetup.offer.priority}</td>
										<td>${rulesetup.offer.days}</td>
										<td>${rulesetup.offer.frieghtCharge}</td>
										<td>${rulesetup.offer.comboField}</td>
										<td>${rulesetup.offer.overridenExplicitly}</td>
										<td>${rulesetup.offer.hardcode}</td>
										<td>${rulesetup.quantityRange1}</td>
										<td>${rulesetup.discountRange1}</td>
										<td>${rulesetup.quantityRange2}</td>
										<td>${uleSetup.discountRange2}</td> 
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>

			<div class="tab-pane" id="standardRule">
				<div class="row">
					<div class="col-md-12">
						<table class="table table-striped">
							<thead>
								<tr>
									<th>Rule Number</th>
									<th>Rule Name</th>
									<th>Account Type</th>
									<th>FC</th>
									<th>Isbn</th>
									<th>Quantity Range1</th>
									<th>Discount Range1</th>
									<th>Quantity Range2</th>
									<th>Discount Range2</th>
									<th>Quantity Range3</th>
									<th>Discount Range3</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="standardRuleSetup" varStatus="item"
									items="${standardRuleSetUpList}">
									<tr>
										<td>${standardRuleSetup.ruleNumber}</td>
										<td>${standardRuleSetup.ruleName}</td>
										<td>${standardRuleSetup.account.accountType}</td>
										<td>${standardRuleSetup.product.familyCode}</td>
										<td>${standardRuleSetup.product.isbn}</td>
										<td>${standardRuleSetup.quantityRange1}</td>
										<td>${standardRuleSetup.discountRange1}</td>
										<td>${standardRuleSetup.quantityRange2}</td>
										<td>${standardRuleSetup.discountRange2}</td>
										<td>${standardRuleSetup.quantityRange3}</td>
										<td>${standardRuleSetup.discountRange3}</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>

			<div class="tab-pane" id="orderLine">
				<div class="row">
					<div class="col-md-12">
						<table class="table table-striped">
							<thead>
								<tr>
									<th>Order Line#</th>
									<th>Account Number</th>
									<th>AT</th>
									<th>FC</th>
									<th>DGP</th>
									<th>Isbn</th>
									<th>Quantity</th>
									<th><form:form method="POST" action="generateOffer"
											commandName="demoForm">
											<div class="input-group">
												<span class="input-group-btn"> <input
													class="btn btn-success" type="submit"
													value="Generate Offer" />
												</span>
											</div>
										</form:form></th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="orderLine" varStatus="item"
									items="${orderLineList}">
									<tr>
										<form:form method="POST" action="deleteOrder"
											commandName="demoForm">
											<td>${orderLine.orderLineId}</td>
											<td>${orderLine.account.accountNumber}</td>
											<td>${orderLine.account.accountType}</td>
											<td>${orderLine.product.familyCode}</td>
											<td>${orderLine.product.productGroupCode}</td>
											<td>${orderLine.product.isbn}</td>
											<td>${orderLine.quantity}</td>
											<td><span class="input-group-btn"> <input
													class="btn btn-success" type="submit" value="Delete Order" />
											</span></td>
										</form:form>
									</tr>
								</c:forEach>

							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- /container -->

	<!-- Latest compiled and minified Jquery and Bootstrap JavaScript -->
	<script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>

</body>
</html>