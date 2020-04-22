package Grafo;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class Jhonson extends JPanel{
    private Vector<Nodo> nodos;
    private Vector<Arista> aristas;
    JFrame ventJh = new JFrame("Jhonson");

    public Jhonson(Vector<Nodo> nodos, Vector<Arista> aristas) {
        this.nodos = nodos;
        this.aristas = aristas;
    }
    public void eject(){
        nodos.get(0).setColor(Color.green);
        modNod();


    }
    public void modNod(){
    for (int i=0;i<nodos.size();i++){
        for (int j=0;j<aristas.size();j++){
            if (nodos.get(i).getPosition()==aristas.get(j).getIni()){
                nodos.get(aristas.get(j).getFin()).setN1(aristas.get(j).getPeso()+nodos.get(aristas.get(j).getIni()).getN1());
            }

        }
    }
        nodos.lastElement().setN2(nodos.lastElement().getN1());
        for (int i=0;i<nodos.size();i++){
            for (int j=0;j<aristas.size();j++){

                nodos.get(aristas.get(j).getIni()).setN2(nodos.get(aristas.get(j).getFin()).getN2()-aristas.get(j).getPeso());
            }
        }
        for (Nodo i: nodos){
            if (i.getN1()==i.getN2()){
                i.setColor(Color.green);

            }
        }
        for (Arista j: aristas){
            if (nodos.firstElement().getPosition()== j.getIni() && nodos.get(j.getFin()).getN2()==nodos.get(j.getFin()).getN1()){
                j.setColorflecha(Color.ORANGE);

            }
            if (nodos.get(j.getFin()).getN2()==nodos.get(j.getFin()).getN1() && nodos.get(j.getIni()).getN2()==nodos.get(j.getIni()).getN1()){
                j.setColorflecha(Color.ORANGE);
            }
        }





    }





}
