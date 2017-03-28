package extjsorg

import static org.springframework.http.HttpStatus.*

class WxInterceptor {
    def springSecurityService

    def userApiAccountService
    def userApiOrgService

    boolean before() {
        def name = getActionName()
        if (name && name == "show") {
            def user = springSecurityService.getCurrentUser()
            def isAuth = userApiAccountService.isAuth(user, params.account) && userApiOrgService.isAuth(user, params.id)
            if (!isAuth) {
                render(status: UNAUTHORIZED)
            }
        }
        true
    }

    boolean after() {
        true
    }

    void afterView() {
        // no-op
    }
}
