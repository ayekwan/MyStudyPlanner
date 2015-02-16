package com.aye.mystudyplanner;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;


public class AddCourse extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_course);
    }

    public void addClicked(View v) {
        EditText etCode = (EditText)findViewById(R.id.code);
        EditText etName = (EditText)findViewById(R.id.name);
        EditText etMid = (EditText)findViewById(R.id.midtermExam);
        EditText etFin = (EditText)findViewById(R.id.finalExam);


        String sCode = etCode.getText().toString();
        String sName = etName.getText().toString();
        String sMid = etMid.getText().toString();
        String sFin = etFin.getText().toString();

        if (sCode.trim().length() == 0 || sName.trim().length() == 0) {
            Toast t = Toast.makeText(this.getApplicationContext(),
                    "Both course code and name are necessary.",
                    Toast.LENGTH_SHORT);
            t.show();
        }
        else {
            Intent result = new Intent();
            result.putExtra("code", sCode);
            result.putExtra("name", sName);
            result.putExtra("midterm", sMid);
            result.putExtra("final", sFin);

            this.setResult(RESULT_OK, result);
            this.finish();
        }
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_add_course, menu);
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
