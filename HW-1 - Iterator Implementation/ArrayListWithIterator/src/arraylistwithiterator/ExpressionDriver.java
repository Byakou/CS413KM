package arraylistwithiterator;

import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class ExpressionDriver {
    private static final String INFIX_EXPRESSION = "(a+b)*(c+d)";
    private static final String POSTFIX_EXPRESSION = "ab+cd*+"; // Corrected postfix expression

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Map<Character, Double> identifierValues = new HashMap<>();

        boolean continueEvaluation = true;
        while (continueEvaluation) {
            getIdentifierValues(input, identifierValues);

            double infixResult = InfixEvaluator.evaluateInfix(INFIX_EXPRESSION, identifierValues);
            double postfixResult = PostfixEvaluator.evaluatePostfix(POSTFIX_EXPRESSION, identifierValues);

            printResults(infixResult, postfixResult, identifierValues);

            System.out.print("Evaluate another expression? (yes/no): ");
            continueEvaluation = input.nextLine().equalsIgnoreCase("yes");
        }

        input.close();
    }

    private static void getIdentifierValues(Scanner input, Map<Character, Double> identifierValues) {
        identifierValues.clear(); // Clear for each evaluation
        for (char identifier : "abcd".toCharArray()) {
            System.out.print("Enter the value for " + identifier + ": ");
            identifierValues.put(identifier, input.nextDouble());
            input.nextLine(); // Consume newline character
        }
    }

    private static void printResults(double infixResult, double postfixResult,
            Map<Character, Double> identifierValues) {
        // ... Formatting the output as specified
    }
}