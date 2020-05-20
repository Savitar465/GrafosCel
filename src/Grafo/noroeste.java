package Grafo;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class noroeste extends JPanel implements MouseListener  {
    JButton btnMax,btnMin;
    int[][] Nor;
    private int[][] MatrizSolucion;
    private Vector<Nodo> nodos;
    private Vector<Arista> aristas;
    int r, c;
    JFrame ven = new JFrame("Grafo");
    GrafoNoroeste grafo1;

    public noroeste(int[][] nor, int r, int c) {
        Nor = nor;
        this.r = r;
        this.c = c;
        ejecutar(Nor,r,c);
    }




    private void ejecutar(int[][] matrix, int matrixRow, int matrixCol) {
        setLayout(null);
        JPanel a = new JPanel();
        JTextField tex= new JTextField();
        btnMax = new JButton("Maximizar");
        btnMin = new JButton("Minimizar");
        btnMax.setBounds(500,300,150,30);
        btnMin.setBounds(500,400,150,30);
        JTextField [][] matriz = new JTextField[matrixRow+2][matrixCol+2];
//        int [] demanda = new int[matrixCol];
//        int [] oferta = new int[matrixRow];
        ArrayList<Integer> demanda =new ArrayList<Integer>();
        ArrayList<Integer> oferta =new ArrayList<Integer>();
        int posh = 20;
        int posv = 60;
        int fil;
        int col;
        for(col=0;col<matrixRow+2;col++){
            for(fil=0;fil<matrixCol+2;fil++){
                matriz[col][fil]= new JTextField();
                matriz[col][fil].setBounds(posv,posh,90,40);
                add(matriz[col][fil]);
                posv+=90;
            }
            posh+=40;
            posv =60;
        }
        matriz[0][0].setVisible(false);
        matriz[matrixRow+1][matrixCol+1].setVisible(false);
        matriz[0][matrixCol+1].setText("Oferta");
        matriz[0][matrixCol+1].setEnabled(false);
        matriz[matrixRow+1][0].setText("Demanda");
        matriz[matrixRow+1][0].setEnabled(false);

        add(btnMax);
        add(btnMin);
        addMouseListener(this);
        btnMax.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                for(int i=0;i<matrixRow;i++){
                    for(int j=0;j<matrixCol;j++){
                        matrix[i][j]=Integer.parseInt(matriz[i+1][j+1].getText());
                    }
                }



                for(int i=0;i<matrixCol;i++){
                    demanda.add(Integer.parseInt(matriz[matrixRow+1][i+1].getText()));
                }
                for(int i=0;i<matrixRow;i++){
                    oferta.add(Integer.parseInt(matriz[i+1][matrixCol+1].getText()));

                }
                MatrizSolucion=Noro9(matrix,demanda,oferta,matrixRow,matrixCol);
                JTable tabla= printMatrix(MatrizSolucion,matrixRow,matrixCol);
                tabla.setBounds(60,400,400,200);
                tabla.setAutoResizeMode(1);
                add(tabla);
                grafo1 = new GrafoNoroeste(matriz, matrixRow,matrixCol, 1,MatrizSolucion);
                ven.add(grafo1);
                ven.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                ven.setSize(800, 800);
                ven. setLocation(1000, 100);;
                ven.setVisible(true);
                mostrar(MatrizSolucion);
                CostoTotal(matrix,MatrizSolucion);
            }


        });
        btnMin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                for(int i=0;i<matrixRow;i++){
                    for(int j=0;j<matrixCol;j++){
                        matrix[i][j]=Integer.parseInt(matriz[i+1][j+1].getText());
                    }
                }



                for(int i=0;i<matrixCol;i++){
                    demanda.add(Integer.parseInt(matriz[matrixRow+1][i+1].getText()));
                }
                for(int i=0;i<matrixRow;i++){
                    oferta.add(Integer.parseInt(matriz[i+1][matrixCol+1].getText()));

                }
                MatrizSolucion=Noro9(matrix,demanda,oferta,matrixRow,matrixCol);
                JTable tabla= printMatrix(MatrizSolucion,matrixRow,matrixCol);
                tabla.setBounds(60,400,400,200);
                tabla.setAutoResizeMode(1);
                add(tabla);
                grafo1 = new GrafoNoroeste(matriz, matrixRow,matrixCol, 1,MatrizSolucion);
                ven.add(grafo1);
                ven.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                ven.setSize(800, 800);
                ven. setLocation(1000, 100);;
                ven.setVisible(true);
                mostrar(MatrizSolucion);
                CostoTotal(matrix,MatrizSolucion);
            }
        });


    }

    public static int[][] Noro9(int[][]matrix,ArrayList<Integer> demanda, ArrayList<Integer> oferta, int matrixRow, int matrixCol){
        int[][] matrizSolucion= new int[matrixRow][matrixCol];
        for(int col=0;col<matrixRow;col++){
            for(int fil=0;fil<matrixCol;fil++){
                if (demanda.get(fil)<=oferta.get(col)){
                    matrizSolucion[col][fil]=demanda.get(fil);
                    oferta.set(col,oferta.get(col)-demanda.get(fil));
                    demanda.set(fil,0);
                }else{
                    matrizSolucion[col][fil]=oferta.get(col);
                    demanda.set(fil,demanda.get(fil)-oferta.get(col));
                    oferta.set(col,0);
                }
            }

        }

        return matrizSolucion;
    }
    public static void enterMatrixData(Scanner scan, int[][] matrix, int matrixRow, int matrixCol) {
        System.out.println("Enter Matrix Data");

        for (int i = 0; i < matrixRow; i++) {
            for (int j = 0; j < matrixCol; j++) {
                matrix[i][j] = scan.nextInt();
            }
        }

    }

    public static JTable printMatrix(int[][] matrix, int matrixRow, int matrixCol) {
        System.out.println("Your Matrix is : ");
        JTable tblMatriz = new JTable();
        DefaultTableModel matri = (DefaultTableModel) tblMatriz.getModel();
        matri.setRowCount(matrixRow);
        matri.setColumnCount(matrixCol);
        for (int i = 0; i < matrixRow; i++) {
            for (int j = 0; j < matrixCol; j++) {
                tblMatriz.setValueAt(matrix[i][j],i,j);
            }

        }

        return tblMatriz;
    }

    public static void CostoTotal(int[][]matriz,int[][]matrizSolu){

        int suma=0;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                suma= suma+(matriz[i][j]*matrizSolu[i][j]);
            }

        }

        JOptionPane.showMessageDialog (null, suma);
    }
    public void mostrar(int matrizAdy[][]) {
        int c =matrizAdy.length;
        String[] m= new String[c];
        for(int i = 0;i < c; i++) {
            String v ="";
            for(int j = 0; j < matrizAdy[0].length; j++) {
                v+= matrizAdy[i][j]+"   ";
            }
            m[i]=v;
        }
        JOptionPane.showMessageDialog (null, m);

    }
    @Override
    public void mouseClicked(MouseEvent mouseEvent) {

    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }
}