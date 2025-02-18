package contabancaria;

public class Cores {

    public static final String PASTEL_ROSA = "\u001B[38;5;218m";    
    public static final String PASTEL_AZUL = "\u001B[38;5;153m";    
    public static final String PASTEL_VERDE = "\u001B[38;5;158m";   
    public static final String PASTEL_LARANJA = "\u001B[38;5;223m"; 
    public static final String PASTEL_VIOLA = "\u001B[38;5;183m";   
    public static final String PASTEL_CINZA = "\u001B[38;5;250m";   

    public static final String RESET = "\u001B[0m";
    public static final String NEGRITO = "\u001B[1m";
    public static final String ITALICO = "\u001B[3m";
    public static final String SUBLINHADO = "\u001B[4m";

    public static String formatar(String texto, String cor, String estilo) {
        return cor + estilo + texto + RESET;
    }
}
