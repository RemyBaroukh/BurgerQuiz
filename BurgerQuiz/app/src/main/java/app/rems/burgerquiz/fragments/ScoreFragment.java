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
    private ImageView ivScore;
    private TextView tvSuivant;
    private TextView tvMiams;
    private AnimationDrawable animation;

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
        ivScore = (ImageView) v.findViewById(R.id.ivScore);
        tvSuivant = (TextView) v.findViewById(R.id.tvSuivant);
        tvMiams = (TextView) v.findViewById(R.id.tvMiams);

        tvMiams.setTypeface(BurgerVariables.customFont);

        if (BurgerVariables.burgerQuiz.getEquipe() == BurgerVariables.Equipe.MAYO)
            tvMiams.setTextColor(getResources().getColor(R.color.mayo));
        else
            tvMiams.setTextColor(getResources().getColor(R.color.ketchup));


        animation = new AnimationDrawable();
        animation.setOneShot(true);

        Resources res = this.getResources();
        Log.d(null, "Burger Quiz - Score - miams " + BurgerVariables.burgerQuiz.getCurrentScore());
        for (int i =0; i <= BurgerVariables.burgerQuiz.getCurrentScore(); i++)
        {
            String name = "miams" + String.valueOf(i);
            int id = getResources().getIdentifier(name, "drawable", getActivity().getPackageName());
            Drawable d = ResourcesCompat.getDrawable(getResources(), id, null);
            animation.addFrame(d, 150);
        }

        ivScore.setBackground(animation);
        animation.start();
        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    mListener.nextTurn();
                } catch (InterruptedException e) {
                }
            }
        };
        thread.start();
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
