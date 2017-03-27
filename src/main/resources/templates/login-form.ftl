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
    
    <script src="js/core/jquery-1.9.1.js" type="text/javascript"></script>

  </head>

<body style="background:#F7F7F7;">
    
    <div class="">
        <a class="hiddenanchor" id="toregister"></a>
        <a class="hiddenanchor" id="tologin"></a>

        <div id="wrapper">
            <div id="login" class="animate form">
                <section class="login_content">
                     <form class="form-signin" method="post" action="/login">
                        <h1>Login Form</h1>
                        <div>
							<input type="text" class="form-control" name="username" placeholder="User name">
                        </div>
                        <div>
                           <input type="password" class="form-control" name="password" placeholder="Password">
                        </div>
						 
                        <div>
							<button class="btn btn-default" type="submit">Log in</button>
                        </div>
                        <div class="clearfix"></div>
                        <div class="separator">
                            <div class="clearfix"></div>
                            <br />
                            <div>
                                <h1><i class="fa fa-paw" style="font-size: 26px;"></i> Order OPS</h1>

                                <p>©2017 All Rights Reserved.</p>
                            </div>
                        </div>
                    </form>
                    <!-- form -->
                </section>
                <!-- content -->
            </div>
    </div>

<script type="text/javascript">
        var _contextPath = '${rc.getContextPath()}';
</script>
</body>
</html>


