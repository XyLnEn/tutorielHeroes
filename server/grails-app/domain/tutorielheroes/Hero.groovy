package tutorielheroes

class Hero extends Personnage {


  Stats bonus;
  //inventaire
  static hasMany = [objet: Item];

    static constraints = {
      bonus unique: true
    }
}
