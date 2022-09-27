package dao;

import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import model.ConfiguracaoPino;

/**
 *
 * @author ruang
 */
public class DaoConfiguracaoPino extends Dao<ConfiguracaoPino> {

    public DaoConfiguracaoPino() {
        super(ConfiguracaoPino.class);
    }
    
    public ConfiguracaoPino get(int numeroCamera, int numeroPino) {
        Query query = this.entityManager.createQuery("from ConfiguracaoPino configuracaoPino"
                                                  + " join configuracaoPino.camera camera"
                                                 + " where camera.numero = :numeroCamera"
                                                   + " and configuracaoPino.numero = :numeroPino");
        
        query.setParameter("numeroCamera", numeroCamera);
        query.setParameter("numeroPino",   numeroPino);
        
        try {
            return (ConfiguracaoPino) query.getSingleResult();
        }
        catch (NoResultException ex) {
            return null;
        }
    }
    
    public List<ConfiguracaoPino> getByCamera(int numeroCamera) {
        Query query = this.entityManager.createQuery("from ConfiguracaoPino configuracaoPino"
                                                  + " join configuracaoPino.camera camera"
                                                 + " where camera.numero = :numeroCamera");
        
        query.setParameter("numeroCamera", numeroCamera);
        
//        try {
            return query.getResultList();
//        }
//        catch (NoResultException ex) {
//            return null;
//        }
    }
    
}
