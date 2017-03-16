package com.domain.auth

import com.controller.BaseController

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class RolePrivilegeController extends BaseController{

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond RolePrivilege.list(params), model:[rolePrivilegeCount: RolePrivilege.count()]
    }

    def show(RolePrivilege rolePrivilege) {
        respond rolePrivilege
    }

    def create() {
        respond new RolePrivilege(params)
    }

    @Transactional
    def save(RolePrivilege rolePrivilege) {
        if (rolePrivilege == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (rolePrivilege.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond rolePrivilege.errors, view:'create'
            return
        }

        rolePrivilege.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'rolePrivilege.label', default: 'RolePrivilege'), rolePrivilege.role])
                redirect action:"index", method:"GET"
            }
            '*' { respond rolePrivilege, [status: CREATED] }
        }
    }

    def edit(RolePrivilege rolePrivilege) {
        respond rolePrivilege
    }

    @Transactional
    def update(RolePrivilege rolePrivilege) {
        if (rolePrivilege == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (rolePrivilege.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond rolePrivilege.errors, view:'edit'
            return
        }

        rolePrivilege.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'rolePrivilege.label', default: 'RolePrivilege'), rolePrivilege.id])
                redirect rolePrivilege
            }
            '*'{ respond rolePrivilege, [status: OK] }
        }
    }

    @Transactional
    def delete(RolePrivilege rolePrivilege) {

        if (rolePrivilege == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        rolePrivilege.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'rolePrivilege.label', default: 'RolePrivilege'), rolePrivilege.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'rolePrivilege.label', default: 'RolePrivilege'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
