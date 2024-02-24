package pageObjects.taskspage;

import org.openqa.selenium.By;
import testbase.TestBase;

import java.util.HashMap;

public class AddTaskGeneralSection extends TestBase {

    public By project = By.id("form_projects_id");
    public By generalType = By.name("tasks[tasks_type_id]");
    public By generalName = By.name("tasks[name]");
    public By generalStatus = By.name("tasks[tasks_status_id]");
    public By generalPriority = By.name("tasks[tasks_priority_id]");
    public By generalLabel = By.name("tasks[tasks_label_id]");
    public By generalAssignedTo = By.name("tasks[assigned_to][]");
    public By generalDescriptionFrame = By.xpath("//iframe[contains(@class,'cke_wysiwyg_frame cke_reset')]");
    public By generalDescription = By.xpath("//body[contains(@class,'cke_editable cke_editable_themed cke_contents_ltr cke_show_borders')]");
    public By generalCreatedBy = By.name("tasks[created_by]");
    public By generalSave = By.cssSelector(".btn.btn-primary");
    public By generalCancel = By.cssSelector(".modal-footer > .btn.btn-default");

    public By timeSection = By.xpath("//a[@href='#tab_time']");

    public void doFillGeneralSectionDetails(HashMap<String, String> testData) {
        dropDownHandler.selectByVisibleText(generateElement(project), testData.get("TaskProject"));
        dropDownHandler.selectByVisibleText(generateElement(generalType), testData.get("TaskType"));
        typeElement(generateElement(generalName),testData.get("TaskName"), "generalName");
        dropDownHandler.selectByVisibleText(generateElement(generalStatus), testData.get("TaskStatus"));
        dropDownHandler.selectByVisibleText(generateElement(generalPriority), testData.get("TaskPriority"));
        dropDownHandler.selectByVisibleText(generateElement(generalLabel), testData.get("TaskLabel"));
        clickElement(generateElement(generalAssignedTo), "generalAssignedTo");
        frameHandler.switchToFrame(generateElement(generalDescriptionFrame), "generalDescriptionFrame");
        typeElement(generateElement(generalDescription),testData.get("TaskDescription"), "generalDescription");
        frameHandler.leaveFrame();
        dropDownHandler.selectByVisibleText(generateElement(generalCreatedBy), testData.get("TaskCreatedBy"));
    }

    public void navigateToTimeSection() {
        clickElement(generateElement(timeSection), "timeSection");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}

