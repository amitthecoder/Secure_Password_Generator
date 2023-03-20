package com.amitmusician.secure;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.security.SecureRandom;

public class PasswordActivity extends AppCompatActivity {

    int len;
    TextView textView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password);
        Bundle bundle = getIntent().getExtras();
        len = bundle.getInt("val");
        String pass = Generate(len);
        textView = findViewById(R.id.password);
        button = findViewById(R.id.copy);
        textView.setText(pass);
        button.setOnClickListener(v -> {
            ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
            ClipData clipDat = ClipData.newPlainText("Edittext",textView.getText().toString());
            clipboard.setPrimaryClip(clipDat);
            Toast.makeText(PasswordActivity.this,"Password copied",Toast.LENGTH_SHORT).show();
        });
    }

    private String Generate(int len) {
        String allchar = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890@#$%!";
        StringBuilder sb = new StringBuilder();
        SecureRandom random = new SecureRandom();
        for (int i=0;i<len;i++){
            int index = random.nextInt(allchar.length());
            sb.append(allchar.charAt(index));
        }
        return sb.toString();
    }
}