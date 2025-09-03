package _09_others.builder;

public class Computer {
//    모든 필드를 private final 선언 (불변성 보장)
    private final String cpu;
    private final String gpu;
    private final int ram;
    private final int storage;

//    private 생성자 -> 외부에서 생성자를 직접 호출 불가능
    private Computer(ComputerBuilder builder) {
        this.cpu = builder.cpu;
        this.gpu = builder.gpu;
        this.ram = builder.ram;
        this.storage = builder.storage;
    }

//    내부 정적 클래스 -> public 선언 -> 외부에서 접근 가능
    public static class ComputerBuilder {
        private String cpu;
        private String gpu;
        private int ram;
        private int storage;
        
//      객체 생성자 public
//      cpu 필드만 매개변수로 받음 -> cpu 필드를 필수값으로 받기 위함
        public ComputerBuilder(String cpu) { this.cpu = cpu; }
    
//      cpu 필드를 제외한 나머지 필드에 대한 setter
//      - this(자기자신, ComputerBuilder) 를 반환 -> "메서드 체이닝" 가능하게 하려고!
        public ComputerBuilder setRam(int ram) {
            this.ram = ram;
            return this;
        }

        public ComputerBuilder setStorage(int storage) {
            this.storage = storage;
            return this;
        }

        public ComputerBuilder setGpu(String gpu) {
            this.gpu = gpu;
            return this;
        }

//        최종적으로 객체 생성하는 메서드
        public Computer build() {
            return new Computer(this);
        }
    }

    @Override
    public String toString() {
        return "ComputerBuilder{" +
                "cpu='" + cpu + '\'' +
                ", gpu='" + gpu + '\'' +
                ", ram=" + ram +
                ", storage=" + storage +
                '}';
    }
}