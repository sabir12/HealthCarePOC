package com.synavos.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * Created by sajjadpervaiz on 18/08/2015.
 */

public final class Activities {


    public Best best;
    public Lifetime lifetime;

    //Default constructor
    public Activities(){}
    @JsonCreator
    public Activities(@JsonProperty("best") Best best, @JsonProperty("lifetime") Lifetime lifetime){
        this.best = best;
        this.lifetime = lifetime;
    }

    public static final class Best {
        public Total total;
        public Tracker tracker;

        //Default constructor
        public Best(){}
        @JsonCreator
        public Best(@JsonProperty("total") Total total, @JsonProperty("tracker") Tracker tracker){
            this.total = total;
            this.tracker = tracker;
        }

        public static final class Total {
            public Distance distance;
            public Steps steps;

            //Default constructor
            public Total(){}
            @JsonCreator
            public Total(@JsonProperty("distance") Distance distance, @JsonProperty("steps") Steps steps){
                this.distance = distance;
                this.steps = steps;
            }

            public final class Distance {
                public String date;
                public double value;
                public Distance(){}
                @JsonCreator
                public Distance(@JsonProperty("date") String date, @JsonProperty("value") double value){
                    this.date = date;
                    this.value = value;
                }
            }

            public final class Steps {
                public String date;
                public long value;

                //Default constructor
                public Steps(){}
                @JsonCreator
                public Steps(@JsonProperty("date") String date, @JsonProperty("value") long value){
                    this.date = date;
                    this.value = value;
                }
            }
        }

        public static final class Tracker {
            public Distance distance;
            public Steps steps;

            //Default constructor
            public Tracker(){}
            @JsonCreator
            public Tracker(@JsonProperty("distance") Distance distance, @JsonProperty("steps") Steps steps){
                this.distance = distance;
                this.steps = steps;
            }

            public final class Distance {
                public String date;
                public double value;

                //Default constructor
                public Distance(){}
                @JsonCreator
                public Distance(@JsonProperty("date") String date, @JsonProperty("value") double value){
                    this.date = date;
                    this.value = value;
                }
            }

            public final class Steps {
                public String date;
                public long value;

                //Default constructor
                public Steps(){}
                @JsonCreator
                public Steps(@JsonProperty("date") String date, @JsonProperty("value") long value){
                    this.date = date;
                    this.value = value;
                }
            }
        }
    }

    public final class Lifetime {
        public Total total;
        public Tracker tracker;

        //Default constructor
        public Lifetime(){}
        @JsonCreator
        public Lifetime(@JsonProperty("total") Total total, @JsonProperty("tracker") Tracker tracker){
            this.total = total;
            this.tracker = tracker;
        }

        public final class Total {
            public long activeScore;
            public long caloriesOut;
            public double distance;
            public long steps;

            //Default constructor
            public Total(){}
            @JsonCreator
            public Total(@JsonProperty("activeScore") long activeScore, @JsonProperty("caloriesOut") long caloriesOut, @JsonProperty("distance") double distance, @JsonProperty("steps") long steps){
                this.activeScore = activeScore;
                this.caloriesOut = caloriesOut;
                this.distance = distance;
                this.steps = steps;
            }
        }

        public final class Tracker {
            public long activeScore;
            public long caloriesOut;
            public double distance;
            public long steps;

            //Default constructor
            public Tracker(){}
            @JsonCreator
            public Tracker(@JsonProperty("activeScore") long activeScore, @JsonProperty("caloriesOut") long caloriesOut, @JsonProperty("distance") double distance, @JsonProperty("steps") long steps){
                this.activeScore = activeScore;
                this.caloriesOut = caloriesOut;
                this.distance = distance;
                this.steps = steps;
            }
        }
    }
    @Override
    public String toString() {
        return "Activities [distance=" + best.total.distance.value+
                "]";
    }
}
