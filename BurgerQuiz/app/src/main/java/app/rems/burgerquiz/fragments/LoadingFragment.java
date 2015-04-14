package app.rems.burgerquiz.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.gms.games.Games;

import org.w3c.dom.Text;

import app.rems.burgerquiz.R;
import app.rems.burgerquiz.game.BurgerVariables;
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
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d(null, "Burger Quiz - SelOuPoivre - OnCreate ");

        View v = inflater.inflate(R.layout.fragment_loading, container, false);
        tvSucces = (TextView) v.findViewById(R.id.tvSucces);
        tvInbox = (TextView) v.findViewById(R.id.tvInbox);
        tvInvite = (TextView) v.findViewById(R.id.tvInvite);
        tvNext = (TextView) v.findViewById(R.id.tvNext);

        tvSucces.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Games.Achievements.unlock(BurgerVariables.mGoogleApiClient, getString(R.string.nuggets));
                Intent intent =
                        Games.Achievements.getAchievementsIntent(BurgerVariables.mGoogleApiClient);
                BurgerVariables.bqActivity.startActivityForResult(intent, 666);

            }
        });

        tvInbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =
                        Games.TurnBasedMultiplayer.getInboxIntent(BurgerVariables.mGoogleApiClient);
                BurgerVariables.bqActivity.startActivityForResult(intent, 666);
            }
        });

        tvInvite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =
                        Games.TurnBasedMultiplayer.getSelectOpponentsIntent(BurgerVariables.mGoogleApiClient, 1, 1, true);
                BurgerVariables.bqActivity.startActivityForResult(intent, 667);

            }
        });

        tvNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BurgerVariables.burgerQuiz.nextEpreuve();
            }
        });

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
