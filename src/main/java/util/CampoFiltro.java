package util;

import java.util.ArrayList;
import java.util.Date;

/**
 * 
 * @author ruang
 */
public class CampoFiltro {

    private Class  clazz;
    private String nome;
    private String descricao;

    public CampoFiltro() {
        
    }
    
    public CampoFiltro(Class clazz, String nome) {
        this.clazz = clazz;
        this.nome = nome;
        this.descricao = StringUtils.ucfirst(nome);
    }
    
    public CampoFiltro(Class clazz, String nome, String descricao) {
        this.clazz = clazz;
        this.nome = nome;
        this.descricao = descricao;
    }

    public Class getClazz() {
        return clazz;
    }

    public CampoFiltro setClazz(Class clazz) {
        this.clazz = clazz;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public CampoFiltro setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public String getDescricao() {
        return descricao;
    }

    public CampoFiltro setDescricao(String descricao) {
        this.descricao = descricao;
        return this;
    }

    public ArrayList<OperadorFiltro> getOperadores() {
        ArrayList<OperadorFiltro> retorno = new ArrayList<>();
        if (this.isTipoString()) {
            retorno.add(OperadorFiltro.getInstanceOperadorIgual());
            retorno.add(OperadorFiltro.getInstanceOperadorDiferente());
            retorno.add(OperadorFiltro.getInstanceOperadorContem());
            retorno.add(OperadorFiltro.getInstanceOperadorNaoContem());
        }
        else if (this.isTipoInteger()) {
            retorno.add(OperadorFiltro.getInstanceOperadorIgual());
            retorno.add(OperadorFiltro.getInstanceOperadorDiferente());
            retorno.add(OperadorFiltro.getInstanceOperadorMaiorQue());
            retorno.add(OperadorFiltro.getInstanceOperadorMaiorIgual());
            retorno.add(OperadorFiltro.getInstanceOperadorMenorQue());
            retorno.add(OperadorFiltro.getInstanceOperadorMenorIgual());
            retorno.add(OperadorFiltro.getInstanceOperadorEntre());
            retorno.add(OperadorFiltro.getInstanceOperadorNaoEntre());
        }
        else if (this.isTipoFloat()) {
            retorno.add(OperadorFiltro.getInstanceOperadorIgual());
            retorno.add(OperadorFiltro.getInstanceOperadorDiferente());
            retorno.add(OperadorFiltro.getInstanceOperadorMaiorQue());
            retorno.add(OperadorFiltro.getInstanceOperadorMaiorIgual());
            retorno.add(OperadorFiltro.getInstanceOperadorMenorQue());
            retorno.add(OperadorFiltro.getInstanceOperadorMenorIgual());
            retorno.add(OperadorFiltro.getInstanceOperadorEntre());
            retorno.add(OperadorFiltro.getInstanceOperadorNaoEntre());
        }
        else if (this.isTipoDate()) {
            retorno.add(OperadorFiltro.getInstanceOperadorIgual());
            retorno.add(OperadorFiltro.getInstanceOperadorDiferente());
            retorno.add(OperadorFiltro.getInstanceOperadorMaiorQue());
            retorno.add(OperadorFiltro.getInstanceOperadorMaiorIgual());
            retorno.add(OperadorFiltro.getInstanceOperadorMenorQue());
            retorno.add(OperadorFiltro.getInstanceOperadorMenorIgual());
            retorno.add(OperadorFiltro.getInstanceOperadorEntre());
            retorno.add(OperadorFiltro.getInstanceOperadorNaoEntre());
        }
        return retorno;
    }
    
    public boolean isTipoString() {
        return this.getClazz().equals(String.class);
    }
    
    public boolean isTipoInteger() {
        return this.getClazz().equals(Integer.class);
    }
    
    public boolean isTipoFloat() {
        return this.getClazz().equals(Float.class);
    }
    
    public boolean isTipoDate() {
        return this.getClazz().equals(Date.class);
    }
    
    @Override
    public String toString() {
        return this.getDescricao();
    }

    @Override
    public boolean equals(Object obj) {
        return this.getNome().equals(((CampoFiltro) obj).getNome());
    }
    
}