package extjsorg

import com.domain.auth.Privilege
import com.domain.auth.Role
import com.domain.auth.RolePrivilege
import com.domain.auth.User
import com.domain.auth.UserRole

class BootStrap {
    def init = { servletContext ->
//        def admin = new User(username: 'admin', displayName: 'admin', password: 'admin')
//        admin.save(flush: true)
//        def role = new Role(authority: 'ROLE_ADMIN', roleName: '系统管理员')
//        role.save(flush: true)
//        def userRole = new UserRole(user: admin, role: role)
//        userRole.save(flush: true)
//        def privilege = new Privilege(name: "用户权限管理", function: "权限", module: "用户权限", url: "/baseinfo/privilege/usermanage.do", code: "yes",memo: "用户权限").save(flush: true)
//        new RolePrivilege(role: role, privilege: privilege).save(flush: true)
    }

    def destroy = {
    }
}
