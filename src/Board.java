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
            //System.out.println(heroesHashMap);
            //System.out.println(arrayList);
        }
        System.out.println(heroesHashMap);
    }
   /*public void starting(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Would you want to play 1v1 or 2v2 enter 1 for 1v1 and 2 for 2v2");
        int x=scanner.nextInt();
        if(x==2){
            for (int j = 0; j < 5;j++) {
                System.out.println("Enter your heroes");
                pick(new  Archer(5,5,0,'A'));
            }
            insert();
            displayBoard();
            start();
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

    int couunt1=0;
    int two=0;
    int three=0;
    public void insert(){
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(arrayList.size());
                if(arrayList.get(i) instanceof Archer|| arrayList.get(i)instanceof Knight) {
                    //System.out.println("cool");
                    if(i>=3 && i<6){
                        board[couunt1][getHeroes(i).Position]=getHeroes(i).Character;
                        couunt1++;
                    }
                    else if(i>=6 && i<9){
                        board[two][getHeroes(i).Position]=getHeroes(i).Character;
                        two++;
                    }
                    else if(i>=9){
                        board[three][getHeroes(i).Position]=getHeroes(i).Character;
                        three++;
                    }
                    else {
                        board[i][getHeroes(i).Position] = getHeroes(i).Character;
                    }
                }
            }
        System.out.println(arrayList);
    }
    public Heroes getHeroes(int row){
        return heroesHashMap.get(row);
    }
   
    public void archerFirst1(){
        if(arrayList.size()==6){
            int why=0;
            int j=1;
            if (getHeroes(i).Character == 'A' && getHeroes(i).Health > 0 && (getHeroes(i + 3).Health > 0)) {//FIRST
                while (why != (getHeroes(i + 3).Position - 1)) {
                    board[i][getHeroes(i).Position + j] = '>';
                    if (j != 1) {
                        board[i][getHeroes(i).Position + (j - 1)] = ' ';
                    }
                    displayBoard();
                    why++;
                    j++;
                }
                board[i][getHeroes(i + 3).Position - 1] = ' ';
                getHeroes(i + 3).Health = getHeroes(i + 3).Health - getHeroes(i).Damage;
                System.out.println(i + " attacked " + (i + 3));
                System.out.println((i + 3) + " health is " + getHeroes(i + 3).Health);
            }
            if (getHeroes(i + 3).Health <= 0) {
                getHeroes(i).Health = getHeroes(i).Health + 2;
                getHeroes(i + 3).Damage = 0;
                board[i][getHeroes(i + 3).Position] = ' ';
                displayBoard();
            }
        }
    }

    public void knightFirst1(){
        if(arrayList.size()>=6){
            if (getHeroes(i).Character == 'K') {
               
                
                if ((board[i][getHeroes(i).Position + 1] == 'A' || board[i][getHeroes(i).Position + 1] == 'K') && (getHeroes(i + 3).Health > 0 ) && getHeroes(i).Health > 0) {//FIRST
                        getHeroes(i + 3).Health = getHeroes(i + 3).Health - getHeroes(i).Damage;
                    System.out.println("ll");
                        System.out.println(i + " attacked " + (i + 3));
                        System.out.println((i + 3) + " Health is " + getHeroes(i + 3).Health);

                } else if ((getHeroes(i + 3).Health > 0 && getHeroes(i).Health>0)) {
                    getHeroes(i).Position++;
                    board[i][getHeroes(i).Position] = 'K';
                    board[i][getHeroes(i).Position - 1] = ' ';
                    displayBoard();
                }
                if (getHeroes(i + 3).Health <= 0) {
                    board[i][getHeroes(i + 3).Position] = ' ';
                    getHeroes(i + 3).Damage = 0;
                    board[i][getHeroes(i).Position] = 'K';
                    displayBoard();
                }

            }
        }


    }
        public void archerLastRow1(){
        if (arrayList.size() ==6) {
            if (getHeroes(i + 3).Character == 'A' && getHeroes(i).Health > 0 && getHeroes(i + 3).Health > 0) {//SECOND
                    int why=getHeroes(i+3).Position;
                    int j=1;
                    while (why != getHeroes(i).Position+1) {
                        board[i][getHeroes(i + 3).Position - j] = '<';
                        if (j != 1) {
                            board[i][getHeroes(i + 3).Position - (j - 1)] = ' ';
                        }
                        displayBoard();
                        why--;
                        j++;
                    }
                    if(getHeroes(i).Position+1!=getHeroes(i+3).Position) {
                        board[i][getHeroes(i).Position + 1] = ' ';

                    }
                    getHeroes(i).Health=getHeroes(i).Health-getHeroes(i+3).Damage;
                    System.out.println((i + 3) + " attacked " + (i));
                    System.out.println((i) + " Health is " + getHeroes(i).Health);

                }
            if(getHeroes(i).Health<=0){
                board[i][getHeroes(i).Position]=' ';
                displayBoard();
                }
            }
        }
   
    public void knightLast1(){
        if(arrayList.size()==6){
            if(getHeroes(i+3).Character=='K'){
                if((board[i][getHeroes(i+3).Position-1]=='A'|| board[i][getHeroes(i + 3).Position - 1] == 'K') && getHeroes(i + 3).Health > 0 && getHeroes(i).Health > 0) {
                    getHeroes(i).Health = getHeroes(i).Health - getHeroes(i + 3).Damage;
                    System.out.println((i + 3) + " attacked " + (i));
                    System.out.println((i) + " Health is " + getHeroes(i).Health);
                    if (getHeroes(i).Health <= 0) {
                        board[i][getHeroes(i).Position] = ' ';
                        board[i][getHeroes(i + 3).Position] = 'K';
                        getHeroes(i).Damage = 0;
                        displayBoard();
                    }
                }else if (getHeroes(i).Health > 0 && getHeroes(i + 3).Health > 0) {
                    getHeroes(i + 3).Position--;
                    board[i][getHeroes(i + 3).Position] = 'K';
                    board[i][getHeroes(i + 3).Position + 1] = ' ';
                    displayBoard();
                }
            }
        }

    }
    int i=0;
    public void start(){
        while (true) {
            /*if(getHeroes(i).Health<=0){
                getHeroes(i).Damage=0;
                board[i][0]=' ';
                displayBoard();
            }*/
            if (getHeroes(0).Health <= 0 && getHeroes(1).Health<=0 && getHeroes(2).Health<=0 ) {
                System.out.println("Second died "+i);
                break;
            }
            /*if(getHeroes(i+9).Character!='K') {
                archerFirst22();
            }*/
            //archerFirst2();
            knightFirst1();
            archerFirst1();
           // knightFirst2();
            /*if(getHeroes(i+3).Health<=0){
                getHeroes(i+3).Damage=0;
                board[i][5]=' ';
                displayBoard();
            }*/
            if(arrayList.size()==9) {
                if (getHeroes(3).Health <= 0 && getHeroes(4).Health <= 0 && getHeroes(5).Health <= 0 && getHeroes(6).Health <= 0 && getHeroes(7).Health <= 0 && getHeroes(8).Health <= 0) {
                    System.out.println("Second died " + i);
                    break;
                }
            }else {
                if(getHeroes(3).Health<=0 && getHeroes(4).Health<=0 && getHeroes(5).Health<=0){
                    System.out.println("Second died "+i);
                    break;
                }
            }
            //knightSecondLastRow();
            //archerSecondLastRow();
           // knightLast22();
            /*if(getHeroes(i+6).Character!='K') {
                archerLastRow();
            }*/
            archerLastRow1();
            knightLast1();
            if(i==2){
                i=0;
            }else {
                i++;
            }

        }
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
     /*
    public void knightFirst2(){
        if(arrayList.size()>=9) {
            if (getHeroes(i+9).Character == 'K') {
                if ((board[i][getHeroes(i+9).Position + 1] == 'A' || board[i][getHeroes(i+9).Position + 1] == 'K') && (getHeroes(i + 3).Health > 0 || getHeroes(i + 6).Health > 0) && getHeroes(i+9).Health > 0) {
                    System.out.println("knight");
                    if (getHeroes(i + 6).Health > 0) {
                        getHeroes(i + 6).Health = getHeroes(i + 6).Health - getHeroes(i + 9).Damage;
                        System.out.println("why");
                        System.out.println((i + 9) + " attacked " + (i + 6));
                        System.out.println((i + 6) + " Health is " + getHeroes(i + 6).Health);
                    }  if (getHeroes(i + 6).Health <= 0) {
                        board[i][getHeroes(i + 6).Position] = ' ';
                        board[i][getHeroes(i+9).Position] = 'K';
                        displayBoard();
                    }
                     if (getHeroes(i + 3).Health > 0 && getHeroes(i + 6).Health <= 0 && board[i][getHeroes(i+9).Position + 1] == 'A' || board[i][getHeroes(i+9).Position + 1] == 'K' ) {
                        System.out.println("y");
                        getHeroes(i + 3).Health = getHeroes(i + 3).Health - getHeroes(i+9).Damage;
                        System.out.println((i+9) + " attacked " + (i + 3));
                        System.out.println((i + 3) + " Health is " + getHeroes(i + 3).Health);
                    }
                    if(getHeroes(i+3).Health<=0){
                        board[i][getHeroes(i + 3).Position] = ' ';
                        getHeroes(i + 3).Damage = 0;
                        board[i][getHeroes(i+9).Position] = 'K';
                        displayBoard();
                    }

                } else if ((getHeroes(i + 3).Health > 0 || getHeroes(i + 6).Health > 0) && getHeroes(i+9).Health > 0) {
                    getHeroes(i+9).Position++;
                    board[i][getHeroes(i+9).Position] = 'K';
                    board[i][getHeroes(i+9).Position - 1] = ' ';
                    displayBoard();
                }
            }
        }
    }*/
    /*
    public void knightLast22(){
        if(arrayList.size()>=9){
            if(getHeroes(i+6).Character=='K'){
                System.out.println("nm");
                System.out.println(getHeroes(i+6).Position-1);
                if((board[i][getHeroes(i+6).Position-1]=='A'|| board[i][getHeroes(i+6).Position-1]=='K'|| board[i][getHeroes(i+6).Position-1]=='>')&& (getHeroes(i).Health>0|| getHeroes(i+9).Health>0) && getHeroes(i+6).Health>0){
                    System.out.println("bn");
                    if(getHeroes(i+9).Health>0){
                        System.out.println("attack");
                        getHeroes(i+9).Health=getHeroes(i+9).Health-getHeroes(i+6).Damage;
                        System.out.println((i + 6) + " attacked " + (i + 9));
                        System.out.println((i + 9) + " Health is " + getHeroes(i + 9).Health);

                    }
                    if (getHeroes(i + 9).Health <= 0) {
                        System.out.println("health");
                        board[i][getHeroes(i + 9).Position] = ' ';
                        board[i][getHeroes(i+6).Position] = 'K';
                        displayBoard();
                    }
                    if (getHeroes(i).Health > 0 && getHeroes(i +9 ).Health <= 0 &&( board[i][getHeroes(i+6).Position - 1] == 'A' || board[i][getHeroes(i+6).Position - 1] == 'K' )) {
                        getHeroes(i ).Health = getHeroes(i).Health - getHeroes(i+6).Damage;
                        System.out.println((i+6) + " attacked " + (i));
                        System.out.println((i) + " Health is " + getHeroes(i).Health);
                    }if(getHeroes(i).Health<=0){
                        System.out.println("heal");
                        board[i][getHeroes(i ).Position] = ' ';
                        getHeroes(i ).Damage = 0;
                        board[i][getHeroes(i+6).Position] = 'K';
                        displayBoard();
                    }
                } else if ((getHeroes(i ).Health > 0 || getHeroes(i + 9).Health > 0) && getHeroes(i+6).Health > 0) {
                    System.out.println("kj");
                    getHeroes(i+6).Position--;
                    board[i][getHeroes(i+6).Position] = 'K';
                    board[i][getHeroes(i+6).Position +1] = ' ';
                    displayBoard();
                }
            }
        }
    }
    */
    /*
    public void archerLastRow() {
        int why=1;
        int j=1;
        int why2=1;
        int j2=1;
        if (arrayList.size() >= 9) {
            if ((getHeroes(i + 3).Character == 'A' || getHeroes(i+6).Character=='A') && (getHeroes(i).Health > 0 ||getHeroes(i+9).Health>0)) {//SECOND
                System.out.println("Last");
                    if (getHeroes(i + 6).Health > 0 && getHeroes(i + 9).Health > 0) {
                        getHeroes(i + 9).Health = getHeroes(i + 9).Health - getHeroes(i + 6).Damage;
                        System.out.println((i + 6) + " attacked " + (i + 9));
                        System.out.println((i + 9) + " Health is " + getHeroes(i + 9).Health);

                }if (getHeroes(i + 9).Health <= 0 ) {
                    board[i][getHeroes(i + 9).Position] = ' ';
                    displayBoard();
                }
                if(getHeroes(i+3).Health>0 && getHeroes(i+6).Health<=0 && getHeroes(i+9).Health>0) {
                    getHeroes(i+9).Health = getHeroes(i+9).Health - getHeroes(i+3).Damage;
                    System.out.println((i+3) + " attacked " + (i+9));
                    System.out.println((i+9 ) + " health is " + getHeroes(i+9).Health);
                }
                if(getHeroes(i+9).Health<=0){
                    board[i][getHeroes(i+9).Position]=' ';
                    displayBoard();

                }
                if(getHeroes(i).Health>0 && getHeroes(i+9).Health<=0 && getHeroes(i+6).Health<=0 && getHeroes(i+3).Health>0) {
                    getHeroes(i).Health = getHeroes(i).Health - getHeroes(i+3).Damage;
                    System.out.println((i+3) + " attacked " + (i));
                    System.out.println((i ) + " health is " + getHeroes(i).Health);
                }
                if(getHeroes(i).Health<=0){
                    board[i][getHeroes(i).Position]=' ';
                    displayBoard();
                }
                if(getHeroes(i+6).Health>0 && getHeroes(i).Health>0 && getHeroes(i+9).Health<=0){
                    getHeroes(i ).Health = getHeroes(i).Health - getHeroes(i+6).Damage;
                    System.out.println((i+6) + " attacked " + (i));
                    System.out.println((i) + " health is " + getHeroes(i).Health);
                }if(getHeroes(i).Health<=0){
                    board[i][getHeroes(i).Position]=' ';
                    displayBoard();
                }
            }

            }
        }
        */

    /*
    public void archerFirst22(){
        int why=1;
        int j=1;
        int why2=1;
        int j2=1;
        if(arrayList.size()>=9){
            if((getHeroes(i+9).Character=='A'|| getHeroes(i).Character=='A')  && (getHeroes(i + 3).Health > 0 || getHeroes(i + 6).Health > 0)){
                System.out.println("first");
                if(getHeroes(i+6).Health>0 && getHeroes(i+9).Health>0 && getHeroes(i+9).Character=='A'){
                    if(getHeroes(i+9).Character=='A') {
                        while (why != getHeroes(i + 6).Position - 1) {
                            board[i][getHeroes(i + 9).Position + j] = '>';
                            if (j != 1) {
                                board[i][getHeroes(i + 9).Position + (j - 1)] = ' ';
                            }
                            displayBoard();
                            why++;
                            j++;
                        }
                        board[i][getHeroes(i + 6).Position - 1] = ' ';
                        getHeroes(i + 6).Health = getHeroes(i + 6).Health - getHeroes(i + 9).Damage;
                        System.out.println((i + 9) + " attacked " + (i + 6));
                        System.out.println((i + 6) + " health is " + getHeroes(i + 6).Health);
                    }
                }if(getHeroes(i+6).Health <=0){
                    System.out.println("ss");
                    board[i][getHeroes(i+6).Position]=' ';
                    displayBoard();
                }
                else if(getHeroes(i+9).Health>0 && getHeroes(i+6).Health<=0 && getHeroes(i+3).Health>0 && getHeroes(i+9).Character=='A'){
                    getHeroes(i+3).Health=getHeroes(i+3).Health-getHeroes(i+9).Damage;
                    System.out.println((i + 9) + " attacked " + (i + 3));
                    System.out.println((i + 3) + " health is " + getHeroes(i + 3).Health);
                }
                if(getHeroes(i+3).Health <=0  ){
                    board[i][getHeroes(i+3).Position]=' ';
                    displayBoard();
                }
                 if(getHeroes(i+3).Health>0 && getHeroes(i+6).Health<=0 && getHeroes(i+9).Health<=0 && getHeroes(i).Health>0){
                    while (why2!=getHeroes(i+3).Position-1){
                        board[i][getHeroes(i+9).Position + j2] = '>';
                        if (j2 != 1) {
                            board[i][getHeroes(i+9).Position + (j2 - 1)] = ' ';
                        }
                        displayBoard();
                        why2++;
                        j2++;
                    }
                    board[i][getHeroes(i + 3).Position - 1] = ' ';
                    getHeroes(i + 3).Health = getHeroes(i + 3).Health - getHeroes(i).Damage;

                     System.out.println(getHeroes(i).Damage);
                    System.out.println((i) + " attacked " + (i + 3));
                    System.out.println((i + 3) + " health is " + getHeroes(i + 3).Health);
                }if(getHeroes(i+3).Health<=0){
                    board[i][getHeroes(i+3).Position]=' ';
                    displayBoard();
                }
                 if(getHeroes(i).Health>0 && getHeroes(i+9).Health<=0 && getHeroes(i+6).Health>0){
                     getHeroes(i + 6).Health = getHeroes(i +6).Health - getHeroes(i).Damage;
                     System.out.println((i) + " attacked " + (i + 6));
                     System.out.println((i + 6) + " health is " + getHeroes(i + 6).Health);
                 }if(getHeroes(i+6).Health<=0 && getHeroes(i+6).Position!=getHeroes(i+9).Position){
                    board[i][getHeroes(i+6).Position]=' ';
                    displayBoard();
                }
            }
        }
    }
    */
    /*


    public void archerFirst2(){
        int why=0;
        int j=1;
        int why2=0;
        int j2=1;
        if(arrayList.size()>=9) {
            if (getHeroes(i).Character == 'A' && getHeroes(i).Health > 0 && (getHeroes(i + 3).Health > 0 || getHeroes(i + 6).Health > 0) && getHeroes(i+9).Health<=0) {//FIRST
                if (getHeroes(i + 6).Health > 0 && getHeroes(i+9).Health<=0) {
                    while (why != (getHeroes(i + 6).Position - 1)) {
                        board[i][getHeroes(i).Position + j] = '>';
                        if (j != 1) {
                            board[i][getHeroes(i).Position + (j - 1)] = ' ';
                        }
                        displayBoard();
                        why++;
                        j++;
                    }
                    board[i][getHeroes(i + 6).Position - 1] = ' ';

                    getHeroes(i + 6).Health = getHeroes(i + 6).Health - getHeroes(i).Damage;
                    System.out.println(i + " attacked " + (i + 6));
                    System.out.println((i + 6) + " health is " + getHeroes(i + 6).Health);
                }
                if (getHeroes(i + 6).Health <= 0) {
                    getHeroes(i + 6).Damage = 0;
                    board[i][getHeroes(i + 6).Position] = ' ';
                    displayBoard();
                }
                else if (getHeroes(i + 3).Health > 0 && getHeroes(i + 6).Health <= 0 && getHeroes(i+9).Health<=0) {
                    while (why2 != (getHeroes(i + 6).Position - 1)) {
                        board[i][getHeroes(i).Position + j] = '>';
                        if (j2 != 1) {
                            board[i][getHeroes(i).Position + (j2 - 1)] = ' ';
                        }
                        displayBoard();
                        why2++;
                        j2++;
                    }
                    board[i][getHeroes(i + 6).Position - 1] = ' ';
                    getHeroes(i + 3).Health = getHeroes(i + 3).Health - getHeroes(i).Damage;
                    System.out.println(i + " attacked " + (i + 3));
                    System.out.println((i + 3) + " health is " + getHeroes(i + 3).Health);
                }
                if (getHeroes(i + 3).Health <= 0) {
                    getHeroes(i).Health = getHeroes(i).Health + 2;
                    getHeroes(i + 3).Damage = 0;
                    board[i][getHeroes(i + 3).Position] = ' ';
                    displayBoard();
                }
            }
        }
    }
    */
     /*
    public void archerSecondLastRow() {
        int why = getHeroes(i+6).Position;
        int j = 1;
        int why2=getHeroes(i).Position;
        int j2=1;
        if (arrayList.size() >= 9) {
            if (getHeroes(i + 6).Character == 'A' && getHeroes(i + 6).Health > 0 && (getHeroes(i).Health > 0|| getHeroes(i+9).Health>0)) {
                if(getHeroes(i+9).Health>0) {
                    while (why != getHeroes(i+9).Position+1) {
                        board[i][getHeroes(i +6).Position - j] = '<';
                        if (j != 1) {
                            board[i][getHeroes(i + 6).Position - (j - 1)] = ' ';
                        }
                        displayBoard();
                        why--;
                        j++;
                    }
                    if(getHeroes(i+9).Position+1!=getHeroes(i+6).Position) {
                        board[i][getHeroes(i+9).Position + 1] = ' ';
                    }
                    getHeroes(i+9).Health=getHeroes(i+9).Health-getHeroes(i+6).Damage;
                    System.out.println((i + 6) + " attacked " + (i+9));
                    System.out.println((i+9) + " Health is " + getHeroes(i+9).Health);

                }if(getHeroes(i+9).Health<=0){
                    board[i][getHeroes(i+9).Position]=' ';
                    displayBoard();
                }
                else if(getHeroes(i+9).Health<=0 && getHeroes(i).Health>0){
                    while (why2 != getHeroes(i).Position+1) {
                        board[i][getHeroes(i +6).Position - j] = '<';
                        if (j != 1) {
                            board[i][getHeroes(i + 6).Position - (j - 1)] = ' ';
                        }
                        displayBoard();
                        why--;
                        j++;
                    }
                    if(getHeroes(i).Position+1!=getHeroes(i+6).Position) {
                        board[i][getHeroes(i).Position + 1] = ' ';
                    }
                    getHeroes(i).Health=getHeroes(i).Health-getHeroes(i+3).Damage;
                    System.out.println((i + 6) + " attacked " + (i));
                    System.out.println((i) + " Health is " + getHeroes(i).Health);
                }
                if(getHeroes(i).Health<=0){
                    board[i][getHeroes(i).Position]=' ';
                    displayBoard();
                }
            }

        }
    }*/
    /*

    public void knightSecondLastRow(){
        if(arrayList.size()==9) {
            if (getHeroes(i + 6).Character == 'K') {//SECOND
                if ((board[i][getHeroes(i + 6).Position - 1] == 'A' || board[i][getHeroes(i + 6).Position - 1] == 'K') && getHeroes(i + 6).Health > 0 && getHeroes(i).Health > 0) {
                    getHeroes(i).Health = getHeroes(i).Health - getHeroes(i + 6).Damage;
                    System.out.println((i + 6) + " attacked " + (i));
                    System.out.println((i) + " Health is " + getHeroes(i).Health);
                    if (getHeroes(i).Health <= 0) {
                        board[i][getHeroes(i).Position] = ' ';
                        board[i][getHeroes(i + 6).Position] = 'K';
                        getHeroes(i).Damage = 0;
                        displayBoard();
                    }
                } else if (getHeroes(i).Health > 0 && getHeroes(i + 6).Health > 0) {
                    getHeroes(i + 6).Position--;
                    board[i][getHeroes(i + 6).Position] = 'K';
                    board[i][getHeroes(i + 6).Position + 1] = ' ';
                    displayBoard();
                }
            }
        }

    }
    */
