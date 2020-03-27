package ohtu;

public class TennisGame {
    
    private int player1Score = 0;
    private int player2Score = 0;
    private String player1Name;
    private String player2Name;

    public TennisGame(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName == "player1")
            player1Score += 1;
        else
            player2Score += 1;
    }

    public String pointsToString(int points) {
        

        if(points == 0) {
            return "Love";
        } else if (points == 1) {
            return "Fifteen"; 
        } else if(points == 2) {
            return "Thirty";
        } else if(points==3){
            return "Forty";
        }

        return "Deuce";
    }

    public String getScore() {
        
        if (player1Score == player2Score)
        {
            return evenGameSituation(player1Score);
        }
        else if (player1Score>=4 || player2Score>=4)
        {
            return advantage(player1Score, player2Score);
        }
        else
        {
            return pointsToString(player1Score) + "-" + pointsToString(player2Score);
        }
        
    }

    public String evenGameSituation(int score) {

        if(score < 4) {
            return pointsToString(score) + "-All";
        } else {
            return "Deuce";
        }

    }

    public String advantage(int score1, int score2) {

        int minusResult = score1 - score2;

        if(minusResult == 1) {
            return "Advantage player1";
        } else if (minusResult == -1) {
            return "Advantage player2";
        } else if (minusResult >= 2) {
            return "Win for player1";
        } else {
            return "Win for player2";
        }
    }
}