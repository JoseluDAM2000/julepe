import java.util.ArrayList;
import java.util.Random;

/**
 * Write a description of class Juego here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Juego
{
    // Atributo que almacena el mazo.
    private Mazo mazo;
    // Atributo que almacena la lista de posibles nombres.
    private ArrayList<String> nombres;
    // Array que almacena los jugadores
    private Jugador[] jugadores;
    // Atributo que almacena el palo que pinta
    private int paloQuePinta;
    // Array
    private String[] nombreJugadores;

    /**
     * Constructor for objects of class Juego
     */
    public Juego(int cantidadJugadores)
    {
        nombres = new ArrayList<String>();
        crearListaNombres();
        Random aleatorio = new Random();
        nombreJugadores = new String[cantidadJugadores];
        jugadores = new Jugador[cantidadJugadores];
        for(int i = 0; i < cantidadJugadores; i++){
            int index = aleatorio.nextInt(nombres.size());
            nombreJugadores[i] = nombres.remove(index);
            Jugador jugador = new Jugador(nombreJugadores[i]);
            jugadores[i] = jugador;
        }
        mazo = new Mazo();
        mazo.barajar();
        paloQuePinta = 0;
    }

    /**
     * 
     */
    public void verCartasJugador(String nombreJugador)
    {
        int contador = 0;
        boolean buscando = true;
        while(contador < jugadores.length && buscando){
            if(nombreJugadores[contador].equals(nombreJugador)){
                jugadores[contador].verCartasJugador();
                buscando = false;
            }
            contador++;
        }
    }

    /**
     * 
     */
    public void repartir()
    {
        for(Jugador jugador : jugadores){
            for(int i = 0; i < 5; i++){
                Carta carta = mazo.sacarCarta();
                jugador.recibirCarta(carta);
                if(i == 4){
                    paloQuePinta = carta.getPalo();
                }
            }
        }
    }

    /**
     * Lista que almacena los nombres de los posibles jugadores.
     */
    private void crearListaNombres()
    {
        nombres.add("Perico");
        nombres.add("Maria");
        nombres.add("Eustaquio");
        nombres.add("Francisca");
        nombres.add("Mariano");
        nombres.add("Pepa");
        nombres.add("Juan");
        nombres.add("Esmeralda");
        nombres.add("Roberto");
        nombres.add("Cristina");
    }
}
