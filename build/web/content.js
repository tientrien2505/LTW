window.onload = function () {
	
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function () {
		if (this.readyState == 4 && this.status == 200){
            console.log("doc duoc file");
			setInterval(update(xhr.responseText),5000);
		}
	}
	xhr.open("GET","./json/content.json?random="+new Date().getTime());
	xhr.send();
}
function update(json) {
	console.log(json);
	var object = JSON.parse(json);
	console.log(object);
	var h1 = document.createElement("h1");
	h1.innerHTML = object.h1;
	var h2 = document.createElement("h2");
	h2.innerHTML = object.h2;
	var divContent = document.createElement("div");
	divContent.innerHTML = object.content;
	var wrap = document.getElementById("addContent");
	wrap.appendChild(h1);
	wrap.appendChild(h2);
	wrap.appendChild(divContent);
}