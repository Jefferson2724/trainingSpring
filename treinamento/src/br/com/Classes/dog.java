package br.com.Classes;

public class dog extends Animal{
	private static int v1 = 100;
    private int v2 = 50;
    public int valor;
    
    public dog() {
    	this.valor = 10;
    }

    public dog(int valor) {
        super();
        this.valor = valor;
 
    }
    
    static int peso() {
        return 60;
    }
}
