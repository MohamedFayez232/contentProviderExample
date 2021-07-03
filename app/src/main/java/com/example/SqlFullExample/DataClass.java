package com.example.SqlFullExample;

public class DataClass {
    private String word;
    private String Explaining;
    private int id;


    public DataClass() {
    }

    public DataClass(String word, String explaining , int id) {
        this.word = word;
        Explaining = explaining;
        this.id = id;
    }

    public DataClass(String word, String explaining ) {
        this.word = word;
        Explaining = explaining;

    }


    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getExplaining() {
        return Explaining;
    }

    public void setExplaining(String explaining) {
        Explaining = explaining;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
