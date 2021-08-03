package com.smallacademy.userroles;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;


public class Register extends AppCompatActivity {
    EditText fullName,email,password,password2;
    Button registerBtn;
    boolean valid = true;

    FirebaseAuth mAuth;
    FirebaseFirestore mStore;
    CheckBox isAdminBox,isUserBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mAuth = FirebaseAuth.getInstance();
        mStore = FirebaseFirestore.getInstance();



        fullName = findViewById(R.id.registerName);
        email = findViewById(R.id.registerEmail);
        password = findViewById(R.id.registerPassword);
        password2 = findViewById(R.id.registerPassword2);
        registerBtn = findViewById(R.id.registerBtn);

        isAdminBox = findViewById(R.id.isAdmin);
        isUserBox = findViewById(R.id.isUser);

        //Casilla de verificación

        isUserBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (compoundButton.isChecked()){
                    isAdminBox.setChecked(false);
                }
            }
        });

        isAdminBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(compoundButton.isChecked()){
                    isUserBox.setChecked(false);
                }
            }
        });


        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){

                registeruser();
            }
        });

    }

    public boolean checkField(EditText textField){
        if(textField.getText().toString().isEmpty()){
            textField.setError("Campo en blanco");
            valid = false;
        }else {
            valid = true;
        }

        return valid;
    }
    private void registeruser() {
        checkField(fullName);
        checkField(email);
        checkField(password);
        checkField(password2);


        if (valid) {
            if(password.length()==11){
                if (password.getText().toString().equals(password2.getText().toString())) {


                    //Empieza el proceso de registro de usuario

                    mAuth.createUserWithEmailAndPassword(email.getText().toString(), password.getText().toString()).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                        @Override
                        public void onSuccess(AuthResult authResult) {
                            FirebaseUser user = mAuth.getCurrentUser();
                            Toast.makeText(Register.this, "Registro exitoso", Toast.LENGTH_SHORT).show();
                            DocumentReference df = mStore.collection("Usuarios").document(user.getUid());
                            Map<String, Object> userInfo = new HashMap<>();
                            userInfo.put("Nombre Completo", fullName.getText().toString());
                            userInfo.put("Correo electrónico", email.getText().toString());
                            userInfo.put("Contraseña", password.getText().toString());

                            // Especificar si el usuario es Administrador
                            if (isAdminBox.isChecked()) {
                                userInfo.put("Es Admin", "1");
                            } else if (isUserBox.isChecked()) {
                                userInfo.put("Es Usuario", "1");
                            } else {
                                userInfo.put("Es Usuario", "1");
                            }

                            df.set(userInfo);

                            if (isAdminBox.isChecked()) {
                                startActivity(new Intent(getApplicationContext(), Admin.class));
                                finish();
                            } else if (isUserBox.isChecked()) {
                                startActivity(new Intent(getApplicationContext(), MusicPlayer.class));
                                finish();
                            } else {
                                startActivity(new Intent(getApplicationContext(), MusicPlayer.class));
                                finish();
                            }

                        }
                    });
                }else {
                    Toast.makeText(Register.this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show();
                }
            } else{
                Toast.makeText(Register.this, "La contraseña debe ser su número telefónico", Toast.LENGTH_SHORT).show();
            }

        }
    }

}