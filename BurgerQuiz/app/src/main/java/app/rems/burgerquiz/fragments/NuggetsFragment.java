package app.rems.burgerquiz.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import app.rems.burgerquiz.R;
import app.rems.burgerquiz.game.BurgerVariables;
import app.rems.burgerquiz.nuggets.Nugget;
import app.rems.burgerquiz.nuggets.NuggetsManager;
import app.rems.burgerquiz.utils.BurgerFragmentListener;

/**
 * Created by Remy on 01/04/2015.
 */
public class NuggetsFragment extends Fragment {

    private BurgerFragmentListener mListener;
    private ImageView ivNuggets;
    private LinearLayout llNuggets;

    public static NuggetsFragment newInstance() {
        NuggetsFragment fragment = new NuggetsFragment();
        return fragment;
    }

    public NuggetsFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d(null, "Burger Quiz - Nuggets - OnCreate ");

        View v = inflater.inflate(R.layout.fragment_nuggets, container, false);

        ivNuggets = (ImageView) v.findViewById(R.id.ivNuggets);
        llNuggets = (LinearLayout) v.findViewById(R.id.llNuggets);

        //Animated Nuggets
        ivNuggets.setBackgroundResource(R.drawable.nuggets_animation);
        AnimationDrawable ivBurgerAnimation = (AnimationDrawable) ivNuggets.getBackground();
        ivBurgerAnimation.start();

        loadQuestion();

        return v;
    }

    private void loadQuestion() {

        final Nugget n = NuggetsManager.getRandomQuestion();
        Log.d(null, "Burger Quiz - Nuggets - OnCreate chargement des nuggets " + n.toString());


        LinearLayout llNugget = (LinearLayout) getActivity().getLayoutInflater().inflate(R.layout.nugget, null);
        TextView question = (TextView) llNugget.findViewById(R.id.tvQuestion);
        question.setText(n.getQuestion());

        LinearLayout llQuestion = (LinearLayout) llNugget.findViewById(R.id.llQuestion);
        if(BurgerVariables.burgerQuiz.getEquipe() == BurgerVariables.Equipe.MAYO)
        {
            llQuestion.setBackgroundColor(getActivity().getResources().getColor(R.color.mayo));
        }

        LinearLayout reponses = (LinearLayout) llNugget.findViewById(R.id.llReponses);
        for (int i = 0; i < 4; i++)
        {
            LinearLayout llReponse = (LinearLayout) getActivity().getLayoutInflater().inflate(R.layout.reponsenugget, null);
            TextView tvNum = (TextView) llReponse.findViewById(R.id.tvNum);
            TextView tvReponse = (TextView) llReponse.findViewById(R.id.tvResp);
            switch(i)
            {
                case 0:
                    tvNum.setText("A");
                    tvReponse.setText(n.getReponse1());
                    break;
                case 1:
                    tvNum.setText("B");
                    tvReponse.setText(n.getReponse2());
                    break;
                case 2:
                    tvNum.setText("C");
                    tvReponse.setText(n.getReponse3());
                    break;
                case 3:
                    tvNum.setText("D");
                    tvReponse.setText(n.getReponse4());
                    break;
                default:
                    break;
            }
            if(BurgerVariables.burgerQuiz.getEquipe() == BurgerVariables.Equipe.MAYO)
            {
                tvNum.setBackgroundColor(getActivity().getResources().getColor(R.color.mayo));
            }
            final int finalI = i;
            llReponse.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (NuggetsManager.checkReponse(finalI, n))
                    {
                        mListener.showEpreuve();
                    }

                }
            });
            reponses.addView(llReponse);
        }

        llNuggets.addView(llNugget);
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
