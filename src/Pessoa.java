
public class Pessoa {
	
	private String nome;
	private TeleSena[] teleSenas = new TeleSena[15];
	private double premio;
	
	public Pessoa(String n, TeleSena[] ts) {
		this.nome = n;
		this.teleSenas = ts;
	}
	
	public TeleSena[] getTeleSenas() {
		return this.teleSenas;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public double getPremio() {
		return this.premio;
	}
}
