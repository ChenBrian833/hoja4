
import list.IList;
import list.SinglyLinkedList;
import list.DoublyLinkedList;

/**
 * ListFactory - Patrón Factory para seleccionar implementación de Lista.
 *
 * Opciones válidas:
 *   "singly" → SinglyLinkedList
 *   "doubly"  → DoublyLinkedList
 */
public class ListFactory {

    public static final String SINGLY = "singly";
    public static final String DOUBLY = "doubly";

    private ListFactory() {}

    public static <T> IList<T> createList(String type) {
        switch (type.trim().toLowerCase()) {
            case SINGLY:
                System.out.println("  [ListFactory] Creando SinglyLinkedList");
                return new SinglyLinkedList<>();
            case DOUBLY:
                System.out.println("  [ListFactory] Creando DoublyLinkedList");
                return new DoublyLinkedList<>();
            default:
                throw new IllegalArgumentException(
                    "Tipo de lista desconocido: '" + type + "'. Use: singly, doubly");
        }
    }
}
