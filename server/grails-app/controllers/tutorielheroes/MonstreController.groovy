package tutorielheroes

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class MonstreController {

    MonstreService monstreService

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond monstreService.list(params), model:[monstreCount: monstreService.count()]
    }

    def show(Long id) {
        respond monstreService.get(id)
    }

    def save(Monstre monstre) {
        if (monstre == null) {
            render status: NOT_FOUND
            return
        }

        try {
            monstreService.save(monstre)
        } catch (ValidationException e) {
            respond monstre.errors, view:'create'
            return
        }

        respond monstre, [status: CREATED, view:"show"]
    }

    def update(Monstre monstre) {
        if (monstre == null) {
            render status: NOT_FOUND
            return
        }

        try {
            monstreService.save(monstre)
        } catch (ValidationException e) {
            respond monstre.errors, view:'edit'
            return
        }

        respond monstre, [status: OK, view:"show"]
    }

    def delete(Long id) {
        if (id == null) {
            render status: NOT_FOUND
            return
        }

        monstreService.delete(id)

        render status: NO_CONTENT
    }
}
