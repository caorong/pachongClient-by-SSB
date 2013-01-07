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
					<br> <input name="opt" type="hidden" value="quickSearchByName" /> 
					<input name="hidUid" value="${model.uid}" type="hidden" />
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
				<!--Body content-->
				<div class="tabbable tabs-left">
					<ul class="nav nav-tabs">
						<li><a href="#1" data-toggle="tab" onclick="">A君</a></li>
						<li><a href="#2" data-toggle="tab">B君</a></li>
						<li><a href="#3" data-toggle="tab">C君</a></li>
					</ul>
					<div class="tab-content">
						<div class="tab-pane" id="1">
							<ul class="pager">
								<li><a
									href="javascript:queryByPage(1);">前一页</a></li>
								<li><a href="javascript:queryByPage(2);">后一页</a></li>
							</ul>
							<table class="table table-striped">
								<tbody>
									<c:forEach var="model" items="${modelList}">
										<tr>
											<td>${model.text}</td>
											<td>${model.attitudescount}</td>
											<td>${model.commentGoodCount}</td>
											<td>${model.commentBadCount}</td>
											<td><a href="">详细</a></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>

						</div>
						<div class="tab-pane" id="2">
							<p>这里是B的.</p>
						</div>
						<div class="tab-pane" id="3">
							<p>这里是C的.</p>
						</div>
					</div>
				</div>
				<div id="myModal" class="modal hide fade">
					
				</div>
			</div>
		</div>
	</div>

	<script type="text/javascript">
		function quickSearch() {
			var search = $("#quickSearchName").val();
			if(search == ""){
				alert("请先输入");
				return;
			}
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
		
		function queryByPage(flag){
			var cpage = parseInt($("#hidcurrentPage").val());
			if(flag==1){
				//前一页
				if(cpage-1==0){
					alert("已经是第一页");
					return;
					cpage--;
				}
			}else if(flag==2){
				cpage++;
			}
			document.getElementById("hidcurrentPage").value = cpage;
			document.getElementById("formQS").submit();
		}
	</script>

</body>
</html>