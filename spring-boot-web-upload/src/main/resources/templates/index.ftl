<!DOCTYPE html>
<html>
<head lang="en">
    <title>Spring Boot Demo - FreeMarker</title>

    <link href="/css/index.css" rel="stylesheet" />

</head>
<body>
<div style="text-align: center;">
    <img src="/images/springboot.jpg" />
</div>

<form method="POST" enctype="multipart/form-data" action="/file/upload">
    文件：<input type="file" name="file" />
    <input type="submit" value="上传" />
</form>

<script type="text/javascript" src="/webjars/jquery/3.3.1/jquery.min.js"></script>

<script>
    $(function(){
        $('#title').click(function(){
            alert('点击了');
        });
    })
</script>
</body>
</html>
