package com.qacart.todo.testcases;
import com.qacart.todo.api.RegisterApi;
import com.qacart.todo.api.TaskApi;
import com.qacart.todo.base.BaseTest;
import com.qacart.todo.pages.LoginPage;
import com.qacart.todo.pages.NewTodoPage;
import com.qacart.todo.pages.TodoPage;
import com.qacart.todo.utils.ConfigUtils;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

@Feature("ToDo Feature")


public class TodoTest extends BaseTest {
    @Story("Add T0d0")
    @Description("it will add new todo")
    @Test (description = "Should to add new todo")
    public void ShouldBeAbleToAddNewTodo()  {

        RegisterApi registerApi = new RegisterApi();
        registerApi.register();

           NewTodoPage newTodoPage = new NewTodoPage(getDriver());

        newTodoPage.load();

             injectCookiesToBrowser(registerApi.getCookies());

            String newTask = newTodoPage.load()
                       .addNewTask("Learn")
                       .getTodoText();
        Assert.assertEquals(newTask , "Learn");

    }
    @Story("Delete T0d0")
    @Description("it will delete todo")
    @Test (description = "Should to delete todo")
    public void ShouldBeAbleToDeleteTodo() throws InterruptedException {

        RegisterApi registerApi = new RegisterApi();
        registerApi.register();

        TaskApi taskApi =new TaskApi();
        taskApi.addTask(registerApi.getToken());

        TodoPage todoPage =new TodoPage(getDriver());
        todoPage.load();
        injectCookiesToBrowser(registerApi.getCookies());

        boolean noTodo= todoPage
                .load()
                .clickOnDelete()
                .isNoTodoDisplayed();
        Assert.assertTrue(noTodo);
        Thread.sleep(2000);
    }
}
