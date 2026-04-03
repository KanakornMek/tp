# Kanakorn Suk-ieam - Project Portfolio Page

## Overview

ExpensiveLeh is a CLI for managing your personal finances. Users can indicate their budget and add expenses into the app to track their budget situation. Features include expense management, budgeting, loans, bookmarks, and search functionality.

## Summary of Contributions

### Code contributed
[[RepoSense Link]](https://nus-cs2113-ay2526-s2.github.io/tp-dashboard/?search=kanakornmek&breakdown=true&sort=groupTitle%20dsc&sortWithin=title&since=2026-02-20T00%3A00%3A00&timeframe=commit&mergegroup=&groupSelect=groupByRepos&checkedFileTypes=docs~functional-code~test-code~other&filteredFileName=&tabOpen=true&tabType=authorship&tabAuthor=KanakornMek&tabRepo=AY2526S2-CS2113-W11-3%2Ftp%5Bmaster%5D&authorshipIsMergeGroup=false&authorshipFileTypes=docs~functional-code~test-code&authorshipIsBinaryFileTypeChecked=false&authorshipIsIgnoredFilesChecked=false)

### Enhancements implemented

**Feature: Implemented ExpenseManager with Budget Tracking**

- Implemented expense management with add, delete, edit, and search operations

**Feature: Budget and Category Budget Management**

- Created `BudgetCommand` and `CategoryBudgetCommand` classes following the Command pattern
- Implemented `ListBudgetsCommand` to display all category budgets with remaining amounts
- Added validation to prevent negative budgets and empty category names

**GitHub Organization and Repository Setup**


### Contributions to the User Guide

- Documented budget management features including:
  - Setting global budgets (`budget AMOUNT`)
  - Setting category-specific budgets (`budget c/CATEGORY a/AMOUNT`)
  - Listing all category budgets (`list budgets`)
- Documented expense management features including:
  - Adding expenses
  - Editing expenses 
  - Deleting expenses

### Contributions to the Developer Guide

**Design Section:**
- Added documentation for the ExpenseManager component
- Created class diagrams showing the Expense superclass hierarchy

**Implementation Section:**
- Wrote the implementation details of expense management features:
  - Add Expense Feature with sequence diagrams
  - Delete Expense Feature with sequence diagrams
  - Edit Expense Feature with sequence diagrams
  - Budget Tracking Feature implementation details
- Included example usage scenarios for each feature

### Contributions to team-based tasks

- Set up GitHub team organization and repository
- Created and managed project issues on GitHub

### Review/mentoring contributions

- Regularly reviewed team pull requests
- Provided suggestions for improving the project architecture and user experience