class ParkingSystem {

    int bigCounter;
    int mediumCounter;
    int smallCounter;

    public ParkingSystem(int big, int medium, int small) {
        bigCounter = big;
        mediumCounter = medium;
        smallCounter = small;

    }

    public boolean addCar(int carType) {
        boolean result = false;
        switch(carType){
            case 1:
                if (bigCounter>0){
                    bigCounter--;
                    result=true;
                }
                break;
            case 2:
                if (mediumCounter > 0) {
                    mediumCounter--;
                    result=true;
                }
                break;
            case 3:
                if(smallCounter>0){
                    smallCounter--;
                    result=true;
                }
                break;
            default:
        }
        return result;
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */

/*
* class ParkingSystem {
    int[] count;
    public ParkingSystem(int big, int medium, int small) {
        count = new int[]{big, medium, small};
    }

    public boolean addCar(int carType) {
        return count[carType - 1]-- > 0;
    }
}*/

/*
* class ParkingSystem {
    int[] slot;
    public ParkingSystem(int big, int medium, int small) {
        slot = new int[3];
        slot[2] = small;
        slot[1] = medium;
        slot[0] = big;
    }

    public boolean addCar(int carType) {
        int idx = carType - 1;
        if (slot[idx] > 0) {
            slot[idx] --;
            return true;
        } else {
            return false;
        }
    }
}*/