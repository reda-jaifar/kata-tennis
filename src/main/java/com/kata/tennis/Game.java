package com.kata.tennis;

public class Game {
    private Player playerOne;
    private Player playerTwo;
    private Score playerOneScore;
    private Score playerTwoScore;

    public Game(Player playerOne, Player playerTwo) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        this.playerOneScore = Score.LOVE;
        this.playerTwoScore = Score.LOVE;
    }

    public String getScore() {
        if(gameWon()){
            return playerOneScore.ordinal() > playerTwoScore.ordinal() ?
                    playerOne.getName() +  " " + Score.WINS
                    : playerTwo.getName() + " " + Score.WINS;
        }
        if(isAdvantage()){
            return playerOneScore.ordinal() > playerTwoScore.ordinal() ?
                    playerOne.getName() +  " " + playerOneScore
                    : playerTwo.getName() + " " + playerTwoScore;
        }
        if(isDeuce()){
            return "deuce";
        }
        return playerOne.getName() + " " + playerOneScore + " " + playerTwo.getName() + " " + playerTwoScore;
    }

    private boolean isDeuce() {
        return playerOneScore.getValue() >= 3 && playerTwoScore.getValue() == playerOneScore.getValue();
    }

    private boolean isAdvantage() {
        if (playerOneScore.getValue() >= 3 && playerOneScore.getValue() == playerTwoScore.getValue() + 1)
            return true;
        if (playerTwoScore.getValue() >= 3 && playerTwoScore.getValue() == playerOneScore.getValue() + 1)
            return true;

        return false;
    }

    private boolean gameWon() {
        if( playerOneScore.getValue() > 3 && playerOneScore.getValue() >= playerTwoScore.getValue() + 2 ) return true;
        if( playerTwoScore.getValue() > 3 && playerTwoScore.getValue() >= playerOneScore.getValue() + 2 ) return true;
        return false;
    }

    public void scores(Player player) {
        if(player == this.playerOne){
            if(playerTwoScore.equals(Score.ADVANTAGE)){
                playerTwoScore = playerTwoScore.decrement();
            } else {
                playerOneScore = playerOneScore.increment();
            }
        } else if(player == this.playerTwo){
            if(playerOneScore.equals(Score.ADVANTAGE)){
                playerOneScore = playerOneScore.decrement();
            } else {
                playerTwoScore = playerTwoScore.increment();
            }
        } else {
            throw new IllegalArgumentException("player is not part of this game");
        }
    }

}
