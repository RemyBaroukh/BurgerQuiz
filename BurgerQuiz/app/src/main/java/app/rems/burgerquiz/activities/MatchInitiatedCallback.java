package app.rems.burgerquiz.activities;

import android.util.Log;

import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatch;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer;

/**
 * Created by Remy on 09/04/2015.
 */
public class MatchInitiatedCallback implements ResultCallback<TurnBasedMultiplayer.InitiateMatchResult> {

    @Override
    public void onResult(TurnBasedMultiplayer.InitiateMatchResult result) {
        // Check if the status code is not success.
        Log.d(null, "Success!!");
        Status status = result.getStatus();
        if (status.isSuccess()) {
//            showError(status.getStatusCode());
            return;
        }

        Log.d(null, "Success!!");

        TurnBasedMatch match = result.getMatch();

        // If this player is not the first player in this match, continue.
        if (match.getData() != null) {
            //showTurnUI(match);
            return;
        }

        // Otherwise, this is the first player. Initialize the game state.
//        initGame(match);

        // Let the player take the first turn
  //      showTurnUI(match);
    }
}
