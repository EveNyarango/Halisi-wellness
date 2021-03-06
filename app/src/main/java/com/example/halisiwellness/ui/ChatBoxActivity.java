package com.example.halisiwellness.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.halisiwellness.R;
import com.example.halisiwellness.models.ChatMessage;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import com.example.halisiwellness.adapter.ChatMessageAdapter;

public class ChatBoxActivity extends AppCompatActivity {



        private ListView mListView;
        private FloatingActionButton mButtonSend;
        private EditText mEditTextMessage;
        private ImageView mImageView;
        private ChatMessageAdapter mAdapter;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_chatbox);
            mListView = (ListView) findViewById(R.id.listView);
            mButtonSend = (FloatingActionButton) findViewById(R.id.btn_send);
            mEditTextMessage = (EditText) findViewById(R.id.et_message);
            mImageView = (ImageView) findViewById(R.id.iv_image);
            mAdapter = new ChatMessageAdapter(this, new ArrayList<ChatMessage>());
            mListView.setAdapter(mAdapter);

//code for sending the message
            mButtonSend.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String message = mEditTextMessage.getText().toString();
                    sendMessage(message);
                    mEditTextMessage.setText("");
                    mListView.setSelection(mAdapter.getCount() - 1);
                }
            });
        }

        private void sendMessage(String message) {
            ChatMessage chatMessage = new ChatMessage(message, true, false);
            mAdapter.add(chatMessage);
            //respond as Helloworld
            mimicOtherMessage("Thank You For Contacting Halisi Wellness");
        }

        private void mimicOtherMessage(String message) {
            ChatMessage chatMessage = new ChatMessage(message, false, false);
            mAdapter.add(chatMessage);
        }

        private void sendMessage() {
            ChatMessage chatMessage = new ChatMessage(null, true, true);
            mAdapter.add(chatMessage);

            mimicOtherMessage();
        }

        private void mimicOtherMessage() {
            ChatMessage chatMessage = new ChatMessage(null, false, true);
            mAdapter.add(chatMessage);
        }
}
