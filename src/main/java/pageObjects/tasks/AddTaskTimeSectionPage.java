package pageObjects.tasks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddTaskTimeSectionPage {

    @FindBy(xpath = "//a[@href='#tab_time']")
    WebElement TimeSection;

    @FindBy(name = "tasks[estimated_time]")
    WebElement TimeEstimatedTime;

    @FindBy(name = "tasks[start_date]")
    WebElement TimeStartDate;

    @FindBy(name = "tasks[due_date]")
    WebElement TimeDueDate;

    @FindBy(name = "tasks[progress]")
    WebElement TimeProgress;

    @FindBy(css = ".modal-footer.ui-draggable-handle > .btn.btn-primary")
    WebElement TimeAttachmentsSave;

    @FindBy(css = ".modal-footer.ui-draggable-handle > .btn.btn-default")
    WebElement TimeAttachmentsCancel;


    public AddTaskTimeSectionPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    public void doFillTimeSectionDetails(){

    }
}

