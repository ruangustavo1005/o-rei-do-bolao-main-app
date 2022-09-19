package interfaces;

import java.util.List;

/**
 * 
 * @author Ruan
 */
public interface ListagemParcial {
    
    /**
     * Array com o nome dos atributos que não devem se listados pelo TableModel
     * @return 
     */
    public List<String> getCamposIgnorar();
    
}