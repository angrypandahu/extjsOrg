package com.domain.auth

import com.domain.api.UserApiOrg
import com.utils.MyStringUtils
import grails.converters.JSON
import org.grails.web.json.JSONArray
import org.grails.web.json.JSONObject

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class OrgController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]
    def orgService

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Org.list(params), model: [orgCount: Org.count()]
    }

    def all() {
        def orgTree = orgService.getOrgTree()
        render(orgTree)
    }

    def show(Org org) {
        respond org
    }

    def create() {
        respond new Org(params)
    }

    def tree() {
        render(orgService.tree())
    }

    def getOrgs() {
        def orgList = UserOrg.findAllByUser(User.get(Long.parseLong(params.user)))?.org
        def ret = new JSONObject()
        ret.put("orgList",new JSONArray(orgList?.id) )
        render MyStringUtils.ajaxJSONReturnTrue(ret);
    }

    @Transactional
    def save(Org org) {
        if (org == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (org.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond org.errors, view: 'create'
            return
        }

        org.save flush: true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'org.label', default: 'Org'), org.id])
                redirect org
            }
            '*' { respond org, [status: CREATED] }
        }
    }

    def edit(Org org) {
        respond org
    }

    @Transactional
    def update(Org org) {
        if (org == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (org.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond org.errors, view: 'edit'
            return
        }

        org.save flush: true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'org.label', default: 'Org'), org.id])
                redirect org
            }
            '*' { respond org, [status: OK] }
        }
    }

    @Transactional
    def delete(Org org) {

        if (org == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        org.delete flush: true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'org.label', default: 'Org'), org.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'org.label', default: 'Org'), params.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NOT_FOUND }
        }
    }
}
