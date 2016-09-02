package code.semaphore;

import code.semaphore.inter.Fruit;
import code.semaphore.inter.IPlant;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * Created by vipkid on 16/8/25.
 */
public class ConditionPlant implements IPlant{
    final Lock lock;
    final Condition isEmptyOrange;
    final Condition isEmptyApple;
    final Condition isFull;
    private static  final int MAX = 100;
//    private static  final Queue<Fruit> orangeBuffer = new ArrayBlockingQueue<Fruit>(MAX);
    private static  final Queue<Fruit> appleBuffer = new ArrayBlockingQueue<Fruit>(MAX);
    private static int count = 0;


    public ConditionPlant(Lock lock) {
        this.lock = lock;
        isFull = lock.newCondition();
        isEmptyApple = lock.newCondition();
        isEmptyOrange = lock.newCondition();

    }


    public <T extends Fruit> void take(T obj) throws InterruptedException {
        lock.lock();

        if(appleBuffer.size()==0){
            System.out.println("take apple await ");
            isEmptyApple.await();
        }
        appleBuffer.remove();

        count--;
        System.out.println("take a apple!  "+ count );

        isFull.signal();
        lock.unlock();

    }

    public <T extends Fruit> void put(T obj) throws InterruptedException {
        lock.lock();

        if(count==MAX){
            System.out.println("put apple await ");
            isFull.await();
        }
        appleBuffer.add(obj);
        count++;
        System.out.println("put a apple!  "+ count );

        isEmptyApple.signal();

        lock.unlock();

    }







}
