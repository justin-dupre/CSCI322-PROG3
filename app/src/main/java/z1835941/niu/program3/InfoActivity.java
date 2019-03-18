package z1835941.niu.program3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;


public class InfoActivity extends AppCompatActivity {

   TextView noodleTitleTV;
   TextView noodleInfoTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        noodleTitleTV = findViewById(R.id.noodleTitle);
        noodleInfoTV = findViewById(R.id.noodleInfo);

        Intent intent = getIntent();
        String noodle = intent.getStringExtra("noodleType");
        int id = intent.getIntExtra("id", -1);
        noodleTitleTV.setText(noodle);

        if(id == 1) {
            noodleInfoTV.setText(R.string.ramen);
        } else if (id == 2) {
            noodleInfoTV.setText(R.string.udon);
        }else if (id == 3) {
            noodleInfoTV.setText(R.string.spaghetti);
        }else if (id == 4) {
            noodleInfoTV.setText(R.string.rice_noodles);
        }else if (id == 5) {
            noodleInfoTV.setText(R.string.hiyamugi);
        }








    }

    public void goBack(View v){
        finish();
    }


}
