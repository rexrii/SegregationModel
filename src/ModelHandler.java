import java.util.ArrayList;
import java.util.Random;

public class ModelHandler {
    /**
     * TODO:
     * Implement Redline
     * Implement agent moving behaviour
     *
     */
    public static void main(String[] args){
        ModelHandler mh = new ModelHandler();
        mh.modelGrid.printGridPrices();
        mh.printBoids();

    }
    private int currentTurn = 0; //Current turn
    private int rowNo = 10; //Number of rows in grid for model
    private int colNo = 20; // Number of columns in grid for model

    private int redLine = 5; //Split the first n rows as area 1, and the rest as area 2
    private ArrayList<Boid> boidList = new ArrayList<>(); //List of all boids
    ModelGrid modelGrid;
    Random r = new Random();

    //Initialise grid prices and boids on construction
    public ModelHandler(){
        modelGrid = new ModelGrid(rowNo, colNo, redLine);
        modelGrid.initialiseGridPrices();
        initialiseBoids(5);
    }

    /**
     * @param num: Create a total of 2*num boids (num of type A + num of type B) and place randomly on map
     */
    private void initialiseBoids(int num){
        int id_A = 1;
        int id_B = 1;

        for(int i=0; i<num; i++){
            Boid boidA = new Boid(Boid.type.A, 1, 0);
            boidA.modelGrid = modelGrid;
            boidA.id = "A"+id_A++;
            Boid boidB = new Boid(Boid.type.B, 1, 0);
            boidB.modelGrid = modelGrid;
            boidB.id = "B"+id_B++;
            boidList.add(boidA);
            boidList.add(boidB);
        }
        //Place boids on map
        for(Boid boid : boidList){
            boid.rowNo = r.nextInt(rowNo);
            boid.colNo = r.nextInt(colNo);
            //Loop until
            while(modelGrid.occupiedMap[boid.rowNo][boid.colNo]){
                boid.rowNo = r.nextInt(rowNo);
                boid.colNo = r.nextInt(colNo);
            }
            modelGrid.occupiedMap[boid.rowNo][boid.colNo] = true;
        }
    }

    //Print boid locations on grid
    private void printBoids(){
        String[][] stringMap = new String[rowNo][colNo];

        for(int i=0; i<rowNo; i++){
            for(int j=0; j<colNo; j++){
                stringMap[i][j] = "_";
            }
        }

        for(Boid boid : boidList){
            stringMap[boid.rowNo][boid.colNo] = boid.id;
            /*
            switch(boid.myType){
                case A:
                    stringMap[boid.rowNo][boid.colNo] = "A";
                    break;
                case B:
                    stringMap[boid.rowNo][boid.colNo] = "B";
                    break;
            }
            */
        }
        for(String[] row : stringMap){
            System.out.print("[");
            for(String s : row){
                System.out.printf("%5s", s);
            }
            System.out.printf("%5s %n", "]");
        }
    }


}
