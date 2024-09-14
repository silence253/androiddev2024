package vn.edu.usth.weather;

import static vn.edu.usth.weather.R.*;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.ResourceBundle;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ForecastFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ForecastFragment extends Fragment {

    public ForecastFragment() {
        // Required empty public constructor
    }
    public static ForecastFragment newInstance(String param1, String param2) {
        ForecastFragment fragment = new ForecastFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ScrollView scrollView = new ScrollView(getActivity());
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, FrameLayout.LayoutParams.WRAP_CONTENT);
        params.setMargins(30, 30, 30, 30);
        // Create a vertical LinearLayout
        LinearLayout view = new LinearLayout(getActivity());
        view.setOrientation(LinearLayout.VERTICAL);
        view.setBackgroundColor(Color.parseColor("#FFE5E5"));
        view.setLayoutParams(params);

        //Pratical4
        /*// Add image
        ImageView img = new ImageView(getActivity());
        img.setImageResource(drawable.sunny);
        img.setPivotY(Gravity.CENTER);
        img.setLayoutParams(new LinearLayout.LayoutParams(144, 144));

        // Add text
        TextView text = new TextView(getActivity());
        text.setText("Thursday");

        // Add text and image to linearlayout
        view.addView(text);
        view.addView(img);
        //END OF PRATICAL 4*/

        // Initiate arrays
        Resources res = getResources();
        String[] days = res.getStringArray(array.DaysOfWeek);
        String[] weather = res.getStringArray(array.Weather);
        String[] degree = res.getStringArray(array.degree);
        int[] img = {drawable.sun_and_cloud, drawable.rainny3, R.drawable.rainny2, drawable.rainny, drawable.cloudy, drawable.sunny2, drawable.lightning2};

        // Create loop for 7 days of week
        for(int i = 0; i < 7; i++){
            LinearLayout dailyForecast = new LinearLayout(getActivity());
            dailyForecast.setOrientation(LinearLayout.HORIZONTAL);
            dailyForecast.setLayoutParams(params);
            dailyForecast.setLayoutParams(new LinearLayout.LayoutParams(1500, LinearLayout.LayoutParams.WRAP_CONTENT));

            // Add Days of week
            TextView date = new TextView(getActivity());
            date.setTextSize(18);
            date.setTypeface(null, Typeface.BOLD);
            date.setPadding(40,100,15,15);
            date.setGravity(Gravity.CENTER);
            date.setText(days[i]);

            // Add image
            ImageView icon = new ImageView(getActivity());
            icon.setImageResource(img[i]);
            icon.setLayoutParams(new LinearLayout.LayoutParams(255, 255));


            // Add weather and degrees
            TextView info = new TextView(getActivity());
            info.setTextSize(18);
            info.setText(weather[i] +"\n" + degree[i]);
            date.setGravity(Gravity.CENTER);
            info.setPadding(40,0,15,15);

            // Add everything back to horizontal layout
            dailyForecast.addView(date);
            dailyForecast.addView(icon);
            dailyForecast.addView(info);

            // Add horizontal layout to vertical one
            view.addView(dailyForecast);

        }
        // Return view
        scrollView.addView(view);
        return scrollView;
    }
}