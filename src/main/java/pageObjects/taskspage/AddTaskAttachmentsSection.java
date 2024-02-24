package pageObjects.taskspage;

import org.openqa.selenium.By;
import testbase.TestBase;

import java.util.HashMap;

public class AddTaskAttachmentsSection extends TestBase {


    public By attachmentsAddAttachment = By.xpath("//div[@id='uploadifive-uploadify_file_upload']//input[@multiple='multiple']");
    public By attachmentsSave = By.cssSelector(".modal-footer > .btn.btn-primary");
    public By attachmentsCancel = By.cssSelector(".modal-footer > .btn.btn-default");

    public void doFillAttachmentSectionDetails(HashMap<String, String> testData){
        //String path = System.getProperty("user.dir") +"/src/test/resources/logs/testCase1_1.log";
        typeElement(generateElement(attachmentsAddAttachment),testData.get("TaskAttachmentFilePath"), "attachmentsAddAttachment");
    }

    public void saveTask(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        clickElement(generateElement(attachmentsSave),"attachmentsSave");
    }
}

