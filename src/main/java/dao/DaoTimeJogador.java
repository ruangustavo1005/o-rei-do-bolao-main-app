package dao;

import java.util.ArrayList;
import model.Jogador;
import model.TimeJogador;

/**
 *
 * @author ruang
 */
public class DaoTimeJogador extends Dao<Jogador> {

    private TimeJogador time;
    
    public DaoTimeJogador(TimeJogador time) {
        super(Jogador.class);
        this.time = time;
    }

    @Override
    protected String getBaseSelect() {
        return "from Jogador tabela where tabela.time.id = " + this.time.getId();
    }
    
}
