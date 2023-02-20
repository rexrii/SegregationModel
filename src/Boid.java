public class Boid {
    enum type {
        A,
        B,
    }

    public String id;
    public type myType;
    public int income;
    public int balance;
    public int rowNo;
    public int colNo;

    public ModelGrid modelGrid;

    public Boid(type myType, int income, int balance){
        this.myType = myType;
        this.income = income;
        this.balance = balance;
    }

    /**
     * Possible actions:
     * Stay (If low balance)
     * Move (If high balance)
     */
    public void chooseBoidAction(Boid b, int row, int col){

    }

    /**
     * (Only use this to move to unoccupied grids)
     *@param boid: boid to be moved
     * @param newRow: Move to this row
     * @param newCol: Move to this col
     * @throws Exception if boid doesnt have enough money or property already occupied
     */
    private void boidMove(Boid boid, int newRow, int newCol) throws Exception{
        int oldRow = boid.rowNo;
        int oldCol = boid.colNo;
        int price = modelGrid.gridPrices[newRow][newCol];
        modelGrid.occupiedMap[oldRow][oldCol] = false;

        if(boid.balance<price){
            throw new Exception("boidMove(): Boid balance < property price");
        }
        boid.balance = boid.balance-price;
        if(modelGrid.occupiedMap[newRow][newCol]){
            throw new Exception("boidMove(): Property already occupied");
        }
        boid.rowNo = newRow;
        boid.colNo = newCol;
        modelGrid.occupiedMap[newRow][newCol] = true;
    }


}
