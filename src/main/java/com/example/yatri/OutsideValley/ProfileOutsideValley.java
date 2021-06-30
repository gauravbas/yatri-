package com.example.yatri.OutsideValley;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
//import com.example.yatridrive.OutsideValley.BusInfoActivity;
//import com.example.yatridrive.OutsideValley.PersonalInfoActivity;
import com.example.yatri.R;

public class ProfileOutsideValley extends AppCompatActivity  {
    /* EditText placeID;
       EditText priceID;
       Button addID;
       DatabaseReference databasePlace;  */
    Button buttonUpdatePersInf,buttonUpdateBusInf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_outside_valley);
     /*   databasePlace = FirebaseDatabase.getInstance().getReference("place");
        placeID=(EditText) findViewById(R.id.placeID);
        priceID=(EditText)findViewById(R.id.priceID);
        addID=(Button)findViewById(R.id.addID);
        addID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addplace();
            }
        }); */

   /* private void addplace(){
        String name = placeID.getText().toString().trim();
        String number=priceID.getText().toString().trim();
        if(!TextUtils.isEmpty(name)){
            String id = databasePlace.push().getKey();
            plist Plist = new plist(id,name,number);
            databasePlace.child(id).setValue(Plist);
            Toast.makeText(this,"added place",Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(this,"you should enter place",Toast.LENGTH_LONG).show();
        }
        }*/
    }
}