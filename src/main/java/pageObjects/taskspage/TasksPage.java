package pageObjects.taskspage;

import testbase.TestBase;

public class TasksPage extends TestBase {

    public AddTaskPage addTaskPage = new AddTaskPage();

//    private ViewAllPage viewAllPage;


    public void performAddTask() {
        addTaskPage.addTask();
    }

}

