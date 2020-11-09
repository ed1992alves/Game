package EdgarGame;

import EdgarGame.Enemies.*;
import java.util.Random;
import java.util.Scanner;

public class Game {
    private boolean status = true;
    private int stage = 5;
    private String[] enemyTypes;
    private Enemy[] enemies;
    private Player player;


    public Game() {
        this.enemyTypes = new String[]{"Elf", "Dwarf", "Human"};
        this.enemies = new Enemy[6];
        this.player = new Player();

    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }



    public void startGame() {

        Random rnd = new Random();
        for (int i = 0; i < enemies.length - 1; i++) {
            int rndInt = rnd.nextInt(3);

            enemies[i] = EnemyFactory.createEnemy(enemyTypes[rndInt]);
        }
        enemies[enemies.length - 1] = EnemyFactory.createEnemy("Dragon");

        round();
    }


    public void round() {

        for (int i = 0; i < enemies.length; i++) {

                do {
                    System.out.println();
                    System.out.println("-----------------");
                    System.out.println("1: to Attack enemy");
                    System.out.println("2: to recharge");
                    System.out.println("3: to Special Attack");
                    System.out.println("4: Avoid Enemy");
                    System.out.println("5: Quit Game");
                    System.out.println("-----------------");
                    System.out.println();
                    Scanner scanner = new Scanner(System.in);
                    String scan = scanner.nextLine();

                    switch (scan) {
                        case "1":
                            enemies[i].printEnemy();
                            System.out.println();
                            System.out.println("Player Attack!!");
                            enemies[i].setDamage(player.normalAttack());
                            player.getHitted(enemies[i].getAttack());
                            System.out.println(" Player Life : " + player.getHealth());
                            System.out.println();
                            break;

                        case "2":
                            if(player.getHealthRechargeCounter() <= 0 || player.getHealth() > 100){
                                System.out.printf("Bro, enough of health");
                            } else {
                                System.out.println("Health coming");
                                player.rechargeHealth(10);
                                System.out.println("\n Player Life : " + player.getHealth());
                            }
                            break;

                        case "3":
                            if (player.getSpecialAttackCounter() <= 0) {
                                System.out.println("No more 'Kame kame haaa' available");
                            } else {
                                enemies[i].printEnemy();
                                System.out.println();
                                System.out.printf("Kame kame haaaaa!!");
                                enemies[i].setDamage(player.specialAttack());
                                player.getHitted(enemies[i].getAttack());
                                System.out.println("\n Player Life : " + player.getHealth());
                                System.out.println();
                            }
                            break;

                        case "4":
                            System.out.println("Avoid Enemy");
                            break;

                        case "5":
                            System.out.println("Game Closed");
                            this.status = false;
                            System.exit(0);
                            break;

                        default:
                            System.out.println("Invalid Command");
                            break;
                    }

                } while (enemies[i].getLife() > 0 && player.getHealth() > 0);

            if (player.getHealth() <= 0) {
                System.out.printf("!!! Fatality !!!");
                this.status = false;
                System.exit(0);
            }
        }
    }
}