package app.rems.burgerquiz.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.gms.games.Games;

import org.w3c.dom.Text;

import app.rems.burgerquiz.R;
import app.rems.burgerquiz.game.BurgerQuiz;
import app.rems.burgerquiz.game.BurgerVariables;
import app.rems.burgerquiz.nuggets.NuggetsManager;
import app.rems.burgerquiz.seloupoivre.SelOuPoivreManager;
import app.rems.burgerquiz.utils.BurgerFragmentListener;

/**
 * Created by remsd_000 on 05/04/2015.
 */
public class LoadingFragment extends Fragment {

    private BurgerFragmentListener mListener;
    private TextView tvSucces;
    private TextView tvInbox;
    private TextView tvInvite;
    private TextView tvNext;

    public static LoadingFragment newInstance() {
        LoadingFragment fragment = new LoadingFragment();
        return fragment;
    }

    public LoadingFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        BurgerVariables.burgerQuiz = new BurgerQuiz();
        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                }
                Thread thread = new Thread() {
                    @Override
                    public void run() {
                        loadManagers();
                    }
                };
                thread.start();
            }
        };
        thread.start();




    }

    private void loadManagers() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                BurgerVariables.customFont = Typeface.createFromAsset(BurgerVariables.bqActivity.getAssets(),
                        "fonts/horseshoeslemonade.ttf");
                NuggetsManager.loadNuggets();
                SelOuPoivreManager.loadSelOuPoivre();
                SelOuPoivreManager.loadSelOuPoivreQuestions();

            }
        }).start();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d(null, "Burger Quiz - SelOuPoivre - OnCreate ");

        View v = inflater.inflate(R.layout.fragment_loading, container, false);

        return v;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (BurgerFragmentListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

}
