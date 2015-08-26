// import java.util.ArrayList;

import org.fluentlenium.adapter.FluentTest;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.junit.rules.ExternalResource;
import org.sql2o.*;
import static org.fluentlenium.core.filter.FilterConstructor.*;
import static org.assertj.core.api.Assertions.assertThat;


public class AppTest extends FluentTest {
  public WebDriver webDriver = new HtmlUnitDriver();

  @Override
  public WebDriver getDefaultDriver() {
    return webDriver;
  }

  @ClassRule
  public static ServerRule server = new ServerRule();

  @Rule
  public DatabaseRule database = new DatabaseRule();


  @Test
  public void rootTest() {
    goTo("http://localhost:4567/");
    assertThat(pageSource()).contains("Todo list!");
  }

  // @Test
  // public void categoryIsCreatedTest() {
  //   goTo("http://localhost:4567/");
  //   fill("#name").with("Household chores");
  //   submit(".btn");
  //   assertThat(pageSource()).contains("Household chores");
  // }

  @Test
  public void categoryIsDisplayedTest() {
    Category myCategory = new Category("Household chores");
    myCategory.save();
    String categoryPath = String.format("http://localhost:4567/categories/%d", myCategory.getId());
    goTo(categoryPath);
    assertThat(pageSource()).contains("Household chores");
  }

  // @Test
  // public void categoryTasksFromIsDisplayed() {
  //   goTo("http://localhost:4567/categories/new");
  //   fill("#name").with("Shopping");
  //   submit(".btn");
  //   System.out.println(pageSource());
  //   click("a", withText("View categories"));
  //   click("a", withText("Shopping"));
  //   click("a", withText("Add a new task"));
  //   assertThat(pageSource()).contains("Add a Task to Shopping");
  // }
  //
  // @Test
  // public void tasksIsAddedAndDisplayed() {
  //   goTo("http://localhost:4567/categories/new");
  //   fill("#name").with("Banking");
  //   submit(".btn");
  //   click("a", withText("View categories"));
  //   click("a", withText("Banking"));
  //   click("a", withText("Add a new task"));
  //   fill("#description").with("Deposit paycheck");
  //   submit(".btn");
  //   assertThat(pageSource()).contains("Deposit paycheck");
  // }
}
