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

public class BurgerQuizActivity extends Activity {

    LoadingFragment loadingFragment;
    private int RC_SELECT_PLAYERS = 666;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_burger_quiz);
    }
}
