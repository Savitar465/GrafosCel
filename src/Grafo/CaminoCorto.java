package Grafo;

import javax.swing.JOptionPane;

public class CaminoCorto {

	private int matriz[][];
	private boolean f;
	
	public  CaminoCorto ( int matrizAdy [][],boolean flag) {
		matriz = matrizAdy;
		f=flag;
	}
	
	
	public void camino () {
		int col[][]; 
		int fil [][];
		int t [][]=matriz;
		//int t [][]= new int [3][3];
//		t[0][0] = 20;
//		t[0][1] = 10;
//		t[0][2] = 30;
//		t[1][0] = 30;
//		t[1][1] = 20;
//		t[1][2] = 10;
//		t[2][0] = 30;
//		t[2][1] = 30;
//		t[2][2] = 20;
		col	=columnas(t);
		t=resta(t,col);
		fil=filas(t);
		t=resta(t,fil);
		mostrar (t);
		escogerceros(t);
		
	}
	
	
	public void mostrar(int matrizAdy[][]) {
		int c =matrizAdy.length;
		String[] m= new String[c];
		for(int i = 0;i < c; i++) {
			String v ="";
			for(int j = 0; j < c; j++) {	
				v+= matrizAdy[i][j]+"   ";
			}
			m[i]=v;
		}
		JOptionPane.showMessageDialog (null, m);
   }
	
	private int [][] columnas (int matriz [][]) {
		int x[][] = new int[ matriz.length][ matriz.length];
		int r [] = new int[ matriz.length];
		int xx =0;
		for (int i = 0; i < matriz.length; i++) 
		{
			xx= matriz[i][i];
			for (int j = 0;j < matriz.length; j++) 
			{
				
				if(f) //ver min
						xx = Math.min(xx,  matriz[j][i]);
				else
					    xx = Math.max(xx,  matriz[j][i]);
			}
			r[i]=xx;
		}
		for (int i = 0; i < matriz.length; i++) 
		{
			for (int j = 0;j < matriz.length; j++) 
			{
				x[j][i]=r[i];
			}
		}
		return x;
	}
	
	private int [][] filas (int matriz [][])  {
		int x[][] = new int[ matriz.length][ matriz.length];
		int r [] = new int[ matriz.length];
		int xx =0;
		for (int i = 0; i < matriz.length; i++) 
		{
			 xx= matriz[i][i];
			for (int j = 0;j < matriz.length; j++) 
			{
				
				if(f) //ver min
						xx = Math.min(xx,  matriz[i][j]);
				
				else
					    xx = Math.max(xx,  matriz[i][j]);
			}
			r[i]=xx;
		}
		for (int i = 0; i < matriz.length; i++) 
		{
			for (int j = 0;j < matriz.length; j++) 
			{
				x[i][j]=r[i];
			}
		}
		
		return x;
	}
	
	private int [][] resta (int a[][], int b [][]) {
		int[][] resultado = new int[a.length][b[0].length];
		for (int x=0; x < resultado.length; x++) {
			  for (int y=0; y < resultado[x].length; y++) {
			    resultado [x][y] = a[x][y] - b[x][y];
			  }
			}
		return resultado;
	}
	
	private void escogerceros(int lle[][]) {
		int [][] x=lle;
		int [][] rr = new int [x.length][x.length];
		boolean todavia=false;
		int i=0;
		if (factible(x,x.length))
		{
			while (todavia)  {
			for (i=0; i < x.length; i++) {
				  for (int j=0; j < x.length; j++) {
				     if (x[i][j] ==0)
				     {
				    	 for (int ii=0; ii < x.length; ii++) {
							  x[ii][j] =110;
							  x[j][ii] =110;
		    		 }
				     }
				     if (factible(x,x.length-j))
				     {
				    		 j=x.length;
				    		 rr[i][j] =1;
				     }		 
				     else
				     {
				    	 x=lle;
				         i=x.length+10;
				         for (int hi=0; hi < x.length; hi++) {
							  for (int hj=0; hj < x.length; hj++) {
							     if (x[hi][hj] ==0)
							    	 x[hi][hj] =110;
							      	todavia=false;
							}}
				     
				    }
			}
		}
			if(i==x.length)	
				todavia= true;
			}	
		mostrar (rr);	
		}
		else
			JOptionPane.showMessageDialog(null, "No factible");
		
		
		
		
		
	}
	private boolean factible(int x[][],int num) {
		int kon=0;
			for (int i=0; i < x.length; i++) {
				  for (int j=0; j < x.length; j++) {
					  if (x[i][j] ==0)
						  kon++;
		     } }
	
		if (num <= kon)
			return true;
		else
			return false;
		
	}

	public static void main(String[] args) {
		int[][] matriz = {
				{80,  10, 30, 120, 20},
				{80,  20, 30, 120,40},
				{60, 65,  30,  80, 22},
				{60, 10,  1,  80, 12},
				{ 6, 90,  8,   4, 5}};
		CaminoCorto cc= new CaminoCorto(matriz, true);
		cc.camino();
	}
}









