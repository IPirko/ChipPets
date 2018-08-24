package com.push.iprun.chippets;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class Pet {

    public String petType;
    public String chipnumber;
    public String petName;
    public String petOwner;

    public Pet() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public Pet(String petType, String chipNumber, String petName, String petOwner) {
        this.petType = petType;
        this.chipnumber = chipNumber;
        this.petName = petName;
        this.petOwner = petOwner;
    }

}
