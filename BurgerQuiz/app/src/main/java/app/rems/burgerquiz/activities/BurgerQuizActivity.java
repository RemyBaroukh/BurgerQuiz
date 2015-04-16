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

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.graphics.Typeface;
import android.graphics.drawable.AnimationDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.transition.Fade;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.google.android.gms.games.Games;
import com.google.android.gms.games.multiplayer.Multiplayer;
import com.google.android.gms.games.multiplayer.realtime.RoomConfig;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatchConfig;

import java.util.ArrayList;

public class BurgerQuizActivity extends Activity implements BurgerFragmentListener {

    LoadingFragment loadingFragment;
    private int RC_SELECT_PLAYERS = 666;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
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
        //TODO: DELETE THAT
        epreuve.setEnterTransition(new Fade(Fade.IN));
        epreuve.setExitTransition(new Fade(Fade.OUT));
        ft.replace(R.id.fragment, epreuve);

        ft.commit();

    }

    @Override
    protected void onStop() {
        super.onStop();
        BurgerVariables.mGoogleApiClient.disconnect();
    }

    @Override
    public void onActivityResult(int request, int response, Intent data) {
        super.onActivityResult(request, response, data);

        if (request == RC_SELECT_PLAYERS) {
            if (response != Activity.RESULT_OK) {
                // user canceled
                return;
            }

            Log.d(null, "SALUT MULTIPLAYER");
            // Get the invitee list.
            final ArrayList<String> invitees =
                    data.getStringArrayListExtra(Games.EXTRA_PLAYER_IDS);

            // Get auto-match criteria.
            Bundle autoMatchCriteria = null;
            int minAutoMatchPlayers = data.getIntExtra(
                    Multiplayer.EXTRA_MIN_AUTOMATCH_PLAYERS, 0);
            int maxAutoMatchPlayers = data.getIntExtra(
                    Multiplayer.EXTRA_MAX_AUTOMATCH_PLAYERS, 0);
            if (minAutoMatchPlayers > 0) {
                autoMatchCriteria = RoomConfig.createAutoMatchCriteria(
                        minAutoMatchPlayers, maxAutoMatchPlayers, 0);
            } else {
                autoMatchCriteria = null;
            }

            TurnBasedMatchConfig tbmc = TurnBasedMatchConfig.builder()
                    .addInvitedPlayers(invitees)
                    .setAutoMatchCriteria(autoMatchCriteria)
                    .build();

            // Create and start the match.
            Games.TurnBasedMultiplayer
                    .createMatch(BurgerVariables.mGoogleApiClient, tbmc)
                    .setResultCallback(new MatchInitiatedCallback());
        }
    }
}
