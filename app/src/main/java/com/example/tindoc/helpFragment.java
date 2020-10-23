package com.example.tindoc;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link helpFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class helpFragment extends Fragment {

    ListView mListView;

    String[] countryNames = {"FAQ", "Contact Us", "Terms and Privacy Policy", "App info"};
    int[] countryFlags = {R.drawable.faq,
            R.drawable.contact,
            R.drawable.terms,
            R.drawable.info,

    };

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private String mParam1;
    private String mParam2;

    public helpFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment helpFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static helpFragment newInstance(String param1, String param2) {
        helpFragment fragment = new helpFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_help, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mListView = (ListView) getView().findViewById(R.id.listview);
        MyAdapter myAdapter = new MyAdapter(getActivity(), countryNames, countryFlags);
        mListView.setAdapter(myAdapter);

    }
}