package br.ufrn.imd.dominio;

import java.util.Objects;

public class Conta {
    private int numero;
    private Agencia agencia;
    private double saldo;

    /**
     * Criar um objeto do tipo conta
     * @param numero da conta
     */
    public Conta(int numero){
        this.numero = numero;
        this.saldo = 0;
    }   

    /**
     * Obter o número da conta
     * @return número da conta
     */
    public int getNumero(){
        return this.numero;
    }

    /**
     * Obter o saldo da conta
     * @return saldo da conta
     */
    public double getSaldo(){
        return this.saldo;
    }

    /**
     * Depositar um valor na conta
     * @param valor a ser depositado 
     * @return true se o depósito foi bem sucedido, false caso contrário
     */
    public boolean depositar(double valor){
        if(valor <= 0) return false;

        this.saldo += valor;
        return true;
    }

    /**
     * Saca um valor da conta
     * @param valor a ser sacado
     * @return true se o saque foi bem sucedido, false caso contrário
     */    
    public boolean sacar(double valor){
        if(valor <= 0 || this.saldo < valor) return false;

        this.saldo -= valor;
        return true;
    }

    /**
     * Transfere um valor para uma conta
     * @param valor a ser transferido
     * @param conta para onde o valor será transferido
     * @return true se a transferência for bem sucedida, false caso contrário
     */
    public boolean transferir(double valor, Conta conta){
        if(valor <=0 || this.saldo < valor || conta == null) return false;

        this.saldo -= valor;
        conta.depositar(valor);
        return true;
    }

    @Override
    public int hashCode(){
        return Objects.hash(this.numero);
    }

    @Override
    public boolean equals(Object obj){
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Conta other = (Conta) obj;
		return (this.numero == other.numero);
    }      
}
