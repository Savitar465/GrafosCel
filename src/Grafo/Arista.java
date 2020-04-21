package Grafo;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

public class Arista  {
	private int x0, y0, x1, y1;
	private int peso;
	private final static int tamFlecha = 7;
	private int ini,fin;
	private Color colorflecha;
	
	public Arista(int x0, int y0, int x1, int y1, int peso,int ini,int fin) {
		super();
		this.x0 = x0;
		this.y0 = y0;
		this.x1 = x1;
		this.y1 = y1;
		this.peso = peso;
		this.ini = ini;
		this.fin = fin;
	}//end class'constructor 
	
	//getters and setters

	public int getIni() { return ini; }
	public int getFin() { return fin; }
	public int getPeso() {return peso;}
	public void setColorflecha(Color colorflecha) { this.colorflecha = colorflecha; }
	public Color getColorflecha() { return colorflecha; }

	public int getX0() { return x0; }
	public int getY0() { return y0; }
	public int getX1() { return x1; }
	public int getY1() { return y1; }

	public void setPeso(int peso) {this.peso = peso;}

	public void paint(Graphics g) {
		if(x0==x1 && y0==y1) {
			g.setColor(Color.black);
			g.drawOval(x0-((Nodo.D)/2), y0-40-(Nodo.D/2), 40, 40);
			g.setColor(Color.black);
			g.drawString(String.valueOf(peso), (x0-(Nodo.D/2)+20),(y0-40-(Nodo.D/2)));
		} else {
			g.setColor(Color.black);
		//	g.drawPolygon(triangulo);
			g.setColor(colorflecha);
			//g.drawLine(x0, y0, x1, y1);
			if(y0>y1)
				drawArrow(g, x0, y0, x1, y1); 
			else
				drawArrow(g, x0, y0, x1, y1); 
			g.setColor(Color.black);
			g.drawString(String.valueOf(peso), ((x0+x1)/2),((y0+y1)/2));
			
		}//end if else 
	}//end class's methods 
	
	private void drawArrow(Graphics g1, int x1, int y1, int x2, int y2) { 
	       Graphics2D g = (Graphics2D) g1.create(); 
	       double dx = x2 - x1, dy = y2 - y1; 
	       double angle = Math.atan2(dy, dx); 
	       int len = (int) Math.sqrt(dx*dx + dy*dy); 
	       AffineTransform at = AffineTransform.getTranslateInstance(x1, y1); 
	       at.concatenate(AffineTransform.getRotateInstance(angle)); 
	       g.transform(at); 

	       // Draw horizontal arrow starting in (0, 0) 
	       g.drawLine(0, 0, len, 0); 
	       g.fillPolygon(new int[] {len, len-tamFlecha, len-tamFlecha, len}, 
		           new int[] {0, -tamFlecha, tamFlecha, 0}, 4);
	}//end methods class
	
}//class's end
