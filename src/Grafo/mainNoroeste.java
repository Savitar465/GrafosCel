package Grafo;

import javax.swing.*;

public class mainNoroeste {


    public static void main(String[] args) {
        JButton btnNor;
        JFrame ventana = new JFrame("Grafo");
        noroeste Nor;


        String row = JOptionPane.showInputDialog("Filas");
        String col = JOptionPane.showInputDialog("Columnas");
        int matrixRow = Integer.parseInt(row);
        int matrixCol = Integer.parseInt(col);
        int[][] matrix = new int[matrixRow][matrixCol];
        Nor = new noroeste(matrix,matrixRow, matrixCol);
        ventana.add(Nor);

        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(800, 800);
        ventana.setLocation(100, 100);
        ventana.setVisible(true);

    }
}
