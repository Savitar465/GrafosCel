package Grafo;

import java.util.Arrays;

public class lop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		int[][] matriz = {
                {80,  0, 30, 120, 0},
                {80,  0, 0, 120, 0},
                {60, 60,  1,  0, 0},
                {60, 60,  1,  80, 0},
                { 0, 90,  0,   0, 5}
                };
		
		int[][] matrizcau= new int [matriz.length][matriz.length] ;
		int menorColumna[] = new int[matriz[0].length];
		for(int k = 0; k < matriz[0].length; k++){menorColumna[k] = 100;}
		for(int i =0; i<matriz.length;i++) {
			for(int j=0;j<matriz.length;j++) {
				  if(matriz[i][j] < menorColumna[j]){ //Encontrar el menor
			            menorColumna[j] = matriz[i][j];
   
			            
			        }
			}
		}
		for(int ii=0;ii<matriz.length;ii++) {
			 System.out.println(menorColumna[ii]);
		}
		
		for(int i =0; i<matriz.length;i++) {
			int aux=0;
			for(int j=0;j<matriz.length;j++) {
				
				  if(matriz[i][j] == menorColumna[i] && aux==0  ){
					 
						  matrizcau[i][j]= 0;
				            aux=1; 	 
			            
			        }
				  else {
					  matrizcau[i][j]=1;
				  }
			}
		}	
		for(int i =0; i<matrizcau.length;i++) {
			for(int j=0;j<matrizcau.length;j++) {
				System.out.print(matrizcau[i][j]+" ");	 
			}
			System.out.println();
		}	
		
	}
	
	

}
