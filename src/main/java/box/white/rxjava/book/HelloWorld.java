package box.white.rxjava.book;

import io.reactivex.Flowable;

public class HelloWorld {

    public static void main(String[] args) {

        Flowable<String> flowable = Flowable.just("Hello", "World!");
        flowable.subscribe(System.out::println);
    }
}
