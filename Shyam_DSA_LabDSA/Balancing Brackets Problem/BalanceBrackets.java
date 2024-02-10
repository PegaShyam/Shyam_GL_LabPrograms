import java.util.HashSet;
import java.util.Set;
import java.util.Stack;
import java.util.Scanner;

public class BalanceBrackets {

    String expression;

    public BalanceBrackets(String expression) {
        this.expression = expression;
    }

    public void check() {
        Stack<Character> stack = new Stack<>();

        int length = expression.length();

        if (length % 2 != 0) {
            System.out.println("Invalid Expression : Number of characters is ODD");
            return;
        }

        for (int index = 0; index < length; index++) {
            char visitedChar = expression.charAt(index);

            if (isOpenBracket(visitedChar)) {
                stack.push(visitedChar);
            } else if (isClosedBracket(visitedChar)) {
                if (stack.isEmpty()) {
                    System.out.println("Non-matching Bracket");
                    return;
                }

                char poppedItem = stack.pop();
                if (!isMatching(poppedItem, visitedChar)) {
                    System.out.println("Non-matching Bracket");
                    return;
                }
            } else {
                System.out.println("Invalid Characters Found: " + visitedChar);
                return;
            }
        }

        if (stack.isEmpty()) {
            System.out.println("The entered String has Balanced Brackets");
        } else {
            System.out.println("The entered String does not contain Balanced Brackets");
        }
    }

    boolean isOpenBracket(char bracket) {
        return bracket == '(' || bracket == '[' || bracket == '{' || bracket == '<';
    }

    boolean isClosedBracket(char bracket) {
        return bracket == ')' || bracket == ']' || bracket == '}' || bracket == '>';
    }

    boolean isMatching(char openBracket, char closeBracket) {
        return (openBracket == '(' && closeBracket == ')') ||
               (openBracket == '[' && closeBracket == ']') ||
               (openBracket == '{' && closeBracket == '}') ||
               (openBracket == '<' && closeBracket == '>');
    }

    public static void main(String[] args) {
        // Output cases :
        //  {[()]} : Balanced
		//  ({[<>]}) : Balanced
		//  [<<] : Non Matching Bracket
		//  [<>]] : Odd number of characters
		//  [<#|>] : Invalid character
		System.out.println("Enter the brackets string :");
		Scanner sc = new Scanner(System.in);
        BalanceBrackets balancer = new BalanceBrackets(sc.nextLine());
        sc.close();
        balancer.check();
    }
}
