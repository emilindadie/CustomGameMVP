package com.example.emili.androidassetsproject.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.emili.androidassetsproject.R;
import com.example.emili.androidassetsproject.presenter.PresenterFragmentBodyPart;
import com.example.emili.androidassetsproject.view.ViewFragmentBodyPart;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link BodyPartFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link BodyPartFragment#newInstance} factory method to
 * create an instance of this fragment.
 */

public class BodyPartFragment extends Fragment implements ViewFragmentBodyPart {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final String TAG = BodyPartFragment.class.getSimpleName();
    private static final String IMAGE_ID_LIST = "imageIdList";
    private static final String LIST_INDEX = "listIndex";
    private static final String BODY_PART_TYPE = "bodyPartType";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public BodyPartFragment() {
        // Required empty public constructor
    }



    private List<Integer> mImageId;
    private int mListIndex;
    int bodyPartIndexForPresenter = 0;



    ImageView imageView;

    public static BodyPartFragment newInstance(String param1, String param2) {
        BodyPartFragment fragment = new BodyPartFragment();
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
        if(savedInstanceState != null){
            mImageId = savedInstanceState.getIntegerArrayList(IMAGE_ID_LIST);
            mListIndex = savedInstanceState.getInt(LIST_INDEX);
            bodyPartIndexForPresenter = savedInstanceState.getInt(BODY_PART_TYPE);
        }


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_body_part, container, false);


    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        imageView = (ImageView) view.findViewById(R.id.imageViewBodyPart);
        PresenterFragmentBodyPart presenterFragmentBodyPart = new PresenterFragmentBodyPart(this, bodyPartIndexForPresenter);
        presenterFragmentBodyPart.updateImageViewBodyPart();

        if(mImageId != null){
            imageView.setImageResource(mImageId.get(mListIndex));
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    if(mListIndex < mImageId.size()-1){
                        mListIndex++;
                    }
                    else {
                        mListIndex = 0;
                    }
                    imageView.setImageResource(mImageId.get(mListIndex));
                }
            });
        }
        else {
            Log.d(TAG, "fragment has null image view id");
        }

    }


    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
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
    public void updateImageViewBodyPart(List<Integer> imgageViewBodyPartId) {
        setmImageId(imgageViewBodyPartId);
    }


    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    public void setmImageId(List<Integer> mImageId){

        this.mImageId = mImageId;
    }

    public void setmListIndex(int mListIndex){

        this.mListIndex = mListIndex;
    }

    public void setBodyPartIndexForPrsenter(int index){
        bodyPartIndexForPresenter = index;
    }

    @Override
    public void onSaveInstanceState(Bundle currentState){
        currentState.putIntegerArrayList(IMAGE_ID_LIST, (ArrayList<Integer>) mImageId);
        currentState.putInt(LIST_INDEX, mListIndex);
        currentState.putInt(BODY_PART_TYPE, bodyPartIndexForPresenter);
    }
}
