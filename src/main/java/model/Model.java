package model;

import java.io.Serializable;
import java.util.Comparator;

/**
 * 
 * @author ruang
 */
abstract public class Model implements Serializable, Comparator<Model> {

    abstract public int getId();
    
    public boolean isChavePreenchida() {
        return this.getId() != 0;
    }
    
    @Override
    public int compare(Model o1, Model o2) {
        return o1.getId() - o2.getId();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Model) {
            return this.getId() == ((Model) obj).getId();
        }
        return super.equals(obj);
    }
    
}