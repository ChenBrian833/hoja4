import java.util.Scanner;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        System.out.println("==========================================");
        System.out.println("  Evaluador de Expresiones Infix - HT4");
        System.out.println("==========================================\n");

        // 1. Leer expresión de datos.txt
        String infix = readFromFile("datos.txt");
        System.out.println("Expresión leída: " + infix + "\n");

        // 2. Selección de implementación de pila
        Scanner sc = new Scanner(System.in);
        System.out.println("Seleccione implementación de pila:");
        System.out.println("  arraylist  → ArrayListStack");
        System.out.println("  vector     → VectorStack");
        System.out.println("  list       → ListStack (basada en lista)");
        System.out.print("Opción: ");
        String stackType = sc.nextLine().trim().toLowerCase();

        // 3. Si eligió lista, pedir tipo de lista
        String listType = "";
        if (stackType.equals("list")) {
            System.out.println("\nSeleccione implementación de lista:");
            System.out.println("  singly → Lista simplemente encadenada");
            System.out.println("  doubly → Lista doblemente encadenada");
            System.out.print("Opción: ");
            listType = sc.nextLine().trim().toLowerCase();
        }

        // StackFactory crea la pila de operadores para conversión
        IStack<String> opStack = StackFactory.createStack(stackType, listType);
        // StackFactory crea la pila de operandos para evaluación
        IStack<Double> evalStack = StackFactory.createStack(stackType, listType);

        System.out.println();

        // 4. Convertir infix → postfix
        InfixToPostfix converter = new InfixToPostfix(opStack);
        String postfix = converter.convert(infix);
        System.out.println("Expresión postfix: " + postfix);

        // 5. Evaluar postfix
        PostfixEvaluator evaluator = new PostfixEvaluator(evalStack);
        double result = evaluator.evaluate(postfix);
        System.out.printf("Resultado: %.2f%n", result);

        sc.close();
    }

    private static String readFromFile(String filename) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line = reader.readLine();
        reader.close();
        if (line == null || line.trim().isEmpty()) {
            throw new IOException("datos.txt está vacío.");
        }
        return line.trim();
    }
}
