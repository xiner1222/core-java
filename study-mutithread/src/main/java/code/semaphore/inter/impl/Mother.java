package code.semaphore.inter.impl;

import code.semaphore.Plant;
import code.semaphore.inter.IProducer;

/**
 * Created by vipkid on 16/8/24.
 */
public class Mother implements IProducer {

    private Plant plant;

    public Mother(Plant plant) {
        this.plant = plant;
    }

    public <T> void product(T source) {
        System.out.println("mother product orange! : orange_count : "+source);

    }

    public void run() {

        while(true){
            System.out.println("Mother--->");
            try {
                plant.put(new Apple());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }
}
