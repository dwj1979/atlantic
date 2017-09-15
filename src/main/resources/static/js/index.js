$(function(){	
	$("#reg").bind("click",function(){
		regist(1);		
	})	
	$("#regts").bind("click",function(){
		regist(10);		
	})	
})

var ipp = 'http://127.0.0.1:9876';

function regist(n){
	var param = {};
	param.uname = $("#uname").val();
	param.pswd = $("#pswd").val();
	param.comment = $("#comment").val();
	param.phone = $("#phone").val();
	param.addr = $("#addr").val();
	param.gender = $("#gender").val();
	var url = ipp+"/user/add";
	for (var i = 0; i < n; i++) {
		post(url,param);
	}
}

function post(url,data){
	$.ajax({
		type : "POST",
		contentType: "application/json; charset=utf-8",
		url : url,
		data: JSON.stringify(data),
		success : function(data) {
			return data;
		},
		error : function (data) {
			alert("fail!");
	    }
	})
}