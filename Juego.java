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
    public Juego(int cantidadJugadores, String jugadorActual)
    {
        nombres = new ArrayList<String>();
        crearListaNombres();
        Random aleatorio = new Random();
        jugadores = new Jugador[cantidadJugadores];
        Jugador usuario = new Jugador(jugadorActual);
        jugadores[0]= usuario;
        String nombresActuales = "";
        for(int i = 1; i < cantidadJugadores; i++){
            int index = aleatorio.nextInt(nombres.size());
            String nombreActual = nombres.remove(index);
            Jugador jugador = new Jugador(nombreActual);
            jugadores[i] = jugador;
            nombresActuales += nombreActual + " ";
        }
        mazo = new Mazo();
        mazo.barajar();
        paloQuePinta = 0;
        System.out.println("Bienvenido " + jugadorActual);
        System.out.println("Tus rivales en esta partida serán");
        System.out.println(nombresActuales);
    }

    /**
     * Muestra las cartas del jugador especificado por parametro.
     */
    public void hacerTrampasYVerCartasDeJugador(String nombreJugador)
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
    public int repartir()
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
        System.out.println("Pintan " + palo(paloQuePinta));
        System.out.println("Tus cartas son:");
        verCartasJugadorHumano();
        return paloQuePinta;
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
    
    /**
     * Devuelve un string con el valor del palo indicado por parametro.
     */
    private String palo(int palo)
    {
        String paloQuePinta = "";
        switch(palo){
            case 0:
            paloQuePinta = "oros";
            break;
            case 1:
            paloQuePinta = "copas";
            break;
            case 2:
            paloQuePinta = "espadas";
            break;
            case 3:
            paloQuePinta = "bastos";
            break;
        }
        return paloQuePinta;
    }
    
    /**
     * Muestra Las cartas del jugador humano.
     */
    public void verCartasJugadorHumano()
    {
        jugadores[0].verCartasJugador();
    }
}
