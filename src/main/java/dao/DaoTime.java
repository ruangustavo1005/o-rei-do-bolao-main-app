package dao;

import java.util.ArrayList;
import model.TimeJogador;

/**
 *
 * @author ruang
 */
public class DaoTime extends Dao<TimeJogador> {

    public DaoTime() {
        super(TimeJogador.class);
    }
    
    public ArrayList<TimeJogador> getOrderedByNome() {
        ArrayList<TimeJogador> lista = null;
        try {
            lista = (ArrayList<TimeJogador>) this.entityManager.createQuery("FROM " + TimeJogador.class.getName() + " ORDER BY nome").getResultList();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }
    
}
