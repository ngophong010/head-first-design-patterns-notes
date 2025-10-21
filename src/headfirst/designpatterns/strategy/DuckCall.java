public class DuckCall {
    // 1. Composition: DuckCall HAS-A QuackBehavior 
    QuackBehavior quackBehavior; 

    // Constructor: Assign a specific QuackBehavior (e.g., Quack)
    public DuckCall() {
        // Giả sử Duck Call tạo ra tiếng Quack thông thường (Quack implementation)
        quackBehavior = new Quack(); 
        // Hoặc một tiếng kêu đặc biệt khác (ví dụ: Kwak) 
        // như được thấy trong ví dụ tái hợp Ducks (trang 600)
    }

    // 2. Delegation: The DuckCall delegates the action to the behavior object
    public void mimicQuack() {
        quackBehavior.quack();
    }
    
    // (Tùy chọn) Khả năng thay đổi hành vi động tại runtime
    public void setQuackBehavior(QuackBehavior qb) {
        quackBehavior = qb;
    }
}