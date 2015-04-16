package app.rems.burgerquiz.game;

import android.graphics.Typeface;

import com.google.android.gms.common.api.GoogleApiClient;

import java.util.Random;

import app.rems.burgerquiz.activities.BurgerQuizActivity;
import app.rems.burgerquiz.activities.GameActivity;

/**
 * Created by remsd_000 on 01/04/2015.
 */
public class BurgerVariables {

    public enum Equipe {
        MAYO,
        KETCHUP
    }

    public enum Epreuve {
        SPLASHSCREEN,
        MAINMENU,
        SCORE,
        NUGGETS,
        SELOUPOIVRE,
        MENUS,
        ADDITION,
        BURGERDELAMORT
    }

    public static BurgerQuiz burgerQuiz;
    public static GameActivity bqActivity;
    public static Random randomGenerator;
    public static Typeface customFont;

    public static GoogleApiClient mGoogleApiClient;
}
