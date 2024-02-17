package pageObjects.tasks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AddTaskPage {

    public AddTaskGeneralSectionPage addTaskGeneralSectionPage;
    public AddTaskTimeSectionPage addTaskTimeSectionPage;
    public AddTaskAttachmentsSectionPage addTaskAttachmentsSectionPage;

    public AddTaskPage(WebDriver driver){
        this.addTaskGeneralSectionPage = PageFactory.initElements(driver, AddTaskGeneralSectionPage.class);
        this.addTaskTimeSectionPage = PageFactory.initElements(driver, AddTaskTimeSectionPage.class);
        this.addTaskAttachmentsSectionPage = PageFactory.initElements(driver, AddTaskAttachmentsSectionPage.class);
    }

    public void addTask(){
        addTaskGeneralSectionPage.doFillGeneralSectionDetails();
        addTaskTimeSectionPage.doFillTimeSectionDetails();
        addTaskAttachmentsSectionPage.doFillAttachmentSectionDetails();
    }

}

