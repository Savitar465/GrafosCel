package Grafo;

public class algo {



        public static void main (String args[]){
            /* Sunpagamos la Matriz de entrada sin procesar*/
            int [][] initialMatriz = {{2,1,8},{3,3,5},{6,8,9}};
            /* Supongamos la Matriz procesada con los 0*/

            int [][] matriz = {{0,0,3},{1,2,0},{0,3,0}};

            System.out.println("Primera Matriz");
            printMatriz(initialMatriz);
            System.out.println("Matriz Procesada");
            printMatriz(matriz);
            int [][] resultado = new int[matriz.length][matriz.length];

            for (int x=0; x < resultado.length; x++) {
                for (int y=0; y < resultado[x].length; y++) {
                    resultado[x][y] = 100*matriz [x][y];
                }
            }
            Sudoku a=new Sudoku(resultado);
            int[][] matrizasd = a.solve();
            System.out.println("Nueva Matriz");
            printMatriz(matrizasd);

            System.out.println("Result Matriz");
            printMatriz(multiplicarMatrices(initialMatriz,matrizasd));
            System.out.println(SumaAsignado(initialMatriz,matrizasd));
//            System.out.println("Costo"+calcularCostoMatriz(multiplicarMatrices(initialMatriz,matrizasd)));
        }

	/*Este metodo selecciona los valores de la matriz procesada y la vuelve en binario*/
//        public static int[][] chooseValues(int [][] mat){
//            int matriz[][] = new int[mat.length][mat[0].length];
//            for (int x=0; x < mat.length; x++) {
//                for (int y=0; y < mat[x].length; y++) {
//                    if(mat[x][y]==0) {
//                        matriz[x][y]=1;
//                    }
//                    else {
//                        matriz[x][y]=0;
//                    }
//
//                }
//            }
//            return matriz;
//        }
//	/Este metodo multiplica la matriz binaria con la matriz original/
    public static int SumaAsignado(int[][] A, int[][] B){
        int suma=0;
        for (int i = 0; i < B.length; i++) {
            for (int j = 0; j < B[0].length; j++) {
                if(B[i][j]==0) {
                    suma=suma+A[i][j];
                }else {

                }
            }
        }

        return suma;

    }
        public static int[][] multiplicarMatrices(int [][] originalMat, int [][] newMat){

            int resultMat[][] = new int[originalMat.length][originalMat[0].length];

            for (int x=0; x < originalMat.length; x++) {
                for (int y=0; y < originalMat[x].length; y++)
                    resultMat[x][y]=originalMat[x][y]*newMat[x][y];
            }

            return resultMat;
        }

//	/Este metodo calcula el costo sumando los valores correspondientes a las pocisiones en 0/
        public static int calcularCostoMatriz(int [][] newMat){
            int costo=0;
            for (int x=0; x < newMat.length; x++) {
                for (int y=0; y < newMat[x].length; y++)
                    costo=costo+newMat[x][y];
            }
            return costo;
        }

//	/Este metodo imprime matrices/
        public static void printMatriz(int [][] mat){
            for (int x=0; x < mat.length; x++) {
                for (int y=0; y < mat[x].length; y++)
                    System.out.print (mat[x][y]+ "\t");

                System.out.println();
            }
        }


}
