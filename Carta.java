
/**
 * Write a description of class Carta here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Carta
{
    // Atributo que almacena el valor de la carta
    private int valor;
    // Atributo que almacena el palo al que corresponde la carta: 0 es oros, 1 es copas, 2 es espadas y 3 es bastos.
    private int palo;
    /**
     * Constructor for objects of class Carta.
     */
    public Carta(int valor, int palo)
    {
        this.valor = valor;
        this.palo = palo;
    }

    /**
     * Metodo que devuelve en forma de 
     * string el valor y el palo de la carta.
     */
    public String toString()
    {
        String carta = "";
        switch (valor){
            case 1:
            carta += "as";
            break;
            case 10:
            carta += "sota";
            break;
            case 11:
            carta += "caballo";
            break;
            case 12:
            carta += "rey";
            break;
            default:
            carta += valor;
        }
        switch (palo){
            case 0:
            carta += " de oros";
            break;
            case 1:
            carta += " de copas";
            break;
            case 2:
            carta += " de espadas";
            break;
            case 3:
            carta += " de bastos";
        }
        return carta;
    }
    
    /**
     * Devuelve el valor de la carta.
     */
    public int getValor()
    {
        return valor;
    }
    
    /**
     * Devuelve el valor que corresponde 
     * al palo de la carta;
     */
    public int getPalo()
    {
        return palo;
    }
}
