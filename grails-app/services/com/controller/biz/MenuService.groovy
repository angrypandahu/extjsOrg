package com.controller.biz

import com.domain.auth.Privilege
import com.domain.auth.Role
import com.domain.auth.RolePrivilege
import com.domain.auth.User
import com.domain.auth.UserRole
import grails.transaction.Transactional

@Transactional
class MenuService {

    def serviceMethod() {

    }

    List<Privilege> findAllPrivilegeByUser(User user) {
        def hql = "select distinct p from ${Privilege.class.simpleName} as p," +
                " ${RolePrivilege.class.simpleName} as rp," +
                " ${Role.class.simpleName} as r," +
                " ${UserRole.class.simpleName} as ur," +
                " ${User.class.simpleName} as u" +
                " where p.id=rp.privilege and rp.role=r.id and r.id = ur.role and ur.user = u.id and u.id = ? order by p.module  "
        return Privilege.executeQuery(hql, [user.id])

    }
}
