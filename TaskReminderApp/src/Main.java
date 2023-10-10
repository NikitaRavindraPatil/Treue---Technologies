import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Task {

    private  String task_title;
    private  String task_deuDate;
    private boolean task_completed;

    public Task(String task_title, String task_deuDate) {
        this.task_title = task_title;
        this.task_deuDate = task_deuDate;
        this.task_completed = false;
    }

    public String getTaskTitle() {
        return task_title;
    }

    public String getdueDate() {
        return task_deuDate;
    }

    public boolean isTaskCompleted() {
        return task_completed;
    }

    public void markTaskCompleted() {
        task_completed = true;
    }

    @Override
    public String toString() {
        String status = task_completed ? "Completed" : "Pending";
        return "Task Information:" +
                "\nTask Title: " + task_title +
                "\nDue Date: " + task_deuDate +
                "\nTask Status: " + status;
    }
}

class TaskReminderApp {
    private static int AddTask = 1;
    private static int MarkAsCompleted = 2;
    private static int ViewTask = 3;
    private static int Exit = 4;

    public static void main(String[] args) {
        List<Task> tasks = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("------ Task Reminder App -----");
            System.out.println("1. Add A New Task");
            System.out.println("2. Mark The Task as Completed");
            System.out.println("3. View All Tasks");
            System.out.println("4. Exit");
            System.out.print("Enter The Choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:

                    System.out.print("Enter The Title of Task: " + "\n");
                    String Title = sc.nextLine();

                    System.out.print("Enter Due Date of Task: ");
                    String DueDate = sc.nextLine();
                    Task task = new Task(Title , DueDate);
                    tasks.add(task);
                    System.out.println("Task Has Been Successfully Added.");
                    break;
                case 2:
                    System.out.print("Enter The Task You Want to Be Marked as Completed: " + "\n");
                    int taskIndex = sc.nextInt();
                    if (taskIndex >= 0 && taskIndex < tasks.size()) {
                        Task selectedTask = tasks.get(taskIndex);
                        selectedTask.markTaskCompleted();
                        System.out.println("Great Work! The Task Has Been Successfully Completed.");
                    } else {
                        System.out.println("Error! The Index is Invalid.");
                    }
                    break;
                case 3:
                    System.out.println("Tasks:" + "\n");
                    for (int i = 0; i < tasks.size(); i++) {
                        System.out.println("Task " + i + ":");
                        System.out.println(tasks.get(i));
                    }
                    break;
                case 4:
                    System.out.println("Thank You For Using Our Application. Visit Again" + "\n");
                    sc.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Error! Choose Valid Option.Try Again");
            }
        }
    }
}