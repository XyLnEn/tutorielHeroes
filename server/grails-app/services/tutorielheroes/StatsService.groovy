package tutorielheroes

import grails.gorm.services.Service

@Service(Stats)
interface StatsService {

    Stats get(Serializable id)

    List<Stats> list(Map args)

    Long count()

    void delete(Serializable id)

    Stats save(Stats stats)

}