<!doctype html>
<html lang="en" class="no-js">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    %{--<meta http-equiv="X-UA-Compatible" content="IE=edge"/>--}%
    <title>
        <g:layoutTitle default="IColor Report"/>
    </title>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>

    <asset:stylesheet src="application.css"/>
    <asset:stylesheet src="zTreeStyle/zTreeStyle.css"/>
    <asset:javascript src="jquery-2.2.0.min.js"/>
    <asset:javascript src="zTree/jquery.ztree.core.js"/>
    <style>
    .my_right {
        position: absolute;
        right: 0;
    }

    .icolor_logo {

    }

    .navbar-default, .navbar-static-top, .footer, .grails-logo-container {
        background-color: #0071d0;
    }
    </style>
    <SCRIPT type="text/javascript">
        var setting = {
            data: {
                simpleData: {
                    enable: true
                }
            },
            callback: {
                beforeClick: function (treeId, treeNode, clickFlag) {
                    return treeNode.click
                },
                onClick: function (event, treeId, treeNode, clickFlag) {
                    var id = treeNode.id;
                    window.location.href = ("/wx/show/" + id + "?" + "account=" + $("#apiAccount").val());
                }
            }
        };

        var zNodes = $.parseJSON('<g:writeWithoutEncoding input="${zTree}"/>');

        $(document).ready(function () {
            $.fn.zTree.init($("#treeDemo"), setting, zNodes);
        });
        //-->
    </SCRIPT>
    <g:layoutHead/>
</head>

<body>


<div class="container-fluid">
    <div class="row-fluid">
        <div class="col-md-3">
            <ul id="treeDemo" class="ztree"></ul>
        </div>

        <div class="col-md-9">
            <g:layoutBody/>
        </div>
    </div>
</div>



</body>
</html>
