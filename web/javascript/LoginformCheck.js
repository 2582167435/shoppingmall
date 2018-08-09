var name_flag = false;
var pwd1_flag = false;
var pwd2_flag = false;

function $(id){
    return document.getElementById(id);
}

function checkName(){
    /*
    1.获取用户名文本框中的内容
    2.校验(正则表达式)
    3.给用户一个反馈
    */
    var name_input = document.getElementById("username").value;
    //定义正则表达式
    var name_regex = /^[0-9a-zA-Z_]{6,10}$/;
    //alert(name_regex.test(name_input));
    if(name_regex.test(name_input)){//java:name_input.machers(regex)
        //符合要求
        $("name_msg").innerHTML='<font color="green">恭喜你</font>';
        name_flag=true;
    }else{
        //不符合要求
        $("name_msg").innerHTML='<font color="red">请重新输入</font>';
        $("username").value="";
        name_flag=false;
    }
}
function checkPwd(){
    var pwd_input = $("pwd1").value;
    if(pwd_input.length>=6 && pwd_input.length<=10){
        //符合要求
        $("pwd1_msg").innerHTML='<font color="green">恭喜你</font>';
        pwd1_flag=true;
    }else{
        //不符合
        $("pwd1_msg").innerHTML='<font color="red">请重新输入</font>';
        $("pwd1").value="";
        pwd1_flag=false;
    }
}
function checkPwd2(){
    /*
    1.获取pwd1和pwd2的value
    2.比较pwd1和pwd2的值
    */
    var pwd1 = $("pwd1").value;
    var pwd2 = $("pwd2").value;
    if(pwd1 != ""){
        //只要排除pwd1是空串(只要有值说明已经校验过了)
        if(pwd1 == pwd2){
            //密码验证成功了
            $("pwd2_msg").innerHTML='<font color="green">密码验证成功</font>';
            pwd2_flag=true;

        }else{
            //密码不一致
            $("pwd2_msg").innerHTML='<font color="red">密码不一致</font>';
            $("pwd2").value="";
            pwd2_flag=false;
        }

    }else{
        //没有输入密码
        $("pwd1_msg").innerHTML='<font color="red">请输入密码</font>';
        $("pwd2").value="";
    }


}

function checkAll(){
    if(name_flag){
        if(pwd1_flag){
            if(pwd2_flag){
                //可以提交

            }else{
                //密码不一致
            }
        }else{
            //密码设置不符合要求
        }
    }else{
        //用户名输入有误
        //1.光标先移动至用户名文本框
        $("username").focus();
        //2.用户名文本框标红
        $("username").className = "msg";
        return false;
    }

}