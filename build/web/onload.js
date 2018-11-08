window.onload = function () {
	var script = document.createElement("script");
	var src = 'javascript.js?random=' + new Date().getTime();
	script.setAttribute('src',src);
	$('body:first').append(script);
	onload();
}