package in.creationdevs.railwaycomplaintapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Main2Activity extends AppCompatActivity {


    private EditText editTextMobile;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        editTextMobile = findViewById(R.id.editTextMobile);
        button = findViewById(R.id.buttonContinue);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String mobile = editTextMobile.getText().toString().trim();

                if(mobile.isEmpty() || mobile.length() < 10){
                    editTextMobile.setError("Enter a valid mobile");
                    editTextMobile.requestFocus();
                    return;
                }

                Intent intent = new Intent(Main2Activity.this, Main3Activity.class);
                intent.putExtra("mobile", mobile);
                startActivity(intent);
            }
        });
    }
}