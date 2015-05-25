/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MazeOefenMeuk;


/**
 * @author Chris
 */


public class ScoreBoard{
    private final Frame frame;
    private final int initialScore;
    private int score;
    
    public ScoreBoard(Frame Frame, int initialscore) {
        initialScore = initialscore;
        score = initialscore;
        frame=Frame;
        updateScore();
    }
    
    public void movePenalty(){
        if(score>(initialScore/10))
        {
        score-=10;
        updateScore();
        }
    }
    
    public void cheatPenalty(){
        score -=(initialScore/2);
        updateScore();
    }
            
    
    private void updateScore(){
        String Score = Integer.toString(score);
        frame.setScore(Score);
    }
    
}
