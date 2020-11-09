package EdgarGame;

import EdgarGame.Enemies.*;

public class EnemyFactory{

    public final static Enemy createEnemy(String enemy) {
        switch(enemy) {
          case "Elf":
            return new Elf(12,12);
          case "Dwarf":
            return new Dwarf(3,13);
          case "Human":
            return new Human(8,9);
          default:
            return new Dragon(20,20);
        }
    }


}