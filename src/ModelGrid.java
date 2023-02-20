import java.util.ArrayList;
import java.util.Random;

public class ModelGrid {
    private int rowNo; //Number of rows in grid for model
    private int colNo; // Number of columns in grid for model

    private int redLine; //Split the first n rows as area 1, and the rest as area 2
    public int[][] gridPrices; //Price of each grid
    public boolean[][] occupiedMap;//true if occupied, false if not

    Random r = new Random();

    public ModelGrid(int rowNo, int colNo, int redLine){
        this.rowNo = rowNo;
        this.colNo = colNo;
        this.redLine = redLine;
        gridPrices = new int[rowNo][colNo];
        occupiedMap = new boolean[rowNo][colNo];
    }

    /**
     * Randomise prices in grid
     * (Currently linear from 0-9)
     */
    public void initialiseGridPrices(){
        for(int i=0; i<rowNo;i++){
            for(int j=0; j<colNo; j++){
                gridPrices[i][j] = r.nextInt(10);
            }
        }
    }

    public void printGridPrices(){
        System.out.println("Printing Prices:");
        for(int[] row : gridPrices){
            System.out.print("[");
            for(int price : row){
                System.out.printf("%5s", price);
            }
            System.out.printf("%5s %n", "]");
        }
    }
}
