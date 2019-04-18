package in.creationdevs.railwaycomplaintapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class RegisterActivity extends AppCompatActivity {
    EditText editTextName;
    EditText editTextEmail;
    SharedPreferences sharedPreferences;
    public static final String PREFERENCES = "LOGIN_INFO";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        editTextEmail = findViewById(R.id.edittext_name);
        editTextName = findViewById(R.id.edittext_email);
        sharedPreferences = getSharedPreferences(PREFERENCES,MODE_PRIVATE);
        if(sharedPreferences.getString("USER_EMAIL",null) != null){
            Intent intent = new Intent(RegisterActivity.this,ComplaintActivity.class);
            startActivity(intent);
        }
    }
    public void onRegisterButtonClick(View view){
        String name = editTextName.getText().toString();
        String email = editTextEmail.getText().toString();
        sharedPreferences = getSharedPreferences(PREFERENCES,MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("USER_EMAIL", email);
        editor.commit();
        Intent intent = new Intent(RegisterActivity.this,ComplaintActivity.class);
        startActivity(intent);

    }


}
