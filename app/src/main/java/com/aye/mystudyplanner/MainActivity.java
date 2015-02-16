package com.aye.mystudyplanner;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.List;


public class MainActivity extends ActionBarActivity {

    List<String> listCodes;
    List<String> listCourseName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void buttonClicked(View v) {
        int id = v.getId();

        switch(id){
            case R.id.button:
                Intent i = new Intent(this, Courselists.class);
                startActivityForResult(i, 88);
                break;
            case R.id.button2:
                Intent j = new Intent(this, AddCourse.class);
                String s = "List of Courses\n";

                for(int k = 0; k < listCodes.size(); k++){
                    s += listCodes.get(k) + "\n";
                    j.putExtra("code", s);

                }
                startActivity(j);
                break;
        }



    }

    public void onActivityResult(int requestCode, int resultCode, Intent data){

        if(requestCode == 88){
            if (resultCode == RESULT_OK){
                String val1 = data.getStringExtra("val1");
                listCodes.add(val1);
            }
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}