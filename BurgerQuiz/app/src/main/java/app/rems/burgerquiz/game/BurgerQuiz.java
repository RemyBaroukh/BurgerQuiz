package app.rems.burgerquiz.game;

import android.util.Log;

import java.util.Random;

/**
 * Created by remsd_000 on 01/04/2015.
 */
public class BurgerQuiz {

    private BurgerVariables.Equipe equipe;
    private Boolean asStart = false;
    private BurgerVariables.Epreuve currentEpreuve = BurgerVariables.Epreuve.SPLASHSCREEN;
    private int currentScore;

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
            default:
                break;
        }
        Log.d(null, "Burger Quiz - Changement d'Epreuve " + currentEpreuve.toString());
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
        return currentScore;
    }

    public void setCurrentScore(int currentScore) {
        this.currentScore = currentScore;
    }

    public void addOneToScore()
    {
        this.currentScore++;
    }
}
