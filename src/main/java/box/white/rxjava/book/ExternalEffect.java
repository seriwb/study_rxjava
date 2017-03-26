package box.white.rxjava.book;

import java.util.concurrent.TimeUnit;

import io.reactivex.Flowable;

public class ExternalEffect {

    /** 計算方法を表すenum */
    private enum State {
        ADD, MULTIPLY;
    };

    /** 指定する集計方法 */
    private static State calcMethod;

    public static void main(String[] args) throws Exception {

        // 加算に設定
        calcMethod = State.ADD;

        @SuppressWarnings("boxing")
        Flowable<Long> flowable =
                // 300ミリ秒毎にデータを通知するFlowableを生成
                Flowable.interval(300L, TimeUnit.MILLISECONDS)
                        // 7件まで通知
                        .take(7)
                        // 各データを集計する
                        .scan((sum, data) -> {
                            if (calcMethod == State.ADD) {
                                return sum + data;
                            }
                            else {
                                return sum * data;
                            }
                        });

        // 購読し受け取ったデータを出力する
        flowable.subscribe(data -> System.out.println("data=" + data));

        // 乗算に設定
        Thread.sleep(1000);
        System.out.println("集計方法を変更");
        calcMethod = State.MULTIPLY;

        Thread.sleep(2000);
    }
}
