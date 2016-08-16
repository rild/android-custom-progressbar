package rimp.rild.com.android.android_custom_progressbar;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;

/**
 * Created by rild on 16/08/15.
 */
public class GifProgressBar extends View{
    View blank;
    View gifProgressBar;
    ImageView gifImage;

    public GifProgressBar(Context context, AppCompatActivity appCompatActivity) {
        super(context);

        getViewsFromActivity(appCompatActivity);

        GlideDrawableImageViewTarget target = new GlideDrawableImageViewTarget(gifImage);
        Glide.with(appCompatActivity).load(R.raw.chirno_progress_material_iloveimg_cropped).into(target);
    }

    private void getViewsFromActivity(AppCompatActivity appCompatActivity) {
        blank = appCompatActivity.findViewById(R.id.blank);
        gifProgressBar = appCompatActivity.findViewById(R.id.gif_progressbar);
        gifImage = (ImageView) appCompatActivity.findViewById(R.id.image_gif);
    }

    public void shrinkStart() {
        blank.startAnimation(getWidthAnimation(blank, gifProgressBar));
    }

    private WidthAnimation getWidthAnimation(View blank, final View gifProgressBar) {

        WidthAnimation widthAnime = new WidthAnimation(blank, 0, 280);
        widthAnime.setDuration(10000);
        widthAnime.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                gifProgressBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.progressbar_background));
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                gifProgressBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.progressbar_end_background));
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });
        return widthAnime;
    }
}
