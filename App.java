import java.util.ArrayList;

public class App {

  public static void main(String[] args) {
    Repository repo = new Repository();
    repo.append(new Worker(22, 1234, "Серёга1 ", "Иванов1 "));
    repo.append(new Worker(22, 1234, "Серёга2 ", "Иванов2 "));
    repo.append(new Worker(22, 1234, "Серёга3 ", "Иванов3 "));
    System.out.println(repo);
  }
}

class Worker {

  public int age;
  public int salary;
  public String firstName;
  public String lastName;

  public Worker(int age, int salary, String firstName, String lastName) {
    this.age = age;
    this.salary = salary;
    this.firstName = firstName;
    this.lastName = lastName;
  }

  public String getFullName() {
    return firstName + " " + lastName;
  }

  @Override
  public String toString() {
    return String.format("%s %d %d", this
        .getFullName(), this
        .age, this
        .salary);
  }
}

/**
 * Класс, который будет хранить воркеров. Внутри репозитория имеется база данных которая скрыта.
 * Дальше в базе имеется конструктор, в которой будет инициализироватся эта база. Добавляем свой
 * API, принимает воркера. Видите ли вы здесь какие ни-будь проблемы?
 */
class Repository {

  private ArrayList<Worker> db;

  public Repository() {
    db = new ArrayList<>();
  }

  public void append(Worker w) {
    db.add(w);
  }

  public Worker getWorkerBy(int id) {
    return db.get(id);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    for (Worker worker : db) {
      sb.append(worker);
      sb.append("\n");
    }
    return sb.toString();
  }
}