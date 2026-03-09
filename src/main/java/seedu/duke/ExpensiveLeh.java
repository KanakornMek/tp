package seedu.duke;

import Storage.Storage;

import java.io.IOException;
import java.util.ArrayList;

public class ExpensiveLeh {

    private Parser parser = new Parser();
    private Storage storage;
    private UI ui = new UI();
    private double currentBudget;
    private ArrayList<Expense> expenseList;

    public ExpensiveLeh(String filePath) throws IOException {
        storage = new Storage(filePath);

        try {
            Storage.StorageData data = storage.load();
            this.currentBudget = data.budget;
            this.expenseList = data.expenses;

        } catch (IOException e) {
            this.currentBudget = 0.0;
            this.expenseList = new ArrayList<Expense>();
        }
    }

    /**
     * Main entry-point for the java.duke.Duke application.
     */
    public void run() {

        ui.showWelcome();

        try {
            Command command = parser.readCommand();
        } catch (ExpensiveLehException e) {
            ui.showError(e.getMessage());
            ui.showLine();
        }
    }

    public static void main(String[] args) {
        new ExpensiveLeh("./data/storage.txt").run();
    }
}
