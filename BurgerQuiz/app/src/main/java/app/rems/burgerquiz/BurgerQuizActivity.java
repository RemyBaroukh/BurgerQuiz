package app.rems.burgerquiz;

import app.rems.burgerquiz.game.BurgerQuiz;
import app.rems.burgerquiz.game.BurgerVariables;
import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

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

        BurgerVariables.burgerQuiz = new BurgerQuiz();

        setUpUi();
        ivMayo = (ImageView) findViewById(R.id.ivMayo);
        ivKetchup = (ImageView) findViewById(R.id.ivKetchup);

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


        //Animated Burger
        ImageView ivBurger = (ImageView) findViewById(R.id.ivBurger);
        ivBurger.setBackgroundResource(R.drawable.burger_animation);
        AnimationDrawable ivBurgerAnimation = (AnimationDrawable) ivBurger.getBackground();
        ivBurgerAnimation.start();


        getActionBar().hide();

    }



}
