
public class Pessoa {
	
	private String nome;
	private TeleSena[] teleSenas = new TeleSena[15];
	private double premio;
	
	// Construtor de Pessoa 
	public Pessoa(String n, TeleSena[] ts) {
		this.nome = n;
		this.teleSenas = ts;
	}

    // Métodos Get	
	public TeleSena[] getTeleSenas() {
		return this.teleSenas;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public double getPremio() {
		return this.premio;
	}

	// Métodos Set
	public void setPremio(double p) {
		this.premio = p;
	}
}
