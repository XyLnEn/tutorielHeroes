package tutorielheroes

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class StatsServiceSpec extends Specification {

    StatsService statsService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Stats(...).save(flush: true, failOnError: true)
        //new Stats(...).save(flush: true, failOnError: true)
        //Stats stats = new Stats(...).save(flush: true, failOnError: true)
        //new Stats(...).save(flush: true, failOnError: true)
        //new Stats(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //stats.id
    }

    void "test get"() {
        setupData()

        expect:
        statsService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Stats> statsList = statsService.list(max: 2, offset: 2)

        then:
        statsList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        statsService.count() == 5
    }

    void "test delete"() {
        Long statsId = setupData()

        expect:
        statsService.count() == 5

        when:
        statsService.delete(statsId)
        sessionFactory.currentSession.flush()

        then:
        statsService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Stats stats = new Stats()
        statsService.save(stats)

        then:
        stats.id != null
    }
}
