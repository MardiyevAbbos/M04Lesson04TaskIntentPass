package com.example.intentpassb12java.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.intentpassb12java.R;
import com.example.intentpassb12java.model.Member;
import com.example.intentpassb12java.model.User;

public class SecondActivity extends AppCompatActivity {

    private TextView tvSecondInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        tvSecondInfo = findViewById(R.id.tv_second_info);
        receiveResultUserUseIntentAndParcelable();

    }


    private void receiveResultUserUseIntentAndParcelable() {
        Member member = (Member) getIntent().getParcelableExtra("member");
        tvSecondInfo.setText(member.getFirstName() + ": " + member.getLastName());
    }

    private void sendResultParcelable(Member member) {
        Intent intent = new Intent();
        intent.putExtra("memberResult", member);
        setResult(10, intent);
        finish();
    }

    @Override
    public void onBackPressed() {
    /*    User user = new User("Result Serializable", 19);
        sendResultSerializable(user);
        // for Serializable SendResult
     */
        Member member = new Member("Result Parcelable", "17 letters");
        sendResultParcelable(member);
        super.onBackPressed();
    }


    private void receiveResultUserUseIntentAndSerializable() {
        User user = (User) getIntent().getSerializableExtra("user");
        tvSecondInfo.setText(user.getName() + ": " + user.getAge() + " letters.");
    }

    private void sendResultSerializable(User user) {
        Intent intent = new Intent();
        intent.putExtra("userResult", user);
        setResult(12, intent);
        finish();
    }


    private void receiveMemberUseIntentAndParcelable() {
        Member member = getIntent().getParcelableExtra("member");
        tvSecondInfo.setText((member.getFirstName() + " " + member.getLastName()).toString());
    }


    private void receiveUserUseIntentAndSerializable() {
        User user = (User) getIntent().getSerializableExtra("user");
        tvSecondInfo.setText((user.getName() + ": " + user.getAge() + " ages").toString());
    }


    private void receiveMessageUseIntent() {
        String message = getIntent().getStringExtra("message");
        tvSecondInfo.setText(message);
    }

}