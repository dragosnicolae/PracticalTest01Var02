package ro.pub.cs.systems.eim.practicaltest01var02;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PracticalTest01Var02SecondaryActivity extends AppCompatActivity {

    private TextView text = null;
    private Button correct = null;
    private Button incorrect = null;

    private ButtonClickListener buttonClickListener = new ButtonClickListener();
    private class ButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            switch(view.getId()) {
                case R.id.correct:
                    setResult(RESULT_OK, null);
                    break;
                case R.id.incorrect:
                    setResult(RESULT_CANCELED, null);
                    break;
            }
            finish();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var02_secondary);

        correct = (Button)findViewById(R.id.correct);
        incorrect = (Button)findViewById(R.id.incorrect);
        text = (TextView)findViewById(R.id.text5);

        correct.setOnClickListener(buttonClickListener);
        incorrect.setOnClickListener(buttonClickListener);

        Intent intent = getIntent();
        if (intent != null && intent.getExtras().containsKey("str")) {
            String str = intent.getStringExtra("str");
            text.setText(str);
        }
    }
}
