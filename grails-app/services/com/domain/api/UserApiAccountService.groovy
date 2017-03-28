package com.domain.api

import com.domain.auth.User
import grails.transaction.Transactional

@Transactional
class UserApiAccountService {

    def serviceMethod() {

    }

    def isAuth(User user, id) {
        if (user && id) {
            def apiAccount = ApiAccount.get(id)
            if (apiAccount) {
                return isAuth(user, apiAccount)
            }
        }
        return false

    }

    def isAuth(User user, ApiAccount account) {
        def accounts = UserApiAccount.findAllByUser(user)?.apiAccount
        if (accounts && accounts.contains(account)) {
            return true
        }
        return false
    }

    def saveUserApiAccounts(params) {
        def userId = Long.parseLong(params.user)
        List<Long> accounts = new ArrayList<>()
        params.apiAccount?.each {
            accounts.add(Long.parseLong(it))
        }
        return saveUserApiAccounts(userId, accounts)
    }

    def saveUserApiAccounts(Long userId, List<Long> accounts) {
        def user = User.get(userId)
        List<ApiAccount> apiAccounts = new ArrayList()
        accounts?.each {
            def apiAccount = ApiAccount.get(it)
            apiAccounts.add(apiAccount)
        }
        def saves = []
        if (user) {
            apiAccounts?.each {
                if (!UserApiAccount.exists(user.id, it.id)) {
                    saves.add(UserApiAccount.create(user, it))
                }
            }
            UserApiAccount.where {
                user == user && !(apiAccount in apiAccounts)
            }.deleteAll()
        }
        return saves

    }


}
