package dao;

import java.util.ArrayList;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import model.Jogador;

/**
 *
 * @author ruang
 */
public class DaoJogador extends Dao<Jogador> {

    public DaoJogador() {
        super(Jogador.class);
    }
    
    public Jogador getByNumero(int numero) {
        Query query = this.entityManager.createQuery("from Jogador jogador"
                                                 + " where jogador.numero = :numero");
        
        query.setParameter("numero", numero);
        
        try {
            return (Jogador) query.getSingleResult();
        }
        catch (NoResultException ex) {
            return null;
        }
    }
    
    public int getSuggestNumero() {
        return (int) this.entityManager.createQuery("SELECT COALESCE(MAX(j.numero), 0) + 1 FROM Jogador j").getSingleResult();
    }
    
    public ArrayList<Jogador> getJogadoresSemTime() {
        ArrayList<Jogador> lista = null;
        try {
            lista = (ArrayList<Jogador>) this.entityManager.createQuery("FROM " + Jogador.class.getName() + " WHERE time IS NULL ORDER BY nome").getResultList();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }
    
}
