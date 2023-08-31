package app.servlets.fitness.util;

public class Constants {

    /**
     * subscription fields
     */
    public static final String SUBSCRIPTION = "subscription";
    public static final String DESCRIPTION = "description";
    public static final String ID = "id";

    /**
     * purchase fields
     */
    public static final String PURCHASE_TABLE = "PURCHASE";
    public static final String USER_ID = "USER_ID";
    public static final String SUBSCRIPTION_ID = "SUBSCRIPTION_ID";
    public static final String AMOUNT_BYN = "AMOUNT_BYN";
    public static final String PAYMENT_DATE = "PAYMENT_DATE";
    public static final String PAYMENT_STATUS = "PAYMENT_STATUS";


    /**
     * errors
     */
    public static final String USER_SEARCH_EXCEPTION = "User is not present by id: ";
    public static final String USER_SEARCH_BY_LOGIN_EXCEPTION = "User is not present by login: ";
    public static final String EXCEPTION = "EXCEPTION {}";
    public static final String VALIDATION_ERROR = "Validation Error: {}";
    public static final String SUBSCRIPTION_CREATION_EXCEPTION = "Subscription CREATING failed";
    public static final String SUBSCRIPTION_SEARCH_EXCEPTION = "Subscription is not present by id: ";
    public static final String ERROR_SEARCH_PURCHASE_EXCEPTION = "The PURCHASE not found";


    /**
     * Password hashing
     */
    public static final String ALGORITHM_PBKDF2 = "PBKDF2WithHmacSHA256";
    public static final String SPLIT_FOR_PBKDF2 = ":";
    public static final int ZERO = 0;
    public static final int ONE = 1;
    public static final int SALT_LENGTH = 16;
    public static final int ITERATIONS = 100000;
    public static final int KEY_LENGTH = 256;


    /**
     * fields for db
     */
    public final static String USER_TABLE = "person";
    public final static String DATE_BIRTHDAY_COLUMN = "date_birthday";
    public final static String SUBSCRIPTION_CATEGORY_COLUMN = "subscription_category";
    public final static String SUBSCRIPTION_NAME_COLUMN = "subscription_name";
    public final static String SUBSCRIPTION_PRICE_COLUMN = "subscription_price";
    public final static String SUBSCRIPTION_DAYS_NUMBER_COLUMN = "subscription_days_number";
    public final static String NUMBER_GUEST_VISIT_DAYS_COLUMN = "number_guest_visit_days";
    public final static String NUMBER_SUBSCRIPTION_STOP_DAYS_COLUMN = "number_subscription_stop_days";
    public static final String LOGIN = "login";
    public static final String PASSWORD = "password";
    public static final String USER = "user";
    public static final String ROLE = "role";
    public static final String FIRST_NAME_COLUMN = "first_name";
    public static final String LAST_NAME_COLUMN = "last_name";
}
