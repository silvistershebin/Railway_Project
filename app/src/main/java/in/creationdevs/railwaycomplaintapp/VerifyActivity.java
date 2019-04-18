package in.creationdevs.railwaycomplaintapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class VerifyActivity extends AppCompatActivity {
    EditText editTextOtp;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify);
        editTextOtp = findViewById(R.id.edittext_otp);
    }
    public void onVerifyButtonClick(View view){
        String otp = editTextOtp.getText().toString();
        Toast.makeText(this, otp, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(VerifyActivity.this, ComplaintActivity.class);
        startActivity(intent);
    }
}
