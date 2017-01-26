<%@ include file="/layout/header.jsp"%>

<div class="vid-container">
	<video class="bgvid" autoplay="autoplay" muted="muted" preload="auto"
		loop>
		<source src="video/Cooking.mp4" type="video/webm">
	</video>
	<div class="inner-container">
		<div class="box">
			<form action="login" method="post" name="Login_Form"
				>
				<h3 class="form-signin-heading">Bienvenido!! Introduzca sus
					datos</h3>
				<hr class="colorgraph">
				<br> <input type="text" class="form-control" name="user"
					placeholder="Username" required="" autofocus="" /> <input
					type="password" class="form-control" name="pass"
					placeholder="Password" required="" />
				<%
					if (request.getParameter("error") != null) {
						if (Integer.parseInt(request.getParameter("error")) == 1) {
				%>
				<div class="alert alert-warning alert-dismissible" role="alert">
					<button type="button" class="close" data-dismiss="alert"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<strong>Error!</strong>Nombre de usuario o contraseña incorrectos
				</div>
				<%
					}
					}
				%>
				<button class="btn btn-lg btn-primary btn-block" name="Submit"
					value="Login" type="Submit">Login</button>
			</form>
		</div>
	</div>
</div>

<%@ include file="/layout/footer.jsp"%>