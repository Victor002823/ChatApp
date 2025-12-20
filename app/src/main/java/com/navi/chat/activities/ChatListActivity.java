package com.navi.chat.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.navi.chat.R;
import com.navi.chat.adapters.ChatsAdapter;
import com.navi.chat.models.Chat;

import java.util.ArrayList;
import java.util.List;

public class ChatListActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ChatsAdapter adapter;
    private List<Chat> chatList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_list);

        recyclerView = findViewById(R.id.recyclerViewChats);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Datos demo
        chatList = new ArrayList<>();
        chatList.add(new Chat("1", "Chat 1", "Hola!"));
        chatList.add(new Chat("2", "Chat 2", "Mensaje demo"));
        chatList.add(new Chat("3", "Chat 3", "Último mensaje"));

        adapter = new ChatsAdapter(this, chatList);
        recyclerView.setAdapter(adapter);
    }
}
