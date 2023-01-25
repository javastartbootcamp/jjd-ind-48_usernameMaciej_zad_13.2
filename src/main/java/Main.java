import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try {
            Main main = new Main();
            main.run(new Scanner(System.in));
        } catch (StringIndexOutOfBoundsException e) {
            System.err.println("Lista jest pusta, spróbuj wpisać liczby od nowa.");
        }
    }

    public void run(Scanner scanner) {
        List<Integer> listFromUser = getListFromUser(scanner);
        readListFromBackwards(listFromUser);
        sumNumbers(listFromUser);
        int lowestNumber = getLowestNumber(listFromUser);
        System.out.println("Najmniejsza liczba w liście to: " + lowestNumber);
        int highestNumber = getHighestNumber(listFromUser);
        System.out.println("Najwieksza liczba w liście to: " + highestNumber);
    }

    private int getHighestNumber(List<Integer> listFromUser) {
        int highestNumber = 0;
        for (Integer integer : listFromUser) {
            if (integer > highestNumber) {
                highestNumber = integer;
            }
        }
        return highestNumber;
    }

    private int getLowestNumber(List<Integer> listFromUser) {
        int lowestNumber = listFromUser.get(0);
        for (Integer integer : listFromUser) {
            if (integer < lowestNumber) {
                lowestNumber = integer;
            }
        }
        return lowestNumber;
    }

    private void sumNumbers(List<Integer> listFromUser) {
        StringBuilder sb = new StringBuilder();
        int sum = 0;
        for (Integer integer : listFromUser) {
            sb.append(integer);
            sb.append(" + ");
            sum += integer;
        }
        sb.replace(sb.length() - 2, sb.length() - 1, "=");
        System.out.print(sb);
        System.out.println(sum);
    }

    private void readListFromBackwards(List<Integer> listFromUser) {
        StringBuilder sb = new StringBuilder();
        for (int i = listFromUser.size(); i > 0; i--) {
            sb.append(listFromUser.get(i - 1) + ", ");
        }
        sb.replace(sb.length() - 2, sb.length() - 1, " ");
        System.out.println(sb);
    }

    private static List<Integer> getListFromUser(Scanner scanner) {
        List<Integer> numbers = new ArrayList<>();
        boolean negativeNumber = true;
        do {
            System.out.println("Wpisz kolejną liczbę dodatnią:");
            int number = scanner.nextInt();
            if (number > 0) {
                numbers.add(number);
            } else {
                negativeNumber = false;
            }
        } while (negativeNumber);
        return numbers;
    }
}
