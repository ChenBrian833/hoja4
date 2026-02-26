public class InfixToPostfix {

    private final IStack<String> stack;

    public InfixToPostfix(IStack<String> stack) {
        this.stack = stack;
    }

    public String convert(String infix) {
        StringBuilder postfix = new StringBuilder();
        String[] tokens = tokenize(infix);

        for (String token : tokens) {
            if (isOperand(token)) {
                postfix.append(token).append(" ");

            } else if (token.equals("(")) {
                stack.push(token);

            } else if (token.equals(")")) {
                while (!stack.isEmpty() && !stack.peek().equals("(")) {
                    postfix.append(stack.pop()).append(" ");
                }
                if (!stack.isEmpty()) stack.pop();

            } else if (isOperator(token)) {
                while (!stack.isEmpty()
                        && isOperator(stack.peek())
                        && precedence(stack.peek()) >= precedence(token)) {
                    postfix.append(stack.pop()).append(" ");
                }
                stack.push(token);
            }
        }

        while (!stack.isEmpty()) {
            postfix.append(stack.pop()).append(" ");
        }

        return postfix.toString().trim();
    }

    private String[] tokenize(String expr) {
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
