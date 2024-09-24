package com.qacart.todo.pages;

import com.qacart.todo.base.BasePage;
import com.qacart.todo.config.EndPoint;
import com.qacart.todo.utils.ConfigUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TodoPage extends BasePage {


    public TodoPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css="[data-testid=\"welcome\"]")
    private WebElement welcomeMassage ;

    @FindBy(css="[data-testid=\"add\"]")
    private WebElement addButton ;

    @FindBy(css="[data-testid=\"todo-item\"]")
    private WebElement toDoItem ;

    @FindBy (css = "[data-testid=\"delete\"]")
    private  WebElement deleteButton ;

    @FindBy (css = "[data-testid=\"no-todos\"]")

    private WebElement noTodoMassage ;

    @Step
    public TodoPage load (){
        driver.get(ConfigUtils.getInstance().getBaseUrl()+ EndPoint.TODO_PAGE_ENDPOIND);
        return this;
    }



    @Step
    public boolean isWelcomeDispalyed (){
      return  welcomeMassage.isDisplayed();
    }
    public NewTodoPage clickOnPlusButton(){
        addButton.click();
        return new NewTodoPage(driver);
    }

    @Step
    public String getTodoText (){
     return   toDoItem.getText();
    }

    @Step
    public TodoPage clickOnDelete (){
        deleteButton.click();
        return this;
    }

    @Step
    public boolean isNoTodoDisplayed (){
        return noTodoMassage.isDisplayed();
    }

}
