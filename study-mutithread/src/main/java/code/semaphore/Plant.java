package code.semaphore;

import code.semaphore.inter.Fruit;
import code.semaphore.inter.IConsumer;
import code.semaphore.inter.IProducer;
import code.semaphore.inter.impl.Daughter;
import code.semaphore.inter.impl.Father;
import code.semaphore.inter.impl.Mother;
import code.semaphore.inter.impl.Orange;
import code.semaphore.inter.impl.Son;

import java.util.concurrent.Semaphore;

/**
 * Created by vipkid on 16/8/24.
 */
public class Plant {

    private static final int PLANT_COUNT_EMPTY = 1;

    Semaphore plant = new Semaphore(PLANT_COUNT_EMPTY);
    Semaphore mutex = new Semaphore(1);
    Semaphore orange = new Semaphore(0);
    Semaphore apple = new Semaphore(0);


    public <T extends Fruit>void take(T obj) throws InterruptedException {
        if(obj.getClass().equals(Orange.class)){
            orange.acquire();
        }else{
            apple.acquire();
        }
        mutex.acquire();
        System.out.println("take : "+obj.getName());
        mutex.release();
        plant.release();

    }

    public <T extends Fruit>void put(T obj) throws InterruptedException {

        plant.acquire();
        mutex.acquire();
        System.out.println("put : "+obj.getName());
        mutex.release();
        if(obj.getClass().equals(Orange.class)){
            orange.release();
        }else{
            apple.release();
        }
    }
}
