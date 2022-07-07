package com.midterm.phanthithusuong.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.midterm.phanthithusuong.R;
import com.midterm.phanthithusuong.databinding.FragmentDetailBinding;
import com.midterm.phanthithusuong.model.mymodel;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link detailFragment#} factory method to
 * create an instance of this fragment.
 */
public class detailFragment extends Fragment {

    private FragmentDetailBinding binding;
    private static com.midterm.phanthithusuong.model.mymodel mymodel;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments() != null){
            mymodel = (mymodel) getArguments().getSerializable("dogBreed");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(getLayoutInflater(),
                R.layout.fragment_detail, null , false);
        View viewroot = binding.getRoot();
        binding.setMymodel(mymodel);
        return viewroot;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }
}