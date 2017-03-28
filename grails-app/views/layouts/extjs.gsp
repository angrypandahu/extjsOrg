<!doctype html>
<html lang="en" class="no-js">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>
        <g:layoutTitle default="IColor Report"/>
    </title>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <asset:stylesheet src="extjs/packages/ext-theme-classic/build/resources/ext-theme-classic-all.css"/>
    <asset:javascript src="extjs/build/ext-all.js"/>
    <asset:javascript src="extjs/ext-locale-zh_CN.js"/>
    <asset:javascript src="extjs/build/ext-theme-classic.js"/>

    <asset:javascript src="jquery-2.2.0.min.js"/>
    <asset:javascript src="extjs/Constants.js"/>
    <asset:javascript src="extjs/ExtGrid.js"/>
    %{--<asset:javascript src="extjs/ComboBox.js"/>--}%
    <script>
        //定义用户表单的字段名称
        var user_uuid = 'User_uuid';
        var user_username = 'User_username';
        var user_password = 'User_password';
        var user_name = 'User_name';
        var user_phone = 'User_phone';
        var user_email = 'User_eMail';
        var user_memo = 'User_memo';

        %{--//定义角色表单的字段名称--}%
        var role_uuid = 'Role_uuid';
        var role_code = 'Role_roleCode';
        var role_name = 'Role_roleName';
        var role_desc = 'Role_description';
    </script>
    <g:layoutHead/>

</head>

<body>

<g:layoutBody/>

</body>
</html>
