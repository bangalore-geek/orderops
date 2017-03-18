<#import "/spring.ftl" as spring />

<#macro showHeader htmlclass="">
<!doctype html>
	<!-- paulirish.com/2008/conditional-stylesheets-vs-css-hacks-answer-neither/ -->
	<!--[if lt IE 7]> <html class="no-js ie6 oldie ${htmlclass}" lang="en"> <![endif]-->
	<!--[if IE 7]>	<html class="no-js ie7 oldie ${htmlclass}" lang="en"> <![endif]-->
	<!--[if IE 8]>	<html class="no-js ie8 oldie ${htmlclass}" lang="en"> <![endif]-->
	<!-- Consider adding an manifest.appcache: h5bp.com/d/Offline -->
	<!--[if gt IE 8]><!--> <html class="no-js ${htmlclass}" lang="en"> <!--<![endif]-->
	</html">
	<head>
		<meta charset="utf-8">
	
		<!-- Use the .htaccess and remove these lines to avoid edge case issues.
			More info: h5bp.com/b/378 -->
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
	
		<title>OrderOPS</title>
		<meta name="description" content="">
		<meta name="author" content="">
	
		<!-- Mobile viewport optimized: j.mp/bplateviewport -->
		<meta name="viewport" content="width=device-width,initial-scale=1">
	
		<!-- Place favicon.ico and apple-touch-icon.png in the root directory: mathiasbynens.be/notes/touch-icons -->

	</head>
	
	<body  class="nav-md" ng-app="defysope">
		<div class="container body">


        <div class="main_container">
			<#include "header.ftl" />
            <div class="col-md-3 left_col">
                <div class="left_col scroll-view">

                    <div class="navbar nav_title" style="border: 0;">
                        <a href="index.html" class="site_title"><i class="fa fa-paw"></i> <span>OrderOPS</span></a>
                    </div>
                    <div class="clearfix"></div>

                    <!-- menu prile quick info -->
                    <div class="profile">
                        <div class="profile_pic">
                            <img src="img/img1.jpg" alt="..." class="img-circle profile_img">
                        </div>
                        <div class="profile_info">
                            <span>Welcome,</span>
                            <#if user??>
   								<h2>${user.name}</h2>
							</#if>
                            
                        </div>
                    </div>
                    <!-- /menu prile quick info -->

                    <br />

                    <!-- sidebar menu -->
                    <div id="sidebar-menu" class="main_menu_side hidden-print main_menu">

                        <div class="menu_section">
                            <h3>General</h3>
                            <ul class="nav side-menu">
                                <#if menus??>
   									<#list menus?keys as prop>
									   <li><a><i class="fa fa-home"></i> ${prop} <span class="fa fa-chevron-down"></span></a>
		                                    <ul class="nav child_menu" style="display: none">
		                                    	<#list menus[prop] as navEntry>
		                                    		<li><a href="${navEntry.url}">${navEntry.title}</a></li>
		                            			</#list>        	
		                                    </ul>
                                		</li>
									</#list> 
								</#if>
                            </ul>
                        </div>
					</div>
                    <!-- /sidebar menu -->

                    <!-- /menu footer buttons -->
                    <div class="sidebar-footer hidden-small">
                        <a data-toggle="tooltip" data-placement="top" title="Settings">
                            <span class="glyphicon glyphicon-cog" aria-hidden="true"></span>
                        </a>
                        <a data-toggle="tooltip" data-placement="top" title="FullScreen">
                            <span class="glyphicon glyphicon-fullscreen" aria-hidden="true"></span>
                        </a>
                        <a data-toggle="tooltip" data-placement="top" title="Lock">
                            <span class="glyphicon glyphicon-eye-close" aria-hidden="true"></span>
                        </a>
                        <a data-toggle="tooltip" data-placement="top" title="Logout">
                            <span class="glyphicon glyphicon-off" aria-hidden="true"></span>
                        </a>
                    </div>
                    <!-- /menu footer buttons -->
                </div>
            </div>
            
			<!-- page content -->
			<div class="right_col" role="main">
                <div class="">
                    <div class="clearfix"></div>
                    <div class="row">

                        <div class="col-md-12 col-sm-12 col-xs-12">
                            <div class="x_panel" style="height:700px;">
                            <#nested/>
                                
                            
</#macro>

<#macro showFooter>

							</div>
                        </div>
                    </div>
                </div>

                <!-- footer content -->
               <!--<footer>
                    <div class="">
                        <p class="pull-right">Gentelella Alela! a Bootstrap 3 template by <a>Kimlabs</a>. |
                            <span class="lead"> <i class="fa fa-paw"></i> OrderOPS</span>
                        </p>
                    </div>
                    <div class="clearfix"></div>
                </footer>
                 /footer content -->

            </div>
            <!-- /page content -->
        </div>

    </div>
		<script type="text/javascript">
			var _context = '${rc.getContextPath()}';
		</script>

		<#include "footer.ftl" />
 
		<#nested>

		<!-- Prompt IE 6 users to install Chrome Frame. Remove this if you want to support IE 6.
			chromium.org/developers/how-tos/chrome-frame-getting-started -->
		<!--[if lt IE 7 ]>
			<script src="//ajax.googleapis.com/ajax/libs/chrome-frame/1.0.3/CFInstall.min.js"></script>
			<script>window.attachEvent('onload',function(){CFInstall.check({mode:'overlay'})})</script>
		<![endif]-->

	</body>
	</html>
</#macro>
