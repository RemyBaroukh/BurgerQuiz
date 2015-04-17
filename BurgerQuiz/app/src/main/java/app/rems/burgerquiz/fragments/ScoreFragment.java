package app.rems.burgerquiz.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.content.res.ResourcesCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import app.rems.burgerquiz.R;
import app.rems.burgerquiz.game.BurgerQuiz;
import app.rems.burgerquiz.game.BurgerVariables;
import app.rems.burgerquiz.utils.BurgerFragmentListener;

/**
 * Created by remsd_000 on 05/04/2015.
 */
public class ScoreFragment extends Fragment {

    private BurgerFragmentListener mListener;
    private TextView tvSuivant;
    private TextView tvMiams;
    private AnimationDrawable animation;
    private TextView tvScoreKetchup;
    private TextView tvScoreMayo;

    public static ScoreFragment newInstance() {
        ScoreFragment fragment = new ScoreFragment();
        return fragment;
    }

    public ScoreFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d(null, "Burger Quiz - Score - OnCreate ");

        View v = inflater.inflate(R.layout.fragment_score, container, false);
        tvSuivant = (TextView) v.findViewById(R.id.tvSuivant);
        tvMiams = (TextView) v.findViewById(R.id.tvMiams);
        tvScoreKetchup = (TextView) v.findViewById(R.id.tvScoreKetchup);
        tvScoreMayo = (TextView) v.findViewById(R.id.tvScoreMayo);

        tvMiams.setTypeface(BurgerVariables.customFont);
        tvScoreKetchup.setTypeface(BurgerVariables.customFont);
        tvScoreMayo.setTypeface(BurgerVariables.customFont);

        tvScoreKetchup.setText(String.valueOf(BurgerVariables.burgerQuiz.getCurrentScoreKetchup()));
        tvScoreMayo.setText(String.valueOf(BurgerVariables.burgerQuiz.getCurrentScoreMayo()));

        if (BurgerVariables.burgerQuiz.getEquipe() == BurgerVariables.Equipe.MAYO)
            tvMiams.setTextColor(getResources().getColor(R.color.mayo));
        else
            tvMiams.setTextColor(getResources().getColor(R.color.ketchup));


        tvSuivant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BurgerVariables.bqActivity.nextTurn();
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
