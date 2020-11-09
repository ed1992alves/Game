package EdgarGame;

public interface IPlayer {

    public void getHitted(double hit);//the player is hit and loses health points

    public int rechargeHealth(int health);  //returns player life after recharge and updates healthRechargeCounter

    public int normalAttack();  //returns normalAttack

    public int specialAttack(); // return specialAttack and updates specialAttackCounter
}
