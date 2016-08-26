package code.semaphore.inter.impl;

import code.semaphore.SemaphorePlant;
import code.semaphore.inter.IPlant;
import code.semaphore.inter.IProducer;

/**
 * Created by vipkid on 16/8/24.
 */
public class Mother implements IProducer {

    private IPlant semaphorePlant;

    public Mother(IPlant semaphorePlant) {
        this.semaphorePlant = semaphorePlant;
    }

    public <T> void product(T source) {
        System.out.println("mother product orange! : orange_count : "+source);

    }

    public void run() {

        while(true){
            try {
                semaphorePlant.put(new Apple());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }
}
