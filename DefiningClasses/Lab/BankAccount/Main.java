package DefiningClasses.Lab.BankAccount;

import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<Integer, BankAccount> bankAccounts = new HashMap<>();

        String command = scanner.nextLine();

        while (!command.equals("End")) {

            String[] tokens = command.split("\\s+");

            if (tokens[0].equals("Create")) {
                BankAccount account = new BankAccount();
                bankAccounts.put(account.getId(), account);
                System.out.println("Account ID" + account.getId() + " created");

            } else if (tokens[0].equals("Deposit")) {
                int id = Integer.parseInt(tokens[1]);
                int amount = Integer.parseInt(tokens[2]);

                if (bankAccounts.containsKey(id)) {
                    bankAccounts.get(id).deposit(amount);
                    System.out.println("Deposited " + amount + " to ID" + id);
                } else {
                    System.out.println("Account does not exist");
                }
            } else if (tokens[0].equals("SetInterest")) {
                BankAccount.setInterestRate(Double.parseDouble(tokens[1]));

            } else if (tokens[0].equals("GetInterest")) {
                int id = Integer.parseInt(tokens[1]);
                int years = Integer.parseInt(tokens[2]);

                if (bankAccounts.containsKey(id)) {
                    double interest = bankAccounts.get(id).getInterest(years);
                    System.out.printf("%.2f%n", interest);
                } else {
                    System.out.println("Account does not exist");
                }
            }
            command = scanner.nextLine();
        }
    }
}
