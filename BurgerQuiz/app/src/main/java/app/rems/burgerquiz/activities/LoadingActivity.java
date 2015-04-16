package app.rems.burgerquiz.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.games.Games;
import com.google.example.games.basegameutils.BaseGameUtils;

import app.rems.burgerquiz.R;
import app.rems.burgerquiz.game.BurgerVariables;


/**
 * Created by remsd_000 on 06/04/2015.
 */
public class LoadingActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.fragment_loading);
        getActionBar().hide();

        //todo change place
        Intent intent = new Intent(this, BurgerQuizActivity.class);
        startActivity(intent);


    }

    @Override
    protected void onStart() {
        super.onStart();
    }



}
