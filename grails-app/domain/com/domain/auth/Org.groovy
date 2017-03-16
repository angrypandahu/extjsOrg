package com.domain.auth

import com.domain.BaseDomain
import groovy.transform.EqualsAndHashCode

@EqualsAndHashCode(includes = 'hierarchy')
class Org extends BaseDomain {
    String hierarchy
    String parent
    int type
    String code
    String name
    String duty
    String phone
    String email
    String memo
    static constraints = {
        hierarchy blank: false, unique: true
        parent nullable: true
        type blank: false
        code nullable: true
        name blank: false
        duty nullable: true
        phone nullable: true
        email email: true, nullable: true
        memo nullable: true

    }
    static mapping = {
        cache true
    }
}
