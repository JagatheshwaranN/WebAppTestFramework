package pageObjects.taskspage;

import testbase.TestBase;

import java.util.HashMap;

public class TasksPage extends TestBase {

    public AddTaskPage addTaskPage = new AddTaskPage();

//    private ViewAllPage viewAllPage;


    public void performAddTask(HashMap<String, String> testData) {
        addTaskPage.addTask(testData);
    }

}

