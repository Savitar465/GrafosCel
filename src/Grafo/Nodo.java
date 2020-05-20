package Grafo;

import java.awt.Color;
import java.awt.Graphics;

public class Nodo {
	private int x, y;
	public static final int D = 50;
	private String nombre;
	private int position;
	private Color color;
	private int n1=0,n2=0;
	public Nodo(int x, int y, String nombre, int position,Color color) {
		super();
		this.x = x;
		this.y = y;
		this.nombre = nombre;
		this.position = position;
		this.color = color;
	}

	public int getN1() { return n1; }
	public void setN1(int n1) { this.n1 = n1; }
	public int getN2() { return n2; }
	public void setN2(int n2) { this.n2 = n2; }

	public void setColor(Color color) { this.color = color; }
	public int getX() {return x;}
	public void setX(int x) {this.x = x;}
	public int getY() {return y;}
	public void setY(int y) {this.y = y;}
	public static int getD() {return D;}
	public String getNombre() {return nombre;}
	public void setNombre(String nombre) {this.nombre = nombre;}
	public int getPosition() {return position;}
	public void setPosition(int position) {this.position = position;}



	public void paint(Graphics g) {

		g.setColor(color);
		g.fillOval(this.x - (D/2),this.y- (D/2), D, D);
		g.setColor(Color.black);
		g.drawString(String.valueOf(nombre), x, y);
		g.drawString(n1 + "|" + n2, x, y-30);


	}	
}
