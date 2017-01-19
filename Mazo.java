import java.util.ArrayList;

/**
 * Write a description of class Mazo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Mazo
{
    // instance variables - replace the example below with your own
    private int x;
    // Coleccion que almacena todas las cartas de la baraja española;
    private ArrayList<Carta> mazo;

    /**
     * Constructor for objects of class Mazo
     */
    public Mazo()
    {
        mazo = new ArrayList<Carta>();
        for(int palo = 0; palo < 4; palo++){
            for(int valor = 1; valor < 11; valor++){
                switch(valor){
                    case 8:
                    Carta sota = new Carta(10, palo);
                    mazo.add(sota);
                    break;
                    case 9:
                    Carta caballo = new Carta(11, palo);
                    mazo.add(caballo);
                    break;
                    case 10:
                    Carta rey = new Carta(12, palo);
                    mazo.add(rey);
                    break;
                    default:
                    Carta carta = new Carta(valor, palo);
                    mazo.add(carta);
                }
            }
        }
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public void verCartasDelMazo()
    {
        for(Carta carta: mazo){
            System.out.println(carta);
        }
    }
}
