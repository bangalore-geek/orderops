<#import "macro.ftl" as macro/>
	<title>myHELPER</title>
	 <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
	 <link rel="stylesheet" type="text/css" href="css/bootstrap-theme.min.css">
     <link rel="stylesheet" type="text/css" href="css/font-awesome.css">
     <link rel="stylesheet" type="text/css" href="css/toastr.css">
     <link rel="stylesheet" type="text/css" href="css/jquery.jqplot.css">
     <link rel="stylesheet" type="text/css" href="css/angular-wizard.min.css">
     
     <link rel="stylesheet" type="text/css" href="css/animate.min.css">
     <link rel="stylesheet" type="text/css" href="css/custom.css">
     <link rel="stylesheet" type="text/css" href="css/floatexamples.css">
     <link rel="stylesheet" type="text/css" href="css/normalize.css">
     <link rel="stylesheet" type="text/css" href="css/nprogress.css">
     <link rel="stylesheet" type="text/css" href="css/icheck/flat/green.css">
     
	<#if user?exists>
	<#else>
	<nav class="navbar navbar-default nav-grad navbar-static-top navbar-fixed-top" role="navigation">
		 <div class="container">
			<div>
				<ul class="nav navbar-nav">
					<li><a href="index.htm"><span class="glyphicon glyphicon-home"></span> Home</a></li>
					<li><a href="products.htm"><span class="glyphicon glyphicon-list-alt"></span> Products</a></li>
					<li><a href="services.htm"><span class="glyphicon glyphicon-folder-open"></span> Services</a></li>
					<li><a href="about.htm"><span class="glyphicon glyphicon-user"></span> About US</a></li>
					<li><a href="contact.htm"><span class="glyphicon glyphicon-phone-alt"></span> Contact</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="${rc.getContextPath()}/user-login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
				</ul>
			</div>
		 </div>
	</nav>
	</#if>