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

    /**
     * Constructor for objects of class Baza
     */
    public Baza(int numeroJugadores, int paloQuePinta)
    {
        baza = new ArrayList<Carta>();
    }
    
    /**
     * Metodo que recibe el nombre del jugador y una carta la cual almacena.
     */
    public void addCarta(Carta cartaTirada, String nombreJugador)
    {
        baza.add(cartaTirada);
    }
}
