package Model;

import java.time.LocalDate;

public class Human {
    private Long id;
    private String name;
    private String gender;
    private LocalDate birtDate;
    private Division division;
    private Integer salary;

    public Human() {
    }

    public Human(final Long id,
                 final String name,
                 final String gender,
                 final LocalDate birtDate,
                 final Division division,
                 final Integer salary) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.birtDate = birtDate;
        this.division = division;
        this.salary = salary;
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(final String gender) {
        this.gender = gender;
    }

    public LocalDate getBirtDate() {
        return birtDate;
    }

    public void setBirtDate(final LocalDate birtDate) {
        this.birtDate = birtDate;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(final Division division) {
        this.division = division;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(final Integer salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Human{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", birtDate=" + birtDate +
                ", division=" + division.toString() +
                ", salary=" + salary +
                '}';
    }
}
