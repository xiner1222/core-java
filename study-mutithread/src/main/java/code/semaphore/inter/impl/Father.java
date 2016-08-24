package code.semaphore.inter.impl;

import code.semaphore.Plant;
import code.semaphore.inter.IProducer;

/**
 * Created by vipkid on 16/8/24.
 */
public class Father implements IProducer {

    private Plant plant;


    public Father(Plant plant) {
        this.plant = plant;
    }

    public <T> void product(T source) {
        System.out.println("father product apple! : apple_count : "+source);
    }

    public void run() {

        while(true){
            try {
                System.out.println("father--->");
                plant.put(new Apple());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
