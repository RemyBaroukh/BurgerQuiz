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

import app.rems.burgerquiz.R;
import app.rems.burgerquiz.game.BurgerVariables;
import app.rems.burgerquiz.seloupoivre.SelOuPoivre;
import app.rems.burgerquiz.seloupoivre.SelOuPoivreManager;
import app.rems.burgerquiz.utils.BurgerFragmentListener;

/**
 * Created by Remy on 01/04/2015.
 */
public class SelOuPoivreFragment extends Fragment {

    private BurgerFragmentListener mListener;
    private SelOuPoivre selOuPoivre;
    private LinearLayout llQuestion;
    private LinearLayout llSeloupoivre;
    private TextView tvSelpoivre;

    public static SelOuPoivreFragment newInstance() {
        SelOuPoivreFragment fragment = new SelOuPoivreFragment();
        return fragment;
    }

    public SelOuPoivreFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d(null, "Burger Quiz - SelOuPoivre - OnCreate ");

        View v = inflater.inflate(R.layout.fragment_seloupoivre, container, false);
        selOuPoivre = SelOuPoivreManager.getRandomQuestion();
        llQuestion = (LinearLayout) v.findViewById(R.id.llQuestion);
        llSeloupoivre = (LinearLayout) v.findViewById(R.id.llSeloupoivre);
        tvSelpoivre = (TextView) v.findViewById(R.id.tvSelPoivre);



        tvSelpoivre.setText(selOuPoivre.getSel() + ", " + selOuPoivre.getPoivre() + " ou " + selOuPoivre.getTitre3());
        tvSelpoivre.setTypeface(BurgerVariables.customFont);
        llQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                llSeloupoivre.setVisibility(View.VISIBLE);
                llQuestion.setVisibility(View.INVISIBLE);
            }
        });
        Log.d(null, "Burger Quiz - SelOupoivre - " + selOuPoivre.toString());
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
