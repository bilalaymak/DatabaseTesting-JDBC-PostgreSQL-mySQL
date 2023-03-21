package jdbc.postgreSqlJdbc.practice04.pojos;

public class Doctor {

    private int id;
    private String name;
    private String field;
    private int salary;

    public Doctor() {
    }

    public Doctor(int id, String name, String field, int salary) {
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

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
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
