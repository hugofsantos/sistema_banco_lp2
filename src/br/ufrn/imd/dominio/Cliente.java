package br.ufrn.imd.dominio;

import java.util.ArrayList;
import java.util.Objects;

public class Cliente extends Pessoa{
    private ArrayList<Conta> contas;

    /**
     * Criar um objeto da classe criante
     * @param nome do cliente
     * @param cpf do cliente
     */
    public Cliente(String nome, String cpf){
        this.setNome(nome);
        this.setCpf(cpf);

        this.contas = new ArrayList<>();
    }

    /**
     * Cria uma conta pro cliente
     * @param conta Conta a ser inserida nas conjunto de contas do cliente
     * @return true se a conta for adicionada com sucesso, false caso contrário
     */
    public boolean adicionarConta(Conta conta){
        if(!this.contas.contains(conta)){
            this.contas.add(conta);
            return true;
        }

        return false;
    }

    /**
     * Fecha uma conta do cliente
     * @param conta : Conta a ser fechada
     * @return {@code true} se a conta for fechada corretamente, {@code false} caso haja uma falha ao fechar conta
     */
    public boolean fecharConta(Conta conta){
        if(!this.contas.contains(conta)) return false;
        
        this.contas.remove(conta);
        return true;
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
