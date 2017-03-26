package box.white.rxjava.book;

import io.reactivex.Flowable;

public class MethodChain {

    public static void main(String[] args) {

        @SuppressWarnings("boxing")
        Flowable<Integer> flowable =
                Flowable.just(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                    .filter(data -> data % 2 == 0)
                    .map(data -> data * 100);

        flowable.subscribe(data -> System.out.println("data=" + data));
    }
}
