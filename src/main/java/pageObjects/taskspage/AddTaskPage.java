package pageObjects.taskspage;

import java.util.HashMap;

public class AddTaskPage {

    public AddTaskGeneralSection addTaskGeneralSection = new AddTaskGeneralSection();
    public AddTaskTimeSection addTaskTimeSection = new AddTaskTimeSection();
    public AddTaskAttachmentsSection addTaskAttachmentsSection = new AddTaskAttachmentsSection();


    public void addTask(HashMap<String, String> testData){
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        addTaskGeneralSection.doFillGeneralSectionDetails(testData);
        addTaskGeneralSection.navigateToTimeSection();
        addTaskTimeSection.doFillTimeSectionDetails(testData);
        addTaskTimeSection.navigateToAttachmentSection();
        addTaskAttachmentsSection.doFillAttachmentSectionDetails(testData);
        addTaskAttachmentsSection.saveTask();
    }

}

