<%--
    Created by mingfei.net@gmail.com
    7/6/17 09:30
    https://github.com/thu/jianshu/
--%>
<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>写文章 - 简书</title>
    <link rel='shortcut icon' type='image/x-icon' href='favicon.ico'>
    <link rel="stylesheet" href="static/css/bootstrap.min.css">
    <link rel="stylesheet" href="static/css/bootstrap-switch.min.css">
    <link rel="stylesheet" href="static/md/css/editormd.min.css"/>
    <style>
        html,
        body {
            height: 100%;
        }

        .container-fluid {
            padding: 0;
        }

        #notebook,
        #note-title,
        #editor-wraper {
            min-height: 100%;
            height: 100%;
        }

        #notebook {
            background: #3f3f3f;
        }

        #note-title {
            border-right: 1px solid #d9d9d9;
        }
    </style>
    <script src="static/js/jquery.min.js"></script>
    <script src="static/js/bootstrap.min.js"></script>
    <script>
        $(function () {
            $('#preview').click(function () {
                $('#notebook').hide();
                $('#note-title').hide();
                $('#editor-wraper')
                    .removeClass('col-md-7')
                    .addClass('col-md-12');
            });
        });
    </script>
</head>
<body class="container-fluid">
<div id="notebook" class="col-md-2">left</div>
<div id="note-title" class="col-md-3">center</div>
<div id="editor-wraper" class="col-md-7">
    <div id="editor">
        <textarea style="display:none;"></textarea>
        <!-- 第二个隐藏文本域，用来构造生成的HTML代码，方便表单POST提交，这里的name可以任意取，后台接受时以这个name键为准 -->
        <textarea class="editormd-html-textarea" name="text"></textarea>
    </div>
    <script src="static/js/jquery.min.js"></script>
    <script src="static/md/editormd.js"></script>
    <script type="text/javascript">
        $(function () {
            editor = editormd("editor", {
                width: "100%",//宽度
                height: "100%",//高度
                // 下面三个选项是设置风格的，每个有什么风格，请看下载插件得examples/themes.html
                theme: "lesser-dark",// 工具栏风格
                previewTheme: "default",// 预览页面风格
                editorTheme: "default",// 设置编辑页面风格
                path: 'static/md/lib/',//这块是lib的文件路径，必须设置，否则几个样式css，js访问不到的
                flowChart: true,//控制流程图编辑
                sequenceDiagram: true,//控制时序图编辑
                taskList: true,//任务列表
                tex: true,//科学公式
                emoji: true,//moji表情
                htmlDecode: "style,script,iframe|on*", // 开启 HTML 标签解析，为了安全性，默认不开启
                codeFold: true,//ctrl+q代码折叠
//                                    saveHTMLToTextarea : true,//这个配置在simple.html中并没有，但是为了能够提交表单，使用这个配置可以让构造出来的HTML代码直接在第二个隐藏的textarea域中，方便post提交表单。这个转换好像有些缺陷，有些配置没有生效，目前还没想到怎么解决，我这里没有用,是在前台读取的时候转换的
                imageUpload: true,//开启本地图片上传
                imageFormats: ["jpg", "jpeg", "gif", "png", "bmp", "webp"],
                imageUploadURL: "/index.php/Admin/News/uploadFileMark",//图片上传地址
                onload: function () {
                    console.log('onload', this);
                }
            });
            //设置可以添加目录，只需要在上面一行输入 [TOCM]，就会有目录，注意下面要空一行
            editor.config({
                tocm: true,
                tocContainer: "",
                tocDropdown: false
            });
        });
    </script>
</div>
</body>
</html>
