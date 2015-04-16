package app.rems.burgerquiz.seloupoivre;

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

import app.rems.burgerquiz.game.BurgerVariables;
import app.rems.burgerquiz.nuggets.Nugget;
import app.rems.burgerquiz.utils.BurgerFragmentListener;

/**
 * Created by remsd_000 on 08/04/2015.
 */
public class SelOuPoivreManager {
    static ArrayList<SelOuPoivre> seloupoivreList = new ArrayList<>();

    public static void loadSelOuPoivre()
    {
        HttpURLConnection urlConnection = null;
        URL url = null;
        JSONObject object = null;
        InputStream inStream = null;
        try {
            url = new URL("http://remybaroukh.fr/burgerquiz/getseloupoivre.php");
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
            JSONArray seloupoivreL = new JSONArray(response);
            for(int i = 0; i < seloupoivreL.length(); i++)
            {
                JSONObject seloupoivreobj = seloupoivreL.getJSONObject(i);
                SelOuPoivre selOuPoivre = new SelOuPoivre(Integer.valueOf(seloupoivreobj.getString("idSeloupoivre")));
                selOuPoivre.setSel(seloupoivreobj.getString("titresel").replaceAll("\\u0092","'"));
                selOuPoivre.setPoivre(seloupoivreobj.getString("titrepoivre").replaceAll("\\u0092", "'"));
                selOuPoivre.setTitre3(seloupoivreobj.getString("titre3").replaceAll("\\u0092", "'"));
                Log.d(null, "Burger Quiz - " + selOuPoivre.toString());
                seloupoivreList.add(selOuPoivre);

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

    public static void loadSelOuPoivreQuestions()
    {
        Log.d(null, "Burger Quizss - ");
        HttpURLConnection urlConnection = null;
        URL url = null;
        JSONObject object = null;
        InputStream inStream = null;
        try {
            url = new URL("http://remybaroukh.fr/burgerquiz/getseloupoivreq.php");
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
            JSONArray seloupoivreList = new JSONArray(response);
            for(int i = 0; i < seloupoivreList.length(); i++)
            {
                JSONObject seloupoivreobj = seloupoivreList.getJSONObject(i);
                SelOuPoivreQuestion question = new SelOuPoivreQuestion(Integer.valueOf(seloupoivreobj.getString("idQuestion")));
                question.setQuestion(seloupoivreobj.getString("question").replaceAll("\\u0092","'"));
                question.setReponses(seloupoivreobj.getString("reponse").replaceAll("\\u0092", "'"));
                ajoutQuestionSelOuPoivre(question, Integer.valueOf(seloupoivreobj.getString("idSeloupoivre")));
                Log.d(null, "Burger Quiz - " + question.toString());

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

    private static void ajoutQuestionSelOuPoivre(SelOuPoivreQuestion question, Integer idSeloupoivre)
    {

        for (int i = 0; i < seloupoivreList.size(); i++)
        {
            SelOuPoivre selOuPoivre = seloupoivreList.get(i);
            if (idSeloupoivre == selOuPoivre.getIdSelOuPoivre())
                selOuPoivre.addQuestion(question);
        }
    }

    public static boolean checkReponse(int idReponse, SelOuPoivre n)
    {
        /*
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

        }*/
        return false;
    }


    public static SelOuPoivre getRandomQuestion()
    {
        int i = BurgerVariables.randomGenerator.nextInt(seloupoivreList.size());
        return seloupoivreList.get(i);
    }
}
