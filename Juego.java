import java.util.ArrayList;
import java.util.Random;

/**
 * 
 */
public class Juego
{
    // Atributo que almacena el mazo.
    private Mazo mazo;
    // Atributo que almacena la lista de posibles nombres.
    private ArrayList<String> nombres;
    // Array que almacena los jugadores.
    private Jugador[] jugadores;
    // Atributo que almacena el palo que pinta.
    private int paloQuePinta;

    /**
     * Constructor for objects of class Juego.
     */
    public Juego(int cantidadJugadores)
    {
        nombres = new ArrayList<String>();
        crearListaNombres();
        Random aleatorio = new Random();
        jugadores = new Jugador[cantidadJugadores];
        for(int i = 0; i < cantidadJugadores; i++){
            int index = aleatorio.nextInt(nombres.size());
            Jugador jugador = new Jugador(nombres.remove(index));
            jugadores[i] = jugador;
        }
        mazo = new Mazo();
        mazo.barajar();
        paloQuePinta = 0;
    }

    /**
     * Muestra las cartas del jugador especificado por parametro.
     */
    public void verCartasJugador(String nombreJugador)
    {
        int contador = 0;
        boolean buscando = true;
        while(contador < jugadores.length && buscando){
            Jugador jugador = jugadores[contador];
            if(jugador.getNombre().equals(nombreJugador)){
                jugadores[contador].verCartasJugador();
                buscando = false;
            }
            contador++;
        }
    }

    /**
     * Reparte 5 cartas a todos los jugadores.
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
