package app.rems.burgerquiz.activities;

import app.rems.burgerquiz.R;
import app.rems.burgerquiz.game.BurgerQuiz;
import app.rems.burgerquiz.game.BurgerVariables;
import app.rems.burgerquiz.utils.BurgerFragmentListener;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class BurgerQuizActivity extends Activity implements BurgerFragmentListener {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_burger_quiz);

        BurgerVariables.burgerQuiz = new BurgerQuiz();

        setUpUi();


    }

    private void setUpUi() {

        getActionBar().hide();

    }


    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
