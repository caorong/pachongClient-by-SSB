<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Upload</title>
</head>
<body>
	<h1>Please upload a file</h1>
	<form method="post" action="fileupload.html" enctype="multipart/form-data">
		<input type="file" name="file"/>
		<input type="hidden" name="OPERATE" value="uploadFile"/>
		<input type="submit"/>
	</form>
</body>
</html>