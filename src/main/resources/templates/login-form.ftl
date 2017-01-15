<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>Sign in-CorpYOGI</title>
    <meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <script src="js/core/jquery-1.9.1.js" type="text/javascript"></script>

  </head>

<body class=""> 
<div class="row-fluid">
    <div class="dialog">
    	<#if error?exists>
   		 <div class="alert alert-error">
    		<button data-dismiss="alert" class="close" type="button"><i class="icon-close"></i></button>
    		<strong>Oops !</strong> user name or password is incorrect.
		 </div>
		</#if> 
        <div class="block">
            <p class="block-heading">Sign In</p>
            <div class="block-body">
                <form class="form-signin" method="post" action="/login">
                	<div class="form-group">
    					<label>Username</label>
    					<div>
    						<input type="text" class="form-control" name="username" placeholder="User name">
      					</div>
  					</div>
  					<div class="form-group">
    					<label>Password</label>
    					<div>
    						<input type="password" class="form-control" name="password" placeholder="Password">
      					</div>
  					</div>
  					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/> 
                    <button class="btn btn-primary pull-right" type="submit">Login</button>
                    <div class="clearfix"></div>
                </form>
            </div>
        </div>
    </div>
  </div>

<script type="text/javascript">
        var _contextPath = '${rc.getContextPath()}';
</script>

<script src="js/core/jquery-1.9.1.js"></script>
<script src="js/core/angular.min.js"></script>
<script src="js/core/bootstrap.min.js"></script>
<script type="text/javascript" src="js/plugin/bootbox.min.js"></script>
<script type="text/javascript" src="select2/select2.js"></script>
<script src="js/core/main.js"></script>
<script src="js/core/ui-bootstrap-tpls-0.12.1.min.js"></script>
<script src="js/core/angular-animate.min.js"></script>
<script src="js/plugin/toastr.js"></script>
<script src="js/plugin/jqplot/jquery.jqplot.js"></script>
<script src="js/plugin/jqplot/jqplot.pieRenderer.js"></script>
</body>
</html>


