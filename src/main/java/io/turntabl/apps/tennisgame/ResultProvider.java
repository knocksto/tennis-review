package io.turntabl.apps.tennisgame;

import java.util.Objects;

public class ResultProvider {
    private static final String[] defaults = {"Love", "Fifteen", "Thirty", "Forty"};

    private static final String WIN = "Win for %s";

    private static final String ADVANTAGE = "Advantage %s";

    private static final String DEUCE = "Deuce";

    private static final String All = "All";

    public static String calculateResult(Integer serverScore, Integer receiverScore, String serverName, String receiverName) {

        if (serverHasWon(serverScore, receiverScore)) {
            return String.format(WIN, serverName);
        } else if (receiverHasWon(serverScore, receiverScore)) {
            return String.format(WIN, receiverName);
        } else if (isDeuce(serverScore, receiverScore)) {
            return DEUCE;
        } else if (serverHasAdvantage(serverScore, receiverScore)) {
            return String.format(ADVANTAGE, serverName);
        } else if (receiverHasAdvantage(serverScore, receiverScore)) {
            return String.format(ADVANTAGE, receiverName);
        } else {
            return defaultCheck(serverScore, receiverScore);
        }
    }

    private static String defaultCheck(Integer serverScore, Integer receiverScore) {
        return Objects.equals(serverScore, receiverScore) ? defaults[serverScore] + "-" + All :
                defaults[serverScore] + "-" + defaults[receiverScore];
    }

    private static boolean receiverHasAdvantage(Integer serverScore, Integer receiverScore) {
        return receiverScore >= 4 && (receiverScore - serverScore) == 1;
    }

    private static boolean serverHasAdvantage(Integer serverScore, Integer receiverScore) {
        return serverScore >= 4 && (serverScore - receiverScore) == 1;
    }

    private static boolean receiverHasWon(Integer serverScore, Integer receiverScore) {
        return receiverScore >= 4 && (receiverScore - serverScore) >= 2;
    }


    private static boolean serverHasWon(Integer serverScore, Integer receiverScore) {
        return serverScore >= 4 && (serverScore - receiverScore) >= 2;
    }

    private static boolean isDeuce(Integer serverScore, Integer receiverScore) {
        return serverScore >= 3 && receiverScore >= 3 && (serverScore == receiverScore);
    }

}
