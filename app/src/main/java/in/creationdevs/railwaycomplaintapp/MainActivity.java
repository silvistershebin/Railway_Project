package in.creationdevs.railwaycomplaintapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText editTextMobile;
    Button buttonSubmit;
    TextView textviewInfo;
    SharedPreferences sharedPreferences;
    public static final String PREFERENCES = "LOGIN_INFO";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.phone_activity);
        editTextMobile = findViewById(R.id.edittext_mobile);
        buttonSubmit = findViewById(R.id.button_submit);
        textviewInfo = findViewById(R.id.textview_info);
        sharedPreferences = getSharedPreferences(PREFERENCES,MODE_PRIVATE);
        if(sharedPreferences.getString("USER_EMAIL",null) != null){
            Intent intent = new Intent(MainActivity.this,ComplaintActivity.class);
            startActivity(intent);
        }
    }

    public void onSubmitButtonClick(View view){
        String mobile = editTextMobile.getText().toString();
        //textviewInfo.setText("An OTP has been sent to the mobile number: "+mobile);
        Toast.makeText(this, mobile, Toast.LENGTH_LONG).show();
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Enter the OTP");
        final View v = getLayoutInflater().inflate(R.layout.activity_verify,null);
        builder.setView(v);
        builder.setPositiveButton("Verfiy the OTP", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(MainActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });
        builder.setNegativeButton("Resend OTP", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //Code for resending OTP
                Toast.makeText(MainActivity.this, "Resend OTP", Toast.LENGTH_SHORT).show();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

}
