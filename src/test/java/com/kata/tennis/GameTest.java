package com.kata.tennis;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GameTest {

    Player playerOne = new Player("reda");
    Player playerTwo = new Player("stephane");
    Game game = new Game(playerOne, playerTwo);

    @Test
    public void when_a_game_starts_then_score_should_be_love_all() {
        assertEquals(game.getScore(), "reda LOVE stephane LOVE");
    }

    @Test
    public void when_player1_scores_first_then_score_should_be_fifteen_love() {
        game.scores(playerOne);
        assertEquals(game.getScore(), "reda FIFTEEN stephane LOVE");
    }

    @Test
    public void when_both_players_scores_then_score_should_be_fifteen_all() {
        game.scores(playerOne);
        game.scores(playerTwo);
        Assertions.assertEquals(game.getScore(), "reda FIFTEEN stephane FIFTEEN");
    }

    @Test
    public void when_players_have_both_forty_then_score_should_be_deuce() {
        game.scores(playerOne);
        game.scores(playerTwo);
        game.scores(playerOne);
        game.scores(playerTwo);
        game.scores(playerOne);
        game.scores(playerTwo);
        Assertions.assertEquals(game.getScore(), "deuce");
    }

    @Test
    public void when_player1_scores_4_points_then_score_should_be_player1_wins() {
        game.scores(playerOne);
        game.scores(playerTwo);
        game.scores(playerOne);
        game.scores(playerOne);
        game.scores(playerOne);
        Assertions.assertEquals(game.getScore(), "reda WINS");
    }

    @Test
    public void when_players_are_deuce_and_player1_scores_then_score_should_be_advantage_for_player1() {
        game.scores(playerOne);
        game.scores(playerTwo);
        game.scores(playerOne);
        game.scores(playerTwo);
        game.scores(playerOne);
        game.scores(playerTwo);
        game.scores(playerOne);
        Assertions.assertEquals(game.getScore(), "reda ADVANTAGE");
    }

    @Test
    public void when_player1_has_advantage_and_player2_scores_then_score_should_be_deuce() {
        game.scores(playerOne);
        game.scores(playerTwo);
        game.scores(playerOne);
        game.scores(playerTwo);
        game.scores(playerOne);
        game.scores(playerTwo);
        game.scores(playerOne);
        game.scores(playerTwo);
        Assertions.assertEquals(game.getScore(), "deuce");
    }
}