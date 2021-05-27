package com.example.databinding2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.databinding2.databinding.FragmentFirstBinding;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding fragmentFirstBinding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        fragmentFirstBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_first, container, false);
        fragmentFirstBinding.setStudent(getCurrentStudent());
        // Inflate the layout for this fragment
        return fragmentFirstBinding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.button_first).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });

//        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
//        activityMainBinding.setStudent(getCurrentStudent());
    }

    private Student getCurrentStudent() {
        return new Student("alex", "alex@gmail.com");
    }
}