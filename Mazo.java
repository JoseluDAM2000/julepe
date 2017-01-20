import java.util.ArrayList;
import java.util.Random;
import java.util.Collections;
/**
 * 
 */
public class Mazo
{
    // Coleccion que almacena todas las cartas de la baraja española;
    private ArrayList<Carta> mazo;
    // Variable que nos permite llamar a un numero aleatorio.
    private Random aleatorio;
    /**
     * Constructor para objetos de la clase Mazo
     */
    public Mazo()
    {
        mazo = new ArrayList<Carta>();
        aleatorio = new Random();
        for(int palo = 0; palo < 4; palo++){
            for(int valor = 1; valor < 11; valor++){
                switch(valor){
                    case 8:
                    Carta sota = new Carta(10, palo);
                    mazo.add(sota);
                    continue;
                    case 9:
                    Carta caballo = new Carta(11, palo);
                    mazo.add(caballo);
                    continue;
                    case 10:
                    Carta rey = new Carta(12, palo);
                    mazo.add(rey);
                    continue;
                    default:
                    Carta carta = new Carta(valor, palo);
                    mazo.add(carta);
                }
            }
        }
    }

    /**
     * Muestra el contenido del mazo.
     */
    public void verCartasDelMazo()
    {
        for(Carta carta: mazo){
            System.out.println(carta);
        }
    }
    
    /**
     * Mezcla las cartas existentes 
     * en el mazo de manera aleatoria.
     */
    public void barajarMal()
    {
        int posicionTemporal = 0;
        int cartasBarajadas = 0;
        Carta[] mazoAyuda = new Carta[mazo.size()];
        ArrayList posicionesOcupadas = new ArrayList();
        while(cartasBarajadas < mazo.size()){
            posicionTemporal = aleatorio.nextInt(mazo.size());
            if(!posicionesOcupadas.contains(posicionTemporal)){
                mazoAyuda[posicionTemporal] = mazo.get(cartasBarajadas);
                posicionesOcupadas.add(posicionTemporal);
                cartasBarajadas++;
            }
        }
        for(int i = 0; i < mazo.size(); i++){
            mazo.set(i, mazoAyuda[i]);
        }
    }
    
    /**
     * Metodo que devuelve la primera carta del mazo;
     */
    public Carta sacarCarta()
    {
        Carta cartaSacada = mazo.get(0);
        mazo.remove(0);
        return cartaSacada;
    }
}
