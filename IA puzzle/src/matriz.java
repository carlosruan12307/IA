import java.util.LinkedList;

public class matriz {
	int linhas;
	int colunas;
	int[] vazio = new int[2];
	int matriz[][];
	int matrizResultado[][];
	int brilla;
	LinkedList<no> r = new LinkedList<no>();
	LinkedList<no> rt = new LinkedList<no>();
	LinkedList<no> teste = new LinkedList<no>();

	public matriz(int linhas, int colunas, int[][] matrizResultado) {
		super();
		this.linhas = linhas;
		this.colunas = colunas;
		this.matriz = new int[linhas+1][colunas+1];
		this.matrizResultado = matrizResultado;
	}
	public void imprimirR() {
		System.out.print("[");
		for(var k = 0;k < r.size();k++) {
			System.out.print("[");
		for(var i = 0;i < r.get(k).matriz.length ;i++) {
			System.out.print("(");
			for(var j = 0; j < colunas+1;j++) {
				
				
			System.out.print( r.get(k).matriz[i][j]);
	
			}
			System.out.print(")");
		}
		System.out.print("]");
		}
	
	}
	public void imprimirPilha() {
		System.out.print("[");
		for(var i = 0;i <  linhas+1;i++) {
			System.out.print("(");
			for(var j = 0; j < colunas+1;j++) {
				
				
			System.out.print( matriz[i][j]);
	
			}
			System.out.println(")");
		}
		System.out.print("[");
	}
	
	public void IniciarMatriz()  {
		for(var i = 0;i <  linhas+1;i++) {
			for(var j = 0; j < colunas+1;j++) {
				matriz[i][j] = 0;
				
				
			System.out.println(i + " " + j + " " + matriz[i][j]);
	
			}
			
		}
	}


	public void AlimentarMatriz(LinkedList<Integer> valoresM)  {
		for(var i = 1;i <  4;i++) {
			for(var j = 1; j < 4;j++) {
				if(valoresM.size() != 0) {
				matriz[i][j] = valoresM.peek();
				valoresM.remove();
				}
				if(matriz[i][j] == -1) {
					vazio[0] = i;
					vazio[1] = j;
				}
	
			}
			
		}
	

	for(int k = 0 ;k < vazio.length;k++) {
		System.out.println(vazio[k]);
		
	}
	no no = new no(matriz,vazio);
	r.add(no);
	teste.add(no);
}
	public void imprimirMatriz() {
		for(var i = 0;i <  linhas+1;i++) {
			for(var j = 0; j < colunas+1;j++) {
				
				
			System.out.println(i + " " + j + " " + matriz[i][j]);
	
			}
			
		}
	}
	public int bfs() {
		int bu[][];
		no matrizB;
		
		while(!r.isEmpty()) {
	   matrizB = r.peek();
	   brilla = 1;
		int[][] mx = cloneM(matrizB.matriz);
		int aux = mx[matrizB.vazio[0]][matrizB.vazio[1]];
		//vazio up
		mx[matrizB.vazio[0]][matrizB.vazio[1]] = mx[matrizB.vazio[0]-1][matrizB.vazio[1]];
		mx[matrizB.vazio[0]-1][matrizB.vazio[1]] = aux;
		
		
		int vaziox[] = {matrizB.vazio[0] - 1, matrizB.vazio[1]};
		
		if(mx[matrizB.vazio[0]][matrizB.vazio[1]] != 0) {
			no n = new no(mx,vaziox);
			r.add(n);
			if(validator("u",mx) == 1) {
				return 1;
			}
			mx = cloneM(matrizB.matriz);
			
		}else {
			mx = cloneM(matrizB.matriz);
		}
	
		
		//vazio down
	
		mx[matrizB.vazio[0]][matrizB.vazio[1]] = mx[matrizB.vazio[0]+1][matrizB.vazio[1]];
		mx[matrizB.vazio[0]+1][matrizB.vazio[1]] = aux;
		
		
		int vaziox1[] = {matrizB.vazio[0] + 1, matrizB.vazio[1]};
		if(mx[matrizB.vazio[0]][matrizB.vazio[1]] != 0 ) {
			no n = new no(mx,vaziox1);
			r.add(n);
			if(validator("d",mx) == 1) {
				return 1;
			};
			mx = cloneM(matrizB.matriz);
			
		}else {
			mx = cloneM(matrizB.matriz);
		}
	
		//vazio left
		
		mx[matrizB.vazio[0]][matrizB.vazio[1]] = mx[matrizB.vazio[0]][matrizB.vazio[1]-1];
		mx[matrizB.vazio[0]][matrizB.vazio[1]-1] = aux;
		
	
		int vaziox2[] = {matrizB.vazio[0], matrizB.vazio[1] - 1};
		if(mx[matrizB.vazio[0]][matrizB.vazio[1]] != 0 ) {
			no n = new no(mx,vaziox2);
			r.add(n);
			if(validator("d",mx) == 1) {
				return 1;
			};
			mx = cloneM(matrizB.matriz);
			
		}else {
			mx = cloneM(matrizB.matriz);
		}
		
		
		
		
		
		
		//vazio right
		
		mx[matrizB.vazio[0]][matrizB.vazio[1]] = mx[matrizB.vazio[0]][matrizB.vazio[1]+1];
		mx[matrizB.vazio[0]][matrizB.vazio[1]+1] = aux;
		
		
		int vaziox3[] = {matrizB.vazio[0], matrizB.vazio[1] + 1};
		
		if(mx[matrizB.vazio[0]][matrizB.vazio[1]] != 0 ) {
			no n = new no(mx,vaziox3);
			r.add(n);
			if(validator("d",mx) == 1) {
				return 1;
			};
			mx = cloneM(matrizB.matriz);
			
		}else {
			mx = cloneM(matrizB.matriz);
		}
		teste.add(r.peek());
		r.remove();
		}
		return 0;
	}	
	
	public int[][] cloneM(int[][] ma) {
		int[][] m = new int[linhas+1][colunas+1];
		for(var i = 0;i <  linhas+1;i++) {
			for(var j = 0; j < colunas+1;j++) {
				
				
			m[i][j] = ma[i][j];
	
			}
			
		}
		return m;
		
	}
	public int validator(String m,int[][] mx) {
		
		//possibilidade inexistente

			
			if(equal(mx,matrizResultado)) {
			return 1;
			}
		
		return 0;

	
	}
	
	
	
	
	
	
	
	
	public boolean equal(int[][] m , int[][] ma) {
		for(var i = 0;i <  linhas+1;i++) {
			for(var j = 0; j < colunas+1;j++) {
				
				
			if(m[i][j] != ma[i][j]) {
				return false;
			};
	
			}
			
		}
		return true;
	}
}
