import java.lang.reflect.Array;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;



public class HWQueue<T> {
 AtomicReference<T>[] items;
 AtomicInteger tail;
 static final int CAPACITY = Integer.MAX_VALUE;

         public HWQueue() {
         items =(AtomicReference<T>[]) Array.newInstance(AtomicReference.class, 1000);
         for (int i = 0; i < items.length; i++) {
             items[i] = new AtomicReference<T>(null);
             }
         tail = new AtomicInteger(0);
         }
 public void enq(T x) {
         int i = tail.getAndIncrement();
         items[i].set(x);
         }
 public T deq() {
         while (true) {
             int range = tail.get();
             for (int i = 0; i < range; i++) {
                 T value = items[i].getAndSet(null);
                 if (value != null) {
                     return value;
                     }
                 }
             }
         }
 }
