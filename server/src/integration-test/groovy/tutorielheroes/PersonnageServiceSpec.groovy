package tutorielheroes

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class PersonnageServiceSpec extends Specification {

    PersonnageService personnageService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Personnage(...).save(flush: true, failOnError: true)
        //new Personnage(...).save(flush: true, failOnError: true)
        //Personnage personnage = new Personnage(...).save(flush: true, failOnError: true)
        //new Personnage(...).save(flush: true, failOnError: true)
        //new Personnage(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //personnage.id
    }

    void "test get"() {
        setupData()

        expect:
        personnageService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Personnage> personnageList = personnageService.list(max: 2, offset: 2)

        then:
        personnageList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        personnageService.count() == 5
    }

    void "test delete"() {
        Long personnageId = setupData()

        expect:
        personnageService.count() == 5

        when:
        personnageService.delete(personnageId)
        sessionFactory.currentSession.flush()

        then:
        personnageService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Personnage personnage = new Personnage()
        personnageService.save(personnage)

        then:
        personnage.id != null
    }
}
