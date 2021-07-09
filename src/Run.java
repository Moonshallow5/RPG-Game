public class Run {
    public static void main(String[] args) {
        Board boards=new Board();
        //Archer archer=new Archer(5,1,0);
        //Archer archer1=new Archer(5,1,0);
        Archer archer2=new Archer(3,3,5,'A');
        Archer archer4=new Archer(3,3,0,'A');
        Archer archer5=new Archer(3,3,0,'A');
        Knight knight=new Knight(10,10,0,'K');
        Knight knight1=new Knight(10,10,5,'K');
        Knight knight2=new Knight(10,10,5,'K');
        boards.initialDisplay();
        boards.displayBoard();
        boards.pick(knight);
        boards.pick(archer4);
        boards.pick(archer5);
        boards.pick(knight2);
        boards.pick(knight1);
        boards.pick(archer2);
        boards.insert();
        boards.displayBoard();
        boards.start();

    }
}
