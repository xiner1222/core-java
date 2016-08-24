package code.semaphore.inter;

import code.semaphore.Plant;
import code.semaphore.inter.impl.Daughter;
import code.semaphore.inter.impl.Father;
import code.semaphore.inter.impl.Mother;
import code.semaphore.inter.impl.Son;

/**
 * Created by vipkid on 16/8/24.
 */
public class TestDemo {

    public static void main(String[] args){
        Plant plant = new Plant();

        new Thread(new Father(plant)).start();
        new Thread(new Daughter(plant)).start();
        new Thread(new Mother(plant)).start();
        new Thread(new Son(plant)).start();
    }

}
