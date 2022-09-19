package util;

import java.util.ArrayList;
import javax.swing.JComboBox;

/**
 *
 * @author ruang
 */
public class ListaUtils {

    static public void povoaComboBox(JComboBox<ListaItem> comboBox, ArrayList<ListaItem> itens) {
        ListaUtils.povoaComboBox(comboBox, itens, null, false);
    }

    static public void povoaComboBox(JComboBox<ListaItem> comboBox, ArrayList<ListaItem> itens, Object valorSelecionado) {
        ListaUtils.povoaComboBox(comboBox, itens, valorSelecionado, false);
    }

    static public void povoaComboBox(JComboBox<ListaItem> comboBox, ArrayList<ListaItem> itens, Object valorSelecionado, boolean identificadorNaDescricao) {
        itens.forEach((ListaItem item) -> {
            comboBox.addItem(item);
            if (valorSelecionado != null && item.getCodigo().equals(valorSelecionado)) {
                comboBox.setSelectedItem(item);
            }
        });
    }

}
