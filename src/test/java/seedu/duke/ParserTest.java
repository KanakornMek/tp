package seedu.duke;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

public class ParserTest {

    private Parser parser;

    @BeforeEach
    public void setUp() {
        parser = new Parser();
    }

    /*
     * Tests for exit command
     */
    @Test
    public void parse_exitCommand_parsedCorrectly() throws ExpensiveLehException {
        final String input = "exit\n";
        final Command result = parse(input);
        assertInstanceOf(ExitCommand.class, result);
    }

    /*
     * Tests for exit command
     */
    @Test
    public void parse_listCommand_parsedCorrectly() throws ExpensiveLehException {
        final String input = "list\n";
        final Command result = parse(input);
        assertInstanceOf(ListCommand.class, result);
    }

    /*
     * Tests for exit command
     */
    @Test
    public void parse_helpCommand_parsedCorrectly() throws ExpensiveLehException {
        final String input = "help\n";
        final Command result = parse(input);
        assertInstanceOf(HelpCommand.class, result);
    }

    /*
     * Tests for budget command
     */
    @Test
    public void parse_budgetCommand_validAmount_returnsBudgetCommand() throws ExpensiveLehException {
        final String input = "budget 67\n";
        final Command result = parse(input);
        assertInstanceOf(BudgetCommand.class, result);
    }

    @Test
    public void parse_budgetCommand_invalidAmount_throwsException() {
        final String input = "budget invalid\n";
        assertThrows(ExpensiveLehException.class, () -> parse(input));
    }

    /*
     * Tests for add command
     */
    @Test
    public void parse_addCommand_validArgs_returnsAddCommand() throws ExpensiveLehException {
        final String input = "add c/food n/burger a/5.50\n";
        final Command result = parse(input);
        assertInstanceOf(AddCommand.class, result);
    }

    @Test
    public void parse_addCommand_missingName_throwsException() {
        final String input = "add c/food a/5.50\n";
        assertThrows(ExpensiveLehException.class, () -> parse(input));
    }

    /*
     * Tests for delete command
     */
    @Test
    public void parse_deleteCommand_validIndex_returnsDeleteCommand() throws ExpensiveLehException {
        final String input = "delete 1\n";
        final Command result = parse(input);
        assertInstanceOf(DeleteCommand.class, result);
    }

    @Test
    public void parse_deleteCommand_invalidIndex_throwsException() {
        final String input = "delete X\n";
        assertThrows(ExpensiveLehException.class, () -> parse(input));
    }

    /*
     * Tests for edit command
     */
    @Test
    public void parse_editCommand_validArgs_returnsEditCommand() throws ExpensiveLehException {
        final String input = "edit 1 n/coffee\n";
        final Command result = parse(input);
        assertInstanceOf(EditCommand.class, result);
    }

    /*
     * Tests for unknown command
     */
    @Test
    public void parse_unknownCommand_throwsException() {
        final String input = "INVALID INPUT\n";
        assertThrows(ExpensiveLehException.class, () -> parse(input));
    }

    /*
     * Utility methods
     */
    private Command parse(String input) throws ExpensiveLehException {
        System.setIn(new java.io.ByteArrayInputStream(input.getBytes()));
        parser = new Parser();
        return parser.readCommand();
    }
}
