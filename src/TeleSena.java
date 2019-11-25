public class TeleSena {
	
	private double valorVenda = 10.00;
	private boolean[] conjunto1, conjunto2  = new boolean[25];
    
    // Construtor de TeleSena 
	public TeleSena(boolean[] c1, boolean[] c2) {
		this.conjunto1 = c1;
		this.conjunto2 = c2;
		
    }

    // Métodos Get
    public double getValorVenda(){
        return this.valorVenda;
    }
    
    public boolean[] getConjunto1(){
        return this.conjunto1;
    }

    public boolean[] getConjunto2(){
        return this.conjunto2;
    }

    // Métodos Set
    public void setConjunto1(boolean[] c1Set){
        this.conjunto1 = c1Set;
    }

    public void setConjunto2(boolean[] c2Set){
        this.conjunto1 = c2Set;
    }
}
