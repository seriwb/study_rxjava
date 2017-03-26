package box.white.rxjava.book;

import io.reactivex.Flowable;

/**
 * 遅延評価の確認
 */
public class DifferenceFromCallable {

    public static void main(String[] args) throws Exception {

        @SuppressWarnings("boxing")
        Flowable<Long> flowable1 = Flowable.just(System.currentTimeMillis());
        @SuppressWarnings("boxing")
        Flowable<Long> flowable2 = Flowable.fromCallable(() -> System.currentTimeMillis());

        flowable1.subscribe(data -> System.out.println("flowable1: " + data));
        flowable2.subscribe(data -> System.out.println("flowable2: " + data));

        Thread.sleep(1000L);

        flowable1.subscribe(data -> System.out.println("flowable1: " + data));
        flowable2.subscribe(data -> System.out.println("flowable2: " + data));
    }
}
