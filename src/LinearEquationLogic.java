import java.util.Scanner;




public class LinearEquationLogic {
    Scanner scan;




    private String coordPair1;
    private String coordPair2;
    private int x1;
    private int y1;
    private int x2;
    private int y2;




    public LinearEquationLogic() {
        scan = new Scanner(System.in);
    }


    public void start() {
        System.out.print("Please enter the first coordinate pair (x, y): ");
        coordPair1 = scan.nextLine();
        System.out.print("Please enter the second coordinate pair (x, y): ");
        coordPair2 = scan.nextLine();
        parseCoords();
        LinearEquation linear = new LinearEquation(x1, y1, x2, y2);


        System.out.println(linear.slope(x1, y1, x2, y2));
        System.out.println(linear.yIntercept(x1, y1, x2, y2));
        System.out.println(linear.equation());
    }


    private void parseCoords() {
        x1 = Integer.parseInt(coordPair1.substring(1, coordPair1.indexOf(",")));
        y1 = Integer.parseInt(coordPair1.substring(coordPair1.indexOf(" ") + 1, coordPair1.indexOf(")")));
        x2 = Integer.parseInt(coordPair2.substring(1, coordPair2.indexOf(",")));
        y2 = Integer.parseInt(coordPair2.substring(coordPair2.indexOf(" ") + 1, coordPair2.indexOf(")")));
    }
}


