package loans;

import seedu.duke.ExpensiveLehException;

import java.util.ArrayList;

/**
 * Manages the list of loans to others
 */
public class LoanManager {
    private final ArrayList<Loan> loans;

    public LoanManager() {
        this.loans = new ArrayList<>();
    }

    public LoanManager(ArrayList<Loan> loans) {
        assert loans != null : "Loans list cannot be null";
        this.loans = loans;
    }

    /**
     * Adds a new debt entry to the tracker.
     * * @param debt The debt object to be added.
     * @throws ExpensiveLehException If the debt object is null.
     */
    public void addLoan(Loan loan) throws ExpensiveLehException {
        if (loan == null) {
            throw new ExpensiveLehException("Loan entry cannot be null.");
        }

        assert loan.getAmount() >= 0 : "Debt amount should not be negative";

        loans.add(loan);
    }

    /**
     * Removes a debt from the list (e.g., when it is paid back).
     * * @param index The zero-based index of the debt in the list.
     * @return The removed Debt object.
     * @throws ExpensiveLehException If the index is out of bounds.
     */
    public Loan deleteLoan(int index) throws ExpensiveLehException {
        if (index < 0 || index >= loans.size()) {
            throw new ExpensiveLehException("Debt ID " + (index + 1) + " doesn't exist.");
        }
        return loans.remove(index);
    }

    public ArrayList<Loan> getLoans() {
        return loans;
    }

    public int getSize() {
        return loans.size();
    }

    public boolean isEmpty() {
        return loans.isEmpty();
    }

    /**
     * Calculates the total amount of money currently owed to the user.
     * * @return Total sum of all debts.
     */
    public double getTotalAmountLent() {
        double total = 0.0;
        for (Loan loan : loans) {
            total += loan.getAmount();
        }
        return total;
    }
}