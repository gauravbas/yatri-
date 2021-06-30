package com.example.yatri.Authentication;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.example.yatri.InsideValley.ProfileInsideValley;
import com.example.yatri.OutsideValley.ProfileOutsideValley;
import com.example.yatri.VehicleTracking.ProfileVehicleTracking;
import com.example.yatri.R;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ProfileActivity extends AppCompatActivity implements View.OnClickListener  {
    private FirebaseAuth firebaseAuth;
    private Button buttonSignOut, buttonInsideValley, buttonOutsideValley, buttonTrackVehicle, buttonViewUserProfile;
    private TextView texViewUserEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        firebaseAuth = FirebaseAuth.getInstance();
        if(firebaseAuth.getCurrentUser()==null){
            finish();
            startActivity(new Intent(this, LoginActivity.class));
        }
        FirebaseUser user = firebaseAuth.getCurrentUser();

        texViewUserEmail = (TextView) findViewById(R.id.textViewUserEmail);
        texViewUserEmail.setText("Welcome " + user.getEmail());
        buttonSignOut = (Button) findViewById(R.id.buttonSignOut);
        buttonInsideValley = (Button) findViewById(R.id.buttonInsideValley);
        buttonOutsideValley = (Button) findViewById(R.id.buttonOutsideValley);
        buttonTrackVehicle = (Button) findViewById(R.id.buttonTrackVehicle);
        buttonViewUserProfile = (Button) findViewById(R.id.buttonViewUserProfile);
        buttonSignOut.setOnClickListener(this);
        buttonTrackVehicle.setOnClickListener(this);
        buttonOutsideValley.setOnClickListener(this);
        buttonInsideValley.setOnClickListener(this);
        buttonViewUserProfile.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view == buttonSignOut){
            firebaseAuth.signOut();
            finish();
            startActivity(new Intent(this, LoginActivity.class));
        }
        if(view == buttonInsideValley){
            startActivity(new Intent(this, ProfileInsideValley.class));
        }
        if(view == buttonOutsideValley){
            startActivity(new Intent(this, ProfileOutsideValley.class));
        }
        if(view== buttonTrackVehicle) {
            startActivity(new Intent(this, ProfileVehicleTracking.class));
        }
        if(view==buttonViewUserProfile){
            startActivity(new Intent(this, ProfileUserInformation.class));
        }
    }
}