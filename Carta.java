
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

    /**
     * Recibe una carta por parametro y un entero que indica 
     * el palo, el metodo devuelve true en caso de que la 
     * carta sea superior a la carta pasada como parametro.
     */
    public boolean ganaA(Carta cartaRival, int paloQuePinta)
    {
        boolean retorno = true;
        int[] numeros={0, 12, 1, 11, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int paloRival = cartaRival.getPalo();
        if(paloQuePinta == palo){
            if(paloQuePinta == paloRival){
                retorno = numeros[cartaRival.getValor()] < numeros[valor];
            }else{
                retorno = true;
            }
        }else{
            if(palo == paloRival){
                retorno = numeros[cartaRival.getValor()] < numeros[valor];
            }else if(paloRival == paloQuePinta){
                retorno = false;
            }
        }
        return retorno;
    }
}
