import java.util.List;
import org.sql2o.*;

public class Category {
  private int id;
  private String name;

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public Category (String name) {
    this.name = name;
  }

  public static List<Category> all() {
    String sql = "SELECT id, name FROM categories";
    try(Connection con = DB.sql2o.open()) {
      return con.createQuery(sql).executeAndFetch(Category.class);
    }
  }

  @Override
  public boolean equals(Object otherCategory) {
    if (!(otherCategory instanceof Category)) {
      return false;
    } else {
      Category newCategory = (Category) otherCategory;
      return this.getName().equals(newCategory.getName());
    }
  }

  public void save() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "INSERT INTO Categories(name) VALUES (:name)";
      this.id = (int) con.createQuery(sql, true)
        .addParameter("name", this.name)
        .executeUpdate()
        .getKey();
    }
  }

  public static Category find(int id) {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM categories WHERE id=:id";
      Category category = con.createQuery(sql)
        .addParameter("id", id)
        .executeAndFetchFirst(Category.class);
        return category;
    }
  }




  //
  //
  // public Category (String name) {
  //   mName = name;
  //   instances.add(this);
  //   mTasks = new ArrayList<Task>();
  //   mId = instances.size();
  // }
  //
  // public String getName() {
  //   return mName;
  // }
  //
  // public static ArrayList<Category> all() {
  //   return instances;
  // }
  //
  // public int getId() {
  //   return mId;
  // }
  //
  // public ArrayList<Task> getTasks() {
  //   return mTasks;
  // }
  //
  // public void addTask(Task taskToAdd) {
  //   mTasks.add(taskToAdd);
  // }
  //
  // public static void clear() {
  //   instances.clear();
  // }
  //
  // public static Category find(int id) {
  //   try {
  //     return instances.get(id - 1);
  //   } catch (IndexOutOfBoundsException exception) {
  //     return null;
  //   }
  // }

}
