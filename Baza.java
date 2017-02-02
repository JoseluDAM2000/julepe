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
    private ArrayList<Carta> baza;
    // Atributo que almacena el palo que pinta.
    private int paloQuePinta;
    /**
     * Constructor for objects of class Baza
     */
    public Baza(int numeroJugadores, int paloQuePinta)
    {
        baza = new ArrayList<Carta>();
        this.paloQuePinta = paloQuePinta;
    }
    
    /**
     * Metodo que recibe el nombre del jugador y una carta la cual almacena.
     */
    public void addCarta(Carta cartaTirada, String nombreJugador)
    {
        baza.add(cartaTirada);
    }
    
    /**
     * Devuelve el palo de la primera carta tirada 
     * o -1 en caso de que no haya cartas.
     */
    public int getPaloPrimeraCartaDeLaBaza()
    {
        int palo = -1;
        if(baza.size() != 0){
            palo = baza.get(0).getPalo();
        }
        return palo;
    }
    
    /**
     * 
     */
    public Carta cartaQueVaGanandoLaBaza()
    {
        Carta cartaQueGana = null;
        if(baza.size() != 0){
            cartaQueGana = baza.get(0);
            for(int i=1; i < baza.size(); i++){
                Carta cartaAspirante = baza.get(i);
                if(cartaAspirante.ganaA(cartaQueGana, paloQuePinta)){
                    cartaQueGana = cartaAspirante;
                }
            }
        }
        return cartaQueGana;
    }
}
