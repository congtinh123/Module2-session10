public class TennisGame {

    private static final int SCORE_LOVE = 0;
    private static final int SCORE_FIFTEEN = 1;
    private static final int SCORE_THIRTY = 2;
    private static final int SCORE_FORTY = 3;
    private static final int SCORE_ADVANTAGE = 4;

    private int player1Score = SCORE_LOVE;
    private int player2Score = SCORE_LOVE;
    private final String player1Name;
    private final String player2Name;

    public TennisGame(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName.equals(player1Name)) {
            player1Score++;
        } else if (playerName.equals(player2Name)) {
            player2Score++;
        }
    }

    public String getScore() {
        if (isScoreEqual()) {
            return getEqualScore();
        }
        if (isWinOrAdvantage()) {
            return getWinOrAdvantageScore();
        }
        return getRegularScore();
    }

    private boolean isScoreEqual() {
        return player1Score == player2Score;
    }

    private String getEqualScore() {
        switch (player1Score) {
            case SCORE_LOVE:
                return "Love-All";
            case SCORE_FIFTEEN:
                return "Fifteen-All";
            case SCORE_THIRTY:
                return "Thirty-All";
            default:
                return "Deuce";
        }
    }

    private boolean isWinOrAdvantage() {
        return player1Score >= SCORE_ADVANTAGE || player2Score >= SCORE_ADVANTAGE;
    }

    private String getWinOrAdvantageScore() {
        int scoreDifference = player1Score - player2Score;
        if (scoreDifference == 1) {
            return "Advantage " + player1Name;
        }
        if (scoreDifference == -1) {
            return "Advantage " + player2Name;
        }
        if (scoreDifference >= 2) {
            return "Win for " + player1Name;
        }
        return "Win for " + player2Name;
    }

    private String getRegularScore() {
        return translateScore(player1Score) + "-" + translateScore(player2Score);
    }

    private String translateScore(int score) {
        switch (score) {
            case SCORE_LOVE:
                return "Love";
            case SCORE_FIFTEEN:
                return "Fifteen";
            case SCORE_THIRTY:
                return "Thirty";
            case SCORE_FORTY:
                return "Forty";
            default:
                throw new IllegalArgumentException("Invalid score: " + score);
        }
    }
}
