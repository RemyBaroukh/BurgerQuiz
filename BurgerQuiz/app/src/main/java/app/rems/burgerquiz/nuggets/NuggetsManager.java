package app.rems.burgerquiz.nuggets;

import android.content.Context;
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

import app.rems.burgerquiz.activities.BurgerQuizActivity;
import app.rems.burgerquiz.game.BurgerVariables;

/**
 * Created by remsd_000 on 04/04/2015.
 */
public class NuggetsManager {

    static ArrayList<Nugget> nuggets = new ArrayList<>();

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
            JSONArray nuggetsList = new JSONArray(response);
            for(int i = 0; i < nuggetsList.length(); i++)
            {
                JSONObject nugget = nuggetsList.getJSONObject(i);
                Nugget nugget1 = new Nugget(Integer.valueOf(nugget.getString("idQuestion")));
                nugget1.setQuestion(nugget.getString("question").replaceAll("\\u0092","'"));
                nugget1.setReponse1(nugget.getString("reponse1").replaceAll("\\u0092","'"));
                nugget1.setReponse2(nugget.getString("reponse2").replaceAll("\\u0092","'"));
                nugget1.setReponse3(nugget.getString("reponse3").replaceAll("\\u0092","'"));
                nugget1.setReponse4(nugget.getString("reponse4").replaceAll("\\u0092","'"));
                nugget1.setResponse(nugget.getString("reponses").replaceAll("\\u0092","'"));
                nuggets.add(nugget1);
                Log.d(null, "Burger Quiz - " + nugget1.toString());

            }
            BurgerVariables.burgerQuiz.nextEpreuve();


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

    public static boolean checkReponse(int idReponse, Nugget n)
    {
        switch(idReponse)
        {
            case 0:
                return n.getResponse().contains("1");
            case 1:
                return n.getResponse().contains("2");
            case 2:
                return n.getResponse().contains("3");
            case 3:
                return n.getResponse().contains("4");
            default:
                return false;

        }
    }


    public static Nugget getRandomQuestion()
    {
        int i = BurgerVariables.randomGenerator.nextInt(nuggets.size());
        return nuggets.get(i);
    }
}
