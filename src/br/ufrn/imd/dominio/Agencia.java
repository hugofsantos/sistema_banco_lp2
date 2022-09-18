package br.ufrn.imd.dominio;

import java.util.Objects;

public class Agencia {
    private int codigo;
    private Banco banco;

    /**
     * Criar um objeto agência
     * @param codigo da agência
     * @param banco da agência
     */
    public Agencia(int codigo, Banco banco){
        this.codigo = codigo;
        this.banco = banco;
    }

    /**
     * Obter o código da agência
     * @return código da agência
     */
    public int getCodigo(){
        return this.codigo;
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
		Agencia other = (Agencia) obj;
		return (this.codigo == other.codigo) && (this.banco == other.banco);
    }    
}
