package app.rems.burgerquiz.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import app.rems.burgerquiz.R;
import app.rems.burgerquiz.utils.BurgerFragmentListener;

/**
 * Created by Remy on 01/04/2015.
 */
public class NuggetsFragment extends Fragment {

    private BurgerFragmentListener mListener;

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
        View v = inflater.inflate(R.layout.fragment_nuggets, container, false);
        Log.d(null, "Burger Quiz - Nuggets - OnCreate ");
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
