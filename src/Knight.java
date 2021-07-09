public class Knight extends Heroes{

    protected Knight(int Health, int Damage,int Position,char Character) {
        super(Health, Damage,Position,Character);
    }

    @Override
    public int Health() {
        return Health;
    }
    public int Position(){
        return Position;
    }

    @Override
    public int getDamage() {
        return Damage;
    }

    public char getChar() {
        return Character;
    }

    public String toString(){
        return "Knights";
    }
}
