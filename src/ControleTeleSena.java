public class ControleTeleSena {
	
	private static Pessoa[] pessoas = new Pessoa[20];
	private Pessoa[] ganhadores = new Pessoa[20];
	
	public void vendaTele(){
		for (int i = 0; i < 20; i++) {
			//Cria as tele senas a serem compradas (quantidade aleatória)
			int nTeles = (int)(Math.random() * 15 + 1);
			TeleSena[] teles = new TeleSena[nTeles];
			for (int j = 0; j < nTeles; j++) {
				teles[j] = new TeleSena(sorteio(),sorteio());				
			}							
			Pessoa p = new Pessoa("Fulano" + (i+1),teles);
			pessoas[i] = p;
		}
		ganhadores = pessoas;
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
	public int[] sorteio(){
		int[] sorteados = new int[25];
		for (int i = 0; i < 25; i++) {
			int nmrSort =  (int)(Math.random() * 60 + 1);
			
			for (int j = 0; j < sorteados.length; j++) {
				if(sorteados[j] == nmrSort){
					nmrSort =  (int)(Math.random() * 60 + 1);
					j = -1;
				}
			}
			sorteados[i] = nmrSort;
		}
		return sorteados;
	}

	// Método retorna string com as informações necessárias 
	public String printInfo() {
		String msg = "Numero de sorteados = " + pessoas.length + "\n" +
				"Quantidade de TeleSenas vendidas = " + quantTele()+ "\n" +
				"Quantidade de ganhadores = " + this.ganhadores.length + "\n" +
				"Nome de cada um dos ganhadores: " + "\n";
		
		for (Pessoa pessoa : ganhadores) {
			msg += pessoa.getNome() + "\n";
		}
		
		msg += "Valor do premio para cada ganhador: " + "\n";
		
		double totalPremio = 0.00;
		
		for (Pessoa pessoa : ganhadores) {
			msg += "R$ " + pessoa.getPremio() + "\n";
			totalPremio += pessoa.getPremio();
		}
		
		double vendaTotal = quantTele()*10.00;
		
		msg += "Valor total das Tele Senas vendidas = R$ " + vendaTotal + "\n"+
				"Lucro do Silvio Santos ma oe = R$ " + (vendaTotal-totalPremio);
		
		return msg;
	}
	
}
