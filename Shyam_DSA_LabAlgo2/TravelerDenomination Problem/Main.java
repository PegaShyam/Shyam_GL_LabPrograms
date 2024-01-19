import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class PayDenomination {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the size of currency denominations:");
        int size = sc.nextInt();
        Integer[] denominations = new Integer[size];
        System.out.println("Enter the currency denominations value:");
        for (int i = 0; i < size; i++) {
            denominations[i] = sc.nextInt();
        }
        System.out.println("Enter the amount you want to pay:");
        int amount = sc.nextInt();
        printPaymentApproach(denominations, amount);

        sc.close();
    }

    private static void printPaymentApproach(Integer[] denominations, int amount) {
        Arrays.sort(denominations, Collections.reverseOrder());
        String[] paymentApproach = new String[denominations.length];
        int paymentIndex = 0;

        for (int i = 0; i < denominations.length; i++) {
            int currentDenomination = denominations[i];
            if (amount >= currentDenomination) {
                int count = amount / currentDenomination;
                paymentApproach[paymentIndex++] = currentDenomination + ":" + count;
                amount -= count * currentDenomination;
            }
        }

        System.out.println("Your payment approach in order to give the minimum number of notes will be:");
        for (int i = 0; i < paymentIndex; i++) {
            System.out.println(paymentApproach[i]);
        }
    }
}
