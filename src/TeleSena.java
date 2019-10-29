public class TeleSena {
	
	private double valorVenda = 10.00;
	private int[] conjunto1, conjunto2  = new int[25];
	
	public TeleSena(int[] c1, int[] c2) {
		this.conjunto1 = c1;
		this.conjunto2 = c2;
		
    }

    public double getValorVenda(){
        return this.valorVenda;
    }
    
    public int[] getConjunto1(){
        return this.conjunto1;
    }

    public int[] getConjunto2(){
        return this.conjunto2;
    }

    public void setConjunto1(int[] c1Set){
        this.conjunto1 = c1Set;
    }

    public void setConjunto2(int[] c2Set){
        this.conjunto1 = c2Set;
    }
}
