package extjsorg

class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?" {
            constraints {
                // apply constraints here
            }
        }

        "/"(view: "/menu/index")
        "/adminIndex"(view: "/index")
        "401"(view: "/401")
        "500"(view: '/error')
        "404"(view: '/notFound')
    }
}
