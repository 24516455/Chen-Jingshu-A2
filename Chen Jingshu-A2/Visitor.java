package org.example;

class Visitor extends Person {
    private String visitorId;
    private String ticketType;

    // 默认构造方法
    public Visitor() {}

    // 带参数的构造方法
    public Visitor(String name, int age, String gender, String visitorId, String ticketType) {
        super(name, age, gender);
        this.visitorId = visitorId;
        this.ticketType = ticketType;
    }

    // Getter 和 Setter 方法
    public String getVisitorId() {
        return visitorId;
    }

    public void setVisitorId(String visitorId) {
        this.visitorId = visitorId;
    }

    public String getTicketType() {
        return ticketType;
    }

    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }
}
