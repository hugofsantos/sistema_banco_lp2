package br.ufrn.imd.dominio;

import java.util.Objects;

public class Banco {
    int codigo;
    String nome;

    /**
     * Cria um banco
     * @param codigo : código do banco
     * @param nome : nome do banco
     */
    public Banco(int codigo, String nome){
        this.nome = nome;
        this.codigo = codigo;
    }

    /**
     * Obter o código do banco
     * @return um {@code int} referente ao código do banco
     */
    public int getCodigo(){
        return this.codigo;
    }

    /**
     * Obter o nome do banco
     * @return uma {@code String} referente ao nome do banco
     */
    public String getNome(){
        return this.nome;
    }

    /**
     * Inserir o nome do banco
     * @param nome : Nome a ser inserido no banco
     */
    public void setNome(String nome){
        this.nome = nome;
    }

    @Override
    public int hashCode(){
        return Objects.hash(this.codigo);
    }

    @Override
    public boolean equals(Object obj){
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Banco other = (Banco) obj;
		return this.codigo == other.codigo;
    }
}
