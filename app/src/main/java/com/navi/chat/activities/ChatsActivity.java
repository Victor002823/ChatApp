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

public class ChatsActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ChatsAdapter adapter;
    private List<Chat> chats;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chats);

        recyclerView = findViewById(R.id.recyclerViewChats);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Datos de ejemplo
        chats = new ArrayList<>();
        chats.add(new Chat("1", "Chat con Juan", "Hola, ¿cómo estás?"));
        chats.add(new Chat("2", "Chat con María", "Nos vemos mañana"));
        chats.add(new Chat("3", "Chat con Pedro", "¿Listo para la reunión?"));

        adapter = new ChatsAdapter(this, chats);
        recyclerView.setAdapter(adapter);
    }
}
