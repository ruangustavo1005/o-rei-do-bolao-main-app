package model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author ruang
 */
@Entity
@Table(name = "configuracao_camera")
public class ConfiguracaoCamera extends Model {

    static public final int ID_CAMERA_1 = 1;
    static public final int ID_CAMERA_2 = 2;
    static public final int ID_CAMERA_3 = 3;
    static public final int ID_CAMERA_4 = 4;

    @Id
    private int numero;
    
    @OneToMany(mappedBy = "camera")
    private List<ConfiguracaoPino> pinos;
    
    @Column(name = "percentual_match")
    private float percentualMatch;
    
    @Column(name = "margem_erro_localizacao")
    private int margemErroLocalizacao;
    
    @Column(name = "endpoint_rtsp")
    private String endpointRTSP;
    
    @Override
    public int getId() {
        return this.getNumero();
    }

    public int getNumero() {
        return numero;
    }

    public ConfiguracaoCamera setNumero(int numero) {
        this.numero = numero;
        return this;
    }

    public List<ConfiguracaoPino> getPinos() {
        return pinos;
    }

    public ConfiguracaoCamera setPinos(List<ConfiguracaoPino> pinos) {
        this.pinos = pinos;
        return this;
    }

    public float getPercentualMatch() {
        return percentualMatch;
    }

    public ConfiguracaoCamera setPercentualMatch(float percentualMatch) {
        this.percentualMatch = percentualMatch;
        return this;
    }

    public int getMargemErroLocalizacao() {
        return margemErroLocalizacao;
    }

    public ConfiguracaoCamera setMargemErroLocalizacao(int margemErroLocalizacao) {
        this.margemErroLocalizacao = margemErroLocalizacao;
        return this;
    }

    public String getEndpointRTSP() {
        return endpointRTSP;
    }

    public ConfiguracaoCamera setEndpointRTSP(String endpointRTSP) {
        this.endpointRTSP = endpointRTSP;
        return this;
    }

    public ConfiguracaoPino getPino(int numero) {
        return this.getPinos().stream()
                .filter((pino) -> pino.getNumero() == numero)
                .findAny().get();
    }
    
    static public ArrayList<Integer> getIds() {
        ArrayList<Integer> ids = new ArrayList<>();
        ids.add(ConfiguracaoCamera.ID_CAMERA_1);
        ids.add(ConfiguracaoCamera.ID_CAMERA_2);
        ids.add(ConfiguracaoCamera.ID_CAMERA_3);
        ids.add(ConfiguracaoCamera.ID_CAMERA_4);
        return ids;
    }
    
}
