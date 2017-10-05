package tutorielheroes

class BootStrap {

    def HeroService
    def ItemService
    def MonstreService
    def PersonnageService
    def StatsService

    def init = { servletContext ->
      def sHero = new Stats(pv:100,pvMax:100,pm:15,force:15,magie:5,defence:10,defenceMagique:8);
      StatsService.save(sHero);
      def sMonstre = new Stats(pv:75, pvMax:75, pm:5, force:20, magie:6, defence:9, defenceMagique:2);
      StatsService.save(sMonstre);
      def sBuff = new Stats(pv:0, pvMax:0, pm:0, force:0, magie:0, defence:0, defenceMagique:0);
      StatsService.save(sBuff);

      Item casque = new Item(pv:0, pvMax:0, pm:0, force:0, magie:0, defence:5, defenceMagique:0);
      ItemService.save(casque);
      Item epee = new Item(pv:0, pvMax:0, pm:0, force:8, magie:0, defence:0, defenceMagique:0);
      ItemService.save(epee);

      def arr = Arrays.asList(casque, epee);
      def hero = new Hero(nom:"hero", stat:sHero, bonus:sBuff, objet:arr);
      HeroService.save(hero);

      def arr2 = Arrays.asList(casque, epee);
      def monstre = new Monstre(nom:"goblin", stat:sMonstre, loot:arr2);
      MonstreService.save(monstre);


    }
    def destroy = {
    }
}
