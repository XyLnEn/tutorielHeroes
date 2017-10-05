package tutorielheroes

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class MonstreServiceSpec extends Specification {

    MonstreService monstreService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Monstre(...).save(flush: true, failOnError: true)
        //new Monstre(...).save(flush: true, failOnError: true)
        //Monstre monstre = new Monstre(...).save(flush: true, failOnError: true)
        //new Monstre(...).save(flush: true, failOnError: true)
        //new Monstre(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //monstre.id
    }

    void "test get"() {
        setupData()

        expect:
        monstreService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Monstre> monstreList = monstreService.list(max: 2, offset: 2)

        then:
        monstreList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        monstreService.count() == 5
    }

    void "test delete"() {
        Long monstreId = setupData()

        expect:
        monstreService.count() == 5

        when:
        monstreService.delete(monstreId)
        sessionFactory.currentSession.flush()

        then:
        monstreService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Monstre monstre = new Monstre()
        monstreService.save(monstre)

        then:
        monstre.id != null
    }
}
