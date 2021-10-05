public class Employee {

    private String fullName;
    private String role;
    private String email;
    private String phone;
    private int salary;
    protected int age;

    public Employee(String fullName, String role, String email, String phone, int salary, int age) {
        this.fullName = fullName;
        this.role = role;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }


    public void getEmployeeInfo() {
        System.out.println("ФИО: " + fullName + "; Должность: "
                + role + "; Email: " + email + "; Телефон: "
                + phone + "; Зарплата: " + salary + " руб; Возраст: "
                + age + " лет.");
    }
}
