package com.example.tindoc;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class signup extends AppCompatActivity {
    private static final String TAG = "signup";
    private static final String KEY_USER = "user";
    private static final String KEY_MOBILE = "mobile";
    private static final String KEY_ADDRESS = "address";
    private static final String KEY_BEMAR = "bemar";
    private EditText editUser;
    private EditText editMobile;
    private EditText editAddress;
    private EditText editBemar;

    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private DocumentReference noteRef = db.document("Patient/Patient Info");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        editUser = findViewById(R.id.username);
        editMobile = findViewById(R.id.phone);
        editAddress = findViewById(R.id.address);
        editBemar = findViewById(R.id.disease);
          }
    public void saveNote(View v) {
        String user = editUser.getText().toString();
        String mobile = editMobile.getText().toString();
        String address = editAddress.getText().toString();
        String bemar = editBemar.getText().toString();
        Map<String, Object> note = new HashMap<>();
        note.put(KEY_USER, user);
        note.put(KEY_MOBILE, mobile);
        note.put(KEY_ADDRESS, address);
        note.put(KEY_BEMAR, bemar);

        noteRef.set(note)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(signup.this, "Data saved", Toast.LENGTH_SHORT).show();
                        home();

                    } })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(signup.this, "Error!", Toast.LENGTH_SHORT).show();
                        Log.d(TAG, e.toString());                    }                });    }

    public void home() {
        Intent intent = new Intent(this, home.class);
        startActivity(intent);
    }
    }