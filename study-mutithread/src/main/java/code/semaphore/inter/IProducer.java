package code.semaphore.inter;

/**
 * Created by vipkid on 16/8/24.
 */
public interface IProducer extends Runnable{

    <T> void product(T source);
}
