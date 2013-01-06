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
		<canvas id="centerCanvas" width="1277" height="630" >
			
		</canvas>


		
	
	<script type="text/javascript">
	
		function getData() {
			var request = $.ajax({
				type : "POST",
				url : '/cssb/weibo/relation.html?opt=userRelatPrint',
				dataType : "JSON",
				success : function(data) {
					//alert(data);
					//初始化canvas
					var canvas = document.getElementById("centerCanvas");
					if (canvas == null)
						return false;
					var context = canvas.getContext("2d");
					//背景涂黑
					context.fillStyle = "#292929";
					context.fillRect(0, 0, 1277, 654);
					
					$.each(data, function(n, v) {
						var centeruid;
						var name;
						var uid;
						var xend;
						var xstart;
						var yend;
						var ystart;
						var noder;
						var deep;
						$.each(v, function(n, v) {
							console.log(n + ":" + v);
							//if(n=='centeruid'){
							//	console.log("dfdfdfdfdfdf ");
							//}
							
							//初始化数据
							if (n == 'centeruid') {
								centeruid = v;
							} else if (n == 'name') {
								name = v;
							} else if(n == 'uid') {
								uid = v;
							} else if(n == 'xend') {
								xend = parseInt(v);
							} else if(n == 'xstart') {
								xstart = parseInt(v);
							} else if(n == 'yend') {
								yend = parseInt(v);
							} else if(n == 'ystart') {
								ystart = parseInt(v);
							} else if(n == 'noder') {
								noder = parseInt(v);
							} else if(n == 'deep') {
								deep = v;
							}
							
						});
						//如果centeruid==uid 将这个对象的name画在中心偏下不做任何事情
						if(deep == "0" /*|| uid == centeruid*/){
							//自己的颜色为红色
					//		context.strokeStyle = "#DC143C";
					//		context.fillStyle = "#DC143C";
					//		context.beginPath();
					//		context.arc(xstart, ystart, 20, 0, Math.PI * 2, true);
					//		context.closePath();
							//仅仅写名字
							context.fillStyle = "#D3D3D3";
							context.strokeStyle = "#D3D3D3";
							context.font = "normal 14px Serif";
							context.textBaseline = 'top';
							//context.fillText(name, xstart + 13, ystart);
						} else {
							//画线颜色
							//console.log(xend,xstart);
							if (deep == "1") {
								context.strokeStyle = "#DC143C";
								context.fillStyle = "#DC143C";
							} else {
								context.strokeStyle = "#D3D3D3";
								context.fillStyle = "#D3D3D3";
							}
							context.beginPath();
							context.lineWidth = 1;
							context.moveTo(xstart, ystart);
							context.lineTo(xend, yend);
							context.closePath();
							context.stroke();

							//画默认圆
							context.beginPath();
							context.arc(xstart, ystart, 1 * parseInt(noder), 0, Math.PI * 2, true);
							context.arc(xend, yend, 10, 0, Math.PI * 2, true);
							context.closePath();
							context.fill();

							//写字  颜色固定为白
							context.fillStyle = "#D3D3D3";
							context.font = "normal 10px Serif";
							context.textBaseline = 'top';
							context.fillText(name, xend + 13, yend);
						}
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
			context.moveTo(1, 1);
			//之后的lineTo会以上次lineTo的节点为开始
			context.lineTo(1211, 600);
			context.lineWidth = 1;
			context.stroke();
		}
	</script>
</body>
</html>