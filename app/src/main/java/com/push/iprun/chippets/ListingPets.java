package com.push.iprun.chippets;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import android.support.v7.app.AppCompatActivity;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


import java.util.ArrayList;
import java.util.List;

public class ListingPets extends AppCompatActivity {
    private DatabaseReference mDatabase;

    private TextView mTypeOfPet;
    private TextView mPetOwnert;
    private TextView mPetChipNumberViewText;

    private ListView mListView;

    private ArrayList<String> mChipID =new ArrayList<>();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listing_pets);

        mDatabase = FirebaseDatabase.getInstance().getReference().child("pets").child());




        mPetChipNumberViewText =(TextView) findViewById(R.id.petChipNumberViewText);
        mTypeOfPet = (TextView) findViewById(R.id.typeOfPet);
        mPetOwnert = (TextView) findViewById(R.id.PetOwnert);

//        mListView =(ListView) findViewById(R.id.ListView);
//
//        final ArrayAdapter<String> arrayAdapter;ggg
//        arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, (List<String>) mListView);
//
//        mListView.setAdapter(arrayAdapter);
//
//
//
//        mDatabase.addChildEventListener(new ChildEventListener() {
//            @Override
//            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
//
//            String value =dataSnapshot.getValue(String.class);
//            mChipID.add(value);
//            arrayAdapter.notifyDataSetChanged();
//
//
//            }
//
//            @Override
//            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
//
//            }
//
//            @Override
//            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {
//
//            }
//
//            @Override
//            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
//
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });


        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String petType =dataSnapshot.getValue().toString();
                String petOwner =dataSnapshot.getValue().toString();
                String petChipNumberViewText =dataSnapshot.getValue().toString();


                mTypeOfPet.setText("petType" + petType);
                mPetOwnert.setText("OwnerName" + petOwner);
                mPetChipNumberViewText.setText("petChipNumberViewText" + petChipNumberViewText);



            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });




    }
}
