package model;

import interfaces.ListagemAdicional;
import interfaces.ListagemFiltravel;
import interfaces.ListagemMaqueada;
import interfaces.ListagemParcial;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import util.CampoFiltro;

/**
 *
 * @author ruan
 */
@Entity
public class TimeJogador extends Model implements ListagemMaqueada, ListagemFiltravel, ListagemParcial, ListagemAdicional {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private String cidadeOrigem;
    @OneToMany(mappedBy = "time")
    private List<Jogador> jogadores;
    
    @Override
    public int getId() {
        return id;
    }

    public TimeJogador setId(int id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public TimeJogador setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public String getCidadeOrigem() {
        return cidadeOrigem;
    }

    public TimeJogador setCidadeOrigem(String cidadeOrigem) {
        this.cidadeOrigem = cidadeOrigem;
        return this;
    }

    public List<Jogador> getJogadores() {
        return jogadores;
    }

    public TimeJogador setJogadores(List<Jogador> jogadores) {
        this.jogadores = jogadores;
        return this;
    }

    public int getJogadoresCount() {
        return this.getJogadores() != null ? this.getJogadores().size() : 0;
    }

    @Override
    public String toString() {
        return this.getNome() + " (" + this.getCidadeOrigem() + ")";
    }
    
    @Override
    public Map<String, String> getTitulosColunas() {
        HashMap<String, String> titulos = new HashMap<>();
        titulos.put("id", "ID");
        titulos.put("cidadeOrigem", "Cidade de Origem");
        titulos.put("jogadoresCount", "Total de Jogadores");
        return titulos;
    }

    @Override
    public ArrayList<CampoFiltro> getCamposFiltraveis() {
        ArrayList<CampoFiltro> filtros = new ArrayList<>();
        filtros.add(new CampoFiltro(Integer.class, "id", "ID"));
        filtros.add(new CampoFiltro(String.class,  "nome"));
        filtros.add(new CampoFiltro(String.class,  "cidadeOrigem", "Cidade de Origem"));
        return filtros;
    }

    @Override
    public List<String> getCamposIgnorar() {
        ArrayList<String> campos = new ArrayList<>();
        campos.add("jogadores");
        return campos;
    }

    @Override
    public List<String> getCamposAdicionar() {
        ArrayList<String> campos = new ArrayList<>();
        campos.add("jogadoresCount");
        return campos;
    }
    
}
