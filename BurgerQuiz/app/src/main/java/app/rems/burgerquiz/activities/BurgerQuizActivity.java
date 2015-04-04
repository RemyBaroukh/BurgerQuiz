package app.rems.burgerquiz.activities;

import app.rems.burgerquiz.R;
import app.rems.burgerquiz.fragments.NuggetsFragment;
import app.rems.burgerquiz.game.BurgerQuiz;
import app.rems.burgerquiz.game.BurgerVariables;
import app.rems.burgerquiz.nuggets.NuggetsManager;
import app.rems.burgerquiz.utils.BurgerFragmentListener;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.graphics.drawable.AnimationDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class BurgerQuizActivity extends Activity implements BurgerFragmentListener {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_burger_quiz);
        BurgerVariables.burgerQuiz = new BurgerQuiz();
        setUpUi();
        new Thread(new Runnable() {
            @Override
            public void run() {
                NuggetsManager.loadNuggets();
            }
        }).start();

    }

    private void setUpUi() {

        getActionBar().hide();

    }

    @Override
    public void showEpreuve() {

        Log.d(null, "Burger Quiz - Changment d'Epreuve - UI " );
       FragmentTransaction ft = getFragmentManager().beginTransaction();

        Fragment epreuve;
        switch(BurgerVariables.burgerQuiz.getCurrentEpreuve())
        {
            case NUGGETS:
                epreuve = NuggetsFragment.newInstance();
                break;
            default:
                epreuve = NuggetsFragment.newInstance();
                break;
        }

        ft.replace(R.id.fragment, epreuve);

        ft.commit();

    }
}
