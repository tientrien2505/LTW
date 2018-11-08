window.onload = function(){
    var nav = document.getElementById("nav");
	var current = document.documentElement.scrollTop;
//        console.log(current);
	window.addEventListener("scroll",function (e) {
//            console.log(current);
            if (document.documentElement.scrollTop > current){
//                console.log(document.documentElement.sroolTop);
		nav.className="nav";
		var t = parseInt($("header").css("height"),10)-50;
		var e = document.getElementsByClassName("nav");
		e[0].setAttribute("style","top:"+t+"px");
		current = document.documentElement.scrollTop;
		}
            else {
		nav.className = "nav1";
		$(".nav1").css("top",$("header").css("height"));
		current = document.documentElement.scrollTop;
            }
            var height = document.body.scrollHeight;
//            var current = document.documentElement.scrollTop;                            
	});
}