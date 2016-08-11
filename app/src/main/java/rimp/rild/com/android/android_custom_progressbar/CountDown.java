package rimp.rild.com.android.android_custom_progressbar;

import android.os.CountDownTimer;

/**
 * Created by rild on 16/08/11.
 */
public class CountDown extends CountDownTimer {

    OnFinishListener onFinishListener;
    OnTickhListener onTickhListener;

    public CountDown(long millisInFuture, long countDownInterval) {
        super(millisInFuture, countDownInterval);
    }

    @Override
    public void onTick(long millisUntilFinished) {
        if (onTickhListener != null) onTickhListener.onTick(millisUntilFinished);
    }

    @Override
    public void onFinish() {
        if (onFinishListener != null) onFinishListener.onFinish();
    }

    public interface OnFinishListener {
        void onFinish();
    }

    public interface OnTickhListener {
        void onTick(long millisUntilFinished);
    }
}
