package contabancaria;

public class Cores {
    // Cores de texto pastéis (8-bit)
    public static final String PASTEL_ROSA = "\u001B[38;5;218m";    // Rosa claro
    public static final String PASTEL_AZUL = "\u001B[38;5;153m";    // Azul céu
    public static final String PASTEL_VERDE = "\u001B[38;5;158m";   // Verde água
    public static final String PASTEL_LARANJA = "\u001B[38;5;223m"; // Laranja suave
    public static final String PASTEL_VIOLA = "\u001B[38;5;183m";   // Lavanda
    public static final String PASTEL_CINZA = "\u001B[38;5;250m";   // Cinza claro

    // Estilos de texto
    public static final String RESET = "\u001B[0m";
    public static final String NEGRITO = "\u001B[1m";
    public static final String ITALICO = "\u001B[3m";
    public static final String SUBLINHADO = "\u001B[4m";

    // Método para combinar estilos
    public static String formatar(String texto, String cor, String estilo) {
        return cor + estilo + texto + RESET;
    }
}
