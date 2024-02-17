package pageObjects.tasks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddTaskAttachmentsSectionPage {

    @FindBy(xpath = "//a[@href='#tab_attachments']")
    WebElement AttachmentsSection;

    @FindBy(xpath = "//div[@id='uploadifive-uploadify_file_upload']//input[@multiple='multiple']")
    WebElement AttachmentsAddAttachment;

    @FindBy(css = ".modal-footer.ui-draggable-handle > .btn.btn-primary")
    WebElement TimeAttachmentsSave;

    @FindBy(css = ".modal-footer.ui-draggable-handle > .btn.btn-default")
    WebElement TimeAttachmentsCancel;

    public AddTaskAttachmentsSectionPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    public void doFillAttachmentSectionDetails(){

    }

}

