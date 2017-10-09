package tutorielheroes

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*
import groovy.xml.MarkupBuilder

class Dog{}

class HeroController {

    HeroService heroService

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def first() {
      def person1 = [nom : "bob"]
      def person2 = [nom : null]
      def person3 = null;
      println person1?.nom?.toUpperCase();
      println person2?.nom?.toUpperCase();
      println person3?.nom?.toUpperCase();

      println "----------------------"


        Dog.metaClass.bark = {println "wan"}
        new Dog().bark()

        def m = 'ah!'
        render m
    }


    // def login() {
    //     def writer = new StringWriter()
    //     def builder = new MarkupBuilder(writer)
    //     builder.html {
    //         head {
    //             title 'Log in'
    //         }
    //         body {
    //             h1 'Hello'
    //             form {
    //             }
    //         }
    //     }
    //
    //     def html = writer.toString()
    //     render html
    // }
    //
    // def multiply() {
    //   def valX = params["X"].toInteger();
    //   def valY = params["Y"].toInteger();
    //   def mult = valX * valY;
    //   redirect(action: 'aff', params: [Z: mult]);
    //   return;
    // }
    //
    // def aff()
    // {
    //   render params["Z"];
    // }

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
