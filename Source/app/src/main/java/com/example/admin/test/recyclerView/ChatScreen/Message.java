package com.example.admin.test.recyclerView.ChatScreen;

public class Message {
    String Context;
    int Vitri;

    public String getContext() {
        return Context;
    }

    public void setContext(String context) {
        Context = context;
    }

    public int getVitri() {
        return Vitri;
    }

    public void setVitri(int vitri) {
        Vitri = vitri;
    }

    public Message(String context, int vitri) {
        Context = context;
        Vitri = vitri;
    }
}
