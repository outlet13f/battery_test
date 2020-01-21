package com.hndsolution.battery.ui.recommendation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.hndsolution.battery.R;
import com.hndsolution.battery.ui.dashboard.DashboardViewModel;

public class RecomFragment extends Fragment {

    private RecomViewModel recomViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {
        recomViewModel =
                ViewModelProviders.of(this).get(RecomViewModel.class);
        View root = inflater.inflate(R.layout.fragment_recom, container, false);
        final TextView textView = root.findViewById(R.id.text_recom);
        recomViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}