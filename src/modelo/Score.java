package modelo;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

public class Score {

    private String nickName;
    private int score;
    File Score;
    FileWriter Writer;
    PrintWriter Line;

    public Score() {

    }

    public void file() {
        Score = new File("src\\file\\Score.txt");
        if (!Score.exists()) {
            try {
                Score.createNewFile();
                Writer = new FileWriter(Score, true);
                Line = new PrintWriter(Writer);
                Line.println(" NickName: " + nickName + " ");
                Line.close();
                Writer.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            try {
                Writer = new FileWriter(Score, true);
                Line = new PrintWriter(Writer);
                Line.println(" NickName: " + nickName + " ");
                Line.close();
                Writer.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void fileScore(int level) {
        Score = new File("src\\file\\Score.txt");
        if (!Score.exists()) {
            try {
                Writer = new FileWriter(Score, true);
                Line = new PrintWriter(Writer);
                Line.println(" Score: " + score);
                Line.close();
                Writer.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            try {
                Writer = new FileWriter(Score, true);
                Line = new PrintWriter(Writer);
                Line.println(" Level " + level + " :" + score);
                Line.close();
                Writer.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void mostrar() {
        System.out.println("" + getNickName());
        System.out.println("" + getScore());
    }

    /**
     * @return the nickName
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * @param nickName the nickName to set
     */
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    /**
     * @return the score
     */
    public int getScore() {
        return score;
    }

    /**
     * @param score the score to set
     */
    public void setScore(int score) {
        this.score = score;
    }
}
