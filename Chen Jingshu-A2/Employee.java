package org.example;

class Employee extends Person {
    private String employeeId;
    private String role;

    // 默认构造方法
    public Employee() {}

    // 带参数的构造方法
    public Employee(String name, int age, String gender, String employeeId, String role) {
        super(name, age, gender);
        this.employeeId = employeeId;
        this.role = role;
    }

    // Getter 和 Setter 方法
    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
