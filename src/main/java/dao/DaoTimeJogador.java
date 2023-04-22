package dao;

import exceptions.ValorInvalidoCampo;
import java.util.ArrayList;
import java.util.stream.Collectors;
import model.Jogador;
import model.TimeJogador;
import util.CampoFiltro;
import util.OperadorFiltro;

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
    public ArrayList<Jogador> get(CampoFiltro campoFiltro, OperadorFiltro operadorFiltro, String valor, String valor2) throws ValorInvalidoCampo {
        return (ArrayList<Jogador>) super.get(campoFiltro, operadorFiltro, valor, valor2)
                .stream()
                .filter(j -> j.getTime().getId() == this.time.getId())
                .collect(Collectors.toList());
    }
    
}
