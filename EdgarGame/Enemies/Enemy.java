package EdgarGame.Enemies;


/* Classe abstract implementa um metodo abstrato */
public class Enemy {
    protected String type;
    protected double life = 100.00;
    protected int defenseFactor;
    protected int attackFactor;

    /* CONSTRUTOR */
    public Enemy(String type, int defenseFactor, int attackFactor) {
        this.type = type;
        this.defenseFactor = defenseFactor;
        this.attackFactor = attackFactor;
    }

    public void printEnemy() {
        System.out.println("Type: " + type + "\n Life:" + life);
    }

    public void setDamage(double damage) {
        int protection = (int) (1 + Math.random() * defenseFactor);
        double newLife = (this.life - (damage - protection));
        this.life = newLife;
    }

    public int getAttack(){
        int hit = (int) (1 + Math.random() * attackFactor);
        this.attackFactor = hit;
        return attackFactor;
    }

    public double getLife() {
        return life;
    }
    public void setLife(double life) {
        this.life = life;
    }

}




