package es.ifoundthatx.models;

public record DefenseResult(String defenseName, String type, double value) {}

//public class DefenseResult {
//    private final String defenseName, type;
//    private final double value;
//
//    public DefenseResult(String defenseName, String type, double value) {
//        this.defenseName = defenseName;
//        this.type = type;
//        this.value = value;
//    }
//
//    public String getDefenseName() { return defenseName; }
//    public String getType() { return this.type; }
//    public double getValue() { return this.value; }
//}
