package model;

import interfaces.ListagemFiltravel;
import interfaces.ListagemMaqueada;
import interfaces.ListagemParcial;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import util.CampoFiltro;

/**
 *
 * @author ruan
 */
@Entity
public class Jogador extends Model implements ListagemMaqueada, ListagemFiltravel, ListagemParcial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = true)
    private int numero;
    private String nome;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_time")
    private TimeJogador time;
    
    @Override
    public int getId() {
        return id;
    }

    public Jogador setId(int id) {
        this.id = id;
        return this;
    }

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

    public TimeJogador getTime() {
        return time;
    }

    public Jogador setTime(TimeJogador time) {
        this.time = time;
        return this;
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
        filtros.add(new CampoFiltro(String.class,  "nome"));
        return filtros;
    }

    @Override
    public List<String> getCamposIgnorar() {
        ArrayList<String> campos = new ArrayList<>();
        campos.add("id");
        return campos;
    }

    @Override
    public String toString() {
        return this.getNome() + " (" + this.getNumero() + ")";
    }
}
