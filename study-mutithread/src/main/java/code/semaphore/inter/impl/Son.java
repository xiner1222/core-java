package code.semaphore.inter.impl;

import code.semaphore.Plant;
import code.semaphore.inter.IConsumer;

/**
 * Created by vipkid on 16/8/24.
 */
public class Son implements IConsumer {

    private Plant plant;

    public Son(Plant plant) {
        this.plant = plant;
    }

    public <T> void conosume(T source) {
        System.out.print("son consume apple ! : apple_count : "+ source);
    }

    public void run() {

        while(true){
            System.out.println("Son--->");
            try {
                plant.take(new Apple());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
