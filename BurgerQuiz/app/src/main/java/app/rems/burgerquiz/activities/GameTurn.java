package app.rems.burgerquiz.activities;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

/**
 * Created by remsd_000 on 14/04/2015.
 */
public class GameTurn {


    public static final String TAG = "EBTurn";

    public int mayoPoints = 0;
    public int ketchupPoints = 0;
    public int turnCounter;

    public GameTurn() {
    }

    // This is the byte array we will write out to the TBMP API.
    public byte[] persist() {
        JSONObject retVal = new JSONObject();

        try {
            retVal.put("mayoPoints", mayoPoints);
            retVal.put("ketchupPoints", ketchupPoints);
            retVal.put("turnCounter", turnCounter);

        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        String st = retVal.toString();

        Log.d(TAG, "==== PERSISTING\n" + st);

        return st.getBytes(Charset.forName("UTF-8"));
    }

    // Creates a new instance of SkeletonTurn.
    static public GameTurn unpersist(byte[] byteArray) {

        if (byteArray == null) {
            Log.d(TAG, "Empty array---possible bug.");
            return new GameTurn();
        }

        String st = null;
        try {
            st = new String(byteArray, "UTF-8");
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
            return null;
        }

        Log.d(TAG, "====UNPERSIST \n" + st);

        GameTurn retVal = new GameTurn();

        try {
            JSONObject obj = new JSONObject(st);

            if (obj.has("mayoPoints")) {
                retVal.mayoPoints = obj.getInt("mayoPoints");
            }
            if (obj.has("turnCounter")) {
                retVal.turnCounter = obj.getInt("turnCounter");
            }
            if (obj.has("ketchupPoints")) {
                retVal.ketchupPoints = obj.getInt("ketchupPoints");
            }

        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return retVal;
    }
}
