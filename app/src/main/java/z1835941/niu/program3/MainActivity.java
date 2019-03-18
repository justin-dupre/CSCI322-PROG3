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

public class MainActivity extends AppCompatActivity {

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

        listValues.add("ramen");
        listValues.add("udon");
        listValues.add("spaghetti");
        listValues.add("rice_noodles");
        listValues.add("hiyamugi");
        listSpin = findViewById(R.id.listSpinner);

        ArrayAdapter<String> adapter3 = new ArrayAdapter<>(getApplicationContext(), R.layout.spinner_view, listValues);

        listSpin.setAdapter(adapter3);
        listSpin.setOnItemSelectedListener(spinnerListener);
    }

    AdapterView.OnItemSelectedListener spinnerListener = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            selectedNoodle = parent.getItemAtPosition(position).toString();
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
        Intent noodleIntent = new Intent(MainActivity.this, InfoActivity.class);
        noodleIntent.putExtra("noodleType", selectedNoodle);
        noodleIntent.putExtra("id", id);
        startActivity(noodleIntent);
    }



}
