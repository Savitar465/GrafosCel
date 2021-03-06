package Sort;

import Grafo.noroeste;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Selection extends JFrame implements ActionListener {
    private static long TInicio;
    private JTextField textfield1;
    private JTextPane text;
    private JTextPane text1;
    private static JTextPane temp;
    private JLabel label1;
    private JButton boton1;
    private JButton boton2;
    private JButton boton3;
    private JButton boton4;
    private JButton boton5;
    int c=0;
    ArrayList<Integer> al=new ArrayList<Integer>();
    private static long  TFin, tiempo;

    static boolean basta=true;
    public static void main(String[] args) {




        if (basta==true){


            Selection formulario1=new Selection();
            formulario1.setBounds(800,500,700,270);
            formulario1.setVisible(true);
            formulario1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        }





    }
    public Selection() {
        setLayout(null);
        label1=new JLabel("Numero:");
        label1.setBounds(10,10,420,30);
        add(label1);
        textfield1=new JTextField();
        textfield1.setBounds(120,10,150,20);
        add(textfield1);
        text = new JTextPane();
        text.setBounds(120,30,300,20);
        text.setEditable(false);
        text.setBackground(null);
        add(text);

        text1 = new JTextPane();
        text1.setBounds(120,50,300,20);
        text1.setEditable(false);
        text1.setBackground(null);
        add(text1);


        temp = new JTextPane();
        temp.setBounds(120,70,300,20);
        temp.setEditable(false);
        temp.setBackground(null);
        add(temp);

        boton1=new JButton("Agregar");
        boton1.setBounds(10,200,100,30);
        add(boton1);
        boton1.addActionListener(this);
        boton2=new JButton("Selection");
        boton2.setBounds(150,200,100,30);
        add(boton2);
        boton2.addActionListener(this);
        boton3=new JButton("Insertion");
        boton3.setBounds(290,200,100,30);
        add(boton3);
        boton3.addActionListener(this);
        boton4=new JButton("Shell");
        boton4.setBounds(450,200,100,30);
        add(boton4);
        boton4.addActionListener(this);
        boton5=new JButton("Merge");
        boton5.setBounds(600,200,100,30);
        add(boton5);
        boton5.addActionListener(this);
    }
    public static void seleccion(int A[]) {

        int i, j, menor, pos, tmp;
        for (i = 0; i < A.length - 1; i++) { // tomamos como menor el primero
            menor = A[i]; // de los elementos que quedan por ordenar
            pos = i; // y guardamos su posici�n
            for (j = i + 1; j < A.length; j++){ // buscamos en el resto
                if (A[j] < menor) { // del array alg�n elemento
                    menor = A[j]; // menor que el actual
                    pos = j;
                }
            }
            if (pos != i){ // si hay alguno menor se intercambia
                tmp = A[i];
                A[i] = A[pos];
                A[pos] = tmp;
            }
            System.out.println(A[pos]);
        }


    }
    public static void insercion(int[] a) {

        int n = a.length;
        for (int i = 1; i <= n - 1; i++) {
            int x = a[i];
            int j = i - 1;
            while (j >= 0 && x < a[j]) {
                a[j + 1] = a[j];
                j = j - 1;
            }
            a[j + 1] = x;
        }
    }
    public static void shell(int A[]){

        int salto, aux, i;
        boolean cambios;
        for(salto=A.length/2; salto!=0; salto/=2){
            cambios=true;
            while(cambios){ // Mientras se intercambie alg�n elemento
                cambios=false;
                for(i=salto; i< A.length; i++) // se da una pasada
                    if(A[i-salto]>A[i]){ // y si est�n desordenados
                        aux=A[i]; // se reordenan
                        A[i]=A[i-salto];
                        A[i-salto]=aux;
                        cambios=true; // y se marca como cambio.
                    }
            }
        }
    }
    public static void mergeSort(int[] a, int n) {

        if (n < 2) {
            return;
        }
        int mid = n / 2;
        int[] l = new int[mid];
        int[] r = new int[n - mid];

        for (int i = 0; i < mid; i++) {
            l[i] = a[i];
        }
        for (int i = mid; i < n; i++) {
            r[i - mid] = a[i];
        }
        mergeSort(l, mid);
        mergeSort(r, n - mid);

        merge(a, l, r, mid, n - mid);
    }
    public static void merge(
            int[] a, int[] l, int[] r, int left, int right) {

        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (l[i] <= r[j]) {
                a[k++] = l[i++];
            }
            else {
                a[k++] = r[j++];
            }
        }
        while (i < left) {
            a[k++] = l[i++];
        }
        while (j < right) {
            a[k++] = r[j++];
        }
    }
    public void actionPerformed(ActionEvent e) {
        String hol="";
        String orden="";
        String inser="";
        String she="";
        String merg="";
        if (e.getSource()==boton1) {

            String cad=textfield1.getText();
            al.add(Integer.parseInt(cad));
            for (int i=0;i<al.size();i++){
                hol+=al.get(i).toString()+"  ";

                text.setText(hol);
            }


        }
        if (e.getSource()==boton2){
            TInicio = System.currentTimeMillis();
            int []A= new int[al.size()];
            for (int i=0;i<al.size();i++){
                A[i]=al.get(i);
            }
            seleccion(A);
            for (int i=0;i<al.size();i++){
                orden+=A[i]+"  ";

                text1.setText(orden);
            }
            TFin = System.currentTimeMillis();
            tiempo = TFin - TInicio; //Calculamos los milisegundos de diferencia
            temp.setText("Tiempo en milisegundos: " + tiempo); //Tomamos la hora en que finaliz� el algoritmo y la almacenamos en la variable T

            basta=false;
        }
        if (e.getSource()==boton3) {
            TInicio = System.currentTimeMillis();
            int []A= new int[al.size()];
            for (int i=0;i<al.size();i++){
                A[i]=al.get(i);
            }
            insercion(A);
            for (int i=0;i<al.size();i++){
                inser+=A[i]+"  ";

                text1.setText(inser);
            }
            TFin = System.currentTimeMillis(); //Tomamos la hora en que finaliz� el algoritmo y la almacenamos en la variable T
            tiempo = TFin - TInicio; //Calculamos los milisegundos de diferencia
            temp.setText("Tiempo en milisegundos: " + tiempo);

            basta=false;

        }
        if (e.getSource()==boton4) {
            TInicio = System.currentTimeMillis();
            int []A= new int[al.size()];
            for (int i=0;i<al.size();i++){
                A[i]=al.get(i);
            }
            shell(A);
            for (int i=0;i<al.size();i++){
                she+=A[i]+"  ";

                text1.setText(she);
            }
            TFin = System.currentTimeMillis(); //Tomamos la hora en que finaliz� el algoritmo y la almacenamos en la variable T
            tiempo = TFin - TInicio; //Calculamos los milisegundos de diferencia
            temp.setText("Tiempo en milisegundos: " + tiempo);

            basta=false;

        }
        if (e.getSource()==boton5) {
            TInicio = System.currentTimeMillis();
            int []A= new int[al.size()];
            for (int i=0;i<al.size();i++){
                A[i]=al.get(i);
            }
            mergeSort(A,A.length);
            for (int i=0;i<al.size();i++){
                merg+=A[i]+"  ";

                text1.setText(merg);
            }
            TFin = System.currentTimeMillis(); //Tomamos la hora en que finaliz� el algoritmo y la almacenamos en la variable T
            tiempo = TFin - TInicio; //Calculamos los milisegundos de diferencia
            temp.setText("Tiempo en milisegundos: " + tiempo);

            basta=false;

        }
    }
}
