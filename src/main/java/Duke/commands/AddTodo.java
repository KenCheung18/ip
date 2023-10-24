package duke.commands;

import duke.inputProcess.TaskList;

/**
 * The `AddTodo` class is responsible for adding todo tasks to the task list in the Duke robot.
 * It takes a user-provided task description and adds it to the list as a todo task.
 */
public class AddTodo {
    private final String userInput;
    private final TaskList tasks;

    /**
     * Constructs an `AddTodo` object with the given user input and task list.
     *
     * @param userInput The description of the todo task provided by the user.
     * @param tasks The task list where the todo task will be added.
     */
    public AddTodo(String userInput, TaskList tasks) {
        this.userInput = userInput;
        this.tasks = tasks;
    }

    /**
     * Adds a todo task to the task list with the task name.
     */
    public void addTodoTask() {
        tasks.addTodo(userInput);
        System.out.println("\tGot it. I've added this task:\n\t\t" + tasks.getByIndex(tasks.getSize() - 1) +
                "\n\tNow you have " + tasks.getSize() + " tasks in the list.");
    }
}
