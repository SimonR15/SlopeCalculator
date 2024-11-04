public class LinearEquation {
    private int x1;
    private int y1;
    private int x2;
    private int y2;


    public LinearEquation(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }


    public double distance() {
        return roundToHundredth(Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2)));
    }


    public double yIntercept() {
        double slope = slope();
        return roundToHundredth(y1 - (slope * x1));
    }


    public double slope() {
        return roundToHundredth((double) (y2 - y1) / (x2 - x1));
    }


    public String equation() {
        String equation = "y = ";
        double slope = slope();
        double yIntercept = yIntercept();
        if (slope < 0) {
            equation += "-";
        }
        if (y1 != y2) {
            if (Math.abs(slope) != 1) {
                if (slope == Math.round(slope)) {
                    equation += (int) Math.abs(slope);
                } else {
                    equation += Math.abs(y2 - y1) + "/" + Math.abs(x2 - x1);
                }
            }
            equation += "x";
            if (yIntercept > 0) {
                equation += " + ";
            } else if (yIntercept < 0) {
                equation += " - ";
            } else {
                return equation;
            }
        } else if (yIntercept < 0) {
            equation += "-";
        }
        equation += Math.abs(yIntercept);
        return equation;
    }


    public String coordinateForX(double x) {
        return "(" + x + ", " + roundToHundredth((slope() * x) + yIntercept()) + ")";
    }


    public String lineInfo() {
        String str = "";
        str += "The two points are: (" + x1 + ", " + y1 + ") and (" + x2 + ", " + y2 + ")";
        str += "\nThe equation of the line between these points is: " + equation();
        str += "\nThe slope of this line is: " + slope();
        str += "\nThe y-intercept of this line is: " + yIntercept();
        str += "\nThe distance between these points is: " + distance();
        return str;
    }


    private double roundToHundredth(double toRound) {
        return Math.round(toRound * 100) / 100.0;
    }
}


