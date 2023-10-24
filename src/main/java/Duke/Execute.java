package duke;

import duke.commands.*;
import duke.inputProcess.Parser;
import duke.inputProcess.TaskList;

/**
 * The `Execute` class is responsible for executing various commands based on user input.
 * It delegates the execution of specific commands to their respective command classes.
 */
public class Execute {
    String command;
    String userInput;
    Parser parser;
    TaskList tasks;

    /**
     * Constructs an `Execute` object with the specified command, user input, parser, and task list.
     *
     * @param command The command to be executed.
     * @param userInput The user input associated with the command.
     * @param parser The parser for processing user input.
     * @param tasks The task list where tasks are managed.
     */
    public Execute(String command, String userInput, Parser parser, TaskList tasks) {
        this.command = command;
        this.userInput = userInput;
        this.parser = parser;
        this.tasks = tasks;
    }

    /**
     * Executes the appropriate action based on the provided command.
     */
    public void execute() {
        switch (command) {
        case "list":
            new PrintList(tasks).print();
            break;
        case "unmark":
            new UnmarkTask(userInput, tasks).unmark();
            break;
        case "mark":
            new MarkTask(userInput, tasks).mark();
            break;
        case "deadline":
            new AddDeadline(parser, tasks).addDeadlineTask();
            break;
        case "event":
            new AddEvent(parser, tasks).addEventTask();
            break;
        case "todo":
            new AddTodo(userInput, tasks).addTodoTask();
            break;
        case "delete":
            new DeleteTask(userInput, tasks).delete();
            break;
        case "find":
            new FindTasks(userInput, tasks).find();
            break;
        case "help":
            Ui.help();
            break;
        default:
            System.out.println("\tOOPS!!! I'm sorry, but I don't know what that means :-(");
        }
    }
}
