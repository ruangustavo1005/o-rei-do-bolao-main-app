package util;

/**
 * 
 * @author ruang
 */
public class NumberUtils {
    
    public static int parseInt(String s) {
        String replace = s.replace(".", "").trim();
        return replace.equals("") ? 0 : Integer.parseInt(replace);
    }
    
    public static float parseFloat(String s) {
        String replace = s.replace(".", "").replace(",", ".").trim();
        return (float) (replace.equals("") ? 0.0 : Float.parseFloat(replace));
    }
    
    public static String formataValor(float valor) {
        return formataValor(valor, 2);
    }
    
    public static String formataValor(float valor, int decimais) {
        return formataValor(valor, decimais, false);
    }
    
    public static String formataValor(float valor, int decimais, boolean withPontos) {
        return formataValor(valor, decimais, withPontos, -1);
    }
    
    public static String formataValor(float valor, int decimais, boolean withPontos, int lpad) {
        String retorno = String.valueOf(((int) (valor * (Math.pow(10, decimais)))) / (Math.pow(10, decimais))).replace(".", ",");
        if (withPontos) {
            String parteInteira = retorno.substring(0, retorno.indexOf(","));
            if (parteInteira.length() > 3) {
                parteInteira = parteInteira.substring(0, parteInteira.length() - 3) + "." + parteInteira.substring(parteInteira.length() - 3);
                int posicaoPonto = parteInteira.indexOf(".");
                while (posicaoPonto > 3) {
                    parteInteira = parteInteira.substring(0, posicaoPonto - 3) + "." + parteInteira.substring(posicaoPonto - 3);
                    posicaoPonto = parteInteira.indexOf(".");
                }
            }
            retorno = parteInteira + retorno.substring(retorno.indexOf(","));
        }
        if (decimais == 0) {
            retorno = retorno.substring(0, retorno.indexOf(','));
        }
        else if (retorno.substring(retorno.indexOf(',') + 1).length() != decimais) {
            retorno = retorno.substring(0, retorno.indexOf(',')).concat(StringUtils.rpad(retorno.substring(retorno.indexOf(',')), decimais + 1));
        }
        if (lpad > 0) {
            while (retorno.length() + 1 < lpad) {
                if (withPontos && retorno.indexOf('.') == 3 || retorno.indexOf(',') == 3) {
                    retorno = ".".concat(retorno);
                }
                else {
                    retorno = "0".concat(retorno);
                }
            }
        }
        return retorno;
    }
    
}