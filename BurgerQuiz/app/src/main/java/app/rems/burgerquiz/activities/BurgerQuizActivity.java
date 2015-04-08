package app.rems.burgerquiz.activities;

import app.rems.burgerquiz.R;
import app.rems.burgerquiz.fragments.LoadingFragment;
import app.rems.burgerquiz.fragments.MainMenuFragment;
import app.rems.burgerquiz.fragments.NuggetsFragment;
import app.rems.burgerquiz.fragments.ScoreFragment;
import app.rems.burgerquiz.fragments.SelOuPoivreFragment;
import app.rems.burgerquiz.game.BurgerQuiz;
import app.rems.burgerquiz.game.BurgerVariables;
import app.rems.burgerquiz.nuggets.NuggetsManager;
import app.rems.burgerquiz.seloupoivre.SelOuPoivreManager;
import app.rems.burgerquiz.utils.BurgerFragmentListener;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.graphics.Typeface;
import android.graphics.drawable.AnimationDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class BurgerQuizActivity extends Activity implements BurgerFragmentListener {

    LoadingFragment loadingFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        BurgerVariables.bqActivity = this;
        setContentView(R.layout.activity_burger_quiz);
        setUpUi();
        loadingFragment = (LoadingFragment) getFragmentManager().findFragmentById(R.id.fragment);
        BurgerVariables.burgerQuiz = new BurgerQuiz();
        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                }
                Thread thread = new Thread() {
                    @Override
                    public void run() {
                        loadManagers();
                    }
                };
                thread.start();
            }
        };
        thread.start();


    }

    private void loadManagers() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                BurgerVariables.customFont = Typeface.createFromAsset(getAssets(),
                        "fonts/horseshoeslemonade.ttf");
                NuggetsManager.loadNuggets();
                SelOuPoivreManager.loadSelOuPoivre();
                SelOuPoivreManager.loadSelOuPoivreQuestions();

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
            case SCORE:
                epreuve = ScoreFragment.newInstance();
                break;
            case MAINMENU:
                epreuve = MainMenuFragment.newInstance();
                break;
            case NUGGETS:
                epreuve = NuggetsFragment.newInstance();
                break;
            case SELOUPOIVRE:
                epreuve = SelOuPoivreFragment.newInstance();
                break;
            default:
                epreuve = NuggetsFragment.newInstance();
                break;
        }

        ft.replace(R.id.fragment, epreuve);

        ft.commit();

    }
}
