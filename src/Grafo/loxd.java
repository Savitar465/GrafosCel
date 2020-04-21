package Grafo;

public class loxd {
	   public static void main(String args[]) {
		   
//		   int[][] matriz = {
//		            {8,  0, 3, 2, 0},
//		            {8,  0, 0, 0, 0},
//		            {6, 6,  1, 1, 0},
//		            {6, 6,  1, 0, 4},
//		            { 0, 9,  0, 0, 5}
//		            };
//
		   int [][] mao= {{2,1,8},{3,3,5},{6,8,9}};
		   int [][] matriz = {{0,0,3},{1,2,0},{0,3,0}};
		   int [][] resultado = new int[matriz.length][matriz.length];
		   
		   for (int x=0; x < resultado.length; x++) {
			   for (int y=0; y < resultado[x].length; y++) {
			     resultado[x][y] = 100*matriz [x][y];
			   }
			 }
	     Sudoku a=new Sudoku(resultado);
	     int[][] matrizasd = a.solve();
	     int[][] hola=multiplicarMatrices(mao,cambiar(matrizasd));
	     
	     for (int i = 0; i <hola.length; i++) {
	            for (int j = 0; j < hola.length; j++) {
	               System.out.print(hola[i][j]+" ");
	            } 
	            System.out.println();
	        }
	    }

	    public static int[][] cambiar(int matriz[][]){
	   		int [][]m;
			for (int x=0; x < matriz.length; x++) {
				for (int y=0; y < matriz[x].length; y++)
					if (matriz[x][y]==1){
						matriz[x][y]=0;
					}else
						matriz[x][y]=1;
			}
	   		return matriz;
		}
	public static int[][] multiplicarMatrices(int [][] originalMat, int [][] newMat){

		int resultMat[][] = new int[originalMat.length][originalMat[0].length];

		for (int x=0; x < originalMat.length; x++) {
			for (int y=0; y < originalMat[x].length; y++)
				resultMat[x][y]=originalMat[x][y]*newMat[x][y];
		}

		return resultMat;
	}
}
