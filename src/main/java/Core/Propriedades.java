package Core;

public class Propriedades {

    public static boolean FECHAR_BROWSER = false;
    public static tiposExecuacao TIPO_EXECUCAO = tiposExecuacao.LOCAL;
    public static navegadores NAVEGADOR = navegadores.CHROME;

    public enum tiposExecuacao{
        LOCAL,
        GRID,
    }
    public enum navegadores{
        CHROME,
        FIREFOX,
        IE
    }

}
