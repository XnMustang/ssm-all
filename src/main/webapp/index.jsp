<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>首页</title>
    <script type="text/javascript" src="resources/js/jquery-3.1.1.js"></script>
</head>
<style>
    body h4{
        color: red;
    }
</style>
<body>
    <h1>首页，欢迎借阅图书！</h1>
    <h4>
        <span id="showAllBook" onclick="showAllBook()">查看所有图书</span>
    </h4>
</body>

<script>
    function showAllBook() {
        $.ajax({
            url: "${pageContext.request.contextPath}/book/allBook",
            data: {},
            success: function (data) {
                console.log(data);
                if(data == null || data == ""){
                    alert("图书查询失败！");
                }else {
                    window.location.href = "${pageContext.request.contextPath}/book/bookList";
                }
            }
        })
    }
</script>
</html>
