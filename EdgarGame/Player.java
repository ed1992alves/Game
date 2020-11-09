package EdgarGame;

public class Player implements IPlayer {

    private int health = 100;
    private int normalAttack = 20;
    private int specialAttack = 50;
    private int healthRechargeCounter = 3;
    private int specialAttackCounter = 3;

    @Override
    public void getHitted(double hit) {
        this.health = (int) (this.health - hit);
    }

    @Override
    public int rechargeHealth(int health) {
        this.health = this.health + health;
        this.healthRechargeCounter =  this.healthRechargeCounter - 1;
        return this.health;
    }

    @Override
    public int normalAttack() {
        return normalAttack;
    }

    @Override
    public int specialAttack() {
        this.specialAttackCounter = this.specialAttackCounter - 1;
            return this.specialAttack;
    }

    public int getHealth() {
        return health;
    }

    public int getHealthRechargeCounter() {
        return healthRechargeCounter;
    }

    public int getSpecialAttackCounter() {
        return specialAttackCounter;
    }
}
