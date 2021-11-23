// =========== 1 solutions =============

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */

class ParkingSystem {

    private int big; 
    private int medium;
    private int small;
    
    public ParkingSystem(int big, int medium, int small) {
        this.big = big;
        this.medium = medium;
        this.small = small;
    }
    
    public boolean addCar(int carType) {
        
        if(1 == carType && big > 0)
        {
            --big;
            return true;
        }
        
        if(2 == carType && medium > 0)
        {
            --medium;
            return true;
        }
        
        if(3 == carType && small > 0)
        {
            --small;
            return true;
        }
        
        return false;
    }
}