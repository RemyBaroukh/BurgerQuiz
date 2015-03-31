package app.rems.burgerquiz;

import app.rems.burgerquiz.game.BurgerQuiz;
import app.rems.burgerquiz.game.BurgerVariables;
import app.rems.burgerquiz.util.SystemUiHider;

import android.annotation.TargetApi;
import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;


/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 *
 * @see SystemUiHider
 */
public class BurgerQuizActivity extends Activity {

    /**
     * Main menu
     */
    private ImageView ivMayo;
    private ImageView ivKetchup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_burger_quiz);

        setUpUi();
        ivMayo = (ImageView) findViewById(R.id.ivMayo);
        ivKetchup = (ImageView) findViewById(R.id.ivKetchup);

        BurgerVariables.burgerQuiz = new BurgerQuiz();

        ivMayo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BurgerVariables.burgerQuiz.start(BurgerQuiz.Equipe.MAYO);
            }
        });
        ivKetchup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BurgerVariables.burgerQuiz.start(BurgerQuiz.Equipe.KETCHUP);
            }
        });


    }

    private void setUpUi() {
        ImageView ivBurger = (ImageView) findViewById(R.id.ivBurger);
        ivBurger.setBackgroundResource(R.drawable.burger_animation);
        AnimationDrawable ivBurgerAnimation = (AnimationDrawable) ivBurger.getBackground();
        ivBurgerAnimation.start();
        getActionBar().hide();


    }



}
