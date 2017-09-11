package com.example.emili.androidassetsproject.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.emili.androidassetsproject.R;
import com.example.emili.androidassetsproject.adapter.AndroidImageAssetsAdapter;
import com.example.emili.androidassetsproject.model.AndroidImageAssets;
import com.example.emili.androidassetsproject.presenter.PresenterMasterList;
import com.example.emili.androidassetsproject.view.ViewFragmentMasterList;

import java.util.ArrayList;
import java.util.List;



public class MasterListFragment extends Fragment implements ViewFragmentMasterList {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    AndroidImageAssetsAdapter androidImageAssetsAdapter;
    RecyclerView recyclerView;
    GridLayoutManager gridLayoutManager;
    List<Integer> masterList;


    private OnFragmentInteractionListener mListener;

    public MasterListFragment() {
        // Required empty public constructor
    }


    public static MasterListFragment newInstance(String param1, String param2) {
        MasterListFragment fragment = new MasterListFragment();
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
        return inflater.inflate(R.layout.fragment_master_list, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        PresenterMasterList presenterMasterList = new PresenterMasterList(this);
        presenterMasterList.updateMasterList();
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerViewMasterList);
        gridLayoutManager = new GridLayoutManager(getContext(), 2);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(gridLayoutManager);

        androidImageAssetsAdapter = new AndroidImageAssetsAdapter(getContext(), masterList, new AndroidImageAssetsAdapter.RecyclerItemClickListener() {
            @Override
            public void OnClickListener(Integer integer, int position) {

                mListener.onFragmentInteraction(position);
            }
        });
        recyclerView.setAdapter(androidImageAssetsAdapter);

    }
    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(int position) {
        if (mListener != null) {
            mListener.onFragmentInteraction(position);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void updateMasterList(List<Integer> masterList) {
        initArrayList(masterList);
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(int position);
    }

    private void initArrayList(List<Integer> masterList){
        this.masterList = masterList;
    }
}
