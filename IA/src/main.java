
public class main {

	public static void main(String[] args) {
	no capacidade = new no(4,3,null);
	no resposta = new no(1,3,null);
	buscas teste = new buscas();
teste.bfs(capacidade, resposta);
teste.imprimirPilha();
teste.descobrirPai(resposta);
	}

}
