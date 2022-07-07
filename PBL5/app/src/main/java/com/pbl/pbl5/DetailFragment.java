package com.pbl.pbl5;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.pbl.pbl5.databinding.FragmentDetailBinding;
import com.pbl.pbl5.databinding.FragmentHomeBinding;
import com.squareup.picasso.Picasso;


public class DetailFragment extends Fragment {
    private FragmentDetailBinding binding;
    private static Users user;





    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments() != null){
            user = (Users) getArguments().getSerializable("users");
            Log.d("DEBUG1", user.getName());
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(getLayoutInflater(),
                R.layout.fragment_detail, null , false);
        View viewroot = binding.getRoot();
        binding.setUser(user);

        return viewroot;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        ImageView avtDetail = binding.detailAvt;
//        Picasso.get()
//                .load(dogBreed.getUrl())
//                .error(R.mipmap.ic_launcher)
//                .resize(300,200)
//                .into(avtDetail);
//        binding.imageButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Bundle bundle = new Bundle();
//                Navigation.findNavController(view).navigate(R.id.listFragment,bundle);
//            }
//        });
    }
}