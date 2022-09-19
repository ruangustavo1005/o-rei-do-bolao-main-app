package util;

/**
 * 
 * @author ruang
 */
public class ListaItem<Chave, Valor> {

    private Chave codigo;
    private Valor nome;

    public ListaItem() {
        
    }
    
    public ListaItem(Chave codigo, Valor nome) {
        this.codigo = codigo;
        this.nome = nome;
    }

    public Chave getCodigo() {
        return codigo;
    }

    public void setCodigo(Chave codigo) {
        this.codigo = codigo;
    }

    public Valor getNome() {
        return nome;
    }

    public void setNome(Valor nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return nome.toString();
    }

    @Override
    public boolean equals(Object obj) {
        return this.getCodigo() == ((ListaItem) obj).getCodigo();
    }
    
}