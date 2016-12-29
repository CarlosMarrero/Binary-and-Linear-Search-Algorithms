package BinaryAndLinearSearch;

import java.awt.*;

import javax.swing.*;

public class BinaryAndLinearSearch extends JFrame {

    JTable chart;
    int g = 0, h = 0, k = 0;
    private final int[] A = new int[10000001];
    private Object[][] linAvAndDev = new Object[14][2];
    private long[] linear = new long[10];//USED FOR STORING TEST RUN TIME.
    private long[] binary = new long[10];
    private Object[][] lin = new Object[7][10];// USED FOR POPULATING THE CHART.
    private Object[][] bin = new Object[7][10];
    Object[][] testResult = new Object[15][13];// MAKES CHART TABLE.

    /**
     * Precondition: Makes an array of 10000001 numbers. Postcondition: Sets
     * each numbers according to the arrays index.
     */
    public void makeArray() {
        for (int i = 0; i < A.length; i++) {
            A[i] = i;
        }
    }

    /**
     * Precondition: Runs a linear search to find the given integer.
     * Postcondition: calculates average and standard deviation after the test
     * is ran 10 times.
     */
    public void linSearch(int current) {
        long average1 = 0, timeA = 0, stanDev = 0;
        System.out.println("\nLINEAR SEARCH\n");
        for (int i = 0; i < 10; i++) {
            long start = System.nanoTime();
            for (int j = 10000000; A[j] >= current; j--) {
                if (current == A[j]) {
                    long stop = System.nanoTime();
                    long timelength = (stop - start);
                    timeA += timelength;// USED FOR GETTING AVERAGE. 
                    lin[g][i] = timelength;//USED FOR STORING THE TIME IT TOOK FOR EACH TEST, IT IS USED LATER ON TO DISPLAY IN THE CHART.
                    linear[i] = timelength;//USED FOR FINDING STANDARD DEVIATION.
                    System.out.println("The number: " + current + " was found at index: " + A[j] + ".\n"
                            + "It took: " + timelength + " nanoseconds.");
                }
            }
        }
        average1 = (timeA / 10);
        linAvAndDev[h][0] = average1;//STORES THE AVEARGE FOR THE TESTS RUNS AND USED FOR THE CHART.
        for (int i = 0; i < 10; i++) {
            stanDev += Math.pow((linear[i] - average1), 2.0);
        }
        stanDev /= 10;
        stanDev = (long) Math.sqrt(stanDev);
        linAvAndDev[h][1] = stanDev;//STORES THE STANDARD DEVIATION AND IS USED FOR THE CHART. MIGHT NOT BE WORKING CORRECTLY.
        System.out.println("The Avearge time for the Linear Search was: " + average1 + " nanoseconds."
                + "\nThe Standard Deviation time for the Linear Search was: " + stanDev + " nanoseconds.");
        g += 1;//USED FOR GOING THROUGH THE OBJECT ARRAY TO STORE INFORMATION.
        h += 1;
    }

    /**
     * Precondition: Runs a binary search of the array made on the given number.
     * Postcondition: calculates average and standard deviation after the test
     * is ran 10 times.
     */
    public void binSearch(int current, int first, int last) {
        long average2 = 0, timeB = 0, stanDev = 0;
        System.out.println("\nBINARY SEARCH\n");
        for (int i = 0; i < 10; i++) {
            long start = System.nanoTime();
            while (last >= first) {
                int mid = (last + first) / 2;//FINDS THE MID WAY POINT IN ORDER TO KEEP HALF-ING THE SEARCH RESULTS.
                if (A[mid] == current) {
                    long stop = System.nanoTime();
                    long timelength = (stop - start);
                    timeB += timelength; // USED FOR GETTING AVERAGE. 
                    bin[k][i] = timelength;//USED FOR STORING THE TIME IT TOOK FOR EACH TEST, IT IS USED LATER ON TO DISPLAY IN THE CHART.
                    binary[i] = timelength;//USED FOR FINDING STANDARD DEVIATION.
                    System.out.println("The number: " + current + " was found in the array index: " + A[mid]
                            + "\nIt took: " + timelength + " nanoseconds.");
                    break;

                } else if (A[mid] < current) {
                    first = mid + 1;
                } else {
                    last = mid - 1;
                }
            }
        }
        average2 = (timeB / 10);
        linAvAndDev[h][0] = average2;
        for (int j = 0; j < 10; j++) {
            stanDev += Math.pow((binary[j] - average2), 2.0);
        }
        stanDev /= 10;
        stanDev = (long) Math.sqrt(stanDev);
        linAvAndDev[h][1] = stanDev;
        System.out.println("The Avearge time for the Binary Search was: " + average2 + " nanoseconds."
                + "\nThe Standard Deviation time for the Binary Search was: " + stanDev + " nanoseconds.");
        h += 1;
        k += 1;
    }

    /**
     * Precondition: Makes a chart with the information provide with the arrays
     * made earlier. Postcondition: has to be called last for information to be
     * inputed correctly.
     */
    public void chart() {
        setLayout(new FlowLayout());
        String[] testNumbers = {"LINEAR SEARCH", "TEST 1", "TEST 2", "TEST 3", "TEST 4", "TEST 5", "TEST 6", "TEST 7", "TEST 8", "TEST 9", "TEST 10", "AVERAGE", "STANDARD DEV."};
        Object[][] testResult = {{"500", lin[0][0], lin[0][1], lin[0][2], lin[0][3], lin[0][4], lin[0][5], lin[0][6], lin[0][7], lin[0][8], lin[0][0], linAvAndDev[0][0], linAvAndDev[0][1]},
        {"10,000", lin[1][0], lin[1][1], lin[1][2], lin[1][3], lin[1][4], lin[1][5], lin[1][6], lin[1][7], lin[1][8], lin[1][9], linAvAndDev[1][0], linAvAndDev[1][1]},
        {"100,000", lin[2][0], lin[2][1], lin[2][2], lin[2][3], lin[2][4], lin[2][5], lin[2][6], lin[2][7], lin[2][8], lin[2][9], linAvAndDev[2][0], linAvAndDev[2][1]},
        {"1,000,000", lin[3][0], lin[3][1], lin[3][2], lin[3][3], lin[3][4], lin[3][5], lin[3][6], lin[3][7], lin[3][8], lin[3][9], linAvAndDev[3][0], linAvAndDev[3][1]},
        {"5,000,000", lin[4][0], lin[4][1], lin[4][2], lin[4][3], lin[4][4], lin[4][5], lin[4][6], lin[4][7], lin[4][8], lin[4][9], linAvAndDev[4][0], linAvAndDev[4][1]},
        {"7,000,000", lin[5][0], lin[5][1], lin[5][2], lin[5][3], lin[5][4], lin[5][5], lin[5][6], lin[5][7], lin[5][8], lin[5][9], linAvAndDev[5][0], linAvAndDev[5][1]},
        {"10,000,000", lin[6][0], lin[6][1], lin[6][2], lin[6][3], lin[6][4], lin[6][5], lin[6][6], lin[6][7], lin[6][8], lin[6][9], linAvAndDev[6][0], linAvAndDev[6][1]},
        {"BINARY SEARCH", "TEST 1", "TEST 2", "TEST 3", "TEST 4", "TEST 5", "TEST 6", "TEST 7", "TEST 8", "TEST 9", "TEST 10", "AVERAGE", "STANDARD DEV."},
        {"500", bin[0][0], bin[0][1], bin[0][2], bin[0][3], bin[0][4], bin[0][5], bin[0][6], bin[0][7], bin[0][8], bin[0][9], linAvAndDev[7][0], linAvAndDev[7][1]},
        {"10,000", bin[1][0], bin[1][1], bin[1][2], bin[1][3], bin[1][4], bin[1][5], bin[1][6], bin[1][7], bin[1][8], bin[1][9], linAvAndDev[8][0], linAvAndDev[8][1]},
        {"100,000", bin[2][0], bin[2][1], bin[2][2], bin[2][3], bin[2][4], bin[2][5], bin[2][6], bin[2][7], bin[2][8], bin[2][9], linAvAndDev[9][0], linAvAndDev[9][1]},
        {"1,000,000", bin[3][0], bin[3][1], bin[3][2], bin[3][3], bin[3][4], bin[3][5], bin[3][6], bin[3][7], bin[3][8], bin[3][9], linAvAndDev[10][0], linAvAndDev[10][1]},
        {"5,000,000", bin[4][0], bin[4][1], bin[4][2], bin[4][3], bin[4][4], bin[4][5], bin[4][6], bin[4][7], bin[4][8], bin[4][9], linAvAndDev[11][0], linAvAndDev[11][1]},
        {"7,000,000", bin[5][0], bin[5][1], bin[5][2], bin[5][3], bin[5][4], bin[5][5], bin[5][6], bin[5][7], bin[5][8], bin[5][9], linAvAndDev[12][0], linAvAndDev[12][1]},
        {"10,000,000", bin[6][0], bin[6][1], bin[6][2], bin[6][3], bin[6][4], bin[6][5], bin[6][6], bin[6][7], bin[6][8], bin[6][9], linAvAndDev[13][0], linAvAndDev[13][1]}};
        chart = new JTable(testResult, testNumbers);
        chart.setPreferredScrollableViewportSize(new Dimension(1500, 500)); // SETS SIZE OF CHART.
        chart.setFillsViewportHeight(true);
        JScrollPane scrollPane = new JScrollPane(chart);
        add(scrollPane);
    }
}
