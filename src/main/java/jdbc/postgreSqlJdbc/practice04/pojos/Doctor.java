package jdbc.postgreSqlJdbc.practice04.pojos;

public class Doctor {

    private int id;
    private String name;
    private String field;
    private String salary;

    public Doctor() {
    }

    public Doctor(int id, String name, String field, String salary) {
        this.id = id;
        this.name = name;
        this.field = field;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", field='" + field + '\'' +
                ", salary='" + salary + '\'' +
                '}';
    }
}
