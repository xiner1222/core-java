package code.semaphore.main;

import code.semaphore.ConditionPlant;
import code.semaphore.inter.impl.Daughter;
import code.semaphore.inter.impl.Father;
import code.semaphore.inter.impl.Mother;
import code.semaphore.inter.impl.Son;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by vipkid on 16/8/26.
 */
public class TestDemoMonitor {

    public static void main(String[] args){
        Lock lock = new ReentrantLock();
        ConditionPlant plant  = new ConditionPlant(lock);

        Father father = new Father(plant);
        Mother mother = new Mother(plant);
        Son son = new Son(plant);
        Daughter daughter = new Daughter(plant);

        new Thread(father).start();
//        new Thread(mother).start();
        new Thread(son).start();
//        new Thread(daughter).start();


    }
}
