package com.saraencci.aad.quadgraphplotter;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;
import com.saraencci.aad.quadgraphplotter.databinding.FragmentHomeBinding;


/**
 * A simple {@link Fragment} subclass.
 */
public class homeFragment extends Fragment {
    FragmentHomeBinding homeBinding;
    public homeFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        homeBinding=FragmentHomeBinding.inflate(inflater);
        homeBinding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkEditTextNotEmpty(homeBinding.editTexta) &&checkEditTextNotEmpty(homeBinding.editTextb) &&checkEditTextNotEmpty(homeBinding.editTextc) &&checkEditTextNotEmpty(homeBinding.editTextd)){
                    homeBinding.graphview.removeAllSeries();
                    double a=Double.valueOf(homeBinding.editTexta.getText().toString()),
                            b=Double.valueOf(homeBinding.editTextb.getText().toString()),
                            c=Double.valueOf(homeBinding.editTextc.getText().toString()),
                            d=Double.valueOf(homeBinding.editTextd.getText().toString());
                    LineGraphSeries<DataPoint> series = new LineGraphSeries < >();
                    for (double i = -4; i < 4.1; i+=0.2) {
                        double y=(a*(Math.pow(i,d))+(b*i+c));
                        series.appendData(new DataPoint(i,y),true,74);
                    }
                    series.setThickness(2);

                    try {
                        series.setAnimated(true);
                        homeBinding.graphview.addSeries(series);
                    } catch (IllegalArgumentException e) {
                        Toast.makeText(getContext(), e.getMessage(), Toast.LENGTH_LONG).show();
                    }

                }
            }
        });


        return homeBinding.getRoot();
    }
   Boolean checkEditTextNotEmpty(EditText editText){
       if(editText.getText().toString().trim().isEmpty()){
           editText.requestFocus();
           Toast.makeText(getContext(), "please ensure you fill all the values", Toast.LENGTH_SHORT).show();
           return false;

       }
       else{
       return true;}
   }
}
