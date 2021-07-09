import java.util.ArrayList;
import java.util.HashMap;

public class Board {
    char[][] board=new char[3][6];

    HashMap<Integer,Heroes>  heroesHashMap=new HashMap<>();
    ArrayList<Heroes> arrayList=new ArrayList<>();
    int count=0;
    public void pick(Heroes heroess){
        if(heroesHashMap.containsValue(heroess)){
            System.out.println("Not allowed");
        }else {
            heroesHashMap.put(count, heroess);
            arrayList.add(heroess);
            count++;
            System.out.println(heroesHashMap);
            //System.out.println(arrayList);
        }
    }
    /*public void pickSecond(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Choose 3 characters between archer and knight for the end of the board");
        System.out.println(pickKnightOrArcher());
        for (int i = 0; i < 3; i++) {
            int x=scanner.nextInt();
            if(x==1){
                countArcherEnd++;
            }
            else if(x==2){
                countKnightEnd++;
            }
            heroesend.add(x);
        }
    }*/
    public final void displayBoard() {
        String rowDivider = "-".repeat(4 * board[0].length + 1);
        System.out.println(rowDivider);
        for (int row = 0; row <board.length; row++) {
            System.out.print("| ");// Prints out vertical lines for the first column
            for (int col = 0; col <board[0].length; col++) {
                System.out.print(board[row][col]);// Prints out the whole 2D array for the characters to be placed in
                System.out.print(" | ");// Prints out the rest of the board with vertical lines
            }
            System.out.println();
            System.out.println(rowDivider);
        }
    }
    public final void initialDisplay(){
        for (int row = 0; row < board.length; row++){//Loop for all the rows in the grid
            for (int col = 0; col < board[0].length; col++){//Loop for all of the columns in the grid
                board[row][col] =' ';//The whole grid will be represented as empty at first
            }
        }
    }

    /*public void insert(){
        Scanner scanner=new Scanner(System.in);
        if(heroes.contains(1)) {
            while (countArcher > 0) {
                System.out.println("Where would you lime place the archer");
                System.out.println("Choose a number between 0 and 2");
                int archer = scanner.nextInt();
                board[archer][0] = 'A';
                countArcher--;
            }
        }if(heroes.contains(2)){
            while (countKnight>0){
                System.out.println("Where would you lime place the knight");
                System.out.println("Choose a number between 0 and 2");
                int knight = scanner.nextInt();
                board[knight][0] = 'K';
                countKnight--;

            }
        }
    }
    public void insertSecond(){
        Scanner scanner=new Scanner(System.in);
        System.out.println(heroesend);
        if(heroesend.contains(1)) {
            while (countArcherEnd > 0) {
                System.out.println("Where would you lime place the archer end of board");
                System.out.println("Choose a number between 0 and 2");
                int archer = scanner.nextInt();
                board[archer][5] = 'A';
                countArcherEnd--;
            }
        }if(heroesend.contains(2)){
            while (countKnightEnd>0){
                System.out.println("Where would you lime place the knight end of board");
                System.out.println("Choose a number between 0 and 2");
                int knight = scanner.nextInt();
                board[knight][5] = 'K';
                countKnightEnd--;

            }
        }

    }*/

    int couunt1=0;
    public void insert(){
        for (int i = 0; i < arrayList.size(); i++) {
                if(arrayList.get(i) instanceof Archer) {
                    //System.out.println("cool");
                    if(i>=3){
                        board[couunt1][5]=getHeroes(i).Character;
                        couunt1++;
                    }else {
                        board[i][0] = getHeroes(i).Character;
                    }
                }else if(arrayList.get(i) instanceof Knight){
                    if(i>=3){
                        board[couunt1][5]=getHeroes(i).Character;
                        couunt1++;
                    }else {
                        board[i][0] = getHeroes(i).Character;
                    }
                }
            }
        System.out.println(arrayList);
    }
    public Heroes getHeroes(int row){
        return heroesHashMap.get(row);
    }
    public void start(){
        int i=0;
        int death1=0;
        int death2=0;
        while (true) {
            /*if(getHeroes(i).Health<=0){
                getHeroes(i).Damage=0;
                board[i][0]=' ';
                displayBoard();
            }*/
            if(getHeroes(i).Character=='A' && (getHeroes(i+3).Health>0) && getHeroes(i).Health>0) {//FIRST
                getHeroes(i + 3).Health = getHeroes(i + 3).Health - getHeroes(i).Damage;
                System.out.println(i + " attacked " + (i + 3));
                System.out.println((i + 3) + " health is " + getHeroes(i + 3).Health);
                if(getHeroes(i+3).Health<=0){
                    death1++;
                    getHeroes(i+3).Damage=0;
                    board[i][getHeroes(i+3).Position]=' ';
                    displayBoard();
                }
            }else if(getHeroes(i).Character=='K'){
                if((board[i][getHeroes(i).Position+1]=='A'|| board[i][getHeroes(i).Position+1]=='K') && getHeroes(i + 3).Health >0 && getHeroes(i).Health>0 ) {//FIRST
                    getHeroes(i + 3).Health = getHeroes(i + 3).Health - getHeroes(i).Damage;
                    System.out.println(i + " attacked " + (i + 3));
                    System.out.println((i + 3) + " Health is " + getHeroes(i + 3).Health);
                    if (getHeroes(i + 3).Health <= 0) {
                        death1++;
                        board[i][getHeroes(i + 3).Position] = ' ';
                        getHeroes(i + 3).Damage = 0;
                        board[i][getHeroes(i).Position]='K';
                        displayBoard();
                    }
                }else if(getHeroes(i + 3).Health >0 && getHeroes(i).Health>0){
                    getHeroes(i).Position++;
                    board[i][getHeroes(i).Position]='K';
                    board[i][getHeroes(i).Position-1]=' ';
                    displayBoard();
                }

            }
            /*if(getHeroes(i+3).Health<=0){
                getHeroes(i+3).Damage=0;
                board[i][5]=' ';
                displayBoard();
            }*/
            if (getHeroes(3).Health <= 0 && getHeroes(4).Health<=0 && getHeroes(5).Health<=0) {
                System.out.println("Second died "+i);
                break;
            }if(getHeroes(i+3).Character=='A' && getHeroes(i).Health>0 && getHeroes(i+3).Health>0) {//SECOND
                getHeroes(i).Health = getHeroes(i).Health - getHeroes(i + 3).Damage;
                System.out.println((i + 3) + " attacked " + (i));
                System.out.println((i) + " Health is " + getHeroes(i).Health);
                if(getHeroes(i).Health<=0){
                    board[i][getHeroes(i).Position]=' ';
                    death1++;
                    getHeroes(i).Damage=0;
                    displayBoard();
                }
            }else if(getHeroes(i+3).Character=='K'){//SECOND
                if((board[i][getHeroes(i+3).Position-1]=='A'|| board[i][getHeroes(i+3).Position-1]=='K') && getHeroes(i+3).Health>0 && getHeroes(i).Health>0) {
                    getHeroes(i).Health = getHeroes(i).Health - getHeroes(i + 3).Damage;
                    System.out.println((i + 3) + " attacked " + (i));
                    System.out.println((i)+" Health is "+getHeroes(i).Health);
                    if (getHeroes(i).Health <= 0) {
                        board[i][getHeroes(i).Position]=' ';
                        death1++;
                        board[i][getHeroes(i+3).Position]='K';
                        getHeroes(i).Damage=0;
                        displayBoard();
                    }
                }
                    else if(getHeroes(i).Health >0 && getHeroes(i+3).Health>0) {
                        getHeroes(i+3).Position--;
                        board[i][getHeroes(i+3).Position]='K';
                        board[i][getHeroes(i+3).Position+1]=' ';
                        displayBoard();
                    }
                    else if(getHeroes(i+3).Health<=0) {
                    board[i][getHeroes(i+3).Position]=' ';
                    }

            }
            if (death1>=3) {
                System.out.println(death1);
                System.out.println(death2);
                System.out.println("First died "+i);
                break;
            }
            if(i==2){
                i=0;
            }else {
                i++;
            }

        }

        System.out.println(getHeroes(0).Health);
        System.out.println(getHeroes(3).Health);
        System.out.println(getHeroes(2).Health);
        System.out.println(getHeroes(5).Health);


    }


}
