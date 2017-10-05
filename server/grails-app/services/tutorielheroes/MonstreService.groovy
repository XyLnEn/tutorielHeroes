package tutorielheroes

import grails.gorm.services.Service

@Service(Monstre)
interface MonstreService {

    Monstre get(Serializable id)

    List<Monstre> list(Map args)

    Long count()

    void delete(Serializable id)

    Monstre save(Monstre monstre)

}