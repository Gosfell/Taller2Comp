package taller2comp;
/**
 * @author Mendoza-Diego_Muñoz-Tomas_Torres-Sebastian
 */

//Clase para crear el arbol
public class Arbol {

    nodoarbol raiz; // Se crea el nodo raiz del Arbol

    public Arbol() {
        raiz = null; // Se inicializa el nodo creado como nulo
    }

    //Metodo para insertar un nodo en el Arbol
    public boolean arbolVacio() {
        return raiz == null;
    }

    //Metodo para insertar un nodo palabra en el Arbol
    public void agregarNodo(String nom, String sig, String clasi) {
        nodoarbol nuevo = new nodoarbol(nom, sig, clasi); //Se crea un nuevo nodo
        if (raiz == null) { //Si no tiene raiz, el nodo ingresado sera la raiz
            raiz = nuevo; 
        } else { //Recorremos el arbol
            nodoarbol auxiliar = raiz;  //Se crea una variable auxiiar y se iguala a la raiz.
            nodoarbol padre;           
            while (true) {
                padre = auxiliar; //Se iguala la variable padre del tipo nodo al auxiliar
                if (nom.compareToIgnoreCase(auxiliar.nombre) <= 0) { //Si la palabra es menor alfabeticamente
                    auxiliar = auxiliar.hizquierdo; //Se le asigna a la variable auxiliar el valor del hijo izquierdo de auxiliar.
                    if (auxiliar == null) {
                        padre.hizquierdo = nuevo; //Al nodo "padre" se le asigna como hijo izquierdo el nodo "nuevo".
                        return;
                    }
                } else { //En caso de no cumplirse el if
                    auxiliar = auxiliar.hderecho; //Se le asigna a la variable auxiliar el valor del hijo derecho de auxiliar
                    if (auxiliar == null) { //Si el auxiliar es nulo
                        padre.hderecho = nuevo; //Al nodo "padre" se le asigna como hijo derecho  el nodo "nuevo".
                        return;
                    }
                }
            }
        }
    }
//Metodo para encontrar el sucesor de un nodo
    private nodoarbol getSuccessor(nodoarbol delNode) {
        nodoarbol successorParent = delNode;
        nodoarbol successor = delNode;
        nodoarbol current = delNode.hderecho;   // go to right child
        while (current != null) // until no more
        {                                 // left children,
            successorParent = successor;
            successor = current;
            current = current.hizquierdo;      // go to left child
        }
        // if successor not
        if (successor != delNode.hderecho) // right child,
        {                                 // make connections
            successorParent.hizquierdo = successor.hderecho;
            successor.hderecho = delNode.hderecho;
        }
        return successor;
    }
//Metodo para buscar un nodo
    public nodoarbol find(String key) // Encuentra el nodo 
    {                           // (Se asume que es un arbol no vacio)
        nodoarbol current = raiz;               //Empieza en la raiz

        while (key.compareToIgnoreCase(current.nombre) != 0) //Mientras no haya coincidencia
        {
            if (key.compareToIgnoreCase(current.nombre) <= 0) //¿A la izquierda?
            {
                current = current.hizquierdo; //se le asigna al auxiliar el valor de la variable hijo izquierdo de auxiliar 
            }

            else //¿O a la derecha?
            {
                current = current.hderecho; //Se le asigna al auxiliar el valor del hijo derecho de auxiliar
            }

            if (current == null) {  //Si no hay "hijo"
                return null;                 //No encuentra la palabra retorna un valor nulo
            }
        }
        return current; //Si encuentra la palabra retorna el valor encontrado
    }

    public boolean delete(String key) //Elimina el nodo con la llave dada
    {                           //(Asume una lista no vacia)
        
        nodoarbol current = raiz; //Se igualan los auxiliares a la raiz
        nodoarbol parent = raiz;
        boolean isLeftChild = true;

        while (key.compareToIgnoreCase(current.nombre) != 0) //Busca el nodo
        {
            parent = current;
            if (key.compareToIgnoreCase(current.nombre) <= 0) //¿Izquierda?
            {
                isLeftChild = true;
                current = current.hizquierdo;
            } 
            else // ¿Derecha?
            {
                isLeftChild = false;
                current = current.hderecho;
            }
            if (current == null) // end of the line,
            {
                return false;                // didn't find it
            }
        }  // end while
        // found node to delete

        // if no children, simply delete it
        if (current.hizquierdo == null
                && current.hderecho == null) {
            if (current == raiz) // if root,
            {
                raiz = null;                 // tree is empty
            } else if (isLeftChild) {
                parent.hizquierdo = null;     // disconnect
            } else // from parent
            {
                parent.hderecho = null;
            }
        } // if no right child, replace with left subtree
        else if (current.hderecho == null) {
            if (current == raiz) {
                raiz = current.hizquierdo;
            } else if (isLeftChild) {
                parent.hizquierdo = current.hizquierdo;
            } else {
                parent.hderecho = current.hizquierdo;
            }
        } // if no left child, replace with right subtree
        else if (current.hizquierdo == null) {
            if (current == raiz) {
                raiz = current.hderecho;
            } else if (isLeftChild) {
                parent.hizquierdo = current.hderecho;
            } else {
                parent.hderecho = current.hderecho;
            }
        } else // two children, so replace with inorder successor
        {
            // get successor of node to delete (current)
            nodoarbol successor = getSuccessor(current);

            // connect parent of current to successor instead
            if (current == raiz) {
                raiz = successor;
            } else if (isLeftChild) {
                parent.hizquierdo = successor;
            } else {
                parent.hderecho = successor;
            }

            // connect successor to current's left child
            successor.hizquierdo = current.hizquierdo;
        }  // end else two children
        // (successor cannot have a left child)
        return true;                                // success
    }  // end delete()  
    
    
    //Metodo para recorrer arbol inOrden
    public void inOrden(nodoarbol r) {
        if (r != null) {
            inOrden(r.hizquierdo);
            System.out.print("\n" + r.nombre + "." + r.clasificacion + "\n " + r.significado + "\n");
            inOrden(r.hderecho);
        }
    }
}
