package com.example.tindoc;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;


public class DetailFragment extends Fragment {

    SearchView searchview;
    ListView my_list;
    ArrayList<String> list;
    ArrayAdapter<String> adapter;


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private String mParam1;
    private String mParam2;

    public DetailFragment() {
        // Required empty public constructor
    }


    public static DetailFragment newInstance(String param1, String param2) {
        DetailFragment fragment = new DetailFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        searchview = (SearchView) getView().findViewById(R.id.searchview);
        my_list = (ListView) getView().findViewById(R.id.my_list);

        list = new ArrayList<String>();

        list.add("Eye and Ear \nDr Dania Nassar" );
        list.add("Eye and Ear \nDr Ameer Hmedian");
        list.add("Eye and Ear \nDr Dr.Barry Cohen");
        list.add("Eye and Ear \nDr Rina Mehta");
        list.add("Eye and Ear \nDr Rina Mehta");
        list.add("Eye and Ear \nDr Felix Chien");
        list.add("Eye and Ear \nDr Rina Mehta");

        list.add("Dentist \nDr David Brisman");
        list.add("Dentist \nDr Lee Gold");
        list.add("Dentist \nDr Jordan Reich");
        list.add("Dentist \nDr Nicole Khalife");
        list.add("Dentist \nDr Devil Konar");

        list.add("Dermatologisgt \nDr Angela Leo");
        list.add("Dermatologisgt \nDr Nikesh Patel");
        list.add("Dermatologisgt \nDr Cindy Li, Do");
        list.add("Dermatologisgt \nDr Henry Heaton");
        list.add("Dermatologisgt \nDr Erin Kil");
        list.add("Dermatologisgt \nDr Morgan Rabach");

        list.add("Primary Care \nDr Morgan Rabach");
        list.add("Primary Care \nDr Andrew Fagelman");
        list.add("Primary Care \nDr Gordan Jay");
        list.add("Primary Care \nDr Anthony Lujack");
        list.add("Primary Care \nDr Brain Buggie");

        list.add("Psychairist \nDr Dania Nassar" );
        list.add("Psychairist \nDr Ameer Hmedian");
        list.add("Psychairist \nDr Barry Cohen");
        list.add("Psychairist \nDr Rina Mehta");
        list.add("Psychairist \nDr Rina Mehta");
        list.add("Psychairist \nDr Felix Chien");
        list.add("Psychairist \nDr Rina Mehta");

        list.add("Oncologist \nDr David Brisman");
        list.add("Oncologist \nDr Lee Gold");
        list.add("Oncologist \nDr Jordan Reich");
        list.add("Oncologist \nDr Nicole Khalife");
        list.add("Oncologist \nDr Devil Konar");

        list.add("Caardiologist \nDr Angela Leo");
        list.add("Caardiologist \nDr Nikesh Patel");
        list.add("Caardiologist \nDr Cindy Li, Do");
        list.add("Caardiologist \nDr Henry Heaton");
        list.add("Caardiologist \nDr Erin Kil");
        list.add("Caardiologist \nDr Morgan Rabach");

        list.add("Neurologist \nDr Morgan Rabach");
        list.add("Neurologist \nDr Andrew Fagelman");
        list.add("Neurologist \nDr Gordan Jay");
        list.add("Neurologist \nDr Anthony Lujack");
        list.add("Neurologist \nDr Brain Buggie");





        adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,list);
        my_list.setAdapter(adapter);
        searchview.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });
    }
}