package gdp.stdlib;

/*************************************************************************
 *  Compilation:  javac StdStats.java
 *  Execution:    java StdStats
 *
 *  Library of statistical functions.
 *
 *  The test client converts the command-line arguments to an array
 *  of doubles, and then calls min(), mean(), stddev(), and max(),
 *
 *  The functions all throw a NullPointerException if the array
 *  passed in is null.
 *
 *  %  java StdStats 3.0 1.0 2.0 5.0 4.0
 *  1.000000 3.000000 (1.414214) 5.000000
 *
 *  Remarks
 *  ------------
 *    - Should we compute sample variance and sample stddev (divide by N-1)
 *      instead of variance and stddev (divide by N) ?
 *  
 *************************************************************************/

public class StdStats {

    // return maximum value (-infinity if no such value)
    public static double max(double[] a) {
        double max = Double.NEGATIVE_INFINITY;
        for (int i = 0; i < a.length; i++) {
            if (a[i] > max) max = a[i];
        }
        return max;
    }

    // return minimum value (+infinity if no such value)
    public static double min(double[] a) {
        double min = Double.POSITIVE_INFINITY;
        for (int i = 0; i < a.length; i++) {
            if (a[i] < min) min = a[i];
        }
        return min;
    }

    // return average value (NaN if no such value)
    public static double mean(double[] a) {
        double sum = 0.0;
        for (int i = 0; i < a.length; i++) {
            sum = sum + a[i];
        }
        return sum / a.length;
    }

    // return average value (NaN if no such value)
    public static double mean(int[] a) {
        double sum = 0.0;
        for (int i = 0; i < a.length; i++) {
            sum = sum + a[i];
        }
        return sum / a.length;
    }

    // return variance (NaN if no such value)
    public static double var(double[] a) {
        double avg = mean(a);
        double sum = 0.0;
        for (int i = 0; i < a.length; i++) {
            sum += (a[i] - avg) * (a[i] - avg);
        }
        return sum / a.length;
    }

    // return variance (NaN if no such value)
    public static double var(int[] a) {
        double avg = mean(a);
        double sum = 0.0;
        for (int i = 0; i < a.length; i++) {
            sum += (a[i] - avg) * (a[i] - avg);
        }
        return sum / a.length;
    }

    // return standard deviation (NaN if no such value)
    public static double stddev(double[] a) {
        return Math.sqrt(var(a));
    }

    // return standard deviation (NaN if no such value)
    public static double stddev(int[] a) {
        return Math.sqrt(var(a));
    }

    // return maximum value (overloaded for int values)
    public static int max(int[] a) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < a.length; i++) {
            if (a[i] > max) max = a[i];
        }
        return max;
    }

    // return sum of all values (0 if no elements)
    public static int sum(int[] a) {
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
        }
        return sum;
    }


    // plot points (i, a[i])
    public static void plotPoints(double[] a) {
        int N = a.length;
        StdDraw.setXscale(0, N-1);
        StdDraw.setPenRadius(1.0 / (3.0 * N));
        for (int i = 0; i < N; i++) {
            StdDraw.point(i, a[i]);
        }
    }

    // plot line segments connecting points (i, a[i])
    public static void plotLines(double[] a) {
        int N = a.length;
        StdDraw.setXscale(0, N-1);
        StdDraw.setPenRadius();
        for (int i = 1; i < N; i++) {
            StdDraw.line(i-1, a[i-1], i, a[i]);
        }
    }

    // plot bars from (0, a[i]) to (i, a[i])
    public static void plotBars(double[] a) {
        int N = a.length;
        StdDraw.setXscale(0, N-1);
        StdDraw.setPenRadius(0.5 / N);
        for (int i = 0; i < N; i++) {
            StdDraw.line(i, 0, i, a[i]);
        }
    }




    // convert command-line arguments to array of doubles and call various methods
    public static void main(String[] args) { 

        // read in values from command line
        double[] a = new double[args.length];
        for (int i = 0; i < args.length; i++) {
            a[i] = Double.parseDouble(args[i]);
        }

        // print results
        StdOut.printf("%f %f (%f) %f\n", min(a), mean(a), stddev(a), max(a));

    }
}
