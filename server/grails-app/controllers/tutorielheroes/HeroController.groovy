package tutorielheroes

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class HeroController {

    HeroService heroService

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond heroService.list(params), model:[heroCount: heroService.count()]
    }

    def show(Long id) {
        respond heroService.get(id)
    }

    def save(Hero hero) {
        if (hero == null) {
            render status: NOT_FOUND
            return
        }

        try {
            heroService.save(hero)
        } catch (ValidationException e) {
            respond hero.errors, view:'create'
            return
        }

        respond hero, [status: CREATED, view:"show"]
    }

    def update(Hero hero) {
        if (hero == null) {
            render status: NOT_FOUND
            return
        }

        try {
            heroService.save(hero)
        } catch (ValidationException e) {
            respond hero.errors, view:'edit'
            return
        }

        respond hero, [status: OK, view:"show"]
    }

    def delete(Long id) {
        if (id == null) {
            render status: NOT_FOUND
            return
        }

        heroService.delete(id)

        render status: NO_CONTENT
    }
}
