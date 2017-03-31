package ro.pub.cs.systems.eim.practicaltest01var02;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class PracticalTest01Var02MainActivity extends AppCompatActivity {

    EditText edit1, edit2;
    Button plus, minus, second;
    TextView text;

    String str;

    ButtonListener listener = new ButtonListener();

    class ButtonListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            int val1 = 0, val2 = 0;
            try {
                val1 = Integer.parseInt(edit1.getText().toString());
                val2 = Integer.parseInt(edit2.getText().toString());
            } catch (Exception e) {
                CharSequence s = "Fields contain invalid number";
                Toast.makeText(getApplicationContext(), s, Toast.LENGTH_LONG).show();
            }

            switch (v.getId()) {
                case R.id.plus:

                    int sum = val1 + val2;
                    str = val1 + "+" + val2 + "=" + sum;
                    text.setText(String.valueOf(sum));
                    break;
                case R.id.minus:
                    int dif = val1-val2;
                    str = val1 + "-" + val2 + "=" + dif;
                    text.setText(String.valueOf(dif));
                    break;

                case R.id.second:
                    Intent intent = new Intent(getApplicationContext(), PracticalTest01Var02SecondaryActivity.class);
                    intent.putExtra("str", str);
                    startActivityForResult(intent, 1);
                    break;
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var02_main);

        edit1 = (EditText)findViewById(R.id.edit1);
        edit2 = (EditText)findViewById(R.id.edit2);

        plus = (Button)findViewById(R.id.plus);
        minus = (Button)findViewById(R.id.minus);
        second = (Button)findViewById(R.id.second);

        text = (TextView)findViewById(R.id.text1);

        plus.setOnClickListener(listener);
        minus.setOnClickListener(listener);
        second.setOnClickListener(listener);

    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putString("edit1", edit1.getText().toString());
        savedInstanceState.putString("edit2", edit2.getText().toString());
        savedInstanceState.putString("text", text.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        if (savedInstanceState.containsKey("edit1")) {
            edit1.setText(savedInstanceState.getString("edit1"));
        } else {
            edit1.setText(String.valueOf(0));
        }

        if (savedInstanceState.containsKey("edit2")) {
            edit2.setText(savedInstanceState.getString("edit2"));
        } else {
            edit2.setText(String.valueOf(0));
        }

        if (savedInstanceState.containsKey("text")) {
            text.setText(savedInstanceState.getString("text"));
        } else {
            text.setText(String.valueOf(0));
        }

        CharSequence s = "field1: " + edit1.getText().toString() + ", field2: " + edit2.getText().toString() + ", res:" + text.getText().toString() + " ";
        Toast.makeText(getApplicationContext(), s, Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if (requestCode == 1) {
            String v;
            if (resultCode == -1)
                v = "correct";
            else
                v = "incorrect";
            Toast.makeText(this, "Activity returned with result " + v, Toast.LENGTH_LONG).show();
        }
    }
}
