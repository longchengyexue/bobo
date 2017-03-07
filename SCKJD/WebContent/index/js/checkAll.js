/**
 * 前台页面的js验证
 * @return 结果
 * @author wuzhihui
 */
function checkAll(){
    //获取用户名
    var username = document.getElementById("ev.username").value;
	//获取密码
	var password = document.getElementById("ev.password").value;
	//获取确认密码
	var queren = document.getElementById("queren").value;
	//获取企业名称
	var company = document.getElementById("ev.ename").value;
	//获取电话
	var telephone = document.getElementById("ev.mobile").value;
	//获取邮箱
	var email = document.getElementById("ev.email").value;
	var reg = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/ ;
	
	//用户名
	if( (username.length < 3) || (username.length > 15)){
		alert("登录名由3-15位字母、数字或中文组成!");
		document.getElementById("ev.username").focus();
		return false;
	}
	for(var i = 0 ; i < username.length ; i++){
		if( (username.charAt(i) < '0' || username.charAt(i) > '9') && (username.charAt(i).toLowerCase() <'a' || username.charAt(i).toLowerCase() > 'z') ){
			alert("登录名由3-15位字母、数字或中文组成!");
			document.getElementById("ev.username").focus();
			return false;
		}
	}
	//密码
	if( (password.length < 6) || (password.length > 12)){
		alert("密码由6-12位数字或字符组成!");
		document.getElementById("ev.password").focus();
		return false;
	}
	for(var i = 0 ; i < password.length ; i++){
		if( (password.charAt(i) < '0' || password.charAt(i) > '9') && (password.charAt(i).toLowerCase() <'a' || password.charAt(i).toLowerCase() > 'z') ){
			alert("密码由6-12位数字或字符组成!");
			document.getElementById("ev.password").focus();
			return false;
		}
	}
	//确认密码
	if(password != queren){
		alert("两次密码必须一致!");
		document.getElementById("queren").focus();
		return false;
	}
	//企业名称
	if(company == ""){
		alert("企业名称不能为空");
		document.getElementById("ev.company").focus();
		return false;
	}
	//电话号码
	if( (telephone.length != 11) && (telephone.length != 12) ){
		alert("电话号码格式不正确!");
		document.getElementById("ev.telephone").focus();
		return false;
	}
	if( (telephone.length == 11) && (telephone.charAt(i) < '0' || telephone.charAt(i) > '9') ){
		alert("电话号码格式不正确!");
		document.getElementById("ev.telephone").focus();
		return false;
	}
	if( (telephone.length == 12) && (telephone.indexOf("-" , 0) != 3)){
		alert("电话号码格式不正确!");
		document.getElementById("ev.telephone").focus();
		return false;
	}
	//邮箱
	if(!(reg.test(email))){
		alert("邮箱格式不正确!");
		document.getElementById("ev.email").focus();
		return false;
	}
	alert("注册成功!");
	document.myForm.submit();
	return true;
}

function resett(){
	document.myForm.reset();
}
function submitt(){
    //验证用户名
    var username = document.getElementById("ev.username").value;
	var password = document.getElementById("ev.password").value;
	if(username == ""){
		alert("用户名不能为空！");
		document.getElementById("ev.username").focus();
		return false;
	}
	else
		if(password == ""){
			alert("密码不能为空！");
			document.getElementById("ev.password").focus();
			return false;
		}
		else{
			document.myForm.submit();
			return true;
		}
}