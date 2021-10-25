package com.kpi.railwaystation.model;

import lombok.NonNull;

import java.time.LocalDateTime;

@NonNull
public class BasicTrainRoute {
    private Integer id;
    private Platform departurePlatform;
    private Platform arrivalPlatform;
    private Train train;
    private LocalDateTime departureDateTime;
    private LocalDateTime arrivalDateTime;

    BasicTrainRoute(Integer id, Platform departurePlatform, Platform arrivalPlatform, Train train, LocalDateTime departureDateTime, LocalDateTime arrivalDateTime) {
        this.id = id;
        this.departurePlatform = departurePlatform;
        this.arrivalPlatform = arrivalPlatform;
        this.train = train;
        this.departureDateTime = departureDateTime;
        this.arrivalDateTime = arrivalDateTime;
    }

    public static BasicTrainRouteBuilder builder() {
        return new BasicTrainRouteBuilder();
    }

    public Integer getId() {
        return this.id;
    }

    public Platform getDeparturePlatform() {
        return this.departurePlatform;
    }

    public Platform getArrivalPlatform() {
        return this.arrivalPlatform;
    }

    public Train getTrain() {
        return this.train;
    }

    public LocalDateTime getDepartureDateTime() {
        return this.departureDateTime;
    }

    public LocalDateTime getArrivalDateTime() {
        return this.arrivalDateTime;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setDeparturePlatform(Platform departurePlatform) {
        this.departurePlatform = departurePlatform;
    }

    public void setArrivalPlatform(Platform arrivalPlatform) {
        this.arrivalPlatform = arrivalPlatform;
    }

    public void setTrain(Train train) {
        this.train = train;
    }

    public void setDepartureDateTime(LocalDateTime departureDateTime) {
        this.departureDateTime = departureDateTime;
    }

    public void setArrivalDateTime(LocalDateTime arrivalDateTime) {
        this.arrivalDateTime = arrivalDateTime;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof BasicTrainRoute)) return false;
        final BasicTrainRoute other = (BasicTrainRoute) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$departurePlatform = this.getDeparturePlatform();
        final Object other$departurePlatform = other.getDeparturePlatform();
        if (this$departurePlatform == null ? other$departurePlatform != null : !this$departurePlatform.equals(other$departurePlatform))
            return false;
        final Object this$arrivalPlatform = this.getArrivalPlatform();
        final Object other$arrivalPlatform = other.getArrivalPlatform();
        if (this$arrivalPlatform == null ? other$arrivalPlatform != null : !this$arrivalPlatform.equals(other$arrivalPlatform))
            return false;
        final Object this$train = this.getTrain();
        final Object other$train = other.getTrain();
        if (this$train == null ? other$train != null : !this$train.equals(other$train)) return false;
        final Object this$departureDateTime = this.getDepartureDateTime();
        final Object other$departureDateTime = other.getDepartureDateTime();
        if (this$departureDateTime == null ? other$departureDateTime != null : !this$departureDateTime.equals(other$departureDateTime))
            return false;
        final Object this$arrivalDateTime = this.getArrivalDateTime();
        final Object other$arrivalDateTime = other.getArrivalDateTime();
        if (this$arrivalDateTime == null ? other$arrivalDateTime != null : !this$arrivalDateTime.equals(other$arrivalDateTime))
            return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof BasicTrainRoute;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $departurePlatform = this.getDeparturePlatform();
        result = result * PRIME + ($departurePlatform == null ? 43 : $departurePlatform.hashCode());
        final Object $arrivalPlatform = this.getArrivalPlatform();
        result = result * PRIME + ($arrivalPlatform == null ? 43 : $arrivalPlatform.hashCode());
        final Object $train = this.getTrain();
        result = result * PRIME + ($train == null ? 43 : $train.hashCode());
        final Object $departureDateTime = this.getDepartureDateTime();
        result = result * PRIME + ($departureDateTime == null ? 43 : $departureDateTime.hashCode());
        final Object $arrivalDateTime = this.getArrivalDateTime();
        result = result * PRIME + ($arrivalDateTime == null ? 43 : $arrivalDateTime.hashCode());
        return result;
    }

    public String toString() {
        return "BasicTrainRoute(id=" + this.getId() + ", departurePlatform=" + this.getDeparturePlatform() + ", arrivalPlatform=" + this.getArrivalPlatform() + ", train=" + this.getTrain() + ", departureDateTime=" + this.getDepartureDateTime() + ", arrivalDateTime=" + this.getArrivalDateTime() + ")";
    }

    public static class BasicTrainRouteBuilder {
        private Integer id;
        private Platform departurePlatform;
        private Platform arrivalPlatform;
        private Train train;
        private LocalDateTime departureDateTime;
        private LocalDateTime arrivalDateTime;

        BasicTrainRouteBuilder() {
        }

        public BasicTrainRouteBuilder id(Integer id) {
            this.id = id;
            return this;
        }

        public BasicTrainRouteBuilder departurePlatform(Platform departurePlatform) {
            this.departurePlatform = departurePlatform;
            return this;
        }

        public BasicTrainRouteBuilder arrivalPlatform(Platform arrivalPlatform) {
            this.arrivalPlatform = arrivalPlatform;
            return this;
        }

        public BasicTrainRouteBuilder train(Train train) {
            this.train = train;
            return this;
        }

        public BasicTrainRouteBuilder departureDateTime(LocalDateTime departureDateTime) {
            this.departureDateTime = departureDateTime;
            return this;
        }

        public BasicTrainRouteBuilder arrivalDateTime(LocalDateTime arrivalDateTime) {
            this.arrivalDateTime = arrivalDateTime;
            return this;
        }

        public BasicTrainRoute build() {
            return new BasicTrainRoute(id, departurePlatform, arrivalPlatform, train, departureDateTime, arrivalDateTime);
        }

        public String toString() {
            return "BasicTrainRoute.BasicTrainRouteBuilder(id=" + this.id + ", departurePlatform=" + this.departurePlatform + ", arrivalPlatform=" + this.arrivalPlatform + ", train=" + this.train + ", departureDateTime=" + this.departureDateTime + ", arrivalDateTime=" + this.arrivalDateTime + ")";
        }
    }
}
