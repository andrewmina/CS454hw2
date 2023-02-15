public class Main {
    public static void main(String[] args) {
        HWQueue<Integer> queue = new HWQueue<>();
        Thread thread1 = new Thread(() -> {
            queue.enq(1);

        });
        Thread thread2 = new Thread(() -> {
            queue.deq();
            queue.enq(2);
        });
        thread1.start();
        thread2.start();

        for(int i = 0; i < queue.items.length;i++){
            System.out.println(queue.deq());
        }

    }




}