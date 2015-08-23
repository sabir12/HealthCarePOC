package com.synavos.util;

/**
 * Created by bilalilyas on 20/08/15.
 */
public class ApplicationURL {

    public static final String FITBIT_PERIOD_DAY_1="1d";
    public static final String FITBIT_PERIOD_DAY_7="7d";
    public static final String FITBIT_PERIOD_DAY_30="30d";
    public static final String FITBIT_PERIOD_WEEK_1="1w";
    public static final String FITBIT_PERIOD_MONTH_1="1m";
    public static final String FITBIT_PERIOD_MONTH_3="3m";
    public static final String FITBIT_PERIOD_MONTH_6="6m";
    public static final String FITBIT_PERIOD_YEAR_1="1y";

    public static String PROFILE="https://api.fitbit.com/1/user/-/profile.json";
    public static String DEVICES="https://api.fitbit.com/1/user/-/devices.json";
    public static String ACTIVITY_LIFETIME_STATS="https://api.fitbit.com/1/user/-/activities.json";
    public static String SLEEP="https://api.fitbit.com/1/user/-/sleep/date/2015-07-14.json";
    public static String FITBIT_DEVICES="https://api.fitbit.com/1/user/-/devices.json";
    public static String DEFAULT_HEART_RATE_TODAY="https://api.fitbit.com/1/user/-/activities/heart/date/today/1d.json";

    public static String HEART_RATE_BY_PERIOD="https://api.fitbit.com/1/user/-/activities/heart/date/{base-date}/{period}.json";


    public static String HEART_RATE_BETWEEN_DATE="https://api.fitbit.com/1/user/-/activities/heart/date/{base-date}/{end-date}.json";

}
