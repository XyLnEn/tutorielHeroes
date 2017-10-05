package tutorielheroes

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class StatsController {

    StatsService statsService

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond statsService.list(params), model:[statsCount: statsService.count()]
    }

    def show(Long id) {
        respond statsService.get(id)
    }

    def save(Stats stats) {
        if (stats == null) {
            render status: NOT_FOUND
            return
        }

        try {
            statsService.save(stats)
        } catch (ValidationException e) {
            respond stats.errors, view:'create'
            return
        }

        respond stats, [status: CREATED, view:"show"]
    }

    def update(Stats stats) {
        if (stats == null) {
            render status: NOT_FOUND
            return
        }

        try {
            statsService.save(stats)
        } catch (ValidationException e) {
            respond stats.errors, view:'edit'
            return
        }

        respond stats, [status: OK, view:"show"]
    }

    def delete(Long id) {
        if (id == null) {
            render status: NOT_FOUND
            return
        }

        statsService.delete(id)

        render status: NO_CONTENT
    }
}
