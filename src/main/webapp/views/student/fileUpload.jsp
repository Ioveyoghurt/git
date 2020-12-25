<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件上传</title>
</head>
<body>

<form action="${pageContext.request.contextPath}/fileUpload" method="post" enctype="multipart/form-data">
    选择文件：<input type="file" name="file"/><br/>
    <input type="submit" value="上传"/>
</form>
</body>
</html>
