import java.util.Scanner;

public class PayMoneyTarget {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("Enter the size of the transaction array:");
            int size = sc.nextInt();

            System.out.println("Enter the values of the array:");
            int[] transactions = new int[size];
            for (int i = 0; i < size; i++) {
                transactions[i] = sc.nextInt();
            }

            System.out.println("Enter the total number of targets that need to be achieved:");
            int totalTargets = sc.nextInt();

            for (int targetCount = 0; targetCount < totalTargets; targetCount++) {
                System.out.println("Enter the value of target:");
                int target = sc.nextInt();

                int currentSum = 0;
                int transactionsNeeded = 0;

                for (int i = 0; i < size; i++) {
                    currentSum += transactions[i];
                    transactionsNeeded++;

                    if (currentSum >= target) {
                        System.out.println("Target achieved after " + transactionsNeeded + " transactions");
                        break;
                    }
                }

                if (currentSum < target) {
                    System.out.println("Given target is not achieved");
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}
