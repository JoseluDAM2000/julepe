import java.util.Random;

/**
 * Write a description of class Jugador here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Jugador
{
    // Atributo que almacena el nombre del jugador.
    private String nombre;
    // Array que almacena las cartas que tiene el jugador.
    private Carta[] mano;
    // Array que almacena las bazas que ha ganado el jugador.
    private Baza[] bazasGanadas;
    // Atributo que almacena cuantas bazas has ganado.
    int numeroBazasGanadas;

    /**
     * Constructor for objects of class Jugador
     */
    public Jugador(String nombre)
    {
        this.nombre = nombre;
        mano = new Carta[5];
        bazasGanadas = new Baza[5];
        numeroBazasGanadas = 0;
    }

    /**
     * Recibe una carta y la guarda en la mano.
     */
    public void recibirCarta(Carta carta)
    {
        boolean cartaRecibida = false;
        int index = 0;
        while(index < mano.length && !cartaRecibida){
            if(mano[index] == null){
                mano[index] = carta;
                cartaRecibida = true;
            }
            index++;
        }
    }

    /**
     * Muestra la mano del jugador.
     */
    public void verCartasJugador()
    {
        for(int index = 0;index < mano.length ; index++){
            if(mano[index] != null){
                System.out.println(mano[index]);
            }
        }
    }

    /**
     * Devuelve la cantidad de cartas 
     * que tiene el jugador en mano.
     */
    public int cartasEnMano()
    {
        int cartasEnMano = 0;
        for(Carta carta : mano){
            if(carta != null){
                cartasEnMano++;
            }
        }
        return cartasEnMano;
    }

    /**
     * Devuelve el nombre del jugador.
     */
    public String getNombre()
    {
        return nombre;
    }

    /**
     * Devuelve carta indicada por parametro, en 
     * caso de no tener la carta indicada devuelve null.
     */
    public Carta tirarCarta(String cartaATirar)
    {
        Carta cartaADevolver = null;
        if(cartasEnMano() != 0){
            int contador = 0;
            boolean buscando = true;
            while(contador < mano.length && buscando){
                Carta carta = mano[contador];
                if(carta != null && carta.toString().equals(cartaATirar)){
                    cartaADevolver = carta;
                    mano[contador] = null;
                    buscando = false;
                    System.out.println("El jugador " + nombre + " ha tirado la carta " + cartaADevolver);
                }
                contador++;
            }
        }
        return cartaADevolver;
    }
    
    /**
     * Devuelve una carta aleatoria de la mano, en 
     * caso de no tener cartas devuelve null.
     */
    public Carta tirarCartaAleatoria()
    {
        Carta cartaADevolver = null;
        if(cartasEnMano() != 0){
            Random aleatorio = new Random();
            while(cartaADevolver == null){
                int posicion = aleatorio.nextInt(mano.length);
                cartaADevolver = mano[posicion];
                mano[posicion] = null;
            }
            System.out.println("El jugador " + nombre + " ha tirado la carta " + cartaADevolver);
        }
        return cartaADevolver;
    }
    
    /**
     * Metodo que recibe los parametros necesarios para que el jugador pueda decidir que carta debe tirar.
     */
    public Carta tirarCartaInteligentemente(int paloPrimeraCarta, Carta cartaQueVaGanando, int paloQuePinta)
    {
        return tirarCartaAleatoria();
    }
    
    /**
     * Añade la baza obtenida por parametro al array que almacena las bazas ganadas.
     */
    public void addBaza(Baza baza)
    {
        bazasGanadas[numeroBazasGanadas] = baza;
        numeroBazasGanadas++;
    }
    
    /**
     * Devuelve el numero de bazas ganadas.
     */
    public int getNumeroBazasGanadas()
    {
        return numeroBazasGanadas;
    }
}
