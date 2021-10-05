public class EmployeeTest {
    public static void main(String[] args) {
        Employee[] employeeArray = new Employee[5];
        employeeArray[0] = new Employee("Pervyy Ivan", "Engineer", " ivivan@mailbox.com ", "892312312", 30000,
                30);
        employeeArray[1] = new Employee("Vtoroy Ivan", "Manager", " twoivan@mailbox.com ", "+794521435", 50000,
                35);
        employeeArray[2] = new Employee("Tretyy Ivan", "Tester", " theeivan@mailbox.com ", "87452142313", 20000,
                25);
        employeeArray[3] = new Employee("Chetvertyy Ivan", "Povar", " chetireivan@mailbox.com ", "6546546", 10000,
                40);
        employeeArray[4] = new Employee("Pyatyy Ivan", "Director", " patyyivan@mailbox.com ", "46545646", 80000,
                45);
        for (Employee employee : employeeArray) {
            if (employee.age > 40) {
                employee.getEmployeeInfo();
            }
        }
    }
}
