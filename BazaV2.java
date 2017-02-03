import java.util.ArrayList;

/**
 * Write a description of class Baza here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BazaV2
{
    // Atributo que almacena la carta que es baza.
    private Carta[] baza;
    // Atributo que almacena el palo que pinta.
    private int paloQuePinta;
    // Atributo que almacena la carta que gana.
    private Carta cartaQueGana;
    // Atributo que almacena el jugador que gana.
    private String jugadorQueGana;
    
    /**
     * Constructor for objects of class BazaV2
     */
    public BazaV2(int numeroJugadores, int paloQuePinta)
    {
        baza = new Carta[numeroJugadores];
        this.paloQuePinta = paloQuePinta;
        cartaQueGana = null;
        jugadorQueGana = "";
    }
    
    /**
     * Metodo que recibe el nombre del jugador y una carta la cual almacena.
     */
    public void addCarta(Carta cartaTirada, String nombreJugador)
    {
        baza[cartasEnBaza()] = cartaTirada;
        if(cartaQueGana == null || cartaTirada.ganaA(cartaQueGana, paloQuePinta)){
            cartaQueGana = cartaTirada;
            jugadorQueGana = nombreJugador;
        }
    }
    
    /**
     * Devuelve el palo de la primera carta tirada 
     * o -1 en caso de que no haya cartas.
     */
    public int getPaloPrimeraCartaDeLaBaza()
    {
        int palo = -1;
        if(baza[0] != null){
            palo = baza[0].getPalo();
        }
        return palo;
    }
    
    /**
     * Devuelve la carta que va ganando la baza o null si no hay cartas aun.
     */
    public Carta cartaQueVaGanandoLaBaza()
    {
        return cartaQueGana;
    }
    
    /**
     * Devuelve el nombre del jugador que va ganando la baza en el momento actual.
     */
    public String nombreJugadorQueVaGanandoLaBaza()
    {
        return jugadorQueGana;
    }
    
    /**
     * Devuelve cuantas cartas hay en la baza.
     */
    private int cartasEnBaza()
    {
        int contador = 0;
        for(Carta carta : baza){
            if(carta != null){
                contador++;
            }
        }
        return contador;
    }
}
