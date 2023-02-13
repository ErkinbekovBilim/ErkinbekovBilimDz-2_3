package com.example.erkinbekovbilimdz_2_3;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class SecondFragment extends Fragment {

    private TextView SendNumber;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initView();
        Receiving();
    }

    private void initView() {
        SendNumber = requireActivity().findViewById(R.id.ResultText);
    }

    private void Receiving() {
        if (getArguments() !=null) {
            String number = getArguments().getString(FirstFragment.KEY_FOR_NUMBER);
            SendNumber.setText(number);
        }
    }
}