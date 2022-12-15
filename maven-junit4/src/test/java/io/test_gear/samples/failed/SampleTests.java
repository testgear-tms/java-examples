package io.test_gear.samples.failed;

import org.junit.Test;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import io.test_gear.annotations.*;
import io.test_gear.listener.BaseJunit4Runner;
import io.test_gear.models.LinkItem;
import io.test_gear.models.LinkType;
import io.test_gear.services.Adapter;

@RunWith(BaseJunit4Runner.class)
public class SampleTests {
    @Step
    @Title("Log in the system")
    @Description("System authentication")
    public void authorization() {
        Assert.assertTrue(setLogin("User_1"));
        Assert.assertTrue(setPassword("Pass123"));
    }

    @Step
    @Title("Set login: {login}")
    @Description("Login \"{login}\" has been set")
    public boolean setLogin(String login) {
        return login.equals("User_1");
    }

    @Step
    @Title("Set password: {password}")
    @Description("Password \"{password}\" has been set")
    public boolean setPassword(String password) {
        return password.equals("Pass123");
    }

    @Step
    @Title("Create a project")
    @Description("Project was created")
    public void createProject() {
        Assert.assertTrue(true);
    }

    @Step
    @Title("Enter the project")
    @Description("The contents of the project are displayed")
    public void enterProject() {
        Assert.assertTrue(true);
    }

    @Step
    @Title("Create a section")
    @Description("Section was created")
    public void createSection() {
        Assert.assertTrue(false);
    }

    @Step
    @Title("Create a test case")
    @Description("Test case was created")
    public void createTestCase() {
        Assert.assertTrue(true);
    }

    @Step
    @Title("Maximum nesting step")
    @Description("15 nesting levels of step")
    public void maximumNestingStep(int level) {
        if (level > 1) {
            maximumNestingStep(level - 1);
        }
    }

    @Test
    @ExternalId("failed_with_all_annotations")
    @DisplayName("Failed test with all annotations")
    @WorkItemIds("123")
    @Title("Title in the autotest card")
    @Description("Test with all annotations")
    @Labels({"Tag1","Tag2"})
    @Links(links = {
            @Link(url = "https://dumps.example.com/module/repository", title = "Repository", description = "Example of repository", type = LinkType.REPOSITORY),
            @Link(url = "https://dumps.example.com/module/projects", title = "Projects", type = LinkType.REQUIREMENT),
            @Link(url = "https://dumps.example.com/module/", type = LinkType.BLOCKED_BY),
            @Link(url = "https://dumps.example.com/module/docs", title = "Documentation", type = LinkType.RELATED),
            @Link(url = "https://dumps.example.com/module/JCP-777", title = "JCP-777", type = LinkType.DEFECT),
            @Link(url = "https://dumps.example.com/module/issue/5", title = "Issue-5", type = LinkType.ISSUE),
    })
    public void allAnnotationsTest() {
       Adapter.addLinks("https://testgear.io/", "Test 1","Desc 1", LinkType.ISSUE);
        authorization();
        createProject();
        enterProject();
        createSection();
        createTestCase();
        maximumNestingStep(13);
    }

    @Test
    @ExternalId("failed_with_required_annotations")
    @DisplayName("Failed test with required annotations")
    public void requiredAnnotationsTest() {
        Assert.assertTrue(false);
    }
}
