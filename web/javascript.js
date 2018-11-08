function onload() {
	var sign = document.createElement("div");
	var body = document.getElementsByTagName("body")[0];
	var wrap = document.getElementById("wrap");
	var header = document.getElementById("header");
	sign.setAttribute("id", "sign");
	sign.innerHTML = "this is sign";
	var background = document.createElement("div");
	background.setAttribute("id", "background");
	background.addEventListener("click", function (e) {
		body.removeChild(this);
		wrap.removeChild(sign);
	});
	//--------show hide popup sign in ------------------------------------------//
	var profile = document.getElementById("profile");
	profile.addEventListener("click", function (e) {
		$("#sign").css({ "z-index": "100", "display": "block" });
		$("#sign").animate({
			"opacity": "1"
		}, 500);
	});
	$('#sign').on('click', function (e) {
		if (e.target !== this) return;

		$('#sign').animate({
			opacity: "0"
		}, 500);
		setTimeout(() => {
			$("#sign").css({ "z-index": "0", "display": "none" });
		}, 500);

	});
	//------------------end show hide pupop sign in-----------------------------------//
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
            if ((current > (height-500))){
                console.log(document.documentElement.scrollTop);
                if (offset < 31){
                    addNews(offset);
                    offset +=10;
                }
		}
	});
	//------------------- đọc bài viết json ---------------------------------------
	// var xhr = new XMLHttpRequest();
	// xhr.onreadystatechange = function () {
	// 	if (this.readyState == 4 && this.status == 200){
 //                        console.log("doc duoc file");
	// 		update(xhr.responseText);			
	// 	}
	// }
	// xhr.open("GET","./json/news.json?random="+new Date().getTime());
	// xhr.send();
	//--------------------------------------------------doc bai viet sql -----------------
	$.ajax({
		type : 'POST',
		url : 'NewsServlet',
		data : {sl : 10,
			offset : 0
				},
		success : update
	});
}
var offset = 10;
function addNews(offset){
	$.ajax({
        type : 'POST',
        url : 'NewsServlet',
        data : {sl : 10,
        offset : offset
    	},
    success : update
        });
}
function update(json) {
	json = json.replace(/\\n/g, "\\n")  
               .replace(/\\'/g, "\\'")
               .replace(/\\"/g, '\\"')
               .replace(/\\&/g, "\\&")
               .replace(/\\r/g, "\\r")
               .replace(/\\t/g, "\\t")
               .replace(/\\b/g, "\\b")
               .replace(/\\f/g, "\\f");
// remove non-printable and other non-valid JSON chars
	json = json.replace(/[\u0000-\u0019]+/g,"");     
	console.log(json);
	var object = JSON.parse(json);
	console.log(object);
	for (var i=0; i< object.length; i++){		
		var li = document.createElement("li");
		var left_news = document.createElement("div");
		left_news.className = "left_news";
		var a1 = document.createElement("a");	
		a1.setAttribute("href","./SubContent"+object[i].link);
		var img = document.createElement("img");
		img.setAttribute("src",object[i].image);
		var right_news = document.createElement("div");
		right_news.className = "right_news";
		var a2 = document.createElement("a");
		a2.setAttribute("href","./SubContent?link="+object[i].link);
		var h2 = document.createElement("h2");
		h2.className = "title";
		h2.innerHTML = object[i].title;
		var time = document.createElement("p");
		time.innerHTML = object[i].time;
		var content = document.createElement("p");
		content.innerHTML = object[i].content;
		a1.appendChild(img);
		left_news.appendChild(a1);
		li.appendChild(left_news);
		a2.appendChild(h2);
		right_news.appendChild(a2);
		right_news.appendChild(time);
		right_news.appendChild(content);
		li.appendChild(right_news);
		var ul = document.getElementById("listNews");
		ul.appendChild(li);
	}
	
}