package app.rems.burgerquiz.game;

import java.util.Random;

import app.rems.burgerquiz.activities.BurgerQuizActivity;

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
    public static BurgerQuizActivity bqActivity;
    public static Random randomGenerator;
}
