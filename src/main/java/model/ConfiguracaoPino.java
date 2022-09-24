package model;

import java.util.ArrayList;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author ruang
 */
@Entity
@Table(name = "configuracao_pino")
public class ConfiguracaoPino extends Model {

    static public final int NUMERO_PINO_1 = 1;
    static public final int NUMERO_PINO_2 = 2;
    static public final int NUMERO_PINO_3 = 3;
    static public final int NUMERO_PINO_4 = 4;
    static public final int NUMERO_PINO_5 = 5;
    static public final int NUMERO_PINO_6 = 6;
    static public final int NUMERO_PINO_7 = 7;
    static public final int NUMERO_PINO_8 = 8;
    static public final int NUMERO_PINO_9 = 9;

    @Id
    private int numero;
    
    @Id
    @ManyToOne
    @JoinColumn(name = "numero_camera", nullable = false)
    private ConfiguracaoCamera camera;
    
    @Column(name = "pos_x", nullable = false)
    private int posX;
    
    @Column(name = "pos_y", nullable = false)
    private int posY;
    
    @Column(name = "percentual_match")
    private float percentualMatch;
    
    @Column(name = "margem_erro_localizacao")
    private int margemErroLocalizacao;
    
    @Lob
    @Basic(fetch = FetchType.LAZY)
    private byte[] imagem;
    
    @Override
    public int getId() {
        return this.getNumero();
    }

    public int getNumero() {
        return numero;
    }

    public ConfiguracaoPino setNumero(int numero) {
        this.numero = numero;
        return this;
    }

    public ConfiguracaoCamera getCamera() {
        return camera;
    }

    public ConfiguracaoPino setCamera(ConfiguracaoCamera camera) {
        this.camera = camera;
        return this;
    }

    public int getPosX() {
        return posX;
    }

    public ConfiguracaoPino setPosX(int posX) {
        this.posX = posX;
        return this;
    }

    public int getPosY() {
        return posY;
    }

    public ConfiguracaoPino setPosY(int posY) {
        this.posY = posY;
        return this;
    }

    public float getPercentualMatch() {
        return percentualMatch;
    }

    public ConfiguracaoPino setPercentualMatch(float percentualMatch) {
        this.percentualMatch = percentualMatch;
        return this;
    }

    public int getMargemErroLocalizacao() {
        return margemErroLocalizacao;
    }

    public ConfiguracaoPino setMargemErroLocalizacao(int margemErroLocalizacao) {
        this.margemErroLocalizacao = margemErroLocalizacao;
        return this;
    }

    public byte[] getImagem() {
        return imagem;
    }

    public ConfiguracaoPino setImagem(byte[] imagem) {
        this.imagem = imagem;
        return this;
    }

    static public ArrayList<Integer> getNumeros() {
        ArrayList<Integer> ids = new ArrayList<>();
        ids.add(ConfiguracaoPino.NUMERO_PINO_1);
        ids.add(ConfiguracaoPino.NUMERO_PINO_2);
        ids.add(ConfiguracaoPino.NUMERO_PINO_3);
        ids.add(ConfiguracaoPino.NUMERO_PINO_4);
        ids.add(ConfiguracaoPino.NUMERO_PINO_5);
        ids.add(ConfiguracaoPino.NUMERO_PINO_6);
        ids.add(ConfiguracaoPino.NUMERO_PINO_7);
        ids.add(ConfiguracaoPino.NUMERO_PINO_8);
        ids.add(ConfiguracaoPino.NUMERO_PINO_9);
        return ids;
    }
    
}
