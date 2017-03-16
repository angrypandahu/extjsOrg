<!DOCTYPE html>
<html>
<head>
    %{--<meta name="layout" content="main"/>--}%
    <g:set var="entityName" value="${message(code: 'user.label', default: 'User')}"/>
    <title><g:message code="default.list.label" args="[entityName]"/></title>
    <style type="text/css">
    /* style rows on mouseover */
    .x-grid-row-over .x-grid-cell-inner {
        font-weight: bold;
    }
    /* shared styles for the ActionColumn icons */
    .x-action-col-cell img {
        height: 16px;
        width: 16px;
        cursor: pointer;
    }

    .x-ie6 .x-action-col-cell img {
        position:relative;
        top:-1px;
    }

    .x-form-readonly {
        border-color: #efefef;
    }
    .x-grid-row-summary .x-grid-cell-inner {
        font-weight      : bold;
        color:darkblue;
        font-size        : 11px;
        /*background-color : #ffd800;*/
    }

    /*.toolbar-color-css {*/
    /*background-color: #d3e1f1;*/
    /*}*/
    </style>
    <asset:stylesheet src="extjs/packages/ext-theme-classic/build/resources/ext-theme-classic-all.css"/>

    <asset:javascript src="extjs/build/ext-all.js"/>
    <asset:javascript src="extjs/ext-locale-zh_CN.js"/>
    <asset:javascript src="extjs/build/ext-theme-classic.js"/>

    <asset:javascript src="menu/index.js"/>

</head>

<body>
<div id="extjs_content" style='width:100%; height:50%;'></div>

</body>
</html>