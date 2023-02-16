public class Main {
    public static void main(String[] args) {
        HWQueue<Integer> queue = new HWQueue<>();
        Thread thread1 = new Thread(() -> {
            queue.enq(1);
            queue.enq(3);
            System.out.println("thread one dequed " + queue.deq());

        });
        Thread thread2 = new Thread(() -> {
            queue.enq(2);
            queue.enq(4);
            System.out.println("thread two dequed " + queue.deq());
        });
        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


//        for(int i = 0; i < queue.items.length;i++){
//            System.out.println(queue.deq());
//        }

    }




}