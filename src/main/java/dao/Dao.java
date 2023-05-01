package dao;

import exceptions.ValorInvalidoCampo;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.Model;
import util.CampoFiltro;
import util.DateUtils;
import util.OperadorFiltro;

/**
 * 
 * @author ruang
 * @param <Type>
 */
public class Dao<Type extends Model> {
    
    protected final EntityManager entityManager;
    protected final Class<Type> classe;
    
    static protected boolean transactions = true;

    public Dao(Class<Type> classe) {
        this.classe        = classe;
        this.entityManager = Connection.getInstance().getEntityManager();
    }
    
    protected String getBaseSelect(){
        return "from " + this.classe.getName() + " tabela where 1 = 1";
    }
    
    public ArrayList<Type> get() {
        ArrayList<Type> lista = null;
        try {
            lista = (ArrayList<Type>) this.entityManager.createQuery(this.getBaseSelect()).getResultList();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }
    
    public ArrayList<Type> get(CampoFiltro campoFiltro, OperadorFiltro operadorFiltro, String valor) throws ValorInvalidoCampo {
        return this.get(campoFiltro, operadorFiltro, valor, "");
    }
    
    public ArrayList<Type> get(CampoFiltro campoFiltro, OperadorFiltro operadorFiltro, String valor, String valor2) throws ValorInvalidoCampo {
        ArrayList<Type> lista = null;
        
        String campo    = campoFiltro.getNome();
        String operador = operadorFiltro.getNome();

        Query query = null;

        switch (operador) {
            case OperadorFiltro.OPERADOR_IGUAL : 
            case OperadorFiltro.OPERADOR_DIFERENTE : 
            case OperadorFiltro.OPERADOR_MAIOR_QUE : 
            case OperadorFiltro.OPERADOR_MAIOR_IGUAL : 
            case OperadorFiltro.OPERADOR_MENOR_QUE : 
            case OperadorFiltro.OPERADOR_MENOR_IGUAL : {
                query = this.entityManager.createQuery(
                    String.format(this.getBaseSelect() + " and tabela.%s %s :param1", campo, operador)
                );

                this.addParamQuery(query, campoFiltro, "param1", valor);
                
                break;
            }

            case OperadorFiltro.OPERADOR_CONTEM : 
            case OperadorFiltro.OPERADOR_NAO_CONTEM : {
                query = this.entityManager.createQuery(
                    String.format(this.getBaseSelect() + " and lower(tabela.%s) %s :param1", campo, operador)
                );
                
                this.addParamQuery(query, campoFiltro, "param1", "%" + valor.toLowerCase() + "%");
                
                break;
            }

            case OperadorFiltro.OPERADOR_ENTRE : 
            case OperadorFiltro.OPERADOR_NAO_ENTRE : {
                query = this.entityManager.createQuery(
                    String.format(this.getBaseSelect() + " and tabela.%s %s :param1 and :param2", campo, operador)
                );
                
                this.addParamQuery(query, campoFiltro, "param1", valor);
                this.addParamQuery(query, campoFiltro, "param2", valor2);
                
                break;
            }
        }

        if (query != null) {
            lista = (ArrayList<Type>) query.getResultList();
        }
        
        return lista;
    }

    protected void addParamQuery(Query query, CampoFiltro campoFiltro, String paramName, String paramValue) throws ValorInvalidoCampo {
        if (campoFiltro.isTipoString()) {
            query.setParameter(paramName, paramValue);
        }
        else if (campoFiltro.isTipoDate()) {
            query.setParameter(paramName, DateUtils.stringToDate(paramValue));
        }
        else {
            try {
                if (campoFiltro.isTipoInteger()) {
                    query.setParameter(paramName, Integer.valueOf(paramValue));
                }
                else if (campoFiltro.isTipoFloat()) {
                    query.setParameter(paramName, Float.valueOf(paramValue));
                }
            }
            catch (NumberFormatException exception) {
                throw new ValorInvalidoCampo();
            }
        }
    }
    
    public boolean add(Type object) {
        boolean retorno = true;
        try {
            this.begin();
            this.entityManager.persist(object);
            this.commit();
        }
        catch (Exception e) {
            e.printStackTrace();
            retorno = false;
            this.rollback();
        }
        return retorno;
    }

    public boolean remove(int id) {
        return this.remove(this.get(id));
    }
    
    public boolean remove(Type object) {
        boolean retorno = true;
        try {
            this.begin();
            this.entityManager.remove(object);
            this.commit();
        }
        catch (Exception e) {
            e.printStackTrace();
            retorno = false;
            this.rollback();
        }
        return retorno;
    }
    
    public boolean update(Type object) {
        boolean retorno = true;
        try {
            this.begin();
            this.entityManager.merge(object);
            this.commit();
        }
        catch (Exception e) {
            e.printStackTrace();
            retorno = false;
            this.rollback();
        }
        return retorno;
    }
    
    public Type get(Object id) {
        Type object = null;
        try {
            object = this.entityManager.find(this.classe, id);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return object;
    }
    
    protected final void begin() {
        if (Dao.transactions) {
            this.entityManager.getTransaction().begin();
        }
    }

    protected final void commit() {
        if (Dao.transactions && this.isTransactionActive()) {
            this.entityManager.getTransaction().commit();
        }
    }

    protected final void rollback() {
        if (Dao.transactions && this.isTransactionActive()) {
            this.entityManager.getTransaction().rollback();
        }
    }
    
    public final boolean isTransactionActive() {
        return this.entityManager.getTransaction().isActive();
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }
    
    static public void disableTransactions() {
        Dao.transactions = false;
    }
    
    static public void enableTransactions() {
        Dao.transactions = true;
    }
    
}