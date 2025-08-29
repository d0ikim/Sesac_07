package _08_dependency_injection.practice;

public class OrderService {
    private NotificationService service;  // 필드를 인터페이스 타입으로 선언

//   1. 생성자 이용 의존성 주입
    public OrderService(NotificationService service){
        this.service = service;
    }

//    2. setter 이용 의존성 주입
    public OrderService() {}    // setter 주입을 위한 기본 생성자

    public void setNotification(NotificationService service) {
        this.service = service;
    }

//    주문 처리 후 알림 전송
    public void processOrder() {
        System.out.println("Order processed successfully");
        service.notificate();
    }
}
