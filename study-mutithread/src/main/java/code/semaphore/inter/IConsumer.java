package code.semaphore.inter;

/**
 * Created by vipkid on 16/8/24.
 */
public interface IConsumer extends  Runnable{

    <T> void conosume(T source);
}
