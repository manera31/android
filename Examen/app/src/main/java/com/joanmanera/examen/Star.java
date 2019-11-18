package com.joanmanera.examen;

public class Star {
    private int id;
    private int hip;
    private String bf;
    private String proper;
    private double ra;
    private double dec;
    private double dist;
    private double mag;
    private String spect;

    public Star(int id, int hip, String bf, String proper, double ra, double dec, double dist, double mag, String spect) {
        this.id = id;
        this.hip = hip;
        this.bf = bf;
        this.proper = proper;
        this.ra = ra;
        this.dec = dec;
        this.dist = dist;
        this.mag = mag;
        this.spect = spect;
    }

    public int getId() {
        return id;
    }

    public int getHip() {
        return hip;
    }

    public String getBf() {
        return bf;
    }

    public String getProper() {
        return proper;
    }

    public double getRa() {
        return ra;
    }

    public double getDec() {
        return dec;
    }

    public double getDist() {
        return dist;
    }

    public double getMag() {
        return mag;
    }

    public String getSpect() {
        return spect;
    }

    @Override
    public String toString() {
        return "Star{" +
                "id=" + id +
                ", hip=" + hip +
                ", bf='" + bf + '\'' +
                ", proper='" + proper + '\'' +
                ", ra=" + ra +
                ", dec=" + dec +
                ", dist=" + dist +
                ", mag=" + mag +
                ", spect='" + spect + '\'' +
                '}';
    }
}
