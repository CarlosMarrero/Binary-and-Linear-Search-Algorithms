package BinaryAndLinearSearch;

import javax.swing.JFrame;

public class BinaryAndLinearSearchDriver {

    public static void main(String[] args) {
        BinaryAndLinearSearch b = new BinaryAndLinearSearch();
        b.makeArray();//CALLS DEFAULT CONSTRUCTOR TO MAKE ARRAY OF 10000001 NUMBERS
        b.linSearch(500);//FINDS 500 LINEAR WISE.
        b.linSearch(10000);
        b.linSearch(100000);
        b.linSearch(1000000);
        b.linSearch(5000000);
        b.linSearch(7000000);
        b.linSearch(10000000);
        b.binSearch(500, 0, 10000001);// FINDS 500 BINARY WISE. TAKES PARAMITERS OF STARTING AND ENDING INTS.
        b.binSearch(10000, 0, 10000001);
        b.binSearch(100000, 0, 10000001);
        b.binSearch(1000000, 0, 10000001);
        b.binSearch(5000000, 0, 10000001);
        b.binSearch(7000000, 0, 10000001);
        b.binSearch(10000000, 0, 10000001);
        b.chart();// MAKES CHART
        b.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// ALLOWS TO CLOSE.
        b.setSize(1550, 360);// SETS SIZE OF WINDOW TO DISPLAY CHART.
        b.setVisible(true);
        b.setTitle("Test Results");//SETS TITLE

    }
}
