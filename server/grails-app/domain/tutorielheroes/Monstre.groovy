package tutorielheroes

class Monstre extends Personnage {

  //loot
  static hasMany = [loot: Item];

    static constraints = {

    }
}
