package pageObjects.taskspage;

public class AddTaskPage {

    public AddTaskGeneralSection addTaskGeneralSection = new AddTaskGeneralSection();
    public AddTaskTimeSection addTaskTimeSection = new AddTaskTimeSection();
    public AddTaskAttachmentsSection addTaskAttachmentsSection = new AddTaskAttachmentsSection();


    public void addTask(){
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        addTaskGeneralSection.doFillGeneralSectionDetails();
        addTaskGeneralSection.navigateToTimeSection();
        addTaskTimeSection.doFillTimeSectionDetails();
        addTaskTimeSection.navigateToAttachmentSection();
        addTaskAttachmentsSection.doFillAttachmentSectionDetails();
        addTaskAttachmentsSection.saveTask();
    }

}

