package BankOfPhillipMa;

import java.util.Date;

public class Employee extends User {
    private String employeeId;
    private String jobTitle;
    private Date hireDate;

    // Constructor
    public Employee(String name, Date birthday, String email, String username, int pin, String password,
            String employeeId, String jobTitle, Date hireDate) {
        super(name, birthday, email, username, pin, password);
        this.employeeId = employeeId;
        this.jobTitle = jobTitle;
        this.hireDate = hireDate;
    }

    // Getters and Setters for Employee-specific attributes
    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }
}