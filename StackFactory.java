

import stack.IStack;
import stack.ArrayListStack;
import stack.VectorStack;
import stack.ListStack;
import list.IList;

/**
 * StackFactory - Patrón Factory para seleccionar implementación de Pila.
 *
 * Opciones válidas:
 *   "arraylist" → ArrayListStack
 *   "vector"    → VectorStack
 *   "list"      → ListStack (delega a ListFactory para elegir tipo de lista)
 *
 * Si se elige "list", se aplica el patrón Factory nuevamente a través de ListFactory.
 */
public class StackFactory {

    public static final String ARRAYLIST = "arraylist";
    public static final String VECTOR    = "vector";
    public static final String LIST      = "list";

    private StackFactory() {}

    /**
     * Crea un Stack<T> según la decisión del usuario.
     *
     * @param stackType  "arraylist", "vector" o "list"
     * @param listType   "singly" o "doubly" (solo usado si stackType = "list")
     */
    public static <T> IStack<T> createStack(String stackType, String listType) {
        switch (stackType.trim().toLowerCase()) {

            case ARRAYLIST:
                System.out.println("[StackFactory] Creando ArrayListStack");
                return new ArrayListStack<>();

            case VECTOR:
                System.out.println("[StackFactory] Creando VectorStack");
                return new VectorStack<>();

            case LIST:
                System.out.println("[StackFactory] Creando ListStack → delegando a ListFactory");
                IList<T> list = ListFactory.createList(listType);
                return new ListStack<>(list);

            default:
                throw new IllegalArgumentException(
                    "Tipo de pila desconocido: '" + stackType + "'. Use: arraylist, vector, list");
        }
    }
}
