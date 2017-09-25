$(function(){	
	$("#reg").bind("click",function(){
		regist(1);		
	})	
	$("#regts").bind("click",function(){
		regist(10);		
	})	
	$("#find").bind("click",function(){
		find();		
	})	
})

var ipp = 'http://127.0.0.1:9876';

function find(){
	var param = {};
	param.uname = $("#funame").val();
	param.phone = $("#fphone").val();
	var url = ipp+"/user/find";
	var res = post(url,param);
	reload(res);
}

function reload(data){
	var html='';
	for (var i = 0; i < data.length; i++) {
		var d = data[i];
		html+=
			'<tr>'+
			'<td>'+d.user_id+'</td>'+
			'<td>'+d.user_name+'</td>'+
			'<td>'+d.phone+'</td>'+
			'<td>'+choseNV(d.gender)+'</td>'+
			'<td>'+d.addr+'</td>'+
			'<td>'+d.comment+'</td>'+
			'</tr>';
	}
	$("#data").html(html);	
}
function choseNV(data){
	if(data==0) return '女';
	return '男';
}

function regist(n){
	var param = {};
	param.uname = $("#uname").val();
	param.pswd = $("#pswd").val();
	param.comment = $("#comment").val();
	param.phone = $("#phone").val();
	param.addr = $("#addr").val();
	param.gender = $("#gender").val();
	if(param.uname==''||param.pswd==''||param.comment==''||
			param.phone==''||param.addr==''||param.gender==''){
		alert("信息填写全了");
	}
	var url = ipp+"/user/add";
	for (var i = 0; i < n; i++) {
		var res = post(url,param);
		if(res=='fail'){ 
			alert("fail");
			return;
		}
	}
	alert('成功');
}

function post(url,data){
	var res = 'fail';
	$.ajax({
		type : "POST",
		contentType: "application/json; charset=utf-8",
		url : url,
		async: false,
		data: JSON.stringify(data),
		success : function(data) {
			res = data;
		},
		error : function (data) {
			alert("fail!");
	    }
	})
	return res;
}