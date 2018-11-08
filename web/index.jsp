<%-- 
    Document   : index
    Created on : Nov 5, 2018, 10:33:21 AM
    Author     : TruongDao
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="style.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" />
	<link href="https://fonts.googleapis.com/css?family=Roboto:100,300,400,500,700,900|Lato|Rubik:400,500,700,900&amp;subset=latin-ext"
	 rel="stylesheet">
	<script type="text/javascript" src="jquery.js"></script>
	<script type="text/javascript" src="onload.js"></script>
        <title>Home</title>
    </head>
    <body>
        <jsp:include page="header.jsp"></jsp:include>
        <div id="sign" class="main-content-agile">
		<div class="popup">
			<h2>Using PTIT Account</h2>
			<form name="aspnetForm" method="post" action="Login" id="aspnetForm">
				<input type="hidden" name="__EVENTTARGET" id="__EVENTTARGET" value="" />
				<input type="hidden" name="__EVENTARGUMENT" id="__EVENTARGUMENT" value="" />

				<!-- <div> -->

				<!-- <input type="hidden" name="__VIEWSTATEGENERATOR" id="__VIEWSTATEGENERATOR" value="CA0B0334" /> -->
				<!-- </div> -->
				<div class="field mr-bottom">
					<span class="fa fa-user-o" aria-hidden="true"></span>
					<input placeholder="User" name="ctl00$ContentPlaceHolder1$ctl00$ucDangNhap$txtTaiKhoa" type="text" id="ctl00_ContentPlaceHolder1_ctl00_ucDangNhap_txtTaiKhoa"
					 required />
				</div>
				<div class="field">
					<span class="fa fa-key" aria-hidden="true"></span>
					<input placeholder="Password" name="ctl00$ContentPlaceHolder1$ctl00$ucDangNhap$txtMatKhau" type="password" id="ctl00_ContentPlaceHolder1_ctl00_ucDangNhap_txtMatKhau"
					 required />
				</div>
				<p class="error">
				</p>
				<div class="sub">
					<a id="ctl00_ContentPlaceHolder1_ctl00_ucDangNhap_lnkBtnQuenMK" href="javascript:__doPostBack('ctl00$ContentPlaceHolder1$ctl00$ucDangNhap$lnkBtnQuenMK','')">Quên
						mật khẩu!</a>
				</div>
				<div class="submit">
					<input type="submit" name="ctl00$ContentPlaceHolder1$ctl00$ucDangNhap$btnDangNhap" value="Đăng Nhập" id="ctl00_ContentPlaceHolder1_ctl00_ucDangNhap_btnDangNhap" />
				</div>
			</form>
		</div>
	</div>
        <div id="wrap" class="wrap">
			<main>
				<article>
					<div id="news">
        				<ul id="listNews">
		        		</ul>
        			</div>
				</article>
				<aside>
					this is aside
				</aside>				
			</main>
		</div>
    </body>
</html>
