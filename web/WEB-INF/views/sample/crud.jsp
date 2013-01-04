<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>CRUD</title>
</head>
<body>
	<h1>
		<font color="blue">*****CRUD FOR REGISTER SAMPLES*****</font>
	</h1>

	<h2>CREATE:</h2>

	<form action="default.html" method="post">
		<input name="opt" type="hidden" value="sampleCreate" />
		<table>
			<thead>
				<tr>
					<th>NAME</th>
					<th>AGE</th>
					<th>GENDER</th>
					<th>BIRTHDAY</th>
					<th>CELLPHONE NO.</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td><input name="name" type="text" /></td>
					<td><input name="age" type="text" /></td>
					<td><input name="gender" type="text" /></td>
					<td><input name="birthday" type="text" /></td>
					<td><input name="cellphone" type="text" /></td>
				</tr>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="5"><input id="create" type="submit"
						value="CREATE" /></td>
				</tr>
			</tfoot>
		</table>
	</form>

	<br />
	<br />

	<table border="1">
		<thead>
			<tr>
				<th>ID</th>
				<th>NAME</th>
				<th>AGE</th>
				<th>GENDER</th>
				<th>BIRTHDAY</th>
				<th>CELLPHONE NO.</th>
			</tr>
		</thead>
		<tbody>

			<c:forEach var="sampleReg" items="${sampleRegList}">
				<tr>
					<td><c:out value="${sampleReg.id}" /></td>
					<td><c:out value="${sampleReg.name}" /></td>
					<td><c:out value="${sampleReg.age}" /></td>
					<td><c:out value="${sampleReg.gender}" /></td>
					<td><fmt:formatDate value="${sampleReg.birthday}"
							pattern="yyyy-MM-dd" type="date" dateStyle="long" /></td>
					<td><c:out value="${sampleReg.cellphone}" /></td>
				</tr>
			</c:forEach>

		</tbody>
		<tfoot>
			<tr>
				<td colspan="6">
					<form action="default.html" method="post">
						<input name="opt" type="hidden" value="sampleQueryAll" /> <input
							id="queryAll" type="submit" value="QUERY ALL" />
					</form>
				</td>
			</tr>
		</tfoot>
	</table>

	<br />
	<br />


	<!-- load, modify, delete -->
	<form action="default.html" method="post">
		<table border="1">
			<thead>
				<tr>
					<th>ID</th>
					<th>NAME</th>
					<th>AGE</th>
					<th>GENDER</th>
					<th>BIRTHDAY</th>
					<th>CELLPHONE NO.</th>
					<th>OPERATE</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td><input name="id" type="text" value="<c:out value='${sampleReg.id}'/>" /></td>
					<td><input name="name" type="text" value="<c:out value='${sampleReg.name}'/>" /></td>
					<td><input name="age" type="text" value="<c:out value='${sampleReg.age}'/>" /></td>
					<td><input name="gender" type="text" value="<c:out value='${sampleReg.gender}'/>" /></td>
					<td><input name="birthday" type="text" value="<fmt:formatDate value='${sampleReg.birthday}'
							pattern='yyyy-MM-dd' type='date' dateStyle='long'/>" /></td>
					<td><input name="cellphone" type="text" value="<c:out value='${sampleReg.cellphone}'/>" /></td>
					<td>
						<input type="submit" value="load" onclick="RecordOpt.load();" />&nbsp;&nbsp; 
						<input type="submit" value="update" onclick="RecordOpt.update();" />&nbsp;&nbsp; 
						<input type="submit" value="delete" onclick="RecordOpt.del();" />&nbsp;&nbsp;
						<!-- <input type="submit" value="send message" onclick="RecordOpt.sendMsg();" />&nbsp;  -->
					</td>
				</tr>
			</tbody>
		</table>
		<input type="hidden" id="recOpt" name="opt" value=""/>
	</form>

	<script type="text/javascript">
	
		var RecordOpt = {
				
				_getOperation : function(){
					return document.getElementById("recOpt");
				},
				
				load : function(){
					this._getOperation().value = "sampleQuery";
				},
				
				update : function(){
					this._getOperation().value = "sampleUpdate";
				},
				
				del : function(){
					this._getOperation().value = "sampleDelete";
				},
				
				sendMsg : function(){
					this._getOperation().value = "sampleSendMsg";
				}
		};
	</script>
</body>
</html>