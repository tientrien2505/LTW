<%-- 
    Document   : header
    Created on : Oct 31, 2018, 10:50:58 PM
    Author     : TruongDao
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Header</title>
        <link rel="stylesheet" type="text/css" href="header.css">
    </head>
    <body>
        <header id="header">
            <div class ="wrap">
                <div id="logo"></div>
		<div id="profile" class="text">Sign In</div>
		<div id="search_area">
                    <input type="text" name="text_search" id="text_search" placeholder="type content to search" class="text">
                    <button id="search" class="text">Search</button>
		</div>
            </div>
        </header>
	<div class="wrap">
            <nav id="nav" class="nav2">
		<ul>
                    <li title="Home">
			<a href="Main">HOME</a>
                    </li>
                    <li title="study process">
			<a href="">Study Process</a>
			<ul id="case_study">
                            <li title="study C"><a href="StudyWeb.jsp">STUDY WEB</a></li>
                            <li title="study java"><a href="#">STUDY JAVA</a></li>
                            <li title="study javascript"><a href="#">STUDY JAVASCRIPT</a></li>
			</ul>
                    </li>
                    <li title="library">
			<a href="library.html">Library</a>
                    </li>
                    <li title="profile">
			<a href="profile.html">Profile</a>
                    </li>
		</ul>
            </nav>
	</div>
    </body>
</html>
