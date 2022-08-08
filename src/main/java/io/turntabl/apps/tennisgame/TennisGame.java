package io.turntabl.apps.tennisgame;

public class TennisGame {

    private int serverScore;
    private int receiverScore;
    private String server;
    private String receiver;

    public TennisGame(String player1, String player2) {
        this.server = player1;
        this.receiver = player2;
    }

    public void wonPoint(String playerName) {
        if (server.equals(playerName))
            this.serverScore += 1;
        else
            this.receiverScore += 1;
    }

    public String getScore() {
        return ResultProvider.calculateResult(serverScore, receiverScore, server, receiver);
    }
}
