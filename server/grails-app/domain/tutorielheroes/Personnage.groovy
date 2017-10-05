package tutorielheroes

abstract class Personnage {

  String nom;
  Stats stat;

    static constraints = {
      stat unique: true
    }
}
