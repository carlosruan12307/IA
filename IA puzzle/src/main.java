import java.util.ArrayList;
import java.util.LinkedList;

public class main {

	public static void main(String[] args) {
		   LinkedList<Integer> valoresM = new LinkedList<Integer>() {
			   {
				   add(1); add(-1); add(3);
				   add(8); add(2); add(4);
				   add(7); add(6); add(5);
			   }  
		   };
		  
		int linhas = 5;
		int colunas = 5;
		 int[][] matrizResultado = new int[linhas+1][colunas+1];
		 
			for(var i = 0;i <  linhas+1;i++) {
				for(var j = 0; j < colunas+1;j++) {
					matrizResultado[i][j] = 0;
					
					
				System.out.println(i + " " + j + " " + matrizResultado[i][j]);
		
				}
				
			}
		matrizResultado[1][1] = 1;
		matrizResultado[1][2] = 3;
		matrizResultado[1][3] = -1;
		matrizResultado[2][1] = 8;
		matrizResultado[2][2] = 2;
		matrizResultado[2][3] = 4;
		matrizResultado[3][1] = 7;
		matrizResultado[3][2] = 6;
		matrizResultado[3][3] = 5;
		
		
		matriz matriz = new matriz(linhas,colunas,matrizResultado);
		matriz.IniciarMatriz();
		System.out.println("------------------------");
		matriz.AlimentarMatriz(valoresM);
System.out.println("---------------------------------------");
matriz.imprimirMatriz();

System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
matriz.bfs();
//matriz.imprimirPilha();
matriz.imprimirR();
	}

	
	


		
}
