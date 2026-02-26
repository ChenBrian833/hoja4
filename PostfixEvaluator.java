

import stack.IStack;

/**
 * PostfixEvaluator - Evalúa una expresión en notación postfix.
 * Usa un IStack<Double> provisto por StackFactory.
 */
public class PostfixEvaluator {

    private final IStack<Double> stack;

    public PostfixEvaluator(IStack<Double> stack) {
        this.stack = stack;
    }

    public double evaluate(String postfix) {
        String[] tokens = postfix.trim().split("\\s+");

        for (String token : tokens) {
            if (isOperand(token)) {
                stack.push(Double.parseDouble(token));
            } else if (isOperator(token)) {
                double b = stack.pop();
                double a = stack.pop();
                stack.push(applyOperator(token, a, b));
            } else {
                throw new IllegalArgumentException("Token desconocido: " + token);
            }
        }

        if (stack.size() != 1) throw new RuntimeException("Expresión postfix inválida.");
        return stack.pop();
    }

    private boolean isOperand(String t) {
        try { Double.parseDouble(t); return true; }
        catch (NumberFormatException e) { return false; }
    }

    private boolean isOperator(String t) {
        return t.equals("+") || t.equals("-") ||
               t.equals("*") || t.equals("/") || t.equals("^");
    }

    private double applyOperator(String op, double a, double b) {
        switch (op) {
            case "+": return a + b;
            case "-": return a - b;
            case "*": return a * b;
            case "/":
                if (b == 0) throw new ArithmeticException("División por cero.");
                return a / b;
            case "^": return Math.pow(a, b);
            default:  throw new IllegalArgumentException("Operador desconocido: " + op);
        }
    }
}
