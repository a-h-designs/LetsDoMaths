package com.ahdesigns.letsdomaths;

public class Score implements Comparable<Score> {

    private String scoreName;
    private String scoreLevel;
    public int scoreNum;

    public Score(String name, String level, int num){
        scoreName=name;
        scoreLevel=level;
        scoreNum=num;
    }

    public int compareTo(Score sc){
        //return 0 if equal
        //1 if passed greater than this
        //-1 if this greater than passed
        return sc.scoreNum>scoreNum? 1 : sc.scoreNum<scoreNum? -1 : 0;
    }

    public String getScoreText()
    {
        return scoreName+" - "+scoreLevel+" - "+scoreNum;
    }
}