public class Game {

    Hero hero = new Hero();
    Monster[] monsters = new Monster[10];
    public void inIt()
    {
        hero.setAll("urutoroman",200,50,20);

        for(int i=1;i<=10;i++)
        {
            monsters[i-1]=new Monster();
            monsters[i - 1].setAll("Monster" + i, 50, 10, 5);
        }
    }

    public void run()
    {
        boolean flag=true;
        for(int i=0;i<10;i++)
        {
            this.hero.attack(monsters[i]);
            monsters[i].attack(this.hero);
            if(hero.getHp()<=0)
            {
                flag=false;
            }

            if(!flag)
            {
                break;
            }

            if(monsters[i].getHp()<=0)
            {
                System.out.println(monsters[i].getName()+":死了");
            }
        }

        if(flag)System.out.println("win");
        else System.out.println("lose");
    }
}
