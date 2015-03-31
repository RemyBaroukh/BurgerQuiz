package app.rems.burgerquiz.game;

import android.util.Log;

/**
 * Created by remsd_000 on 01/04/2015.
 */
public class BurgerQuiz {

    public enum Equipe {
        MAYO,
        KETCHUP
    }

    private Equipe equipe;
    private Boolean asStart = false;

    public BurgerQuiz()
    {
        Log.d(null, "Burger Quiz - Creation du jeu");
    }

    public void start(Equipe equipechoisi)
    {
        equipe = equipechoisi;
        asStart = true;
        Log.d(null, "Burger Quiz - Choix de l'equipe " + equipe.toString());
    }

}
