package _08_dependency_injection.practice;

public class Main {
    public static void main(String[] args) {
//        1. 생성자 주입 방식 email알림
        OrderService service = new OrderService(new EmailNotificationService());
        service.processOrder();

        System.out.println("---");
        
//        2. setter 주입 방식 SMS알림
        service = new OrderService();
        service.setNotification(new SMSNotificationService());
        service.processOrder();
    }
}