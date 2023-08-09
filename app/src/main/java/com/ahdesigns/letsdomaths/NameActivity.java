package com.ahdesigns.letsdomaths;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class NameActivity extends AppCompatActivity {

    EditText name;
    String passName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.name_activity);

        Button enterBtn = (Button) findViewById(R.id.enter_btn);
        name = (EditText)findViewById(R.id.name);

        name.requestFocus();
        name.setOnEditorActionListener(new TextView.OnEditorActionListener() {

            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {

                    enterBtn.performClick();
                    return true;
                }
                return false;
            }
        });
    }

    public void enter(View view) {
        if (view.getId() == R.id.enter_btn) {
            passName = name.getText().toString();
            Intent mainIntent = new Intent(this, MainActivity.class);
            mainIntent.putExtra("name", passName);
            this.startActivity(mainIntent);
        }
    }
}