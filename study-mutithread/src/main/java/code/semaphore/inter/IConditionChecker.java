package code.semaphore.inter;

/**
 * Created by vipkid on 16/8/25.
 */
public interface IConditionChecker {
    <T,S>boolean checkCondition(T conditon,S target);
}
