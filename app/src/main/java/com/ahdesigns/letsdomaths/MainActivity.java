package com.ahdesigns.letsdomaths;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener {

    private final String[] levelNames = {"Easy", "Medium", "Hard"};
    String namePass;

    @SuppressLint("SetTextI18n")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        Button playBtn = (Button) findViewById(R.id.play_btn);
        Button helpBtn = (Button) findViewById(R.id.help_btn);
        Button highBtn = (Button) findViewById(R.id.high_btn);
        TextView name = (TextView) findViewById(R.id.name);

        Bundle extras = getIntent().getExtras();
        if(extras != null)
        {
            namePass = extras.getString("name", "");
        }

        String welcome = getString(R.string.welcome);
        name.setText(welcome + namePass);

        playBtn.setOnClickListener(this);
        helpBtn.setOnClickListener(this);
        highBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.play_btn){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Choose a level")
                    .setSingleChoiceItems(levelNames, 0, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                            //start gameplay
                            startPlay(which);
                        }
                    });
            AlertDialog ad = builder.create();
            ad.show();
        }
        else if(view.getId()==R.id.help_btn){
            //how to play button
        }
        else if(view.getId()==R.id.high_btn){
            Intent highIntent = new Intent(this, HighScores.class);
            this.startActivity(highIntent);
        }
    }

    private void startPlay(int chosenLevel)
    {
        //start gameplay
        Intent playIntent = new Intent(this, PlayGame.class);
        playIntent.putExtra("level", chosenLevel);
        playIntent.putExtra("name", namePass);
        this.startActivity(playIntent);
    }
}