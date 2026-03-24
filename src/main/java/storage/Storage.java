package storage;

import loans.Loan;
import seedu.duke.Expense;
import seedu.duke.Food;
import seedu.duke.Transport;
import seedu.duke.Groceries;
import seedu.duke.Others;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate; // Need this for parsing
import java.util.Scanner;
import java.util.ArrayList;

public class Storage {
    private String filePath;

    public static class StorageData {
        public final double budget;
        public final ArrayList<Expense> expenses;
        public final ArrayList<Loan> loans;

        public StorageData(double budget, ArrayList<Expense> expenses, ArrayList<Loan> loans) {
            this.budget = budget;
            this.expenses = expenses;
            this.loans = loans;
        }
    }

    public Storage(String filePath) {
        this.filePath = filePath;
    }

    // Fixed the Arraylist capitalization
    public void save(double budget, ArrayList<Expense> expenses, ArrayList<Loan> loans) throws IOException {
        File f = new File(filePath);
        if (f.getParentFile() != null && !f.getParentFile().exists()) {
            f.getParentFile().mkdirs();
        }

        FileWriter fw = new FileWriter(f);
        fw.write("BUDGET | " + budget + System.lineSeparator());

        // Save Expenses (added Date to keep format consistent)
        for (Expense e : expenses) {
            String type = e instanceof Food ? "F" : e instanceof Transport ? "T" : e instanceof Groceries ? "G" : "O";
            fw.write(type + " | " + e.getDescription() + " | " + e.getAmount() + " | " + e.getDate()
                    + System.lineSeparator());
        }

        // Save Loans
        for (Loan l : loans) {
            fw.write("L | " + l.getDescription() + " | " + l.getAmount() + " | " + l.getDate()
                    + System.lineSeparator());
        }
        fw.close();
    }

    public StorageData load() throws IOException {
        ArrayList<Expense> loadedExpenses = new ArrayList<>();
        ArrayList<Loan> loadedLoans = new ArrayList<>();
        double loadedBudget = 0.0;

        File f = new File(filePath);
        if (!f.exists()) return new StorageData(loadedBudget, loadedExpenses, loadedLoans);

        Scanner s = new Scanner(f);
        while (s.hasNextLine()) {
            String line = s.nextLine();
            if (line.trim().isEmpty()) continue;

            String[] parts = line.split(" \\| ");
            if (parts[0].equals("BUDGET")) {
                loadedBudget = Double.parseDouble(parts[1]);
                continue;
            }

            String category = parts[0];
            String description = parts[1];
            double amount = Double.parseDouble(parts[2]);
            LocalDate date = LocalDate.parse(parts[3]);

            if (category.equals("L")) {
                loadedLoans.add(new Loan(description, amount, date));
                continue;
            }

            Expense expense;
            switch (category) {
            case "F": expense = new Food(description, amount, date); break;
            case "T": expense = new Transport(description, amount, date); break;
            case "G": expense = new Groceries(description, amount, date); break;
            default: expense = new Others(description, amount, date); break;
            }
            loadedExpenses.add(expense);
        }
        s.close();
        return new StorageData(loadedBudget, loadedExpenses, loadedLoans);
    }
}