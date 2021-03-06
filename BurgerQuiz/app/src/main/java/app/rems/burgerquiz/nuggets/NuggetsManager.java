package app.rems.burgerquiz.nuggets;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by remsd_000 on 04/04/2015.
 */
public class NuggetsManager {

    private ArrayList<Nugget> nuggets = new ArrayList<>();

    public static void loadNuggets()
    {
        HttpURLConnection urlConnection = null;
        URL url = null;
        JSONObject object = null;
        InputStream inStream = null;
        try {
            url = new URL("http://remybaroukh.fr/burgerquiz/getnuggets.php");
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.setDoOutput(true);
            urlConnection.setDoInput(true);
            urlConnection.connect();
            inStream = urlConnection.getInputStream();
            BufferedReader bReader = new BufferedReader(new InputStreamReader(inStream));
            String temp, response = "";
            while ((temp = bReader.readLine()) != null) {
                response += temp;
            }
            object = new JSONObject(response);
            JSONArray nuggetsList = object.getJSONArray("nuggets");
            for(int i = 0; i < nuggetsList.length(); i++)
            {
                JSONObject nugget = nuggetsList.getJSONObject(i);
                Nugget nugget1 = new Nugget(Integer.valueOf(nugget.getString("idQuestion")));
                nugget1.setQuestion(nugget.getString("question"));
                nugget1.setReponse1(nugget.getString("reponse1"));
                nugget1.setReponse2(nugget.getString("reponse2"));
                nugget1.setReponse3(nugget.getString("reponse3"));
                nugget1.setReponse4(nugget.getString("reponse4"));
                Log.d(null, "Burger Quiz - Nuggets - OnCreate chargement des nuggets " + nugget1.toString());

            }

        } catch (Exception e) {
            Log.e(null, e.toString());
        } finally {
            if (inStream != null) {
                try {
                    // this will close the bReader as well
                    inStream.close();
                } catch (IOException ignored) {
                }
            }
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
        }
    }
}
