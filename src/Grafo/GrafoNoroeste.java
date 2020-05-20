package Grafo;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.*;

@SuppressWarnings("serial")
public class GrafoNoroeste extends JPanel implements Grafo, MouseListener {

    private JButton btnMatriz, camino, john;
    private JTextField[][]matrix;
    private boolean dirigido; // Indica si es dirigido o no.
    private int maxNodos; // Tamaño máximo de la tabla.
    private int numNodos; // Número de vértices del grafo.
    private int  matrizAdy [][]; // Matriz de adyacencias del grafo.
    private int opcion;

    private int  matrizCostos [][];
    private int  matrizSolu [][];
    private int fi; // Tamaño máximo de la tabla.
    private int co; // Tamaño máximo de la tabla.

    private Vector<Nodo> nodos;
    private Vector<Arista> aristas;
    private Point p1, p2;

    private int inicio;

    private int fina;
    private int c;
    private int f=0;
    public GrafoNoroeste (boolean d) {
        maxNodos = numNodos = c = 0;

        dirigido = d;
        ejecutar();
    }
    public GrafoNoroeste (JTextField [][]matrix,int n, int opcion) {
//        dirigido = d;
        maxNodos = n;
        numNodos = 0;
        this.opcion = opcion;
        this.matrix =matrix;
        matrizAdy = new int[n][n];
        ejecutar();
    }
    public GrafoNoroeste (JTextField [][]matrix, int f, int c, int opcion,int[][]matrizSolu) {
        this.fi = f;
        this.co = c;
        this.opcion = opcion;
        this.matrix =matrix;
        this.matrizSolu=matrizSolu;
        matrizCostos = new int[f][c];
        ejecutar();

    }

    private void ejecutar() {
        setLayout(new BorderLayout());
        nodos = new Vector<Nodo>();
        aristas = new Vector<Arista>();


        addMouseListener(this);


    }

    @Override
    public void insertaNodo(int n) {
        for (int i=0; i < numNodos + n; i++) {
            for (int j = numNodos; j < numNodos + n; j++)
                matrizAdy [i] [j] = matrizAdy [j] [i] = 0;
        }
        numNodos = numNodos + n;
    }
    @Override
    public void eliminarNodo(int v) {
        // TODO Auto-generated method stub

    }
    @Override
    public void insertaArista(int i, int j, int peso) {
        switch (opcion) {
            case 0:
                matrizAdy [i] [j] = peso;
                if (!dirigido)
                    matrizAdy [j] [i] = matrizAdy [i] [j] = peso;
                break;
            case 1:
                matrizCostos [i] [j] = peso;
                break;

            default:
                break;
        }

    }
    //    public void insertarMatrizOriginal(int i,int j){
//        switch (opcion) {
//            case 0:
//                matrizAdy [i] [j] = peso;
//                if (!dirigido)
//                    matrizAdy [j] [i] = matrizAdy [i] [j] = peso;
//                break;
//            case 1:
//                matrizCostos [i] [j] = peso;
//                break;
//
//            default:
//                break;
//    }
    @Override
    public void eliminarArista(int i, int j) {
			/*matrizAdy [i] [j] = false;
		if (!dirigido)
			matrizAdy [j] [i] = false;*/

    }
    @Override
    public boolean esVacio(Grafo g) {
        // TODO Auto-generated method stub
        return false;
    }
    @Override
    public boolean existeArista(int i, int j) {
        // TODO Auto-generated method stub
        return false;
    }
    @Override
    public int gradoIn(int j) {
		/*int gIn = 0;
		for (int i = 0; i < numNodos; i++) //recorrido por filas
			if (matrizAdy [i] [j]) gIn++; //manteniendo la posición de la columna en [j] */
        return 0;
    }
    @Override
    public int gradoOut(int i) {
		/*int gOut = 0;
		for (int j= 0; j < numNodos; j++)
			if (matrizAdy [i][j]) gOut++; // manteniendo la posición de la fila en [i] */
        return 0;
    }
    @Override
    public int incidencia(int i) {
        if (!dirigido)
            return gradoIn (i);
        else
            return gradoIn (i) + gradoOut (i);
    }
    @Override
    public int tamano() {
		/*int tm = 0;
		for (int i = 0; i < numNodos; i++)
			for (int j=0; j < numNodos; j++)
				if (matrizAdy [i] [j]) tm++;
		if (dirigido)
			return tm;
		else */
        //return tm/2;
        return 0;
    }
    public boolean isDirigido() {
        boolean dir = true;
        for (int i = 0; i < numNodos; i++)
            for (int j = 0; j < numNodos; j++)
                if (matrizAdy [i] [j] != matrizAdy [j] [i])
                    dir = false;
        return dir;
    }
    public void setMaxNodos(int maxNodos) {this.maxNodos = maxNodos;}
    public void setDirigido(boolean dirigido) {this.dirigido = dirigido;}
    public int getMaxNodos() {return maxNodos;}

    @Override
    protected void paintComponent(Graphics g) {
        // TODO Auto-generated method stub
        super.paintComponent(g);
        for(Nodo i : nodos) {
            i.paint(g);
        }
        for(Arista i : aristas) {
            i.paint(g);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getButton() == MouseEvent.BUTTON1) {

            switch (opcion) {
                case 0:

                    if(nodos.size() >= maxNodos) {
                        JOptionPane.showMessageDialog(null, "Error, se supera el número de nodos máximo",
                                "Error", JOptionPane.ERROR_MESSAGE);
                    } else {
//                        String nombre = JOptionPane.showInputDialog("Introduce nombre para el Nodo");

//                            insertaNodo(1);
                            nodos.add(new Nodo(e.getX(), e.getY(), matrix[0][c+1].getText(), c, Color.ORANGE));
                            repaint();
                            c++;

                    }

                    break;
                case 1:
                    if(nodos.size() >= fi+co){
                        JOptionPane.showMessageDialog(null, "Ahi ta la magia",
                                "Error", JOptionPane.INFORMATION_MESSAGE);

                        for (int i = 0; i < fi; i++) {
                            for (int j = 0; j < co; j++) {
                                Arista a = new Arista(nodos.get(i).getX(), nodos.get(i).getY(), nodos.get(j+fi).getX(), nodos.get(j+fi).getY(), matrizSolu[i][j], inicio, fina);
                                aristas.add(a);
                                repaint();
                            }
                        }
                        for (Arista j: aristas){
                            if (j.getPeso()!=0){
                                j.setColorflecha(Color.GREEN);

                            }

                        }
                    }
                    else {
                        if(nodos.size() >= fi) {

                            //	insertaNodo(1);
                            nodos.add(new Nodo(e.getX(), e.getY(), matrix[0][c-2].getText(), c, Color.ORANGE));
                            repaint();
                            c++;
                        }else{
                            nodos.add(new Nodo(e.getX(), e.getY(), matrix[c+1][0].getText(), c, Color.ORANGE));
                            repaint();
                            c++;
                        }
                    }


                    break;
            }

        }//event node's ends

        if(e.getButton() == MouseEvent.BUTTON3) {
            switch (opcion) {
                case 0:
                    for(Nodo i : nodos) {
                        int pi=i.getPosition();

                        if(new Rectangle(i.getX() - Nodo.getD()/2, i.getY() - Nodo.getD()/2,
                                Nodo.getD(), Nodo.getD()).contains(e.getPoint())) {
                            if(p1 == null) {
                                p1 = new Point(i.getX(), i.getY());
                                //inicio = i.getNombre();
                                if (new Rectangle(i.getX() - Nodo.getD()/2, i.getY() - Nodo.getD()/2,
                                        Nodo.getD(), Nodo.getD()).contains(e.getPoint())){
                                    inicio = i.getPosition();
                                    System.out.println(inicio);
                                }

                            } else {

                                p2 = new Point(i.getX(), i.getY());
                                int peso = Integer.parseInt(JOptionPane.showInputDialog("Introduce valor para el Arista"));
                                if (new Rectangle(i.getX() - Nodo.getD()/2, i.getY() - Nodo.getD()/2,
                                        Nodo.getD(), Nodo.getD()).contains(e.getPoint())){
                                    fina = i.getPosition();
                                    System.out.println(fina);
                                }
                                int si= i.getPosition();
                                Arista a = new Arista(p1.x, p1.y, p2.x, p2.y, peso,inicio,fina);
                                aristas.add(a);
                                insertaArista(inicio, i.getPosition(), a.getPeso());
                                repaint();
                                p1 = null;
                                p2 = null;
                            }
                        }
                    }

                    break;
                case 1:
                    int pi=0, si=0;

                    for(Nodo i : nodos) {
                        //System.out.println("indice "+i.getPosition());
                        if(new Rectangle(i.getX() - Nodo.getD()/2, i.getY() - Nodo.getD()/2,
                                Nodo.getD(), Nodo.getD()).contains(e.getPoint())) {
                            System.out.println("Primer "+i.getNombre());
                            if(p1 == null ) {
                                p1 = new Point(i.getX(), i.getY());
                                inicio = i.getPosition();
                                pi=i.getPosition();
                                if(fi-1< pi )
                                {	JOptionPane.showMessageDialog(null, "Un destino no puede ser origen",
                                        "Error", JOptionPane.ERROR_MESSAGE);
                                    p1 = null; break;
                                }
                            } else {
                                p2 = new Point(i.getX(), i.getY());
                                si=i.getPosition();
                                if(si< fi )
                                {	JOptionPane.showMessageDialog(null, "Un origen no puede ser detino",
                                        "Error", JOptionPane.ERROR_MESSAGE);
                                    p1 = null; p2=null; break;
                                }
                                int peso = Integer.parseInt(JOptionPane.showInputDialog("Introduce valor para el Arista"));
                                Arista a = new Arista(p1.x, p1.y, p2.x, p2.y, peso,pi,si);
                                aristas.add(a);
                                System.out.println("Segundo indice "+i.getNombre());
                                insertaArista(inicio, i.getPosition()-fi, a.getPeso());
                                repaint();
                                p1 = null;
                                p2 = null;
                            }
                        }
                    }
                    break;
            }
        }//event aristas's ends
    }
    private boolean existeOtroIgual(String nombre) {
        boolean flag = false;
        for(Nodo i : nodos) {
            if((nombre.equals(i.getNombre()))){
                flag = true;
            }

        }
        return flag;
    }


    public String imprimirMatrizAdyString() {
        String m = "";
        for(int i = 0;i < matrizAdy.length; i++) {
            m = m.concat("\n");
            for(int j = 0; j < matrizAdy[0].length; j++) {
                m = m.concat(String.valueOf(matrizAdy[i][j])).concat("    ");
            }
        }
        return m;
    }
    public String imprimirMatrizAdyString(int[][] y) {
        String m = "";
        for(int i = 0;i < y.length; i++) {
            m = m.concat("\n");
            for(int j = 0; j < y[0].length; j++) {
                m = m.concat(String.valueOf(y[i][j])).concat("    ");
            }
        }
        return m;
    }

    @Override
    public void mousePressed(MouseEvent e) {}
    @Override
    public void mouseReleased(MouseEvent e) {}
    @Override
    public void mouseEntered(MouseEvent e) {}
    @Override
    public void mouseExited(MouseEvent e) {}

}