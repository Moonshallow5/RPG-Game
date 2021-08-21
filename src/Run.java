public class Run {
    public static void main(String[] args) {
        Board boards=new Board();
        //Archer archer=new Archer(5,1,0);
        //Archer archer1=new Archer(5,1,0);
        //Archer archer2=new Archer(3,3,4,'A');
        Archer archer1=new Archer(4,1,0,'A');
    
        Knight knight1=new Knight(10,10,0,'K');
        Knight knight2=new Knight(10,1,5,'K');
        //Archer archer6=new Archer(4,1,4,'A');
        //Archer archer7=new Archer(4,1,4,'A');
        //Archer archer8=new Archer(4,1,1,'A');
        Archer archer=new Archer(4,1,0,'A');
        Archer archer3=new Archer(4,1,5,'A');
        //Archer archer2=new Archer(4,1,5,'A');
        Archer archer9=new Archer(4,1,5,'A');
        //Archer archer10=new Archer(4,1,1,'A');
        //Archer archer11=new Archer(4,1,1,'A');
        //Archer archer12=new Archer(3,1,1,'A');
        boards.initialDisplay();
        boards.displayBoard();
        boards.pick(archer1);
        boards.pick(knight1);
        boards.pick(archer);
        boards.pick(archer3);
        boards.pick(knight2);
        boards.pick(archer9);
        /*boards.pick(archer6);
        boards.pick(archer7);
        boards.pick(knight2);
        boards.pick(archer10);
        boards.pick(archer11);
        boards.pick(archer8);*/
        boards.insert();
        boards.displayBoard();
        boards.start();

    }
}
