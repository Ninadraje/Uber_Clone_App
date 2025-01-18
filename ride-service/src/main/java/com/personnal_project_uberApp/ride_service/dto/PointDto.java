package com.personnal_project_uberApp.ride_service.dto;


public class PointDto {

    private double[] coordinates;

    private String type = "Point";

    public PointDto(double[] coordinates) {
        this.coordinates = coordinates;
    }

    public PointDto(double[] coordinates, String type) {
        this.coordinates = coordinates;
        this.type = type;
    }

    public PointDto() {
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof PointDto)) return false;
        final PointDto other = (PointDto) o;
        if (!other.canEqual((Object) this)) return false;
        if (!java.util.Arrays.equals(this.getCoordinates(), other.getCoordinates())) return false;
        final Object this$type = this.getType();
        final Object other$type = other.getType();
        if (this$type == null ? other$type != null : !this$type.equals(other$type)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof PointDto;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        result = result * PRIME + java.util.Arrays.hashCode(this.getCoordinates());
        final Object $type = this.getType();
        result = result * PRIME + ($type == null ? 43 : $type.hashCode());
        return result;
    }

    public String toString() {
        return "PointDto(coordinates=" + java.util.Arrays.toString(this.getCoordinates()) + ", type=" + this.getType() + ")";
    }

    public double[] getCoordinates() {
        return this.coordinates;
    }

    public String getType() {
        return this.type;
    }

    public void setCoordinates(double[] coordinates) {
        this.coordinates = coordinates;
    }

    public void setType(String type) {
        this.type = type;
    }
}
