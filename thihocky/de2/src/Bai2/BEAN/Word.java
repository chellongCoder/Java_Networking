package Bai2.BEAN;

import java.io.Serializable;

/**
 * @Project de2
 * @Author chellong on 4/1/19.
 **/
public class Word implements Serializable {
    private String shortWord;
    private String longWord;

    public Word(String shortWord, String longWord) {
        this.shortWord = shortWord;
        this.longWord = longWord;
    }

    public Word() {
    }

    public String getshortWord() {
        return shortWord;
    }

    public void setshortWord(String shortWord) {
        this.shortWord = shortWord;
    }

    public String getlongWord() {
        return longWord;
    }

    public void setlongWord(String longWord) {
        this.longWord = longWord;
    }

    @Override
    public String toString() {
        return "Word{" +
                "shortWord='" + shortWord + '\'' +
                ", longWord='" + longWord + '\'' +
                '}';
    }
}
