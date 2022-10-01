package entities;

public class Champion {

    private String name;
    private int life;
    private int attack;
    private int armor;

    public Champion() {
    }

    public Champion(String name, int life, int attack, int armor) {
        this.name = name;
        this.life = life;
        this.attack = attack;
        this.armor = armor;
    }

    public String getName() {
        return name;
    }

    public int getLife() {
        return life;
    }

    public void takeDamage(Champion other) {
        if (armor >= other.attack) {
            life -= 1;
        }
        else {
            int damage = other.attack - armor;
            life -= damage;
        }
    }

    public String status() {
        if (life <= 0) {
            return name + " morreu.";
        }
        else {
            return name + " tem " + life + " de vida.";
        }
    }


}
