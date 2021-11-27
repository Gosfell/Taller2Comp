package taller2comp;
/**
 *
 * @author Mendoza-Diego_Muñoz-Tomas_Torres-Sebastian
 */
//clase para crear el nodo

public class nodoarbol {

    String nombre;
    String significado;
    String clasificacion;
    nodoarbol hizquierdo, hderecho;

    public nodoarbol(String nom, String sig, String clasi) {
        this.nombre = nom; // llave/nombre de la palabra
        this.significado = sig; // significado de la palabra
        this.clasificacion = clasi; // clasificacion de la palabra
        this.hizquierdo = null; // hijo izquierdo de este nodo
        this.hderecho = null; // hijo derecho de este nodo
    }

    public void displayNode() // metodo para mostrar el nodo palabra en pantalla
    {
        System.out.print(nombre + "." + clasificacion + ": \n " + significado);

    }

    @Override 
    public String toString() {
        String msj = "\n Palabra: " + nombre + "\n Significado: " + significado + "\n clasificacion: " + clasificacion;
        return msj;
    }
}
