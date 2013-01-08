<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/datav/deps.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/datav/seajs/sea.js"></script>
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css"
	rel="stylesheet" media="screen">
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<title>微博</title>
</head>
<body>

<br>
	<div class="container-fluid">
		<div class="row-fluid">
			<div class="span2">
				<!--Sidebar content-->
				<p>快速搜索</p>
				<div class="well sidebar-nav">
					<form id="formQS" action="weibo.html" method="post">
					<input id="quickSearchName" name="iqnPostData" type="text" class="span12" style="margin: 0 auto;"
						data-provide="typeahead" data-items="4"
						data-source='["周鸿祎","王石","Arizona","Arkansas","California","West Virginia"]'>
					<br> <input id="iopt" name="opt" type="hidden" value="quickSearchByName" /> 
					<input id="hidUid" name="hidUid" value="${modeluid}" type="hidden" />
					<input id="hidcurrentPage" name="hidcurrentPage" value="${hidcurrentPage}"  type="hidden" />
					<br> <input class="btn btn-primary" type="button" value="确认" onclick="quickSearch();"/>
					<br> <br>
					</form>
					<ul class="nav nav-list">
						<li class="nav-header">A大类</li>
						<li><a href="#">IT</a></li>
						<li><a href="#">CEO</a></li>
						<li class="nav-header">A大类</li>
						<li><a href="#">321</a></li>
						<li><a href="#">321</a></li>
						<li><a href="#">321</a></li>
						<li class="nav-header">C大类</li>
						<li><a href="#">中央</a></li>
						<li><a href="#">中央</a></li>
						<li><a href="#">中央</a></li>
					</ul>
				</div>

			</div>
			<div class="span10">
				<!--Body content
				<div class="tabbable tabs-left">
					<ul class="nav nav-tabs">
						<li><a href="#1" data-toggle="tab" onclick="">A君</a></li>
						<li><a href="#2" data-toggle="tab">B君</a></li>
						<li><a href="#3" data-toggle="tab">C君</a></li>
					</ul>
					<div class="tab-content">-->
						<div class="tab-pane" id="1">
							<ul class="pager">
								<li><a
									href="javascript:queryByPage(1);">前一页</a></li>
								<li><a href="javascript:queryByPage(2);">后一页</a></li>
								<li><a  href="#" rel="tooltip" data-original-title="点击查看好评坏评统计图" >查看好坏评统计图</a></li>
							</ul>
							<table class="table table-striped">
								<tbody>
									<c:forEach var="model" items="${modelList}">
										<tr>
											<td>${model.text}</td>
											<td>${model.attitudescount}</td>
											<td>${model.commentGoodCount}</td>
											<td>${model.commentBadCount}</td>
											<td><a class="btn btn-primary btn-mini" id="amodaltoggle" onclick="getDatalevel(${model.wid},1);">关注</a></td>
											<td><a class="btn btn-primary btn-mini" id="amodaltoggle" onclick="getData(${model.wid},0);">不关注</a></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>

						</div>
						<!--
						<div class="tab-pane" id="2">
							<p>这里是B的.</p>
						</div>
						<div class="tab-pane" id="3">
							<p>这里是C的.</p>
						</div>
					</div>
				</div>-->
				

			</div>
		</div>
	</div>
	<div id="myModal" class="modal hide" style="position: absolute; left: 300px;top: 20px;width:97%" data-backdrop='false'>
					<div class="modal-header">
						<a class="close" data-dismiss="modal">&times;</a>
						<h3>对话框</h3>
					</div>
					<div id="treechart" class="modal-body">
						
					</div>
					<div class="modal-footer">
						<a href="#" class="btn" data-dismiss="modal">关闭</a>
					</div>
				</div>
<input type="button" onclick="test();"/>
	<script type="text/javascript">
	//$('#hrddd').tooltip();
		function quickSearch() {
			var search = $("#quickSearchName").val();
			if (search == "") {
				alert("请先输入");
				return;
			}
			document.getElementById("iopt").value = "quickSearchByName";
			document.getElementById("formQS").submit();
			//		search = {search:search};
			//		$.ajax({
			//			type : "POST",
			//			url : '/cssb/weibo/weibo.html?opt=quickSearchByName',
			//			data : search,
			//			dataType : "JSON",
			//			success : function(data) {				
			//			}
			//		});
		}

		function queryByPage(flag) {
			alert($("#hidUid").val());
			if ($("#hidUid").val() == "")
				return;
			var cpage = parseInt($("#hidcurrentPage").val());
			if (flag == 1) {
				//前一页
				if (cpage - 1 == 0) {
					alert("已经是第一页");
					return;
					cpage--;
				}
			} else if (flag == 2) {
				cpage++;
			}
			//document.getElementById("hidUid").value = ;
			document.getElementById("hidcurrentPage").value = cpage;
			document.getElementById("iopt").value = "getStatusByPage";
			document.getElementById("formQS").submit();
		}

		function test() {
			
			var arrayObj = new Array();
			arrayObj.push(["ID", "name", "size", "parentID"]);
			arrayObj.push(["12", "22", "1", "12"]);
			arrayObj.push(["12", "22", "1", "12"]);
			arrayObj.push(["12", "22", "1", "12"]);
			alert(arrayObj.length);
			
		}

		function getData(wid,flag) {
		//	alert(wid+"    "+flag);
		//	wid="3526775705197239";
			//通过ajax获得评论深度图
			$.ajax({
				type : "POST",
				url : '/cssb/weibo/weibo.html?opt=getReStatus',
				data : {postwid:wid,authorfansflag:flag},
				dataType : "JSON",
				success : function(res) {
					var arrayObj = new Array();
					arrayObj.push(["ID", "name", "size", "parentID"]);
					
					$.each(res, function(n, v) {
						console.log(v);
						var id;
						var name;
						var parentid;
						var size;
						$.each(v, function(n, v) {
							if(n=='id'){
								id = v;
							}else if(n=='name'){
								name = v;
							}else if(n=='parentid'){
								parentid = v;
							}else if(n=='size'){
								size = v;
							}
						});
						arrayObj.push([id, name, size, parentid]);
					});
					seajs.config({
					      alias: {  //http://localhost:8080/cssb/js/datav/seajs/sea.js
					    	  'DataV': '/cssb/js/lib/datav.js',
					          'Tree': '/cssb/js/lib/charts/tree.js'
					      }
					   });
					seajs.use(["Tree", "DataV"], function (Tree, DataV) {
						var tree = new Tree("treechart", {width:1200 ,height:700});
						//设置数据，输入的数据为一个二维数组
						tree.setSource(arrayObj);
						//绘制
						tree.render();
					});
				}
			});
			//display
			$('#myModal').modal({
				backdrop : true,
				keyboard : true,
				show : true
			});
		}
		
		
		
		
		// 只画至少2层的  
		function getDatalevel(wid,flag) {
			//	alert(wid+"    "+flag);
				wid="3481017534962625";
				//通过ajax获得评论深度图
				//强制改变flag为1 增加数量 test--
				//flag = "1";
				$.ajax({
					type : "POST",
					url : '/cssb/weibo/weibo.html?opt=getReStatuslevel',
					data : {postwid:wid,authorfansflag:flag},
					dataType : "JSON",
					success : function(res) {
						var arrayObj = new Array();
						arrayObj.push(["ID", "name", "size", "parentID"]);
						
						$.each(res, function(n, v) {
						//	console.log(v);
							var id;
							var name;
							var parentid;
							var size;
							$.each(v, function(n, v) {
								if(n=='id'){
									id = v;
								}else if(n=='name'){
									name = v;
								}else if(n=='parentid'){
									parentid = v;
								}else if(n=='size'){
									size = v;
								}
							});
							arrayObj.push([id, name, size, parentid]);
						});
						if(arrayObj.length<3){
							alert("没有数据");
							return;
						}
						seajs.config({
						      alias: {  //http://localhost:8080/cssb/js/datav/seajs/sea.js
						    	  'DataV': '/cssb/js/lib/datav.js',
						          'Tree': '/cssb/js/lib/charts/tree.js'
						      }
						   });
						seajs.use(["Tree", "DataV"], function (Tree, DataV) {
							var tree = new Tree("treechart", {width:1100 ,height:700});
							//设置数据，输入的数据为一个二维数组
							tree.setSource(arrayObj);
							//绘制
							tree.render();
						});
					}
				});
				//display
				$('#myModal').modal({
					backdrop : true,
					keyboard : true,
					show : true
				});
			}
		
		
		
	</script>

</body>
</html>