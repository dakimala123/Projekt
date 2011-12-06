
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

                if (sArray[y][x] == i && isUnique(x, y, i)) {
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

                if (sArray[y][x] == i && isUnique(x, y, i)) {
                    x++;
                } else {
                    i++;
                }
            }
            return true;
        }
        return false;
    }

    public boolean isUnique(int x, int y, int i) {
        int counter = 0;
        int a = x;
        int b = y;

        while (a == x) {
            if (i == sArray[y][x]) {
                counter++;
                a++;
            } else {
                x++;
            }
        }
        if (counter > 1) {
            return false;
        }
        return true;
    }

    private boolean verifyMatrix() {
        int x = 0;
        int y;
        int i = 1;

        for (y = 0; y < 9; y++) {
            if (i > 9) {
                i = 1;
            }

            while (y <= (y + 2)) {
                while (x <= (x + 2)) {
                    if (isUnique(x, y, i)) {
                        i++;
                        x++;
                    } else {
                        return false;
                    }
                }
                y++;
            }

        }
        return false;
    }
}