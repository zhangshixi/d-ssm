<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
    	<title>DeCoo ERP</title>
    </head>
      
    <body class="loginPage">

	    <div class="container-fluid">
	        <div id="header">
	            <div class="row-fluid">
	                <div class="navbar">
	                    <div class="navbar-inner">
	                      <div class="container">
	                            <a class="brand" href="dashboard.html">Decoo.<span class="slogan">ERP</span></a>
	                      </div>
	                    </div><!-- /navbar-inner -->
	                  </div><!-- /navbar -->
	            </div><!-- End .row-fluid -->
	        </div><!-- End #header -->
	    </div><!-- End .container-fluid -->    
	
	    <div class="container-fluid">
	        <div class="loginContainer">
	            <form class="form-horizontal" action="dashboard.html" id="loginForm">
	                <div class="form-row row-fluid">
	                    <div class="span12">
	                        <div class="row-fluid">
	                            <label class="form-label span12" for="username">
	                                Username:
	                                <span class="icon16 icomoon-icon-user-2 right gray marginR10"></span>
	                            </label>
	                            <input class="span12" id="username" type="text" name="username" value="Administrator" />
	                        </div>
	                    </div>
	                </div>
	
	                <div class="form-row row-fluid">
	                    <div class="span12">
	                        <div class="row-fluid">
	                            <label class="form-label span12" for="password">
	                                Password:
	                                <span class="icon16 icomoon-icon-locked right gray marginR10"></span>
	                                <span class="forgot"><a href="#">Forgot your password?</a></span>
	                            </label>
	                            <input class="span12" id="password" type="password" name="password" value="somepass" />
	                        </div>
	                    </div>
	                </div>
	                <div class="form-row row-fluid">                       
	                    <div class="span12">
	                        <div class="row-fluid">
	                            <div class="form-actions">
	                            <div class="span12 controls">
	                                <input type="checkbox" id="keepLoged" value="Value" class="styled" name="logged" /> Keep me logged in
	                                <button type="submit" class="btn btn-info right" id="loginBtn"><span class="icon16 icomoon-icon-enter white"></span> Login</button>
	                            </div>
	                            </div>
	                        </div>
	                    </div> 
	                </div>
	            </form>
	        </div>
	    </div><!-- End .container-fluid -->

	    <script type="text/javascript">
	        // document ready function
	        $(document).ready(function() {
	            $("input, textarea, select").not('.nostyle').uniform();
	            $("#loginForm").validate({
	                rules: {
	                    username: {
	                        required: true,
	                        minlength: 4
	                    },
	                    password: {
	                        required: true,
	                        minlength: 6
	                    }  
	                },
	                messages: {
	                    username: {
	                        required: "Fill me please",
	                        minlength: "My name is bigger"
	                    },
	                    password: {
	                        required: "Please provide a password",
	                        minlength: "My password is more that 6 chars"
	                    }
	                }   
	            });
	        });
	    </script>
 
    </body>
</html>