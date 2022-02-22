import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class buscas {
ArrayList<no> stringP = new ArrayList();
LinkedList<no> r = new LinkedList<no>();
no inicio = new no(0,0,null);


public int bfs(no capacidade, no resposta) {
	r.add(inicio);
	stringP.add(inicio);
	no base;
	while(!r.isEmpty()) {
		base = r.peek();
		// caso resposta
		if(base.primeiro == resposta.primeiro && base.segundo == resposta.segundo) {
			return 0;
			
		}
	
		// encher 1 full
		if(base.primeiro < capacidade.primeiro) {
			no enter = new no(capacidade.primeiro,base.segundo,base);
			r.add(enter);
			stringP.add(enter);
			if(capacidade.primeiro == resposta.primeiro && base.segundo == resposta.segundo) {
				return 0;
				
			}
			
		}
		
		// encher 2 full
		if(base.segundo < capacidade.segundo) {
			no enter = new no(base.primeiro,capacidade.segundo,base);
			r.add(enter);
			stringP.add(enter);
			if(base.primeiro== resposta.primeiro && capacidade.segundo == resposta.segundo) {
				return 0;
				
			}
			
		}
		// jogar fora agua do 1
		if(base.primeiro > 0) {
			no enter = new no(0,base.segundo,base);
			r.add(enter);
			stringP.add(enter);
			if(0 == resposta.primeiro && base.segundo == resposta.segundo) {
				return 0;
				
			}
		}
		// jogar fora agua do 2 
		if(base.segundo > 0) {
			no enter = new no(base.primeiro,0,base);
			r.add(enter);
			stringP.add(enter);
			if(base.primeiro == resposta.primeiro && 0 == resposta.segundo) {
				return 0;
				
			}
		}
		// se o primeiro ta cheio e eu consigo jogar do primeiro para o segundo deixnado o restante que nao deu no primeiro
		if(base.primeiro > 0 && (base.primeiro + base.segundo) >= capacidade.segundo) {
			no enter = new no((base.primeiro-(capacidade.segundo-base.segundo)),capacidade.segundo,base);
			r.add(enter);
			stringP.add(enter);
			if((base.primeiro-(capacidade.segundo-base.segundo)) == resposta.primeiro && capacidade.segundo == resposta.segundo) {
				return 0;
				
			}
		}
		// se o segundo ta cheio e eu consigo jogar do segundo para o primeiro deixando restante que nao deu no segundo
		if(base.segundo > 0 && (base.primeiro + base.segundo) >= capacidade.primeiro) {
			no enter = new no(capacidade.primeiro,(base.segundo-(capacidade.primeiro-base.primeiro)),base);
			r.add(enter);
			stringP.add(enter);
			if(capacidade.primeiro == resposta.primeiro && (base.segundo-(capacidade.primeiro-base.primeiro)) == resposta.segundo) {
				return 0;
				
			}
			
		}
		//primeiro cheio e eu consigo jogar tudo do primeiro para o segundo
		if(base.primeiro >0 && (base.primeiro + base.segundo) <= capacidade.segundo) {
			no enter = new no(0,(base.primeiro + base.segundo),base);
			r.add(enter);
			stringP.add(enter);
			if(0 == resposta.primeiro && (base.primeiro + base.segundo) == resposta.segundo) {
				return 0;
				
			}
		}
		//segundo cheio e eu consigo jogar tudo do segundo para o primeiro
		if(base.segundo >0 && (base.primeiro + base.segundo) <= capacidade.primeiro) {
			no enter = new no((base.primeiro + base.segundo),0,base);
			r.add(enter);
			stringP.add(enter);
			if((base.primeiro + base.segundo) == resposta.primeiro && 0 == resposta.segundo) {
				return 0;
				
			}
		}
		r.remove();
		
	}
return 0;
}












public void descobrirPai(no x) {
	for(int i = 0;i< stringP.size();i++) {
		if(stringP.get(i).primeiro == x.primeiro && stringP.get(i).segundo == x.segundo) {
			System.out.println("\npai : " + "(" + stringP.get(i).pai.primeiro + "," + stringP.get(i).pai.segundo + ")");
			
		}
		
		
	}
	
}


public void imprimirPilha() {
	for(no user : stringP) {
		  System.out.print( "(" + (user.primeiro) +"," + (user.segundo) + ")");
		   //e o que mais desejar
		}
}
}