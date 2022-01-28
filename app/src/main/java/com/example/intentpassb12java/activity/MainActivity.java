package com.example.intentpassb12java.activity;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.intentpassb12java.R;
import com.example.intentpassb12java.model.Member;
import com.example.intentpassb12java.model.User;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity {

    private TextView tvMainInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

    }

    private void initViews() {
        Button btnSend = findViewById(R.id.btn_open_secondActivity);
        tvMainInfo = findViewById(R.id.tv_main_info);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendResultUserUseIntentAndParcelable();
            }
        });
    }


    private void sendResultUserUseIntentAndParcelable() {
        Member member = new Member("Send Parcelable", "15 letters");
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("member", member);
        launcherParcelable.launch(intent);
    }


    ActivityResultLauncher<Intent> launcherParcelable = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == 10) {
                        Member member = (Member) result.getData().getParcelableExtra("memberResult");
                        tvMainInfo.setText(member.getFirstName() + ": " + member.getLastName());
                    }
                }
            }
    );


    private void sendResultUserUseIntentAndSerializable() {
        User user = new User("Send Serializable", 17);
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("user", user);
        launcherSerializable.launch(intent);
    }


    ActivityResultLauncher<Intent> launcherSerializable = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == 12) {
                        User user = (User) result.getData().getSerializableExtra("userResult");
                        tvMainInfo.setText(user.getName() + ": " + user.getAge() + " letters");
                    }
                }
            }
    );


    private void sendMemberUseIntentAndParcelable() {
        Member member = new Member("Abbos", "Mardiyev");
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("member", member);
        startActivity(intent);
    }


    private void sendUserUseIntentAndSerializable() {
        User user = new User("Abbos", 22);
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("user", user);
        startActivity(intent);
    }


    private void sendMessageUseIntent() {
        String message = "Send Message to SecondActivity";
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("message", message);
        startActivity(intent);
    }

}