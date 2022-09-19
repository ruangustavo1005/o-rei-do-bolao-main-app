package interfaces;

import java.util.Map;

/**
 * 
 * @author Ruan
 */
public interface ListagemMaqueada {
    
    /**
     * Map na estrutura ["nomeDoAtributo" : "Novo Título"]
     * Trata os campos adicionais que forem trazidos pela interface ListagemAdicional
     * @return 
     */
    public Map<String, String> getTitulosColunas();
    
}