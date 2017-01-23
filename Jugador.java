
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

    /**
     * Constructor for objects of class Jugador
     */
    public Jugador(String nombre)
    {
        this.nombre = nombre;
        mano = new Carta[5];
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
}
