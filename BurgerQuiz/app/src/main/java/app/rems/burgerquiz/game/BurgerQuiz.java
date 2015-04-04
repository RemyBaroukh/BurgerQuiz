package app.rems.burgerquiz.game;

import android.util.Log;

import java.util.Random;

/**
 * Created by remsd_000 on 01/04/2015.
 */
public class BurgerQuiz {

    private BurgerVariables.Equipe equipe;
    private Boolean asStart = false;
    private BurgerVariables.Epreuve currentEpreuve = BurgerVariables.Epreuve.MAINMENU;

    public BurgerQuiz()
    {
        Log.d(null, "Burger Quiz - Creation du jeu");
    }

    public void start(BurgerVariables.Equipe equipechoisi)
    {
        equipe = equipechoisi;
        asStart = true;
        BurgerVariables.randomGenerator = new Random();
        Log.d(null, "Burger Quiz - Choix de l'equipe " + equipe.toString());
    }

    public void nextEpreuve()
    {
        if (currentEpreuve == BurgerVariables.Epreuve.MAINMENU)
            currentEpreuve = BurgerVariables.Epreuve.NUGGETS;
        Log.d(null, "Burger Quiz - Changement d'Epreuve " + currentEpreuve.toString());
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
}
