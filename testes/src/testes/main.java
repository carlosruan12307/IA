package testes;

public class main {

	public static void main(String[] args) {
	no capacidade = new no(4,3,null,0);
	no resposta = new no(1,3,null,0);
	buscas teste = new buscas();
teste.dfs(new no(0,0,null,1),capacidade, resposta);
teste.imprimirPilha();
teste.descobrirPai(resposta);
	}

}
