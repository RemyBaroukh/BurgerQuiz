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
    private int currentScoreMayo = 0;
    private int currentScoreKetchup = 0;
    private BurgerVariables.Equipe equipe1 = BurgerVariables.Equipe.PASCHOISI;
    private BurgerVariables.Equipe equipe2 = BurgerVariables.Equipe.PASCHOISI;

    public BurgerQuiz() {
        Log.d(null, "Burger Quiz - Creation du jeu");
    }

    public void start(BurgerVariables.Equipe equipechoisi) {
        equipe = equipechoisi;
        equipe1 = equipechoisi;
        asStart = true;
        BurgerVariables.randomGenerator = new Random();
        Log.d(null, "Burger Quiz - Choix de l'equipe " + equipe.toString());
    }

    public void startP2()
    {
        if (equipe1 == BurgerVariables.Equipe.KETCHUP) {
            equipe = BurgerVariables.Equipe.MAYO;
            equipe2 = BurgerVariables.Equipe.MAYO;
        }
        else
        {
            equipe = BurgerVariables.Equipe.KETCHUP;
            equipe2 = BurgerVariables.Equipe.KETCHUP;
        }

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
                currentEpreuve = BurgerVariables.Epreuve.SELOUPOIVRE;
                break;
            case NUGGETS:
                currentEpreuve = BurgerVariables.Epreuve.SCORE;
                break;
            case SCORE:
                currentEpreuve = BurgerVariables.Epreuve.NUGGETS;
                break;
            case SELOUPOIVRE:
                currentEpreuve = BurgerVariables.Epreuve.SCORE;
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
        Log.d(null, "Burger Quiz - Score actuel " + this.currentScoreKetchup + " " + this.currentScoreMayo);
    }

    public int getCurrentScoreMayo() {
        return currentScoreMayo;
    }

    public void setCurrentScoreMayo(int currentScoreMayo) {
        this.currentScoreMayo = currentScoreMayo;
    }

    public int getCurrentScoreKetchup() {
        return currentScoreKetchup;
    }

    public void setCurrentScoreKetchup(int currentScoreKetchup) {
        this.currentScoreKetchup = currentScoreKetchup;
    }

    public BurgerVariables.Equipe getEquipe1() {
        return equipe1;
    }

    public void setEquipe1(BurgerVariables.Equipe equipe1) {
        this.equipe1 = equipe1;
    }

    public BurgerVariables.Equipe getEquipe2() {
        return equipe2;
    }

    public void setEquipe2(BurgerVariables.Equipe equipe2) {
        this.equipe2 = equipe2;
    }
}
