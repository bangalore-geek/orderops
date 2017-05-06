<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>Sign in-OrderOPS</title>
<meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/font-awesome.min.css" rel="stylesheet">
<link href="css/animate.min.css" rel="stylesheet">
<link href="css/custom.css" rel="stylesheet">
<link href="css/icheck/flat/green.css" rel="stylesheet">
<script src="js/core/jquery-1.9.1.js" type="text/javascript"></script>
</head>

<body style="background: #F7F7F7;">
	<div class="" ng-controller="loginCtrl">
		<a id="toregister" class="hiddenanchor"></a> <a id="tologin"
			class="hiddenanchor"></a>

		<div id="wrapper">
			<div class="animate form" id="login">
				<section class="login_content">
					<form class="form-signin" method="post" action="/login">
						<h1>Login Form</h1>
						<div>
							<input type="text" class="form-control" name="username"
								placeholder="User name">
						</div>
						<div>
							<input type="password" class="form-control" name="password"
								placeholder="Password">
						</div>
						<div>
							<button class="btn btn-default" type="submit">Log in</button>
							<a class="to_register" href="#toregister">Lost your password?</a>
						</div>
						<div class="clearfix"></div>
						<div class="separator">
							<div class="clearfix"></div>
							<br>
							<div>
								<h1>
									<i style="font-size: 26px;" class="fa fa-paw"></i> OrderOps!
								</h1>

								<p>&copy;2015 All Rights Reserved. Gentelella Alela! is a
									Bootstrap 3 template. Privacy and Terms</p>
							</div>
						</div>
					</form>
					<!-- form -->
				</section>
				<!-- content -->
			</div>
			<div class="animate form" id="register">
				<section class="login_content">
					<form method="post" action="/forgetPassword">
						<h1>Forget Password</h1>
						<div>
							<input type="email" required="" placeholder="Email" name="email"
								class="form-control">
						</div>
						<div>
							<button type="submit" class="btn btn-default submit">Submit</button>
						</div>
						<div class="clearfix"></div>
						<div class="separator">

							<p class="change_link">
								Already a member ? <a class="to_register" href="#tologin">
									Log in </a>
							</p>

							<div class="clearfix"></div>
							<br>
							<div>
								<h1>
									<i style="font-size: 26px;" class="fa fa-paw"></i> Gentelella
									Alela!
								</h1>

								<p>&copy;2015 All Rights Reserved. Gentelella Alela! is a
									Bootstrap 3 template. Privacy and Terms</p>
							</div>
						</div>
					</form>
					<!-- form -->
				</section>
				<!-- content -->
			</div>
		</div>
	</div>
	<script type="text/javascript">
        var _contextPath = '${rc.getContextPath()}';
</script>
<script type="text/javascript" src="js/pages/reset-password.js"></script>
</body>
</html>

