<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.3.min.js"></script>
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet" media="screen">
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<title>用户关系图</title>
</head>
<body>

<!--	<div class="container"> -->
	<!--  
		<form class="form-horizontal">
			<div class="control-group">
				<label class="control-label">YourUid</label>
				<div class="controls">
					<input type="text" id="inputYourUid" placeholder="Plz write your Uid">
				</div>
			</div>
			<div class="control-group">
				<div class="controls">
					<button type="submit" class="btn btn-info">Sign in</button>
				</div>
			</div>
		</form>
	-->
		<input type="button" name="123" onclick="getData();" />
		<input type="hidden" id="paths" value=""/>
		<canvas id="centerCanvas" width="1277" height="654" >
			
		</canvas>


		
	
	<script type="text/javascript">
		function getData() {
			var request = $.ajax({
				type : "POST",
				url : '/weiboCSSB/weibo/relation.html?opt=ajaxTest',
				dataType: "JSON",
				success : function(data) {
					alert(data);
					$.each(data,function(n,v){
						$.each(v,function(n,v){
							console.log(n+":"+v.);
						});
					});
					
					alert('Load was performed.');
				}
			});
		}
		
		function draw() {
			var canvas = document.getElementById("centerCanvas");
			if (canvas == null)
				return false;
			var context = canvas.getContext("2d");
			//context.beginPath();
			//背景涂黑
			context.fillStyle = "rgb(0,0,0)";
			context.fillRect(0, 0, 1277, 654);

			context.strokeStyle = "rgb(250,250,250)";
			//       context.fillStyle = "rgb(150,0,0)";
			//实验证明第一次lineTo的时候和moveTo功能一样
			context.lineTo(1, 1);
			//之后的lineTo会以上次lineTo的节点为开始
			context.lineTo(1211, 600);
			context.lineWidth = 1;
			context.stroke();
		}
	</script>
</body>
</html>