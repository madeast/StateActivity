package edu.ctec.stateactivity.controller;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import edu.ctec.stateactivity.model.AndroidSaveState;
import android.view.View;
import android.widget.TextView;
import android.content.Intent;
import android.widget.Button;
import edu.ctec.stateactivity.R;


/**
 * Created by emad6932 on 10/14/15.
 */
public class BackpageActivity extends ActionBarActivity
{
        private AndroidSaveState saveState;
        private Button backButton;
        private TextView userText;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_back_page);

        saveState = (AndroidSaveState) getApplication();
        backButton = (Button) findViewById(R.id.backButton);
        userText = (TextView) findViewById(R.id.backpageText);

        loadContent();

        setupListeners();

    }

    private void loadContent()
    {
        userText.setText(saveState.getUserName() + " is " + saveState.getAge() + " years old and " + saveState.getIsTired() + " tired. ");
    }

    private void setupListeners()
    {
        backButton .setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View buttonView)
            {
                Intent returnIntent = new Intent();
                setResult(RESULT_OK, returnIntent);
                finish();
            }
        });
    }

}
