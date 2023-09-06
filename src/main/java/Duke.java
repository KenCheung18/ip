import java.util.Scanner;


public class Duke {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(" Hello! I'm Bot Hilary ");
        Task[] list = new Task[100];
        System.out.println(" What can I do for you? ");
        String line = in.nextLine();
        while (!line.equals("bye")){
            if (line.equals("list")) {
                for (int i = 0; i < Task.listCount; ++i) {
                    System.out.println(list[i]);
                }
            }
            else if (line.contains("unmark")){
                line = line.replace("unmark ", "");
                list[Integer.parseInt(line) - 1].unmark();
                System.out.println(" OK, I've marked this task as not done yet:");
                System.out.println(list[Integer.parseInt(line) - 1]);

            }
            else if (line.contains("mark")){
                line = line.replace("mark ", "");
                list[Integer.parseInt(line) - 1].markAsDone();
                System.out.println(" Nice! I've marked this task as done:");
                System.out.println(list[Integer.parseInt(line) - 1]);

            }
            else{
                String eventTime = "";
                if (line.contains("deadline")){
                    eventTime = line.split("/by ",2)[1];
                    line = line.split(" ",2)[1];
                    line = line.split("/",2)[0];
                    eventTime = eventTime.replace("from", "from:");
                    eventTime = eventTime.replace("/", "");
                    list[Task.listCount] = new Deadline(line, eventTime);
                }
                else if (line.contains("event")){
                    eventTime = line.split("/from ",2)[1];
                    line = line.split(" ",2)[1];
                    line = line.split("/",2)[0];
                    eventTime = eventTime.replace("/to", "to:");
                    list[Task.listCount] = new Event(line, eventTime);
                }
                else {
                    list[Task.listCount] = new Todo(line.split(" ", 2)[1]);
                }
                System.out.println(" Got it. I've added this task:");
                System.out.println(list[Task.listCount]);
                Task.listCount++;
                System.out.println("Now you have " + Task.listCount + " in the list");
            }
            line = in.nextLine();
        }
        System.out.println("  Bye. Hope to see you again soon! ");
    }
}
