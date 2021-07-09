public class Archer extends Heroes {

    protected Archer(int Health, int Damage,int Position,char Character) {
        super(Health, Damage,Position,Character);
    }
    public int Position(){
        return Position;
    }


    public String toString(){
        return "Archers";
    }

    @Override
    public int Health() {
        return Health;
    }

    @Override
    public int getDamage() {
        return Damage;
    }

}
