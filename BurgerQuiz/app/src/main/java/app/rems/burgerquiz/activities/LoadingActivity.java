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
public class LoadingActivity extends Activity implements
        GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener {

    private static int RC_SIGN_IN = 9001;

    private boolean mResolvingConnectionFailure = false;
    private boolean mAutoStartSignInflow = true;
    private boolean mSignInClicked = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.fragment_loading);
        getActionBar().hide();
        // Create the Google Api Client with access to the Play Game services
        BurgerVariables.mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(Games.API).addScope(Games.SCOPE_GAMES)
                        // add other APIs and scopes here as needed
                .build();


    }

    @Override
    protected void onStart() {
        super.onStart();
        BurgerVariables.mGoogleApiClient.connect();
    }



    @Override
    public void onConnected(Bundle bundle) {

        Log.d(null, "burger quiz CONNECTE COUCOU");
        Intent intent = new Intent(this, BurgerQuizActivity.class);
        startActivity(intent);

    }


    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {
        if (mResolvingConnectionFailure) {
            // already resolving
            return;
        }

        // if the sign-in button was clicked or if auto sign-in is enabled,
        // launch the sign-in flow
        if (mSignInClicked || mAutoStartSignInflow) {
            mAutoStartSignInflow = false;
            mSignInClicked = false;
            mResolvingConnectionFailure = true;

            if (!BaseGameUtils.resolveConnectionFailure(this,
                    BurgerVariables.mGoogleApiClient, connectionResult,
                    RC_SIGN_IN, "ERROR DE MERDE"))
            {
                mResolvingConnectionFailure = false;
            }
            // Attempt to resolve the connection failure using BaseGameUtils.
            // The R.string.signin_other_error value should reference a generic
            // error string in your strings.xml file, such as "There was
            // an issue with sign-in, please try again later."
            Log.d(null, "Burger quiz - error sign in 1 " + connectionResult.toString());
        }

        // Put code here to display the sign-in button
    }

    @Override
    public void onConnectionSuspended(int i) {
        // Attempt to reconnect
        BurgerVariables.mGoogleApiClient.connect();
    }

    protected void onActivityResult(int requestCode, int resultCode,
                                    Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        if (requestCode == RC_SIGN_IN) {
            mSignInClicked = false;
            Log.d(null, "code " + requestCode + " result " + resultCode);
            mResolvingConnectionFailure = false;
            if (resultCode == RESULT_OK) {
                BurgerVariables.mGoogleApiClient.connect();
            } else {
                // Bring up an error dialog to alert the user that sign-in
                // failed. The R.string.signin_failure should reference an error
                // string in your strings.xml file that tells the user they
                // could not be signed in, such as "Unable to sign in."

                BaseGameUtils.showActivityResultError(this,
                        requestCode, resultCode, R.string.error_signin);
            }
        }
    }
}
