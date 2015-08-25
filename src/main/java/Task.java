import java.time.LocalDateTime;
// import java.util.ArrayList;
import java.util.List;
import org.sql2o.*;

public class Task{
  private int id;
  private String description;

  public int getId() {
    return id;
  }

  public String getDescription() {
    return description;
  }

  public Task(String description) {
    this.description = description;
  }

  @Override
  public boolean equals(Object otherTask) {
    if(!(otherTask instanceof Task)) {
      return false;
    } else {
      Task newTask = (Task) otherTask;
      return this.getDescription().equals(newTask.getDescription());
    }
  }

  public static List<Task> all() {
    String sql = "SELECT id, description FROM tasks";
    try(Connection con = DB.sql2o.open()) {
      return con.createQuery(sql).executeAndFetch(Task.class);
    }
  }

  // private String mDescription;
  // private LocalDateTime mCreatedAt;
  // private boolean mCompleted;
  // private int mId;
  //
  //
  // public Task(String description){
  //   mDescription = description;
  //   mCreatedAt = LocalDateTime.now();
  //   mCompleted = false;
  //   instances.add(this);
  //   mId = instances.size();
  // }
  //
  // public String getDescription() {
  //   return mDescription;
  // }
  //
  // public boolean isCompleted() {
  //   return mCompleted;
  // }
  //
  // public int getId() {
  //   return mId;
  // }
  //
  // public void completeTask() {
  //   mCompleted = true;
  // }
  //
  // public static ArrayList<Task> all() {
  //   return instances;
  // }
  //
  // public static Task find(int id) {
  //   try {
  //     return instances.get(id-1);
  //   } catch (IndexOutOfBoundsException e) {
  //     return null;
  //   }
  // }
  //
  // public static void clear() {
  //   instances.clear();
  // }
}
