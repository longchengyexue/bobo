/**
 * 后台页面的js验证
 * @return 结果
 * @author wuzhihui
 */
function qcheck(){                      //企业检验
		var qname = document.getElementById("ev.ename").value;
		var username = document.getElementById("ev.username").value;
		var password = document.getElementById("ev.password").value;
		//获取邮箱
		var email = document.getElementById("ev.email").value;
		var reg = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/ ;
		var qtel = document.getElementById("ev.mobile").value;
		var qintro = document.getElementById("qintro").value;
		//企业名称检查
		if(qname.length<1){
			alert("企业名称不能为空");
			return false;
		}
		if(username.length<1){
			alert("用户名不能为空");
			return false;
		}
		if(password.length<1){
			alert("密码不能为空");
			return false;
		}
		if(password.length<6){
			alert("密码不能少于6位");
			return false;
		}
		//电话号码检查
		if(qtel.length<1){
			alert("企业电话不能为空");
			return false;
		}
		if( (qtel.length != 11) && (qtel.length != 12) ){
			alert("电话号码格式不正确!");
			document.getElementById("ev.mobile").focus();
			return false;
		}
//		//如果长度为11
//		if(qtel.length == 11){
//			for(var i = 0; i < qtel.length(); i++ ){
//				if(qtel.charAt(i) < '0' || qtel.charAt(i) > '9'){
//					alert("电话号码格式不正确!");
//					document.getElementById("ev.mobile").focus();
//					return false;
//				}
//			}
//		}
		if( (qtel.length == 12) && (qtel.indexOf("-" , 0) != 3)){
			alert("电话号码格式不正确!");
			document.getElementById("ev.mobile").focus();
			return false;
		}
		if(email.length<1){
			alert("邮箱不能为空");
			return false;
		}
		//邮箱
		if(!(reg.test(email))){
			alert("邮箱格式不正确!");
			return false;
		}
		//企业简介检查
		if(qintro.length<1){
				alert("企业简介不能为空");
				return false;
		}
		alert("提交成功！");
		document.myForm.submit();
		return true;
	}
	
// 基地检验
function jcheck(){
		var jname = document.getElementById("vo.bname").value;
		var jintro = document.getElementById("vo.bintroduction").value;
		if(jname.length<1){
				alert("基地名称不能为空");
				return false;
		}
		if(jintro.length<1){
				alert("基地简介不能为空");
				return false;
		}
		alert("提交成功！");
		document.myForm.submit();
		return true;
}
// 公告检验
function gcheck(){
		var title = document.getElementById("ev.ntitle").value;
		var date = document.getElementById("ev.ndate").value;
		var nr = document.getElementById("ev.ncontent").value;
		if(title.length<1){
			alert("标题不能为空");
			return false;
		}
		if(date.length<1){
			alert("时间不能为空");
			return false;
		}
		if(nr.length<1){
			alert("简介不能为空");
			return false;
		}
		alert("提交成功！");
		document.myForm.submit();
		return true;
}
//重置方法
function qreset(){
	document.myForm.reset();
	return false;
}
function reset1(){
	document.getElementById("ev.ename").value = "";
	document.getElementById("ev.username").value = "";
	document.getElementById("ev.password").value = "";
	document.getElementById("ev.email").value = "";
	document.getElementById("ev.mobile").value = "";
	document.getElementById("qintro").value = "";
}
function reset2(){
	document.getElementById("vo.bname").value = "";
	document.getElementById("vo.bintroduction").value = "";
}
function reset3(){
	document.getElementById("ev.ntitle").value = "";
	document.getElementById("ev.ncontent").value = "";
}