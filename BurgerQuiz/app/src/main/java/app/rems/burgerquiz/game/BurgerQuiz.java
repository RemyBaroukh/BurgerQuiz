package app.rems.burgerquiz.game;

import android.util.Log;

import org.json.JSONObject;

import java.util.Random;

/**
 * Created by remsd_000 on 01/04/2015.
 */
public class BurgerQuiz {

    private BurgerVariables.Equipe equipe;
    private Boolean asStart = false;
    private BurgerVariables.Epreuve currentEpreuve = BurgerVariables.Epreuve.SPLASHSCREEN;
    private int currentScoreMayo;
    private int currentScoreKetchup;

    public BurgerQuiz() {
        Log.d(null, "Burger Quiz - Creation du jeu");
    }

    public void start(BurgerVariables.Equipe equipechoisi) {
        equipe = equipechoisi;
        asStart = true;
        BurgerVariables.randomGenerator = new Random();
        Log.d(null, "Burger Quiz - Choix de l'equipe " + equipe.toString());
    }


    public void nextEpreuve() {

        switch(currentEpreuve)
        {
            case SPLASHSCREEN:
                currentEpreuve = BurgerVariables.Epreuve.MAINMENU;
                break;
            case MAINMENU:
                currentEpreuve = BurgerVariables.Epreuve.NUGGETS;
                break;
            case NUGGETS:
                currentEpreuve = BurgerVariables.Epreuve.SCORE;
                break;
            case SCORE:
                currentEpreuve = BurgerVariables.Epreuve.SELOUPOIVRE;
                break;
            default:
                break;
        }
        Log.d(null, "Burger Quiz - Changement d'Epreuve " + currentEpreuve.toString() + " " + currentScoreMayo + " " + currentScoreKetchup);
       BurgerVariables.bqActivity.showEpreuve();
    }

    public BurgerVariables.Equipe getEquipe() {
        return equipe;
    }

    public void setEquipe(BurgerVariables.Equipe equipe) {
        this.equipe = equipe;
    }

    public Boolean getAsStart() {
        return asStart;
    }

    public void setAsStart(Boolean asStart) {
        this.asStart = asStart;
    }

    public BurgerVariables.Epreuve getCurrentEpreuve() {
        return currentEpreuve;
    }

    public void setCurrentEpreuve(BurgerVariables.Epreuve currentEpreuve) {
        this.currentEpreuve = currentEpreuve;
    }

    public int getCurrentScore() {
        if (equipe == BurgerVariables.Equipe.KETCHUP)
            return currentScoreKetchup;
        else
            return currentScoreMayo;
    }

    public void setCurrentScore(int currentScore) {
        if (equipe == BurgerVariables.Equipe.KETCHUP)
            currentScoreKetchup = currentScore;
        else
            currentScoreMayo = currentScore;
    }

    public void addOneToScore()
    {
        if (equipe == BurgerVariables.Equipe.KETCHUP)
            this.currentScoreKetchup++;
        else
            this.currentScoreMayo++;
    }
}
