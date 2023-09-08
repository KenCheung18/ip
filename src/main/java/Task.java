public class Task {
    protected String description;
    protected boolean isDone;
    public static int listCount = 0;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public String getStatusIcon() {
        return (isDone ? "X" : " "); // mark done task with X
    }
    public void markAsDone(){
        isDone = true;
    }

    public void unmark(){
        isDone = false;
    }
    public String getDescription(){
        return description;
    }
    public String toString(){
        return("[" + getStatusIcon() + "]" + description);
    }
}