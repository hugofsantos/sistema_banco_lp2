package br.ufrn.imd.dominio;

import java.util.ArrayList;
import java.util.Objects;

public class Cliente extends Pessoa{
    private Conta conta;

    /**
     * Criar um objeto da classe criante
     * @param nome do cliente
     * @param cpf do cliente
     */
    public Cliente(String nome, String cpf){
        this.setNome(nome);
        this.setCpf(cpf);

        this.conta = null;
    }

    /**
     * Cria uma conta pro cliente
     * @param conta : Conta que o cliente irá possuir
     * @return true se a conta for cadastrada com sucesso, false caso contrário
     */
    public boolean criarConta(Conta conta){
        if(conta != null){
            this.conta = conta;
            return true;
        }

        return false;
    }

    /**
     * Obter conta do cliente
     * @return conta do cliente
     */
    public Conta getConta(){
        return this.conta;
    }

    /**
     * Fecha a conta do cliente
     */
    public void fecharConta(){
        this.conta = null;
    }

    @Override
    public int hashCode(){
        return Objects.hash(this.cpf);
    }

    @Override
    public boolean equals(Object obj){
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return this.cpf == other.cpf;
    }    
}
