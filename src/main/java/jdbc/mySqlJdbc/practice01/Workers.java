package jdbc.mySqlJdbc.practice01;


public class Workers {

    private String id;
    private String name;
    private String address;
    private String exam_grade;
    private String registration_date;

    public Workers(String id, String name, String address, String exam_grade, String registration_date) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.exam_grade = exam_grade;
        this.registration_date = registration_date;
    }

    public Workers() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getExam_grade() {
        return exam_grade;
    }

    public void setExam_grade(String exam_grade) {
        this.exam_grade = exam_grade;
    }

    public String getRegistration_date() {
        return registration_date;
    }

    public void setRegistration_date(String registration_date) {
        this.registration_date = registration_date;
    }

    @Override
    public String toString() {
        return "Workers{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", exam_grade='" + exam_grade + '\'' +
                ", registration_date='" + registration_date + '\'' +
                '}';
    }
}
