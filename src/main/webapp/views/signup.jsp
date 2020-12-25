<%@ page pageEncoding="utf-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>注册</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/semantic-ui@2.4.2/dist/semantic.min.css">
    <link rel="stylesheet" href="./static/css/me.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css">
</head>
<body>
<script src="https://cdn.jsdelivr.net/npm/jquery@3.2/dist/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/semantic-ui@2.4.2/dist/semantic.min.js"></script>

<!---------------------------            导航             ---------------------->
<nav class="ui inverted attached segment m-padded-tb-small m-shadow-small">
    <!--        设置菜单(黑色，看不出来)和log，由于log太靠做，所以需要将菜单栏放到另一个<div class="ui container">里面-->
    <div class="ui container">
        <div class="ui inverted secondary stackable menu">
            <!--             在菜单栏里面加入log ，颜色为teal，item表示是菜单栏的一个条目，如果菜单栏背景不是黑色，那么会清楚的看到有一个切割线-->
            <h1 class="ui teal header item">在线查重系统</h1>
            <!--                   <i class="home icon"></i>是表示一些小图标，可在semantic框架中找 -->
            <a href="../indexBoth.jsp" class="m-item item m-mobile-hide m-margin-small m-font-size-small"><i class="small home icon"></i>首页</a>
            <a href="#" class="m-item item m-mobile-hide m-margin-small m-font-size-small"><i class="small search icon"></i>论文小技巧</a>
            <a href="#" class="m-item item m-mobile-hide m-margin-small m-font-size-small"><i class="small book icon"></i>论文小常识</a>
            <a href="#" class="m-item item m-mobile-hide m-margin-small m-font-size-small"><i class="small idea icon"></i>常见问题</a>
            <a href="#" class="m-item item m-mobile-hide m-margin-small m-font-size-small"><i class="small question circle outline icon"></i>使用帮助</a>
            <a href="#" class="m-item item m-mobile-hide m-margin-small m-font-size-small"><i class="small address card icon"></i>关于</a>
        </div>
    </div>
    </div>
    <a href="#" class="ui menu toggle black icon button m-position-right-top m-mobile-show">
        <i class="sidebar icon"></i>
    </a>

</nav>

<!-- -------------------                 中间 ----------------------------->

<div class="m-container m-padded-tb-huge">
    <div class="ui container">
        <!--          header-->
        <div class="ui top center aligned attached padded segment" style="background:rgba(255,255,255,0.4)">
            <h2 class="ui teal header">注&nbsp;册</h2>
        </div>
        <!--        中间内容-->
        <div class="ui segment m-margin-tb-tiny animate__animated  animate__swing m-padded-tb-huge" style="background:rgba(255,255,255,0.4)">
                <br>
                <div class="ui stackable grid">
                    <div class="left aligned five wide column grid">

                    </div>
                    <div class="ui six wide column grid" >
                        <form action="${pageContext.request.contextPath}/register" class="ui form" method="post">
                            <!--                        选择角色-->
                            <h4 class="ui header">请选择角色：</h4>
                            <div class="ui identity field">
                            <div class="ui labeled input" >
                                <div class="ui label">
                                    <i class="idea icon"></i>
                                </div >
                                <select class="ui  fluid dropdown selection dropdown"  name="identity" id="jiaose" >
                                    <option value="">请选择身份</option>
                                    <option value="学生">学生</option>
                                    <option value="老师">教工</option>
                                </select>
                            </div>
                        </div>
                            <!--                        账号输入框-->
                            <h4 class="ui header">请输入账号：</h4>
                            <div class="ui username field">
                                <div class="ui labeled input">
                                    <div class="ui label">
                                        <i class="address book outline icon"></i>
                                    </div>
                                    <input type="text" name="num"  placeholder="请输入账号">账号长度最大为9位
                                </div>
                            </div>
                            <!--                        密码输入框-->
                            <h4 class="ui header">请输入密码：</h4>
                            <div class="ui password field">
                                <div class="ui labeled input">
                                    <div class="ui label">
                                        <i class="ui lock icon"></i>
                                    </div>
                                    <input type="text" name="password"  placeholder="请输入密码">密码长度最大为6位
                                </div>
                            </div>
<!--                            提交-->
                            <input type="submit" value="提交" class="signin m-font-size-middle m-margin-tb-tiny"/>
                            <div class="ui error message"></div>
                          <br>


                        </form>
                    </div>
                    <div class="right aligned five wide column grid">
                        <br><br><br><br><br>  <br><br><br><br><br>  <br><br><br><br><br><br>
                        <a href="../indexBoth.jsp" class="ui teal border m-item item m-mobile-hide m-margin-small m-font-size-small basic button" style="margin-right:100px">返回</a>
                    </div>
                </div>
        </div>
    </div>
</div>
<br>
<br><br><br><br><br>
<div id="toolbar" class="m-fixed m-right-bottom m-padded-big" >
    <div class="ui vertical icon buttons">
        <div id="toTop-button" class="ui teal icon button"><i class="up chevron icon"></i><br><br></div>
        <!--        <div id="toTop-button01" class="ui teal icon button"></div>-->
        <br>
    </div>

</div>


<!--------------------------------底部----------------------->
<footer class="ui inverted vertical segment m-padded-tb-massive">
    <!--        center aligned:将文字居中显示-->
    <div class="ui center aligned container">
        <!--            将容器分为竖着的16份,divided:表示分割线，three wide column:表示占3列，而且wide意思时占满-->
        <div class="ui inverted divided stackable grid">
            <div class="three wide column">
                <div class="ui inverted link list">
                    <h4 class="ui inverted header m-opacity-mini m-text-spaced">扫码关注</h4>
                    <div class="item">
                        <img src="./static/images/wechat.png" class="ui rounded image" style="width:110px">
                    </div>
                </div>

            </div>
            <div class="three wide column">
                <h4 class="ui inverted header m-opacity-mini m-text-spaced">其他查重系统</h4>
                <!--                    这里的Link在超链接点击时会发生变化-->
                <div class="ui inverted link list">
                    <a href="https://www.freecheck.cn/vpcs/detection?id=14" class="item">维普检测大学生版</a>
                    <a href="https://www.freecheck.cn/HowNet/detection?id=21" class="item">知网博硕VIP5.3检测</a>
                    <a href="https://www.freecheck.cn/vpcs/detection?id=15" class="item">维普检测职称版</a>
                    <a href="https://www.freecheck.cn/vpcs/detection?id=16" class="item">维普检测编辑部版</a>
                </div>
            </div>
            <div class="three wide column">
                <h4 class="ui inverted header m-opacity-mini m-text-spaced">联系我们</h4>
                <div class="ui inverted link list">
                    <a href="#" class="item">QQ:1302628281</a>
                    <a href="#" class="item">Phone:15515157920</a>
                    <a href="#" class="item">Email:1302628281@qq.com</a>
                </div>
            </div>

            <div class="seven wide column">
                <h4 class="ui inverted header m-opacity-mini m-text-spaced">关于我们</h4>
                <p class="m-opacity-small m-text-thin m-text-spaced">这是一个在线学习管理与论文查重系统，提供5大分类，12个专业的毕业论文检测服务，同时推出免费论文检测字数活动。动态指纹技术保障、权威可信赖的论文查重系统现已为超300万人提供论文检测服务。</p>
            </div>
        </div>
        <!--            底部的分割线-->
        <div class="ui inverted section divider"></div>
        <p class="m-opacity-mini m-text-thin m-text-spaced m-opacity">Copyright@2020-2021 JiaoJiaoZi Designed by JiaoJIaozi</p>
    </div>

</footer>
<script>

    $('.ui.dropdown').dropdown({
        on:'hover'
    });
    $('#toTop-button').click(function(){
        $(window).scrollTop(0);
    });
    $('form').form({
        fields:{
            identity:{
                    identifier:'identity',
                    rules:[{
                        type:'empty',
                        //这里的提示信息会放在上面的<div class="ui error message"></div>
                        prompt:'请选择身份信息！！！！'
                    }]
                },
            username:{
                identifier:'num',
                rules:[{
                    type:'empty',
                    prompt:'账号不能为空！！！！'
                }]
            },

            password:{
                identifier:'password',
                rules:[{
                    type:'empty',
                    //这里的提示信息会放在上面的<div class="ui error message"></div>
                    prompt:'密码不能为空！！！！'
                }]
            }
        }
    });


</script>

</body>
</html>