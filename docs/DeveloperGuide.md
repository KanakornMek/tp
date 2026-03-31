# Developer Guide

## Acknowledgements

{list here sources of all reused/adapted ideas, code, documentation, and third-party libraries -- include links to the original source as well}

## Design 
### ExpenseManager

The `ExpenseManager` is responsible for managing expenses and budgets:

- **Expense Collection**: Maintains an `ArrayList<Expense>` of all expenses
- **Budget Tracking**: Tracks both global and category-specific budgets
- **Search Functionality**: Implements keyword-based search across expenses

Key methods include:
- `addExpense()`: Adds new expense with validation
- `deleteExpense()`: Removes expense by index with bounds checking
- `editExpense()`: Updates expense fields, allowing category changes
- `setBudget()` / `getBudget()`: Global budget management
- `setCategoryBudget()` / `getCategoryBudget()`: Category-specific budgets
- `getRemainingBudget()`: Calculates remaining global budget
- `getRemainingBudgetForCategory()`: Calculates remaining category budget
- `searchByKeyword()`: Case-insensitive search across descriptions and categories
- `getCategoryTotals()`: Get total expenses by category

![ExpenseManager Class Diagram](Diagrams/ExpenseManager.png)

*ExpenseManager class showing expense hierarchy and command relationships*
## Implementation



## Product scope
### Target user profile

Busy students who want to manage their spending

### Value proposition

Students who are busy require an easy and convenient way to manage their finances. Our product serves as an easy way for
them to track their expenses so that they do not overspend their budgets.

## User Stories

| Version | As a ...  | I want to ...                                               | So that I can ...                                                  |
|---------|-----------|-------------------------------------------------------------|--------------------------------------------------------------------|
| v1.0    | user      | see my past expenses                                        | track my total expenditure                                         |
| v1.0    | user      | log an expense using a single command                       | record expenses quickly without navigating through multiple inputs |
| v2.0    | user      | add people who owe me money                                 | remember to chase them to return my money                          |
| v2.0    | user      | mark people who have returned money owed                    | stop chasing them for money                                        |
| v2.0    | user      | know my remaining budget immediately after logging expenses | know how much money I have saved                                   |
| v2.0    | lazy user | bookmark frequent expenses and add them                     | log them easily without typing everything out                      |

## Non-Functional Requirements

{Give non-functional requirements}

## Glossary

* *glossary item* - Definition

## Instructions for manual testing

{Give instructions on how to do a manual product testing e.g., how to load sample data to be used for testing}
