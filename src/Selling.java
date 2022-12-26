import java.util.Scanner;

public class Selling {
    public static boolean isInBakery = true;
    public static int dollarsCollected = 0;

    public static int rowS = -1;
    public static int collS = -1;

    public static int rowFirstPillar = -1;
    public static int collFirstPillar = -1;
    public static int rowSecondPillar = -1;
    public static int collSecondPillar = -1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        String[][] bakery = new String[n][n];

        for (int i = 0; i < n; i++) {
            String[] line = scanner.nextLine().split("");
            bakery[i] = line;
            for (int j = 0; j < n; j++) {
                if (line[j].equals("S")) {
                    rowS = i;
                    collS = j;
                } else if (line[j].equals("O")) {
                    if (rowFirstPillar == -1) {
                        rowFirstPillar = i;
                        collFirstPillar = j;
                    } else {
                        rowSecondPillar = i;
                        collSecondPillar = j;
                    }
                }
            }
        }

        while (isInBakery && dollarsCollected < 50) {
            String command = scanner.nextLine();
            bakery[rowS][collS] = "-";
            switch (command) {
                case "up":
                    if (rowS - 1 >= 0) {
                        rowS --;
                        checkSymbol(bakery);
                    } else {
                        isInBakery = false;
                    }
                    break;
                case "down":
                    if (rowS + 1 < n) {
                        rowS ++;
                        checkSymbol(bakery);
                    } else {
                        isInBakery = false;
                    }
                    break;
                case "left":
                    if (collS - 1 >= 0) {
                        collS --;
                        checkSymbol(bakery);
                    } else {
                        isInBakery = false;
                    }
                    break;
                case "right":
                    if (collS + 1 < n) {
                        collS ++;
                        checkSymbol(bakery);
                    } else {
                        isInBakery = false;
                    }
                    break;
            }

        }

        if (isInBakery) {
            bakery[rowS][collS] = "S";
        }
        if (!isInBakery) {
            System.out.println("Bad news, you are out of the bakery.");
        } else {
            System.out.println("Good news! You succeeded in collecting enough money!");
        }

        System.out.printf("Money: %d%n", dollarsCollected);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(bakery[i][j]);
            }
            System.out.println();
        }

    }


        private static boolean isInteger( String[][] bakery, int rowS, int collS) {
            try {
                Integer.parseInt( bakery[rowS][collS]);
                return true;
            }
            catch( Exception e ) {
                return false;
            }
        }


    private static void checkSymbol(String [][] bakery) {
        if (isInteger(bakery, rowS, collS)){
            dollarsCollected += Integer.parseInt(bakery[rowS][collS]);
        } else if (bakery[rowS][collS].equals("O")) {
            if (rowS == rowFirstPillar) {
                bakery[rowS][collS] = "-";
                rowS = rowSecondPillar;
                collS = collSecondPillar;
            } else if (rowS == rowSecondPillar) {
                bakery[rowS][collS] = "-";
                rowS = rowFirstPillar;
                collS = collFirstPillar;
            }
        }
    }
}
