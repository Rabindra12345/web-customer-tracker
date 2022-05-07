<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

<head>
	<title>List Customers</title>
	
	<!-- reference our style sheet -->

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css" />
	
	
		  
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">

</head>

<body>

	<div id="wrapper">
		<div id="header">
			<center><h2>RCMS - Rabindra's Customer  Management System</h2></center>
			 <audio controls>
				  <source src="${pageContext.request.contextPath}/resources/GASHI - Mama (Official Video) ft. Sting.mp3" type="audio/ogg">
 			</audio> 
		</div>
	</div>
	
	<div id="container">
	
		<div id="content">
		<!-- put new button: Add Customer -->
		
			<input type="button" value="Add Customer"
			onclick="window.location.href='showFormForAdd'; return false;"
			class="add-button"
			/>
		
			<!--  add our html table here -->
		
			<table>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Update</th>
					<th>Delete</th>
				</tr>
				
				<!-- loop over and print our customers -->
				<c:forEach var="tempCustomer" items="${customers}">
				
				<!-- construct a update link with customer id-->
				
				<c:url var="updateLink" value="/customers/showFormForUpdate">
						<c:param name="customerId" value="${tempCustomer.id }"/>
				</c:url>
				
				<!-- construct a delete link with customer id-->
				
				<c:url var="deleteLink" value="/customers/delete">
						<c:param name="customerId" value="${tempCustomer.id }"/>
				</c:url>
				
					<tr>
						<td> ${tempCustomer.firstName} </td>
						<td> ${tempCustomer.lastName} </td>
						<td> ${tempCustomer.email} </td>
						
						<!-- display the update link -->
						<td>
							<a href="${updateLink }">Update</a>
						</td>
						
						<!-- display the delete link -->
						<td>
							<a href="${deleteLink }" 
							onclick="if (!(confirm('Are you sure you want to delete this customer?'))) return false">Delete</a>
						</td>
					</tr>
				
				</c:forEach>
						
			</table>
				
		</div>
	
	</div>
	
	<!-- footer section here -->
 	<div class="footer-dark">
        <footer>
            <div class="container">
                <div class="row">
                    <div class="col-sm-6 col-md-3 item">
                        <h3>Services</h3>
                        <ul>
                            <li><a href="#">Web design</a></li>
                            <li><a href="#">Development</a></li>
                            <li><a href="#">Hosting</a></li>
                        </ul>
                    </div>
                    <div class="col-sm-6 col-md-3 item">
                        <h3>About</h3>
                        <ul>
                            <li><a href="#">Company</a></li>
                            <li><a href="#">Team</a></li>
                            <li><a href="#">Careers</a></li>
                        </ul>
                    </div>
                    <div class="col-md-6 item text">
                        <h3 c>Rabindra's IT Hub</h3>
                        <p>Praesent sed lobortis mi. Suspendisse vel placerat ligula. Vivamus ac sem lacus. Ut vehicula rhoncus elementum. Etiam quis tristique lectus. Aliquam in arcu eget velit pulvinar dictum vel in justo.</p>
                    </div>
                    <div class="col item social"><a href="https://www.facebook.com/ram.dahal.54379236"><i class="icon ion-social-facebook"></i></a><a href="#"><i class="icon ion-social-twitter"></i></a><a href="#"><i class="icon ion-social-snapchat"></i></a><a href="#"><i class="icon ion-social-instagram"></i></a></div>
                </div>
                <p class="copyright">Rabindra's IT Hub © 2022</p>
            </div>
        </footer>

</body>

</html>









