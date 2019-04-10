$(document).ready(function() {
    $("#loginBtn").click(function(){
        var user = {
            username: $.trim($("#username").val()),
            password: $.trim($("#password").val())
        };
        //前台的非空验证
        if(user.username == "" || user.username == null){
            $("#username").focus;
        }else if(user.password == "" || user.password == null){
            $("#password").focus;
        }else{
            //如果账号和密码都不为空，就进行 ajax 异步提交
            $.ajax({
                type:'POST', //提交方法是POST
                url:'/hangele/user/login', //请求的路径
                dataType:'json',
                data: user,
                success: function (result) {
                    if (result.status && result.status == '0000') {
                        $("loginMsg").html(result.data);
                        window.open('/html/main.html');
                    } else{
                        alert("账号或密码不正确");
                    }
                },
                error:function () {
                    alert("出现错误！");
                }
            });
        }
    });
});