package app.rems.burgerquiz.fragments;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import app.rems.burgerquiz.R;
import app.rems.burgerquiz.game.BurgerQuiz;
import app.rems.burgerquiz.game.BurgerVariables;
import app.rems.burgerquiz.utils.BurgerFragmentListener;

public class MainMenuFragment extends Fragment {


    /**
     * Main menu
     */
    private ImageView ivMayo;
    private ImageView ivKetchup;

    private BurgerFragmentListener mListener;

    public static MainMenuFragment newInstance() {
        MainMenuFragment fragment = new MainMenuFragment();
        return fragment;
    }

    public MainMenuFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_mainmenu, container, false);
        ivMayo = (ImageView) v.findViewById(R.id.ivMayo);
        ivKetchup = (ImageView) v.findViewById(R.id.ivKetchup);

        ivMayo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BurgerVariables.burgerQuiz.start(BurgerVariables.Equipe.MAYO);
                BurgerVariables.burgerQuiz.nextEpreuve();
                mListener.showEpreuve();

            }
        });
        ivKetchup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BurgerVariables.burgerQuiz.start(BurgerVariables.Equipe.KETCHUP);
                BurgerVariables.burgerQuiz.nextEpreuve();
                mListener.showEpreuve();
            }
        });

        //Animated Burger
        ImageView ivBurger = (ImageView) v.findViewById(R.id.ivBurger);
        ivBurger.setBackgroundResource(R.drawable.burger_animation);
        AnimationDrawable ivBurgerAnimation = (AnimationDrawable) ivBurger.getBackground();
        ivBurgerAnimation.start();
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
