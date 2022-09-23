package model;

import java.util.ArrayList;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import util.ListaItem;

/**
 *
 * @author ruang
 */
@Entity
public class Configuracao extends Model {

    static public final int ID = 1;
    
    static public final int TIPO_EXPERIENCIA_PRIMEIRA_BOLA = 1;
    static public final int TIPO_EXPERIENCIA_MENOR_BOLA    = 2;

    @Id
    private int id;
    
    @Column(name = "tipo_experiencia")
    private int tipoExperiencia;
    
    @Column(name = "percentual_match")
    private float percentualMatch;
    
    @Column(name = "margem_erro_localizacao")
    private int margemErroLocalizacao;

    public Configuracao() {
        this.id = Configuracao.ID;
    }
    
    @Override
    public int getId() {
        if (this.id == 0) {
            this.id = Configuracao.ID;
        }
        return id;
    }

    public int getTipoExperiencia() {
        return tipoExperiencia;
    }

    public Configuracao setTipoExperiencia(int tipoExperiencia) {
        this.tipoExperiencia = tipoExperiencia;
        return this;
    }

    public float getPercentualMatch() {
        return percentualMatch;
    }

    public Configuracao setPercentualMatch(float percentualMatch) {
        this.percentualMatch = percentualMatch;
        return this;
    }

    public int getMargemErroLocalizacao() {
        return margemErroLocalizacao;
    }

    public Configuracao setMargemErroLocalizacao(int margemErroLocalizacao) {
        this.margemErroLocalizacao = margemErroLocalizacao;
        return this;
    }
    
    static public ArrayList<ListaItem> getListaTipoExperiencia() {
        ArrayList<ListaItem> itens = new ArrayList<>();
        itens.add(new ListaItem<>(Configuracao.TIPO_EXPERIENCIA_PRIMEIRA_BOLA, "Primeira bola"));
        itens.add(new ListaItem<>(Configuracao.TIPO_EXPERIENCIA_MENOR_BOLA,    "Bola de menor pontuação"));
        return itens;
    }
    
}
