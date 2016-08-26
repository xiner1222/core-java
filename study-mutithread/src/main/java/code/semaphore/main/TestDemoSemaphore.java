package code.semaphore.main;

import code.semaphore.SemaphorePlant;
import code.semaphore.inter.impl.Daughter;
import code.semaphore.inter.impl.Father;
import code.semaphore.inter.impl.Mother;
import code.semaphore.inter.impl.Son;

/**
 * Created by vipkid on 16/8/24.
 */
public class TestDemoSemaphore {

    public static void main(String[] args){
        SemaphorePlant semaphorePlant = new SemaphorePlant();

        new Thread(new Father(semaphorePlant)).start();
        new Thread(new Daughter(semaphorePlant)).start();
        new Thread(new Mother(semaphorePlant)).start();
        new Thread(new Son(semaphorePlant)).start();
    }

}
