package code.semaphore.inter.impl;

import code.semaphore.SemaphorePlant;
import code.semaphore.inter.IConsumer;
import code.semaphore.inter.IPlant;

/**
 * Created by vipkid on 16/8/24.
 */
public class Son implements IConsumer {

    private IPlant semaphorePlant;

    public Son(IPlant semaphorePlant) {
        this.semaphorePlant = semaphorePlant;
    }

    public <T> void conosume(T source) {
        System.out.print("son consume apple ! : apple_count : "+ source);
    }

    public void run() {

        while(true){
            try {
                semaphorePlant.take(new Apple());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
