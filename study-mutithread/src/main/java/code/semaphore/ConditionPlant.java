package code.semaphore;

import code.semaphore.inter.Fruit;
import code.semaphore.inter.IConditionChecker;
import code.semaphore.inter.IPlant;
import code.semaphore.inter.impl.Orange;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.SynchronousQueue;
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
    private static  final Queue<Fruit> orangeBuffer = new ArrayBlockingQueue<Fruit>(MAX);
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

        judgeAndTakeFruit(obj);

        count--;

        isFull.signal();
        lock.unlock();

    }

    public <T extends Fruit> void put(T obj) throws InterruptedException {
        lock.lock();

        judgeAndPutFruit(obj);

        count++;
        notifyConsumer(obj);

        lock.unlock();

    }


    private <T extends Fruit>void judgeAndPutFruit(T obj) throws InterruptedException {
        if (count == MAX-1) {
            isFull.await();
        }
        if (obj.getClass().equals(Orange.class)) {
            orangeBuffer.add(obj);
        }else{
            appleBuffer.add(obj);
        }
        System.out.println(" put a "+obj.getName()+ " "+(count+1));
    }

    private <T extends Fruit> void judgeAndTakeFruit(T obj) throws InterruptedException {
        if(obj.getClass().equals(Orange.class)){
            if(orangeBuffer.isEmpty()){
                isEmptyOrange.await();
            }else{
                orangeBuffer.poll();
            }
        }else{
            if(appleBuffer.isEmpty()){
                isEmptyApple.await();

            }else{
                orangeBuffer.poll();

            }
        }
        System.out.println(" take a  "+obj.getName()+ " " + (count-1));
    }

    private <T>void notifyConsumer(T obj){
        if(obj.getClass().equals(Orange.class)){
            isEmptyOrange.signal();
        }else{
            isEmptyApple.signal();
        }
    }





}
