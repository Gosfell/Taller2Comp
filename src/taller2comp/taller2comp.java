package taller2comp;
/**
 *
 * @author Mendoza-Diego_Muñoz-Tomas_Torres-Sebastian
 */

import javax.swing.JOptionPane; 
public class taller2comp {
    public static void main(String[] args) {
        int opcion = 0;
        
        String nombre, significado, clasificacion, encontrar, eliminar;
        Arbol diccionario = new Arbol();
         //Ingresamos palabras a los nodos del arbol
        diccionario.agregarNodo("arquitectura", "Arte y técnica de diseñar, proyectar y construir edificios y espacios públicos.", "Sustantivo");
        diccionario.agregarNodo("comunicacion", "Transmisión de señales mediante un código común al emisor y al receptor.", "Sustantivo");
        diccionario.agregarNodo("complejo", "Que es difícil de comprender o de resolver por estar compuesto de muchos aspectos.", "Sustantivo");
        diccionario.agregarNodo("arbol" , "Planta perenne , de tronco leñoso y elevado, que se ramifica a cierta altura del suelo.","Sustantivo");
        diccionario.agregarNodo("algoritmo" , "Conjunto ordenado de operaciones sistemáticas que permite hacer un cálculo y hallar la solución de un tipo de problemas.","Sustantivo");
        diccionario.agregarNodo("programar","Dar las instrucciones necesarias a una máquina o aparato para que realice su función de manera automática.","Verbo");
        diccionario.agregarNodo("nodo","Cada uno de los puntos de un cuerpo vibrante que permanecen fijos.","Sustantivo");
        diccionario.agregarNodo("organizar","Preparar una cosa pensando detenidamente en todos los detalles necesarios para su buen desarrollo.","Verbo");
        diccionario.agregarNodo("el","Se utiliza ante nombres cuyos referentes son conocidos por el hablante o el oyente, bien porque ha sido nombrado en el discurso previo, bien porque su existencia se puede presuponer","Articulo");
        diccionario.agregarNodo("mostrar","Exponer una cosa de forma que pueda ser vista por alguien con detenimiento.","Verbo");
        
        //menu 
        do{
            try {
                opcion = Integer.parseInt(JOptionPane.showInputDialog(null,
                        "1. Agregar palabra\n"
                        + "2. Buscar palabra\n"
                        + "3. Eliminar palabra\n"
                        + "4. Mostrar diccionario de palabras\n"
                        + "5. Salir \n"
                        + "Elige una opcion: ", "arbol binario de texto", JOptionPane.QUESTION_MESSAGE));

                switch (opcion) {
                    case 1: //para agregar una palabra

                        nombre = JOptionPane.showInputDialog(null, "Ingrese la palabra que desea agregar ", "Agregando palabra", JOptionPane.QUESTION_MESSAGE);
                        significado = JOptionPane.showInputDialog(null, "Ingrese el significado de la palabra ", "Agregando significado", JOptionPane.QUESTION_MESSAGE);
                        clasificacion = JOptionPane.showInputDialog(null, "Ingrese la clasificacion de la palabra(artículo, verbo o sustantivo) ", "Agregando clasificacion", JOptionPane.QUESTION_MESSAGE);
                        
                        diccionario.agregarNodo(nombre, significado, clasificacion); //para recibir las variables entregadas por el usuario

                        break;
                    case 2: // para buscar una palabra
                        System.out.print("");
                        encontrar = JOptionPane.showInputDialog(null, "Ingrese la palabra que desea buscar ", "Buscando palabra", JOptionPane.QUESTION_MESSAGE);
                        nodoarbol found = diccionario.find(encontrar);
                        if (found != null) {
                            System.out.println("Palabra encontrada exitosamente");
                            found.displayNode();
                            System.out.print("\n");
                        } else {
                            System.out.print("No se pudo encontrar la palabra ");
                        }
                        System.out.print(encontrar + '\n');
                        break;

                    case 3: // para eliminarr una palabra
                        System.out.print("");
                        eliminar = JOptionPane.showInputDialog(null, "Ingrese la palabra que desea Eliminar", "Eliminando palabra", JOptionPane.QUESTION_MESSAGE);
                        boolean didDelete = diccionario.delete(eliminar);
                        if (didDelete) {
                            System.out.print("Eliminado: " + eliminar);
                        } else {
                            System.out.print("No se pudo encontrar la palabra ");
                        }
                        System.out.print(eliminar + '\n');
                        break;

                    case 4: //para mostrar arbol diccionario completo
                        if (!diccionario.arbolVacio()) {
                            System.out.println("Diccionario:");
                            diccionario.inOrden(diccionario.raiz);

                        } else {
                            JOptionPane.showInputDialog(null, "El diccionario esta vacio", JOptionPane.QUESTION_MESSAGE);
                        }
                        break;
                        
                    case 5: //salir del menu
                        JOptionPane.showMessageDialog(null, "Aplicacion finalizada ", "Fin", JOptionPane.INFORMATION_MESSAGE);
                        break;
                    default:
                        JOptionPane.showInputDialog(null, "Opcion incorrecta", JOptionPane.QUESTION_MESSAGE);
                        break;


                }
            } catch (NumberFormatException n) { //mensaje de error
                if ("null".equals(n.getMessage())) {
                    break;
                } else {
                    JOptionPane.showMessageDialog(null, "Error" + n.getMessage());
                }
            }
        } while (opcion != 5);
    }
}
