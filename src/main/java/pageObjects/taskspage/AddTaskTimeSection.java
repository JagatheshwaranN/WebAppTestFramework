package pageObjects.taskspage;

import org.openqa.selenium.By;
import testbase.TestBase;

public class AddTaskTimeSection extends TestBase {

    public By timeEstimatedTime = By.name("tasks[estimated_time]");
    public By timeStartDate = By.name("tasks[start_date]");
    public By timeDueDate = By.name("tasks[due_date]");
    public By timeProgress = By.name("tasks[progress]");
    public By timeAttachmentsSave = By.cssSelector(".modal-footer.ui-draggable-handle > .btn.btn-primary");
    public By timeAttachmentsCancel = By.cssSelector(".modal-footer.ui-draggable-handle > .btn.btn-default");
    public By attachmentsSection = By.xpath("//a[@href='#tab_attachments']");

    public void doFillTimeSectionDetails(){
        typeElement(generateElement(timeEstimatedTime), "5", "timeEstimatedTime");
        typeElement(generateElement(timeStartDate), "2024-02-22", "timeEstimatedTime");
        typeElement(generateElement(timeDueDate), "2024-02-27", "timeDueDate");
        dropDownHandler.selectByValue(generateElement(timeProgress), "5");
    }

    public void navigateToAttachmentSection() {
        clickElement(generateElement(attachmentsSection), "attachmentsSection");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

