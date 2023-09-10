package app.servlets.fitness.util;

public class Constants {

    /**
     * log patterns
     */
    public static final String REQUEST_LOG_PATTERN = "{} -> {} : {}";
    public static final String RESPONSE_LOG_PATTERN = "{} -> {} : {}, response : {}";
    public static final String ARGUMENT_LOG_PATTERN = "Method arguments: {}";
    public static final String RESPONSE = "response";
    public static final String EMPTY = "";

    /**
     * invalid messages
     */
    public static final String INVALID_AMOUNT = "Amount cannot be null";
    public static final String INVALID_USER_ID = "User id cannot be null";
    public static final String INVALID_SUBSCRIPTION_ID = "Subscription id cannot be null";
    public static final String INVALID_SUBSCRIPTION_CATEGORY = "Subscription category cannot be null";
    public static final String INVALID_SUBSCRIPTION_NAME = "Subscription name cannot be blank";
    public static final String INVALID_SUBSCRIPTION_PRICE = "Subscription price cannot be null";
    public static final String INVALID_FIRST_NAME = "First name cannot be blank";
    public static final String INVALID_LAST_NAME = "Last name cannot be blank";
    public static final String INVALID_DATE_OF_BIRTH = "Date of birth cannot be null";
    public static final String INVALID_LOGIN = "Login cannot be blank";
    public static final String INVALID_PASSWORD = "Password cannot be blank";
    public static final String INVALID_ROLE = "Role cannot be null";

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
    public static final String AMOUNT = "AMOUNT";
    public static final String PAYMENT_DATE = "PAYMENT_DATE";
    public static final String PAYMENT_STATUS = "PAYMENT_STATUS";

    /**
     * errors
     */
    public static final String USER_SEARCH_EXCEPTION = "User is not present by id: %s";
    public static final String USER_SEARCH_BY_LOGIN_EXCEPTION = "User is not present by login: %s";
    public static final String EXCEPTION = "EXCEPTION {}";
    public static final String VALIDATION_ERROR = "Validation Error: {}";
    public static final String ERROR_SEARCH_EXCEPTION = "Purchase CREATING failed. Subscription or user not found";
    public static final String SUBSCRIPTION_SEARCH_EXCEPTION = "Subscription is not present by id: %s";
    public static final String ERROR_SEARCH_PURCHASE_EXCEPTION = "Purchase is not present by id: %s";

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
