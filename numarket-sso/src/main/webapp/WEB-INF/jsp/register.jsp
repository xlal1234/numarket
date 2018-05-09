<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="Cache-Control" content="no-cache,must-revalidate">
    <title>Regist An Account</title>
    <link type="text/css" rel="stylesheet" href="/css/regist.personal.css"/>
    <link type="text/css" rel="stylesheet" href="/css/passport.base.css"/>
    <script type="text/javascript" src="/js/jquery-1.6.4.js"></script>
</head>
<body>
<!-- <div class="w" id="logo">
    <div>
    	<a href="http://localhost:8082">
    		<img src="/images/taotao-logo.gif" alt="淘淘商城" width="170" height="60"/>
    	</a> <b></b>
    </div>
</div> -->

<div class="w" id="regist">
    <div class="mt">
        <ul class="tab">
            <li class="curr">Private Account</li>
        </ul>
        <div class="extra">
        <span>Had registered, Now&nbsp;
        	<a href="/page/login" class="flk13">Login</a>
        </span>
        </div>
    </div>
    <div class="mc">
        <form id="personRegForm" method="post" onsubmit="return false;">
            <div class="form" onselectstart="return false;">
                <div class="item" id="select-regName">
                    <span class="label"><b class="ftx04">*</b>Set Username：</span>

                    <div class="fl item-ifo">
                        <div class="o-intelligent-regName">
                            <input type="text" id="regName" name="username" class="text" tabindex="1" autoComplete="off"
                                   onpaste="return false;"
                                   value=""
                                   onfocus="if(this.value=='') this.value='';this.style.color='#333'"
                                   onblur="if(this.value=='') {this.value='';this.style.color='#999999'}"/>
                            <i class="i-name"></i>
                            <ul id="intelligent-regName" class="hide"></ul>
                            <label id="regName_succeed" class="blank"></label>
                            <label id="regName_error" class="hide"></label>
                        </div>
                    </div>
                </div>
                <div id="o-password">
                    <div class="item">
                        <span class="label"><b class="ftx04">*</b>Set Password：</span>

                        <div class="fl item-ifo">
                            <input type="password" id="pwd" name="password" class="text" tabindex="2"
                                   style="ime-mode:disabled;"
                                   onpaste="return  false" autocomplete="off"/>
                            <i class="i-pass"></i>
                            <label id="pwd_succeed" class="blank"></label>
                            <label id="pwd_error"></label>
                            <span class="clr"></span>
                        </div>
                    </div>

                    <div class="item">
                        <span class="label"><b class="ftx04">*</b>Confirm Password：</span>

                        <div class="fl item-ifo">
                            <input type="password" id="pwdRepeat" name="pwdRepeat" class="text" tabindex="3"
                                   onpaste="return  false" autocomplete="off"/>
                            <i class="i-pass"></i>
                            <label id="pwdRepeat_succeed" class="blank"></label>
                            <label id="pwdRepeat_error"></label>
                        </div>
                    </div>
					<div class="item" id="dphone">
						<span class="label"><b class="ftx04">*</b>Verfiy Phone No.：</span>

						<div class="fl item-ifo">
							<input type="text" id="phone" maxlength="11" name="phone"
								class="text" tabindex="4"
								autocomplete="off" /> <i class="i-phone"></i> <label
								id="phone_succeed" class="blank"></label> <label
								id="phone_error"></label>
						</div>
					</div>
					</div>
                <div class="item item-new">
                    <span class="label">&nbsp;</span>

                    <div class="fl item-ifo">
                        <input type="checkbox" class="checkbox" checked="checked" id="readme"
                               onclick="agreeonProtocol();">
                        <label for="protocol">Agree With <a href="#" class="blue" id="protocol">《User Rule》</a></label>
                        <span class="clr"></span>
                        <label id="protocol_error" class="error hide">Please, accept the User Rule</label>
                    </div>
                </div>
                <div class="item">
                    <span class="label">&nbsp;</span>
                    <input type="button" class="btn-img btn-regist" id="registsubmit" value="Regist" tabindex="8"
                           clstag="regist|keycount|personalreg|07"
                           onclick="REGISTER.reg();"/>
                </div>
            </div>
            <!-- <div class="phone">
                <img width="180" height="180" src="/images/phone-bg.jpg">
            </div> -->
            <span class="clr"></span>
        </form>
    </div>
<script type="text/javascript">
	var REGISTER={
		param:{
			//单点登录系统的url
			surl:""
		},
		inputcheck:function(){
				//不能为空检查
				if ($("#regName").val() == "") {
					alert("Username cannot be null.");
					$("#regName").focus();
					return false;
				}
				if ($("#pwd").val() == "") {
					alert("Password cannot be null.");
					$("#pwd").focus();
					return false;
				}
				if ($("#phone").val() == "") {
					alert("Phone Number cannot be null.");
					$("#phone").focus();
					return false;
				}
				//密码检查
				if ($("#pwd").val() != $("#pwdRepeat").val()) {
					alert("Password and Re-entered Password do not match.");
					$("#pwdRepeat").select();
					$("#pwdRepeat").focus();
					return false;
				}
				return true;
		},
		beforeSubmit:function() {
				//检查用户是否已经被占用
				$.ajax({
	            	url : REGISTER.param.surl + "/user/check/"+escape($("#regName").val())+"/1?r=" + Math.random(),
	            	success : function(data) {
	            		if (data.data) {
	            			//检查手机号是否存在
	            			$.ajax({
	            				url : REGISTER.param.surl + "/user/check/"+$("#phone").val()+"/2?r=" + Math.random(),
				            	success : function(data) {
				            		if (data.data) {
					            		REGISTER.doSubmit();
				            		} else {
				            			alert("This Number Had Been Registered！");
				            			$("#phone").select();
				            		}
				            	}
	            			});
	            		} else {
	            			alert("Username Already Exists");
	            			$("#regName").select();
	            		}	
	            	}
				});
	            	
		},
		doSubmit:function() {
			$.post("/user/register",$("#personRegForm").serialize(), function(data){
				if(data.status == 200){
					alert('Success, Login Please');
					REGISTER.login();
				} else {
					alert("Failed！");
				}
			});
		},
		login:function() {
			 location.href = "/page/login";
			 return false;
		},
		reg:function() {
			if (this.inputcheck()) {
				this.beforeSubmit();
			}
		}
	};
</script>
</body>
</html>
