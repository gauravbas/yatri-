package com.example.yatri.Authentication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.yatri.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ProfileUserInformation extends AppCompatActivity {
    EditText editTextUserName, editTextUserAge, editTextUserPhone;
    Button buttonUserUpdateInfo;
    private FirebaseAuth firebaseAuth;
    private DatabaseReference databaseReference;
    ProfileUserInfo profileUserInfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_user_information);
        firebaseAuth = FirebaseAuth.getInstance();
        editTextUserName = (EditText) findViewById(R.id.editTextUserName);
        editTextUserAge = (EditText) findViewById(R.id.editTextUserAge);
        editTextUserPhone = (EditText) findViewById(R.id.editTextUserPhone);
        buttonUserUpdateInfo = (Button) findViewById(R.id.buttonUserUpdateInfo);

        profileUserInfo=new ProfileUserInfo();
        databaseReference = FirebaseDatabase.getInstance().getReference().child("Users");
        buttonUserUpdateInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Name = editTextUserName.getText().toString().trim();
                String Age = editTextUserAge.getText().toString().trim();
                String Phone = editTextUserPhone.getText().toString().trim();
                FirebaseUser user = firebaseAuth.getCurrentUser();
                String UserId = user.getUid();
                ProfileUserInfo personalInfo = new ProfileUserInfo(Name,Age,Phone,UserId);
                databaseReference.child(user.getUid()).setValue(personalInfo);
                Toast.makeText(ProfileUserInformation.this,"Data Updated",Toast.LENGTH_LONG).show();
            }
        });
    }
}