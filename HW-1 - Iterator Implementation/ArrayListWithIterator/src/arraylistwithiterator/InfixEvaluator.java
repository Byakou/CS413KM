package arraylistwithiterator;

import java.util.Stack;

public class InfixEvaluator {
    public static double evaluateInfix(String expression, Map<Character, Double> identifierValues) {
        Stack<Double> valueStack = new Stack<>();
        Stack<Character> operatorStack = new Stack<>();

        for (char token : expression.toCharArray()) {
            if (isOperand(token)) {
                valueStack.push(identifierValues.get(token));
            } else if (isOperator(token)) {
                // ... Logic to handle operators based on precedence
            } else if (token == '(') {
                operatorStack.push(token);
            } else if (token == ')') {
                // ... Logic to process operators within parentheses
            }
        }

        // ... Final processing of any remaining operators

        return valueStack.pop(); // Assuming a single value remains as the result
    }

    private static boolean isOperand(char token) {
        // ... Implement logic to identify operands (likely identifiers a-z)
    }

    private static boolean isOperator(char token) {
        // ... Implement logic to identify operators (+, -, *, /, etc.)
    }

    //
}
