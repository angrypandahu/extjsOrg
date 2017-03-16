package com.controller.biz

import com.controller.BaseController
import com.domain.auth.Privilege
import com.domain.auth.RolePrivilege
import com.domain.auth.User
import grails.converters.JSON

class MenuController extends BaseController {

    def menuService

    def index() {

    }

    def getMenus() {
        User user = getAuthenticatedUser()
        def findAll = menuService.findAllPrivilegeByUser(user)
        render(findAll as JSON)

    }


}
