// leetcode 1603 Design Parking System

/*
time: O(1)
space: O(1)
*/

class ParkingSystem {

    private int[] count;
    public ParkingSystem(int big, int medium, int small) {
        count = new int[] {0, big, medium, small};
    }
    
    public boolean addCar(int carType) {
        return count[carType]-- > 0;
    }
}