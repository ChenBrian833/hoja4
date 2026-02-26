

import stack.IStack;

/**
 * InfixToPostfix - Convierte una expresión infix a postfix
 * usando el algoritmo de la Hoja 4 (Shunting-yard).
 *
 * Soporta: +  -  *  /  ^  y paréntesis ( )
 * Soporta números multi-dígito separando tokens.
 */
public class InfixToPostfix {

    private final IStack<String> stack;

    public InfixToPostfix(IStack<String> stack) {
        this.stack = stack;
    }

    public String convert(String infix) {
        StringBuilder postfix = new StringBuilder();
        // Tokenize: separa números multi-dígito de operadores
        String[] tokens = tokenize(infix);

        for (String token : tokens) {
            if (isOperand(token)) {
                postfix.append(token).append(" ");

            } else if (token.equals("(")) {
                stack.push(token);

            } else if (token.equals(")")) {
                // Pop hasta encontrar '('
                while (!stack.isEmpty() && !stack.peek().equals("(")) {
                    postfix.append(stack.pop()).append(" ");
                }
                if (!stack.isEmpty()) stack.pop(); // elimina '('

            } else if (isOperator(token)) {
                // Pop operadores de mayor o igual precedencia
                while (!stack.isEmpty()
                        && isOperator(stack.peek())
                        && precedence(stack.peek()) >= precedence(token)) {
                    postfix.append(stack.pop()).append(" ");
                }
                stack.push(token);
            }
        }

        // Vaciar pila restante
        while (!stack.isEmpty()) {
            postfix.append(stack.pop()).append(" ");
        }

        return postfix.toString().trim();
    }

    private String[] tokenize(String expr) {
        // Inserta espacios alrededor de operadores y paréntesis
        String spaced = expr.replaceAll("([+\\-*/^()])", " $1 ");
        return spaced.trim().split("\\s+");
    }

    private boolean isOperand(String token) {
        try { Double.parseDouble(token); return true; }
        catch (NumberFormatException e) { return false; }
    }

    private boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") ||
               token.equals("*") || token.equals("/") ||
               token.equals("^");
    }

    private int precedence(String op) {
        switch (op) {
            case "^": return 3;
            case "*": case "/": return 2;
            case "+": case "-": return 1;
            default: return 0;
        }
    }
}
