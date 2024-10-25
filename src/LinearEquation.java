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


    public double distance(int x1, int y1, int x2, int y2) {
        return roundToHundredth(Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2)));
    }


    public double yIntercept(int x1, int y1, int x2, int y2) {
        double slope = slope(x1, y1, x2, y2);
        return roundToHundredth(y1 - (slope * x1));
    }


    public double slope(int x1, int y1, int x2, int y2) {
        return (double) (y2 - y1) / (x2 - x1);
    }


    public String equation() {
        String equation = "y = ";
        double slope = slope(x1, y1, x2, y2);
        double yIntercept = yIntercept(x1, y1, x2, y2);
        if (y1 != y2) {
            if (slope == Math.round(slope)) {
                equation += (int) slope;
            } else {
                equation += (y2 - y1) + "/" + (x2 - x1);
            }
            equation += "x";
            if (yIntercept > 0) {
                equation += " + ";
            } else if (yIntercept < 0) {
                equation += " - ";
            } else {
                return equation;
            }
        }
        equation += Math.abs(yIntercept);
        return equation;
    }


    public String coordinateForX(double x) {
        return "(" + x + ", " + roundToHundredth((slope(x1, y1, x2, y2) * x) + yIntercept(x1, y1, x2, y2)) + ")";
    }


    private double roundToHundredth(double toRound) {
        return Math.round(toRound * 100) / 100.0;
    }
}


