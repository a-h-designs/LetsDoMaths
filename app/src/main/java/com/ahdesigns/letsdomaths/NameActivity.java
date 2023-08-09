package com.ahdesigns.letsdomaths;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class NameActivity extends AppCompatActivity implements OnClickListener {

    EditText name;
    String passName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.name_activity);

        Button enterBtn = (Button) findViewById(R.id.enter_btn);
        name = (EditText)findViewById(R.id.name);

        enterBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.enter_btn) {
            passName = name.getText().toString();
            Intent mainIntent = new Intent(this, MainActivity.class);
            mainIntent.putExtra("name", passName);
            this.startActivity(mainIntent);
        }
    }
}