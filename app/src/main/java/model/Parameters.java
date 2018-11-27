package model;

public class Parameters {
    private String label;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    private String value;

    public Parameters(String label, String value, String rank) {
        this.label = label;
        this.value = value;
        this.rank = rank;
    }

    private String rank;
}
