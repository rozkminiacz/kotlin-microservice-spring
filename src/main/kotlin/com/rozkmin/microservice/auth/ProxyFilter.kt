package com.rozkmin.microservice.auth

import com.netflix.zuul.ZuulFilter
import com.netflix.zuul.context.RequestContext
import com.rozkmin.microservice.service.WithCurrentUser


class ProxyFilter(override val securityContextService: SecurityContextService) : ZuulFilter(), WithCurrentUser {

    override fun run(): Any? =
            RequestContext.getCurrentContext().put("X-User-Key", securityContextService.currentUser()?.id)
//                    .apply { println(RequestContext.getCurrentContext().keys) }


    override fun shouldFilter(): Boolean = true

    override fun filterType(): String = "pre"

    override fun filterOrder(): Int = 6
}