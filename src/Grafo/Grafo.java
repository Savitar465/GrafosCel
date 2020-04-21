package Grafo;

public interface Grafo { 
	public void insertaNodo(int n);
	/** Inserta un v�rtice en el grafo siempre que no se supere el n�mero m�ximo de nodos permitidos **/ 
	public void eliminarNodo(int v); 
	/** Elimina un v�rtice del grafo **/ 
	public void insertaArista(int i, int j, int peso); 
	/** Inserta una arista entre los v�rtices i y j **/ 
	public void eliminarArista(int i, int j); 
	/** Elimina la arista entre los v�rtices i y j **/ 
	public boolean esVacio(Grafo g); 
	/** Devuelve true si el grafo no contiene ning�n v�rtice **/ 
	public boolean existeArista(int i, int j); 
	/** Devuelve true si existe una arista que una los v�rtices i y j. **/
	public int gradoIn(int i) ; 
	/** Devuelve el grado de entrada del v�rtice i **/ 
	public int gradoOut(int i); 
	/** Devuelve el grado de salida del v�rtice i **/ 
	public int incidencia (int i);
	/** Devuelve la incidencia del v�rtice i **/ 
	public int tamano();
	/** Devuelve el tama�o (n�mero de aristas) del grafo **/
	public boolean isDirigido() ; 
	/** Devuelve true si el grafo g es dirigido **/ 
	public void setMaxNodos(int maxNodos); 
	/** Asigna el n�mero m�ximo de nodos o v�rtices permitidos en el grafo**/ 
	public void setDirigido(boolean dirigido); 
	/** Determina si es un grafo dirigido o no dirigido **/ 
}
