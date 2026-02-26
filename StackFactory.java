public class StackFactory {

    public static final String ARRAYLIST = "arraylist";
    public static final String VECTOR    = "vector";
    public static final String LIST      = "list";

    private StackFactory() {}

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
