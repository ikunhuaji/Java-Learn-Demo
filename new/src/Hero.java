import java.util.Random;

public class Hero {

    private String name;
    private int hp;
    private int maxAttackNum;
    private int minAttackNum;

    public void setAll(String name,int hp,int maxAttackNum,int minAttackNum)
    {
        this.name=name;
        this.hp=hp;
        this.maxAttackNum=maxAttackNum;
        this.minAttackNum=minAttackNum;
    }
    public void setName(String name) {this.name=name;}
    public void setHp(int hp) {this.hp=hp;}

    public void setMaxAttackNum(int maxAttackNum) {this.maxAttackNum=maxAttackNum;}
    public void setMinAttackNum(int minAttackNum) {this.minAttackNum=minAttackNum;}

    public String getName() {return this.name;}
    public int getHp() {return this.hp;}
    public int getMaxAttackNum() {return this.maxAttackNum;}
    public int getMinAttackNum() {return this.minAttackNum;}

    public void attack(Monster monster)
    {
        Random random = new Random();
        int count = random.nextInt(maxAttackNum-minAttackNum)+minAttackNum;
        monster.setHp(monster.getHp()-count);
    }

    public void attack(Monster[] monsters)
    {
        for (Monster monster:monsters)
        {
            attack(monster);
        }
    }
}
