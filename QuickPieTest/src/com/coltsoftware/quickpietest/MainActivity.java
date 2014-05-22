package com.coltsoftware.quickpietest;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.os.Build;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            
            Resources res = container.getResources();
            
            final PieChart pie = (PieChart) rootView.findViewById(R.id.Pie);
            pie.addItem("Agamemnon", 2, res.getColor(R.color.seafoam));
            pie.addItem("Bocephus", 3.5f, res.getColor(R.color.chartreuse));
            pie.addItem("Calliope", 2.5f, res.getColor(R.color.emerald));
            pie.addItem("Daedalus", 3, res.getColor(R.color.bluegrass));
            pie.addItem("Euripides", 1, res.getColor(R.color.turquoise));
            pie.addItem("Ganymede", 3, res.getColor(R.color.slate));

            ((Button) rootView.findViewById(R.id.Reset)).setOnClickListener(new View.OnClickListener() {
                private int i;

				public void onClick(View view) {
                    pie.setCurrentItem(i++);
                }
            });
            
            return rootView;
        }
    }

}
