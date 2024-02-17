package pageObjects.tasks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddTaskGeneralSectionPage {

    @FindBy(name = "tasks[tasks_type_id]")
    WebElement GeneralType;

    @FindBy(name="tasks[name]")
    WebElement GeneralName;

    @FindBy(name="tasks[tasks_status_id]")
    WebElement GeneralStatus;

    @FindBy(name="tasks[tasks_priority_id]")
    WebElement GeneralPriority;

    @FindBy(name="tasks[tasks_label_id]")
    WebElement GeneralLabel;

    @FindBy(name="tasks[assigned_to][]")
    WebElement GeneralAssignedTo;

    @FindBy(name="cke_1_contents")
    WebElement GeneralDescription;

    @FindBy(name="tasks[created_by]")
    WebElement GeneralCreatedBy;

    @FindBy(css = ".btn.btn-primary")
    WebElement GeneralSave;

    @FindBy(css=".modal-footer > .btn.btn-default")
    WebElement GeneralCancel;

    public AddTaskGeneralSectionPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    public void doFillGeneralSectionDetails(){

    }

}

