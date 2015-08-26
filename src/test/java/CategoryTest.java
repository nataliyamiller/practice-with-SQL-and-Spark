import java.util.Arrays;

import org.junit.*;
import static org.junit.Assert.*;


public class CategoryTest {

    @Rule
    public DatabaseRule database = new DatabaseRule();

    @Test
    public void all_emptyAtFirst() {
      assertEquals(Category.all().size(), 0);
    }

    @Test
    public void equals_returnsTrueIfDescriptionsAretheSame() {
      Category firstCategory = new Category("Household Shores");
      Category secondCategory = new Category("Household Shores");
      assertTrue(firstCategory.equals(secondCategory));
    }

    @Test
    public void save_savesIntoDatabase_true() {
      Category myCategory = new Category("Household Shores");
      myCategory.save();
      assertTrue(Category.all().get(0).equals(myCategory));
    }

    @Test
    public void find_findsCategoryInDatabase_true() {
      Category myCategory = new Category("Household Shores");
      myCategory.save();
      Category savedCategory = Category.find(myCategory.getId());
      assertTrue(myCategory.equals(savedCategory));
    }

    @Test
    public void getTasks_retrievesAllTasksFromDatabase_tasksList() {
      Category myCategory = new Category("Household chores");
      myCategory.save();
      Task firstTask = new Task("Mow the lawn", myCategory.getId());
      firstTask.save();
      Task secondTask = new Task("Do the dishes", myCategory.getId());
      secondTask.save();
      Task[] tasks = new Task[] {firstTask, secondTask};
      assertTrue(myCategory.getTasks().containsAll(Arrays.asList(tasks)));
    }
    
}
