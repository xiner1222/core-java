package code.semaphore.inter;

/**
 * Created by vipkid on 16/8/25.
 */
public interface IPlant {

    public <T extends Fruit>void take(T obj) throws InterruptedException;

    public <T extends Fruit>void put(T obj) throws InterruptedException ;

}
