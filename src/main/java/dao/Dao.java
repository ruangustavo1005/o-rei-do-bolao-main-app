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
    protected boolean transactions = true;

    public Dao(Class<Type> classe) {
        this.classe        = classe;
        this.entityManager = Connection.getInstance().getEntityManager();
    }
    
    public ArrayList<Type> get() {
        ArrayList<Type> lista = null;
        try {
            lista = (ArrayList<Type>) this.entityManager.createQuery("from " + this.classe.getName()).getResultList();
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
                    String.format("from %s tabela where tabela.%s %s :param1", this.classe.getName(), campo, operador)
                );

                this.addParamQuery(query, campoFiltro, "param1", valor);
                
                break;
            }

            case OperadorFiltro.OPERADOR_CONTEM : 
            case OperadorFiltro.OPERADOR_NAO_CONTEM : {
                query = this.entityManager.createQuery(
                    String.format("from %s tabela where lower(tabela.%s) %s :param1", this.classe.getName(), campo, operador)
                );
                
                this.addParamQuery(query, campoFiltro, "param1", "%" + valor.toLowerCase() + "%");
                
                break;
            }

            case OperadorFiltro.OPERADOR_ENTRE : 
            case OperadorFiltro.OPERADOR_NAO_ENTRE : {
                query = this.entityManager.createQuery(
                    String.format("from %s tabela where tabela.%s %s :param1 and :param2", this.classe.getName(), campo, operador)
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
        else if (campoFiltro.isTipoInteger()) {
            try {
                query.setParameter(paramName, Integer.valueOf(paramValue));
            }
            catch (NumberFormatException exception) {
                throw new ValorInvalidoCampo();
            }
        }
        else if (campoFiltro.isTipoFloat()) {
            query.setParameter(paramName, Float.valueOf(paramValue));
        }
        else if (campoFiltro.isTipoDate()) {
            query.setParameter(paramName, DateUtils.stringToDate(paramValue));
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
    
    public final void begin() {
        if (this.transactions) {
            this.entityManager.getTransaction().begin();
        }
    }

    public final void commit() {
        if (this.transactions && this.isTransactionActive()) {
            this.entityManager.getTransaction().commit();
        }
    }

    public final void rollback() {
        if (this.transactions && this.isTransactionActive()) {
            this.entityManager.getTransaction().rollback();
        }
    }
    
    public final boolean isTransactionActive() {
        return this.entityManager.getTransaction().isActive();
    }
    
    public void disableTransactions() {
        this.transactions = false;
    }
    
    
    public void enableTransactions() {
        this.transactions = true;
    }
    
}