import java.util.ArrayList;

/**
 * Write a description of class Baza here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Baza
{
    // Atributo que almacena la carta que es baza.
    private Carta[] baza;
    // Atributo que almacena en orden los jugadores que han tirado cartas.
    private String[] jugadores;
    // Atributo que almacena el palo que pinta.
    private int paloQuePinta;
    /**
     * Constructor for objects of class Baza
     */
    public Baza(int numeroJugadores, int paloQuePinta)
    {
        baza = new Carta[numeroJugadores];
        jugadores = new String[numeroJugadores];
        this.paloQuePinta = paloQuePinta;
    }
    
    /**
     * Metodo que recibe el nombre del jugador y una carta la cual almacena.
     */
    public void addCarta(Carta cartaTirada, String nombreJugador)
    {
        int index = cartasEnBaza();
        baza[index] = cartaTirada;
        jugadores[index] = nombreJugador;
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
        Carta cartaQueGana = null;
        if(cartasEnBaza() != 0){
            cartaQueGana = baza[0];
            for(int i=1; i < cartasEnBaza(); i++){
                Carta cartaAspirante = baza[i];
                if(cartaAspirante.ganaA(cartaQueGana, paloQuePinta)){
                    cartaQueGana = cartaAspirante;
                }
            }
        }
        return cartaQueGana;
    }
    
    /**
     * Devuelve el nombre del jugador que va ganando la baza en el momento actual.
     */
    public String nombreJugadorQueVaGanandoLaBaza()
    {
        String nombreJugador = "";
        int index = 0;
        boolean buscando = true;
        while(index < cartasEnBaza() && buscando){
            if(baza[index].equals(cartaQueVaGanandoLaBaza())){
                nombreJugador = jugadores[index];
                buscando = false;
            }
            index++;
        }
        return nombreJugador;
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
