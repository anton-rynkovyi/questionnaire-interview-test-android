package com.qit.android.rest.api;

public class FirebaseEventinfoGodObj {

    private static String firebaseCurrentEventName;
    private static String firebaseUserFullName;
    private static String firebaseUSerEmail;
    private static int firebaseCurrentQuestion;

    public static String getFirebaseCurrentEventName() {
        return firebaseCurrentEventName;
    }

    public static void setFirebaseCurrentEventName(String string) {
        firebaseCurrentEventName = string;
    }


    public static String getFirebaseUserFullName() {
        return firebaseUserFullName;
    }

    public static void setFirebaseUserFullName(String firebaseUserFullName) {
        FirebaseEventinfoGodObj.firebaseUserFullName = firebaseUserFullName;
    }

    public static String getFirebaseUSerEmail() {
        return firebaseUSerEmail;
    }

    public static void setFirebaseUSerEmail(String firebaseUSerEmail) {
        FirebaseEventinfoGodObj.firebaseUSerEmail = firebaseUSerEmail;
    }

    public static int getFirebaseCurrentQuestion() {
        return firebaseCurrentQuestion;
    }

    public static void setFirebaseCurrentQuestion(int firebaseCurrentQuestion) {
        FirebaseEventinfoGodObj.firebaseCurrentQuestion = firebaseCurrentQuestion;
    }


}