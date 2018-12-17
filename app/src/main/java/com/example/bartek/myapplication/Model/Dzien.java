package com.example.bartek.myapplication.Model;

public class Dzien {

    public int idnotatka;
    public String data, text;

    public Dzien(int idnotatka, String data, String text) {
        this.idnotatka = idnotatka;
        this.data = data;
        this.text = text;
    }

    public Dzien() {
    }

    public void setIdnotatka(int idnotatka) {
        this.idnotatka = idnotatka;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getIdnotatka() {
        return idnotatka;
    }

    public String getData() {
        return data;
    }

    public String getText() {
        return text;
    }
}
