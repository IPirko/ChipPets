package com.push.iprun.chippets;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity
{
    private DatabaseReference mDatabase;



    Button buttonListing;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button buttonAdd = findViewById(R.id.buttonSubmit);
        final Spinner spinnerPet = findViewById(R.id.petTypeSpinner);
        final EditText editTextChipNumber = findViewById(R.id.petChipNumberEditText);
        final EditText editTextPetName = findViewById(R.id.petNameEditText);
        final EditText editTextPetOwner = findViewById(R.id.petOwnerFullNameEditText);
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writeNewPet(spinnerPet.getSelectedItem().toString(), editTextChipNumber.getText().toString(), editTextPetName.getText().toString(), editTextPetOwner.getText().toString() );


            }

        });


        mDatabase = FirebaseDatabase.getInstance().getReference();

        buttonListing =(Button) findViewById(R.id.buttonListing);
    }



    private void writeNewPet(String petType, String chipNumber, String petName, String petOwner) {
        Pet pet = new Pet(petType, chipNumber, petName, petOwner);
        //chip number unique
        mDatabase.child("pets").child("ID: " + chipNumber).setValue(pet);
    }


    public void buttonListing(View view) {
        Intent Intent = new Intent(this, ListingPets.class);
        startActivity(Intent);
    }


}
