package com.domain.api

import com.domain.BaseDomain
import groovy.transform.ToString

@ToString(includes = 'name', includeNames = true, includePackage = false)
class ApiAccount extends BaseDomain {
    String name
    String type
    String accessToken
    String appId
    String description
    static constraints = {
        name blank: false
        type blank: false,inList: ["微信公众号"]
        accessToken blank: false
        appId nullable: true
        description nullable: true
    }
}
