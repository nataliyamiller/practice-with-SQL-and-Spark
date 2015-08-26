import org.junit.*;
import static org.junit.Assert.*;
import org.junit.Rule;

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



  // @Test
  // public void getName_returnsName_true() {
  //   Category testCategory = new Category("Home");
  //   assertEquals("Home", testCategory.getName());
  // }
  //
  // @Test
  // public void getId_returnsCategoryId() {
  //   Category testCategory = new Category("Home");
  //   assertTrue(testCategory.all().size() == testCategory.getId());
  // }
  //
  // @Test
  // public void getTasks_initiallyReturnsEmptyArrayList() {
  //   Category testCategory = new Category("Home");
  //   assertTrue(testCategory.getTasks() instanceof ArrayList);
  // }
  //
  // @Test
  // public void all_returnsAllInstancesOfTask_true() {
  //   Category firstCategory = new Category("Home");
  //   Category secondCategory = new Category("Garden");
  //   assertTrue(Category.all().contains(firstCategory));
  //   assertTrue(Category.all().contains(secondCategory));
  // }
  //
  // @Test
  // public void clear_removesAllCategoryInstancesFromMemory() {
  //   Category testCategory = new Category("Home");
  //   Category.clear();
  //   assertTrue(Category.all().size() == 0);
  // }
  //
  // @Test
  // public void find_returnsCategoryWithSameId() {
  //   Category testCategory = new Category("Home");
  //   assertEquals(Category.find(testCategory.getId()), testCategory);
  // }
  //
  // @Test
  // public void addTask_addsTaskToList() {
  //   Category testCategory = new Category("Home");
  //   Task testTask = new Task("Buy groceries");
  //   testCategory.addTask(testTask);
  //   assertTrue(testCategory.getTasks().contains(testTask));
  // }
}
