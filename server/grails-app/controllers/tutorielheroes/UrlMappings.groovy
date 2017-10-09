package tutorielheroes

class UrlMappings {

    static mappings = {
        delete "/$controller/$id(.$format)?"(action:"delete")
        get "/$controller(.$format)?"(action:"index")

        get "/$controller/first(.$format)?"(action:"first")
        // get "/$controller/login(.$format)?"(action:"login")
        // get "/$controller/multiply(.$format)?"(action:"multiply")
        // get "/$controller/aff(.$format)?"(action:"aff")

        get "/$controller/$id(.$format)?"(action:"show")
        post "/$controller(.$format)?"(action:"save")
        put "/$controller/$id(.$format)?"(action:"update")
        patch "/$controller/$id(.$format)?"(action:"patch")

        "/"(controller: 'application', action:'index')
        "500"(view: '/error')
        "404"(view: '/notFound')
    }
}
