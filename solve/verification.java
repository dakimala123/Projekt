public class verification {
    
    private int[][] sArray;

    public void Verify(int[][] array) {
        sArray = array;
    } 

    public boolean verify() {
        if (verifyVert() && verifyHor()/* && verifyMat()*/) {
            return true;
        }
        return false;
    }

    private boolean verifyVert() {
        int x = 0;
        int y = 0;
        int i = 1;

        for (; x < 9; x++) {
            while (y < 9) {
                if (i > 9) {
                    i = 1;
                }

                if (sArray[y][x] == i) {
                    y++;
                } else {
                    i++;
                }
            }
            return true;
        }
        return false;
    }

    private boolean verifyHor() {
        int x = 0;
        int y = 0;
        int i = 1;

        for (; y < 9; y++) {
            while (x < 9) {
                if (i > 9) {
                    i = 1;
                }

                if (sArray[y][x] == i) {
                    x++;
                } else {
                    i++;
                }
            }
            return true;
        }
        return false;
    }

    private boolean isUnique(int x, int y, int i) {
        int counter = 0;
        int a = x;
        int b = y;

        while (a == x) {
            if (i == sArray[y][x]) {
                counter++;
            } else {
                x++;
            }
        }
        if (counter > 1) {
            return false;
        }
        return true;
    }

//    private boolean verifyMat() {
//        int x = 0;
//        int y = 0;
//        int i = 1;
//        
//        
//    }
}