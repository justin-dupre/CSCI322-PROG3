package z1835941.niu.program3;

import android.content.Intent;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.AdapterView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/*************************
 * Justin Dupre and Brady Goldsworthy
 * z1835941         z1816747
 *
 * CSCI 322 Assignment 3
 * Using Intents and Widgets
 * Due 3/20/19
 *
 *************************/

public class MainActivity extends AppCompatActivity {

    //create class variables
    private Spinner listSpin;
    private String selectedNoodle;
    ImageView noodleIV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        noodleIV = findViewById(R.id.noodleImage);

        //spinner from object
        List<String> listValues = new ArrayList<>();
        //add all noodle types to list
        listValues.add("ramen");
        listValues.add("udon");
        listValues.add("spaghetti");
        listValues.add("rice_noodles");
        listValues.add("hiyamugi");
        //connect our spinner to variable
        listSpin = findViewById(R.id.listSpinner);

        ArrayAdapter<String> adapter3 = new ArrayAdapter<>(getApplicationContext(), R.layout.spinner_view, listValues);

        listSpin.setAdapter(adapter3);
        listSpin.setOnItemSelectedListener(spinnerListener);
    }

    AdapterView.OnItemSelectedListener spinnerListener = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            //set variable to which noodle was selected
            selectedNoodle = parent.getItemAtPosition(position).toString();

            //set the image depending on which noodle is selected
            if (selectedNoodle == "ramen"){
                noodleIV.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.ramen, null));
            } else if (selectedNoodle == "udon") {
                noodleIV.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.udon, null));
            } else if (selectedNoodle == "spaghetti") {
                noodleIV.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.spaghetti, null));
            } else if (selectedNoodle == "rice_noodles") {
                noodleIV.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.rice_noodle, null));
            } else if (selectedNoodle == "hiyamugi") {
                noodleIV.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.hiyamugi, null));
            }


        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    };

    public void goToNoodle(View v){

        //create an id corresponding to each noodle
        int id = 1;
        if (selectedNoodle == "ramen") {
            id = 1;
        } else if (selectedNoodle == "udon") {
            id = 2;
        } else if (selectedNoodle == "spaghetti"){
            id = 3;
        } else if (selectedNoodle == "rice_noodles") {
            id = 4;
        } else if (selectedNoodle == "hiyamugi") {
            id = 5;
        }

        //create intent and send noodle type and id
        Intent noodleIntent = new Intent(MainActivity.this, InfoActivity.class);
        noodleIntent.putExtra("noodleType", selectedNoodle);
        noodleIntent.putExtra("id", id);
        startActivity(noodleIntent);
    }



}
