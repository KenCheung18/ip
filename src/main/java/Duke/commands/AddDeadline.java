package duke.commands;

import duke.inputProcess.Parser;
import duke.inputProcess.TaskList;

import java.time.format.DateTimeParseException;

/**
 * The `AddDeadline` class is responsible for adding deadline tasks to the task list in the Duke robot.
 * It parses user input and extracts the necessary information to create a deadline task.
 */
public class AddDeadline {
    private Parser parser;
    private TaskList tasks;

    /**
     * Constructs an `AddDeadline` object with `Parser` and `TaskList`.
     *
     * @param parser The parser is to process input from the user.
     * @param tasks The task list where the deadline task will be added.
     */
    public AddDeadline(Parser parser, TaskList tasks) {
        this.parser = parser;
        this.tasks = tasks;
    }

    /**
     * Adds a deadline task to the task list.
     * Parses the input, extracts the task name and deadline time, then adds the deadline task to the list.
     * If the input format is incorrect, appropriate error messages are displayed.
     */
    public void addDeadlineTask() {
        try {
            try {
                // Attempt to parse the deadline input and add the task to the list
                Parser deadlineParse = parser.getDeadlineInput();
                tasks.addDeadline(deadlineParse.getTaskName(), parser.getTaskTime1());
                System.out.println("\tGot it. I've added this task:\n\t\t" + tasks.getByIndex(tasks.getSize() - 1) +
                        "\n\tNow you have " + tasks.getSize() + " tasks in the list.");
            } catch (DateTimeParseException e) {
                // Handle invalid date/time format
                System.out.println("\tThe input format for deadline event needs to be \"deadline deadlineEvent /by dd/MM/yyyy HHmm\"");
            }
        } catch (IndexOutOfBoundsException e) {
            // Handle missing "/by" separator in the input
            System.out.println("\tOOPS!!! The deadline needs to be separated by \"/by\"");
        }
    }
}
