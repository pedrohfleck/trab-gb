public class Testes {

    public static void main(String[] args) {
        ControleTeleSena cts = new ControleTeleSena();
            
        cts.vendaTele();
        cts.sorteiaGanhador();
        System.out.println(cts.printInfo());
        
    }    
}