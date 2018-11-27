package model;

public class P2 {
    public P2(Parameters score, Parameters winRatio, Parameters kills, Parameters kpg) {
        this.score = score;
        this.winRatio = winRatio;
        this.kills = kills;
        this.kpg = kpg;
    }

    public Parameters getScore() {
        return score;
    }

    public void setScore(Parameters score) {
        this.score = score;
    }

    public Parameters getWinRatio() {
        return winRatio;
    }

    public void setWinRatio(Parameters winRatio) {
        this.winRatio = winRatio;
    }

    public Parameters getKills() {
        return kills;
    }

    public void setKills(Parameters kills) {
        this.kills = kills;
    }

    public Parameters getKpg() {
        return kpg;
    }

    public void setKpg(Parameters kpg) {
        this.kpg = kpg;
    }

    Parameters score;
    Parameters winRatio;
    Parameters kills;
    Parameters kpg;
}
