public abstract class Heroes {

    public abstract int Health();
    public abstract int getDamage();
    public abstract int Position();
    int Health;
    int Damage;
    int Position;
    char Character;
    protected Heroes(int Health,int Damage, int Position,char Character){
        this.Health=Health;
        this.Damage=Damage;
        this.Position=Position;
        this.Character=Character;
    }


}
