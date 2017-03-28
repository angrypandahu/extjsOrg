package com.domain.api

import com.domain.auth.User

class WxController {

    def apiOrgService

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        def userId = getAuthenticatedUser().id
        def apiAccountList = UserApiAccount.findAllByUser(User.load(userId))?.apiAccount
        render view: 'index', model: [zTree: apiOrgService.findZTreeJSON(userId), apiAccountList: apiAccountList]
    }

    def show() {
        def apiOrg = ApiOrg.load(params.id)
        def userId = getAuthenticatedUser().id
        def apiAccount = ApiAccount.load(params.account)
        respond apiOrg, model: [zTree: apiOrgService.findZTreeJSON(userId), apiAccount: apiAccount]
    }

}
