import java.util.Scanner;


public class LinearEquationLogic {
    Scanner scan;


    private String coordPair1;
    private String coordPair2;
    private int x1;
    private int y1;
    private int x2;
    private int y2;
    private boolean cont = true;


    public LinearEquationLogic() {
        scan = new Scanner(System.in);
    }


    public void start() {
        while (cont) {
            System.out.print("Please enter the first coordinate pair (x, y): ");
            coordPair1 = scan.nextLine();
            System.out.print("Please enter the second coordinate pair (x, y): ");
            coordPair2 = scan.nextLine();
            System.out.println();
            parseCoords();

            if (x1 != x2) {
                LinearEquation linear = new LinearEquation(x1, y1, x2, y2);

                System.out.println(linear.lineInfo());
                System.out.println();

                System.out.print("Please enter an x value: ");
                System.out.println("The point on this line at that x value is: " + linear.coordinateForX(scan.nextDouble()));
                scan.nextLine();
            } else {
                System.out.println("Equation: x = " + x1);
                System.out.println("Since the x values are the same, there is no possible y = mx + b equation for these points.");
            }

            System.out.println();
            System.out.print("Would you like to go again? (y/n) ");
            if (scan.nextLine().equals("n")) {
                cont = false;
            } else {
                System.out.println("------------------------------");
            }
        }
    }


    private void parseCoords() {
        x1 = Integer.parseInt(coordPair1.substring(1, coordPair1.indexOf(",")));
        y1 = Integer.parseInt(coordPair1.substring(coordPair1.indexOf(" ") + 1, coordPair1.indexOf(")")));
        x2 = Integer.parseInt(coordPair2.substring(1, coordPair2.indexOf(",")));
        y2 = Integer.parseInt(coordPair2.substring(coordPair2.indexOf(" ") + 1, coordPair2.indexOf(")")));
    }
}


