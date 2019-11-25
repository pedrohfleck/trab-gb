import java.util.Random;

public class ControleTeleSena {
	
	private static Pessoa[] pessoas = new Pessoa[20];
	private static Pessoa[] ganhadores = new Pessoa[20];
	
	public void vendaTele(){
		for (int i = 0; i < 20; i++) {
			//Cria as tele senas a serem compradas (quantidade aleatória)
			int nTeles = (int)(Math.random() * 15 + 1);
			TeleSena[] teles = new TeleSena[nTeles];
			for (int j = 0; j < nTeles; j++) {
				teles[j] = new TeleSena(sorteadorDeNumeros(),sorteadorDeNumeros());				
			}							
			Pessoa p = new Pessoa("Fulano" + (i+1),teles);
			pessoas[i] = p;
		}
		// ganhadores = pessoas;
	}

	// Método que retorna a quantidade de TeleSenas vendidas
	static int quantTele() {
		int quant = 0;
		for (Pessoa pessoa : pessoas) {
			TeleSena[] ts = pessoa.getTeleSenas();
			quant += ts.length;			
		}
		return quant;
	}
	
	// Método que sorteia os números da TeleSena vencedora
	public boolean[] sorteadorDeNumeros(){
		// int[] sorteados = new int[25];
		// for (int i = 0; i < 25; i++) {
		// 	int nmrSort =  (int)(Math.random() * 60 + 1);
			
		// 	for (int j = 0; j < sorteados.length; j++) {
		// 		if(sorteados[j] == nmrSort){
		// 			nmrSort =  (int)(Math.random() * 60 + 1);
		// 			j = -1;
		// 		}
		// 	}
		// 	sorteados[i] = nmrSort;
		// }
		// return sorteados;
		int cont = 0;
		boolean[] sorteados = new boolean[60];
		Random random = new Random();
		for (int i = 0; i < sorteados.length; i++) {
			if(cont<25){
				sorteados[i] = random.nextBoolean();
				if(sorteados[i]) cont++;
			}else{
				sorteados[i] = false;				
			}
			// System.out.println(b);
		}
		// System.out.println(cont);
		return sorteados;
	}

	public void sorteiaGanhador(){
		boolean[] numerosGanhadores = sorteadorDeNumeros();
		int cont1 = 0,cont2 = 0;
		for (Pessoa p : pessoas) {
			TeleSena[] teles = p.getTeleSenas();
			for (TeleSena t : teles) {
				boolean[] c1 = t.getConjunto1();
				boolean[] c2 = t.getConjunto2();		
				for (int i = 0; i < numerosGanhadores.length; i++) {
					if(numerosGanhadores[i]== true && c1[i] == true){
						cont1++;
					}
					if(numerosGanhadores[i]== true && c2[i] == true){
						cont2++;
					}
				}	
				if(cont1 == 25 || cont2 == 25){ 
					// adicionar pessoa ao array ganhadores
					insereGanhador(p);
					cont1 = 0;
					cont2 = 0;
					break;
				}else{
					cont1 = 0;
					cont2 = 0;
				}
			}
		} 
	}

	public boolean insereGanhador(Pessoa g) {
        
        for (int i = 0; i < ganhadores.length; i++) {
            
            if (ganhadores[i] == null) {
                
                ganhadores[i] = g;
                return true;
                
            }
            
        }
        
        return false;
        
    }
	// Método retorna string com as informações necessárias 
	public String printInfo() {
		String msg = "Numero de sorteados = " + pessoas.length + "\n" +
				"Quantidade de TeleSenas vendidas = " + quantTele()+ "\n" +
				"Quantidade de ganhadores = " + ganhadores.length + "\n" + 
				"Nome de cada um dos ganhadores: " + "\n";
		
		for (Pessoa pessoa : ganhadores) {
			if(pessoa == null){
				break;
			}
			msg += pessoa.getNome() + "\n";
		}
		
		msg += "Valor do premio para cada ganhador: " + "\n";
		
		double totalPremio = 0.00;
		
		for (Pessoa pessoa : ganhadores) {
			if(pessoa == null){
				break;
			}
			msg += "R$ " + pessoa.getPremio() + "\n";
			totalPremio += pessoa.getPremio();
		}
		
		double vendaTotal = quantTele()*10.00;
		
		msg += "Valor total das Tele Senas vendidas = R$ " + vendaTotal + "\n"+
				"Lucro do Silvio Santos ma oe = R$ " + (vendaTotal-totalPremio);
		
		return msg;
	}
	
}
