<div class="container-fluid">
    <div class="row">
        <div class="col-md-12">
            <form role="form" action="${apiOrg.url}" method="${apiOrg.method}">
                <div class="form-group">
                    <label>
                        账号
                    </label>

                    ${apiAccount.name}
                </div>
                <div class="form-group">
                    <label>
                        方法
                    </label>
                    ${apiOrg.method}

                </div>
                <div class="form-group">

                    <label for="accessToken">
                        access_token
                    </label>
                    <input type="text" class="form-control" id="accessToken" value="${apiAccount.accessToken}"
                           name="access_token"
                           readonly/>
                </div>

                <div class="form-group">

                    <label for="api">
                        api
                    </label>
                    <input type="text" class="form-control" id="api" value="${apiOrg.name}"
                           readonly/>
                </div>
                <g:if test="${apiOrg.extraParams}">
                    <div class="form-group">

                        <label for="${apiOrg.extraParams}">
                            ${apiOrg.extraParams}
                        </label>
                        <input type="text" class="form-control" id="${apiOrg.extraParams}" value=""
                               name="${apiOrg.extraParams}" required/>
                    </div>
                </g:if>
                <g:if test="${apiOrg.method == 'POST'}">
                    <div class="form-group">

                        <label for="body">
                            body
                        </label>
                        <textarea class="form-control" id="body" name="body" required></textarea>
                    </div>
                </g:if>


                <button type="submit" class="btn btn-default">
                    Submit
                </button>
            </form>
        </div>
    </div>
</div>