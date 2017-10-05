package tutorielheroes

class Stats {

  int pv;
  int pvMax;
  int pm;
  int force;
  int magie;
  int defence;
  int defenceMagique;

  static belongsTo = [Personnage]

    static constraints = {
    }
}
