package code.semaphore.inter.impl;

import code.semaphore.Plant;
import code.semaphore.inter.IConsumer;

/**
 * Created by vipkid on 16/8/24.
 */
public class Daughter implements IConsumer {
    private Plant plant;


    public Daughter(Plant plant) {
        this.plant = plant;
    }

    public <T> void conosume(T source) {
        System.out.print("daughter consume orange ! : orange_count : "+ source);
    }

    public void run() {

        while(true){
            System.out.println("daughter--->");
            try {
                plant.take(new Orange());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
