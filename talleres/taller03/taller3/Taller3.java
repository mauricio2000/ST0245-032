public class Taller3 {

	public static void torresDeHannoi(int n) {
		torresDeHannoiAux(n, 1, 2, 3);
	}

	/**
	*
	* El método torresDeHannoi es un auxiliar del proceso 
	* @param n numero de discos
	* @param origen la torre número uno donde se posicionan todos los discos inicialmente
	* @param destino la torre donde deben posicionarse todos los discos terminado el proceso
	* @param intermedio torre auxiliar para que el cambio de torres se haga efectivo
	* 
	* debe devolver la secuencia de pasos en consola de esta manera:
	* System.out.println("Disk "+ n + " from "+ origen + " to "+ destino);
	*
	* @see <a href="http://www.uterra.com/juegos/torre_hanoi.php"> Simulación del funcionamiento</a>
	* @see <a href="https://es.wikipedia.org/wiki/Torres_de_Han%C3%B3i"> Un poco de historia </a>
	*/	
	
	private static void torresDeHannoiAux(int n, int origen, int intermedio, int destino) {
		if(n==1){
		    System.out.println("Disk "+ n + " from "+ origen + " to "+ destino);
		  }    
		
		  else{
		      torresDeHannoiAux(n-1, origen, destino, intermedio);
		      System.out.println("Disk "+ n + " from "+ origen + " to "+ destino);
		      torresDeHannoiAux(n-1, intermedio , origen, destino);
		  }
	}
		
		


		
		
	/**
	*
	* El método permutation es un auxiliar del proceso 
	* @param str es la cadena a permutar
	*/
	public static void permutation(String str) {
		permutationAux("", str); 
	}
	
	/**
	*
	* El método permutationAux es el core del proceso, en el se busca conseguir
	* las posibles permutaciones que puede tener la cadena str 
	* @param str es la cadena a permutar
	* @param prefix cadena auxiliar donde se guarda la cadena de salida
	*
	* Las cadenas de salida tienes una longitud de lenght de la cadena s
	* Ej: para la cadena AB se tiene la salida: { ABC,ACB,BAC,BCA,CAB,CBA }
	* donde los caracteres no se repiten pero el orden tiene un papel importante.
	*
	*/
	private static void permutationAux(String p, String str) {
	    for(){
		if(0==str.length()){System.out.println(p);}
		else if(str.length()==1){
		  permutationAux(p+str, "");
		  }
		else {//if (str.length()==2){
		  permutationAux(p+str.charAt(1),str.substring(2)+str.charAt(0));
		  permutationAux(p+str.charAt(str.length()-1), str.substring(0,str.length()-1));
		  permutationAux(p+str.charAt(0), str.substring(1));
		  
		  }
}
	}
		
	
}
