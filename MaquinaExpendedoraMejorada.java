public class MaquinaExpendedoraMejorada {
    
    // El precio del billete
    private int precioBillete;
    // La cantidad de dinero que lleva metida el cliente actual
    private int balanceClienteActual;
    // El total de dinero almacenado en la maquina desde su ultimo vaciado
    private int totalDineroAcumulado;
    // El origen del billete
    private String estacionOrigen;
    // El destino del billete
    private String estacionDestino;
    // La cantidad de billetes vendidos
    private int billetesVendidos;
    private boolean premio;
    private int maxBilletes;

    /**
     * Crea una maquina expendedora de billetes de tren con el 
     * precio del billete y el origen y destino dados. Se asume que el precio
     * del billete que se recibe es mayor que 0.
     */
    public MaquinaExpendedoraMejorada(int precioDelBillete, String origen, String destino, boolean hayPremio, int max) {
        precioBillete = precioDelBillete;
        balanceClienteActual = 0;
        totalDineroAcumulado = 0;
        estacionOrigen = origen;
        estacionDestino = destino;
        billetesVendidos = 0;
        premio = hayPremio;
        maxBilletes = max;
    }
    
    public MaquinaExpendedoraMejorada(boolean hayPremio, int max) {
        precioBillete = 20;
        balanceClienteActual = 0;
        totalDineroAcumulado = 0;
        estacionOrigen = "Valencia";
        estacionDestino = "Oviedo";
        billetesVendidos = 0;
        premio = hayPremio;
        maxBilletes = max;
    }

    /**
     * Devuelve el precio del billete
     */
    public int getPrecioBillete() {
        return precioBillete;
    }

    /**
     * Devuelve la cantidad de dinero que el cliente actual lleva introducida
     */
    public int getBalanceClienteActual() {
        return balanceClienteActual;
    }
    
    public int getNumeroBilletesVendidos() {
        return billetesVendidos;
    }

    /**
     * Simula la introduccion de dinero por parte del cliente actual
     */
    public void introducirDinero(int cantidadIntroducida) {
        if (billetesVendidos == maxBilletes) {
            System.out.println("Su dinero no ha sido acptado porque todos los billetes ya han sido vendidos");
        }
        else if (cantidadIntroducida > 0){
            balanceClienteActual = balanceClienteActual + cantidadIntroducida;
        }else {
            System.out.println(cantidadIntroducida + " no es una cantidad de dinero valida.");
        }        
    }

    /**
     * Imprime un billete para el cliente actual
     */
    public void imprimirBillete() {
        int cantidadDeDineroQueFalta = precioBillete - balanceClienteActual;
        if (billetesVendidos == maxBilletes){
            System.out.println("Todos los billetes ya han sido vendidos");
        }else if (cantidadDeDineroQueFalta <= 0) {        
            // Simula la impresion de un billete
            System.out.println("##################");
            System.out.println("# Billete de tren:");
            System.out.println("# De " + estacionOrigen + " a " + estacionDestino);
            System.out.println("# " + precioBillete + " euros.");
            int prob = (billetesVendidos + 1) % 4;
            if(premio == true && prob == 0){
                double descuento = precioBillete / 4.0;
                System.out.println(descuento + "€ de descuento en Mercadona");
                System.out.println("##################");
            }else{
                System.out.println("##################");
            }
            System.out.println();
            
            // Actualiza el total de dinero acumulado en la maquina
            totalDineroAcumulado = totalDineroAcumulado + precioBillete;
            // Reduce el balance del cliente actual dejandole seguir utilizando la maquina
            balanceClienteActual = balanceClienteActual - precioBillete;
            billetesVendidos = billetesVendidos + 1;
            
        }
        else {
            System.out.println("Necesitas introducir " + (cantidadDeDineroQueFalta) + " euros mas!");
                    
        } 
    }
    
    public void imprimirNumeroBilletesVendidos() {
        System.out.println("Numero de billetes vendidos: " + billetesVendidos);
    }
    
    /**
     * Cancela la operacion de compra del cliente actual y le
     * devuelve al cliente el dinero que ha introducido hasta el momento
     */
    public int cancelarOperacionYDevolverDinero() {
        int cantidadDeDineroADevolver;
        cantidadDeDineroADevolver = balanceClienteActual;
        balanceClienteActual = 0;
        return cantidadDeDineroADevolver;
    }
    
    public int vaciarDineroDeLaMaquina(){
        int totalDinero;
        if (balanceClienteActual != 0){
            totalDinero = -1;
            System.out.println("Cancela la operacion para poder vaciar la maquina");
        }else {
            totalDinero = totalDineroAcumulado + balanceClienteActual;
            balanceClienteActual = 0;
            totalDineroAcumulado = 0;
        }
        return totalDinero;
    }
}