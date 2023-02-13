package com.example.erkinbekovbilimdz_2_3;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

public class FirstFragment extends Fragment {
    private TextView numbers;
    static final String KEY_FOR_NUMBER = "Number_key" ;
    private Button minus, plus, send;
    private int result = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        initView();
        MinusButton();
        PlusButton();
        SendButton();
    }

    private void initView() {
        numbers = requireActivity().findViewById(R.id.textViewZero);
        minus = requireActivity().findViewById(R.id.btn_minus);
        plus = requireActivity().findViewById(R.id.btn_plus);
        send = requireActivity().findViewById(R.id.SendText);
    }

    private void SendButton() {
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString(KEY_FOR_NUMBER, numbers.getText().toString());
                SecondFragment secondFragment = new SecondFragment();
                secondFragment.setArguments(bundle);
                requireActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_one, secondFragment).addToBackStack(null).commit();
            }
        });
    }

    private void PlusButton() {
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result ++;
                numbers.setText(String.valueOf(result));
            }
        });
    }

    private void MinusButton() {
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result --;
                numbers.setText(String.valueOf(result));
            }
        });
    }
}