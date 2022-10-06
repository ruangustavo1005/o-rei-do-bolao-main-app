package model;

import interfaces.ListagemFiltravel;
import interfaces.ListagemMaqueada;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.Entity;
import javax.persistence.Id;
import util.CampoFiltro;

/**
 *
 * @author ruan
 */
@Entity
public class Jogador extends Model implements ListagemMaqueada, ListagemFiltravel {

    @Id
    private int numero;
    private String nome;

    public int getNumero() {
        return numero;
    }

    public Jogador setNumero(int numero) {
        this.numero = numero;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public Jogador setNome(String nome) {
        this.nome = nome;
        return this;
    }

    @Override
    public int getId() {
        return this.getNumero();
    }

    @Override
    public Map<String, String> getTitulosColunas() {
        HashMap<String, String> titulos = new HashMap<>();
        titulos.put("numero", "Número");
        return titulos;
    }

    @Override
    public ArrayList<CampoFiltro> getCamposFiltraveis() {
        ArrayList<CampoFiltro> filtros = new ArrayList<>();
        filtros.add(new CampoFiltro(Integer.class, "numero", "Número"));
        filtros.add(new CampoFiltro(String.class, "nome"));
        return filtros;
    }
    
}
