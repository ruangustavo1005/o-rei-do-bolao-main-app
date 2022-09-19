package util;

/**
 * 
 * @author ruang
 */
public class OperadorFiltro {

    static public final String OPERADOR_IGUAL       = "=";
    static public final String OPERADOR_DIFERENTE   = "!=";
    static public final String OPERADOR_CONTEM      = "like";
    static public final String OPERADOR_NAO_CONTEM  = "not like";
    static public final String OPERADOR_MAIOR_QUE   = ">";
    static public final String OPERADOR_MAIOR_IGUAL = ">=";
    static public final String OPERADOR_MENOR_QUE   = "<";
    static public final String OPERADOR_MENOR_IGUAL = "<=";
    static public final String OPERADOR_ENTRE       = "between";
    static public final String OPERADOR_NAO_ENTRE   = "not between";
    
    static public final String _OPERADOR_IGUAL       = "Igual";
    static public final String _OPERADOR_DIFERENTE   = "Diferente";
    static public final String _OPERADOR_CONTEM      = "Contém";
    static public final String _OPERADOR_NAO_CONTEM  = "Não Contem";
    static public final String _OPERADOR_MAIOR_QUE   = "Maior Que";
    static public final String _OPERADOR_MAIOR_IGUAL = "Maior Igual";
    static public final String _OPERADOR_MENOR_QUE   = "Menor Que";
    static public final String _OPERADOR_MENOR_IGUAL = "Menor Igual";
    static public final String _OPERADOR_ENTRE       = "Entre";
    static public final String _OPERADOR_NAO_ENTRE   = "Não Entre";
    
    private String nome;
    private String descricao;

    public OperadorFiltro() {
        
    }

    public OperadorFiltro(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public OperadorFiltro setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public String getDescricao() {
        return descricao;
    }

    public OperadorFiltro setDescricao(String descricao) {
        this.descricao = descricao;
        return this;
    }
    
    public boolean usaCampo2() {
        return this.getNome().equals(OperadorFiltro.OPERADOR_ENTRE)
            || this.getNome().equals(OperadorFiltro.OPERADOR_NAO_ENTRE);
    }
    
    static public OperadorFiltro getInstanceOperadorIgual() {
        return new OperadorFiltro(OperadorFiltro.OPERADOR_IGUAL, OperadorFiltro._OPERADOR_IGUAL);
    }
    
    static public OperadorFiltro getInstanceOperadorDiferente() {
        return new OperadorFiltro(OperadorFiltro.OPERADOR_DIFERENTE, OperadorFiltro._OPERADOR_DIFERENTE);
    }
    
    static public OperadorFiltro getInstanceOperadorContem() {
        return new OperadorFiltro(OperadorFiltro.OPERADOR_CONTEM, OperadorFiltro._OPERADOR_CONTEM);
    }
    
    static public OperadorFiltro getInstanceOperadorNaoContem() {
        return new OperadorFiltro(OperadorFiltro.OPERADOR_NAO_CONTEM, OperadorFiltro._OPERADOR_NAO_CONTEM);
    }
    
    static public OperadorFiltro getInstanceOperadorMaiorQue() {
        return new OperadorFiltro(OperadorFiltro.OPERADOR_MAIOR_QUE, OperadorFiltro._OPERADOR_MAIOR_QUE);
    }
    
    static public OperadorFiltro getInstanceOperadorMaiorIgual() {
        return new OperadorFiltro(OperadorFiltro.OPERADOR_MAIOR_IGUAL, OperadorFiltro._OPERADOR_MAIOR_IGUAL);
    }
    
    static public OperadorFiltro getInstanceOperadorMenorQue() {
        return new OperadorFiltro(OperadorFiltro.OPERADOR_MENOR_QUE, OperadorFiltro._OPERADOR_MENOR_QUE);
    }
    
    static public OperadorFiltro getInstanceOperadorMenorIgual() {
        return new OperadorFiltro(OperadorFiltro.OPERADOR_MENOR_IGUAL, OperadorFiltro._OPERADOR_MENOR_IGUAL);
    }
    
    static public OperadorFiltro getInstanceOperadorEntre() {
        return new OperadorFiltro(OperadorFiltro.OPERADOR_ENTRE, OperadorFiltro._OPERADOR_ENTRE);
    }
    
    static public OperadorFiltro getInstanceOperadorNaoEntre() {
        return new OperadorFiltro(OperadorFiltro.OPERADOR_NAO_ENTRE, OperadorFiltro._OPERADOR_NAO_ENTRE);
    }
    
    @Override
    public String toString() {
        return this.getDescricao();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj != null) {
            return this.getNome().equals(((OperadorFiltro) obj).getNome());
        }
        return false;
    }
    
}