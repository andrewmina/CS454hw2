public class Main {
    public static void main(String[] args) {
        HWQueue<Integer> queue = new HWQueue<>();
        Thread thread1 = new Thread(() -> {
            queue.enq(1);
            System.out.println("thread one " + queue.tail);

        });
        Thread thread2 = new Thread(() -> {
            queue.enq(2);
            System.out.println("thread two " + queue.tail);
        });
        thread1.start();
        thread2.start();

//        for(int i = 0; i < queue.items.length;i++){
//            System.out.println(queue.deq());
//        }

    }




}