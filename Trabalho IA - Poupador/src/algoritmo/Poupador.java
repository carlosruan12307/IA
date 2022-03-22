package algoritmo;

import controle.Constantes;

public class Poupador extends ProgramaPoupador {

	public int acao() {
		int[] visao = sensor.getVisaoIdentificacao();
		int[] pesos = new int[24];
		int[] custos = new int[24];
		int custoL;
		int custoC;
		int custoT;
		//return (int) (Math.random() * 5);
		for(int i = 0;i < sensor.getVisaoIdentificacao().length;i++) {
			switch (visao[i]) {
			case 0:
				custoL = Linha(i) - 3;
				custoC = Coluna(i) - 3;
				custoT = (Math.abs(custoL) + Math.abs(custoC)) ;
				custos[i] = custoT;
				break;
			case 100,110:
				pesos[i] = -900;
			break;
			case 200,210,220,230:
				pesos[i] = -10000;
				break;
			case 5: // Pastilha do poder
			
				if(sensor.getNumeroDeMoedas() >= 5) {
					custoL = Linha(i) - 3;
					custoC = Coluna(i) - 3;
					custoT = (Math.abs(custoL) + Math.abs(custoC)) ;
					custos[i] = custoT * 100;
					pesos[i] += -800;
				}else {
					pesos[i] += -700;
				}
				break;
			case 4: // Moeda
				custoL = Linha(i) - 3;
				custoC = Coluna(i) - 3;
				custoT = (Math.abs(custoL) + Math.abs(custoC)) ;
				custos[i] = custoT * 1000;
				pesos[i] += 2600;
				break;
			case 3: // Banco
				if(sensor.getNumeroDeMoedas() > 0) {
					custoL = Linha(i) - 3;
					custoC = Coluna(i) - 3;
					custoT = (Math.abs(custoL) + Math.abs(custoC)) ;
					custos[i] = custoT;
					pesos[i] = 500 * sensor.getNumeroDeMoedas();
				}else {
					pesos[i] = -600;
				}
			
				break;
			case 1: // Parede
				pesos[i] += -600;
				break;
			case -1: // Fora do Ambiente
				pesos[i] += -600;
				break;
			case -2: // Sem visão
				pesos[i] += -200;
				
				break;
			}	
			
		}
		int maior = Integer.MIN_VALUE;
		int i = 0;
		for(int j = 0;j < pesos.length;j++) {
			if(pesos[j] > maior && pesos[j] > 0 && pesos[i] != 1) {
				maior = pesos[j];
				i = j;
			}
		}
		if(maior == Integer.MIN_VALUE) {
			return (int) (Math.random() * 5);
			
		}
		switch (i) {
		case 2,7:
			return 1;
		case 16,21:
			return 2;
		case 10,11:
			return 4;
		case 12,13:
			return 3;
		case 0,1,5,6:
			if(sensor.getVisaoIdentificacao()[7] != 1) {
				return 1;
			}else {
				return 4;
			}
		case 3,4,8,9:
			if(sensor.getVisaoIdentificacao()[7] != 1) {
				return 1;
			}else {
				return 3;
			}
		case 14,15,19,20:
			if(sensor.getVisaoIdentificacao()[16] != 1) {
				return 2;
			}else {
				return 4;
			}
		case 17,18,22,23:
			if(sensor.getVisaoIdentificacao()[16] != 1) {
				return 2;
			}else {
				return 3;
			}
		}
			return (int) (Math.random() * 5);
		
		}

		public int possivel(int i) {

			return -1;

		}
		public boolean worth(int custoP,int custoL) {
			if(custoL - custoP <= 0 ) { // correr
				return false;
			}
			return  true;
		}
		public int custoMP(int iM) {
			int custoP1 = Linha(iM) - 3;
			int custoP2 = Coluna(iM) - 3;
			int custoT = Math.abs(custoP1) + Math.abs(custoP2);
			return custoT;

		}
		public int custo(int iM, int iL) {
			int custoP1 = Linha(iM) - Linha(iL);
			int custoP2 = Coluna(iM) - Coluna(iL);
			int custoT = Math.abs(custoP1) + Math.abs(custoP2);
			return custoT;
		}
		public int verLadrao() {
			for(int i = 0;i < sensor.getVisaoIdentificacao().length;i++) {

				if(sensor.getVisaoIdentificacao()[i] == 200 || sensor.getVisaoIdentificacao()[i] == 210 || sensor.getVisaoIdentificacao()[i] == 220 || sensor.getVisaoIdentificacao()[i] == 230) {
					return i;
				}


			}
			return -1;
		}
		public int Linha(int i) {
			if (i >= 0 && i <= 4)
				return 1;
			if (i >= 5 && i <= 9)
				return 2;
			if (i >= 10 && i <= 13)
				return 3;
			if (i >= 14 && i <= 18)
				return 4;
			if (i >= 19 && i < 23)
				return 5;
			return 0;
		}

		public int Coluna(int i) {
			switch (i){
			case 0:
			case 5:
			case 10:
			case 14:
			case 19:
				return 1;
			case 1:
			case 6:
			case 11:
			case 15:
			case 20:
				return 2;
			case 2:
			case 7:
			case 16:
			case 21:
				return 3;
			case 3:
			case 8:
			case 12:
			case 17:
			case 22:
				return 4;
			case 4:
			case 9:
			case 13:
			case 18:
			case 23:	
				return 5;
			}
			return 0;
		}

	}