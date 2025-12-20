package com.navi.chat.activities;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.navi.chat.R;
import com.navi.chat.adapters.MessageAdapter;
import com.navi.chat.models.Message;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChatActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MessageAdapter adapter;
    private List<Message> messages;
    private EditText etMessage;
    private Button btnSend;

    // Simulamos mensajes por chat
    private static final Map<String, List<Message>> chatMessages = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        recyclerView = findViewById(R.id.recyclerView);
        etMessage = findViewById(R.id.etMessage);
        btnSend = findViewById(R.id.btnSend);

        // Obtener nombre del chat
        String chatName = getIntent().getStringExtra("chatName");

        // Inicializar lista de mensajes para este chat si no existe
        if (!chatMessages.containsKey(chatName)) {
            List<Message> demoMessages = new ArrayList<>();
            demoMessages.add(new Message("Hola", "User1"));
            demoMessages.add(new Message("¿Cómo estás?", "User2"));
            chatMessages.put(chatName, demoMessages);
        }

        messages = chatMessages.get(chatName);
        adapter = new MessageAdapter(messages);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        btnSend.setOnClickListener(v -> {
            String text = etMessage.getText().toString().trim();
            if (!text.isEmpty()) {
                messages.add(new Message(text, "Yo"));
                adapter.notifyItemInserted(messages.size() - 1);
                recyclerView.scrollToPosition(messages.size() - 1);
                etMessage.setText("");
            }
        });
    }
}
