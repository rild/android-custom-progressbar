package rimp.rild.com.android.android_custom_progressbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;

public class MainActivity extends AppCompatActivity {
    View blank;
    View gifProgressBar;

    Button restartButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        blank = findViewById(R.id.blank);
        gifProgressBar = findViewById(R.id.gif_progressbar);
        restartButton = (Button) findViewById(R.id.restart);
        restartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shrinkStart();
            }
        });

        ImageView imageView = (ImageView) findViewById(R.id.image_gif);
        GlideDrawableImageViewTarget target = new GlideDrawableImageViewTarget(imageView);
        Glide.with(this).load(R.raw.chirno_progress_material_iloveimg).into(target);

        shrinkStart();
    }

    private void shrinkStart() {
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
            public void onAnimationRepeat(Animation animation) {}
        });
        return widthAnime;
    }
}
