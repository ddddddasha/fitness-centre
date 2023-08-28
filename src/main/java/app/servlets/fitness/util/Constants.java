package app.servlets.fitness.util;

public class Constants {

    /**
     * email filter
     */
    public static final String EMAIL_REGEX = "[A-Za-z0-9]+@[A-Za-z0-9]+\\.[A-Za-z]{2,4}";


    /**
     * url
     */
    public static final String LOGIN_URL = "/login";
    public static final String ADMIN_READ_USERS_URL = "/admin/users";
    public static final String SUBSCRIPTIONS_URL = "/subscription";


    /**
     * pages
     */
    public static final String USER_REGISTRATION_PAGE = "/pages/user/user-registration.jsp";
    public static final String INDEX_PAGE = "/index.jsp";
    public static final String EDIT_SUBSCRIPTION_PAGE = "/pages/subscriptions/editSub.jsp";
    public static final String ALL_SUBSCRIPTIONS_PAGE = "/pages/subscriptions/subscriptions.jsp";
    public static final String EDIT_USER_PAGE = "/pages/user/editUser.jsp";
    public static final String ALL_USERS_PAGE = "/pages/admin/read-all-users.jsp";
    public static final String SIGN_IN_PAGE = "/pages/user/user-sign-in.jsp";
    public static final String CLIENT_HOME_PAGE = "/pages/client/client-home.jsp";
    public static final String FIND_SUBS_PAGE = "/pages/subscriptions/findSubs.jsp";
    public static final String EDIT_SUBSCRIPTION_EXCEPTION_PAGE = "/pages/exceptions/edit-subscription-exception.jsp";
    public static final String DELETE_SUBSCRIPTION_EXCEPTION_PAGE ="/pages/exceptions/delete-subscription-exception.jsp";
    public static final String EDIT_USER_EXCEPTION_PAGE = "/pages/exceptions/edit-user-exception.jsp";


    /**
     * subscription fields
     */
    public static final String SUBSCRIPTION = "subscription";
    public static final String SUBSCRIPTION_SERVICE = "subscriptionService";
    public static final String SUBSCRIPTION_CATEGORY = "subscriptionCategory";
    public static final String SUBSCRIPTION_NAME = "subscriptionName";
    public static final String SUBSCRIPTION_PRICE = "subscriptionPrice";
    public static final String SUBSCRIPTION_PERIOD = "subscriptionPeriod";
    public static final String NUMBER_OF_GUEST_VISITS = "numberOfGuestVisits";
    public static final String MAX_SUBSCRIPTION_STOP = "maxSubscriptionStop";
    public static final String DESCRIPTION = "description";
    public static final String ID = "id";
    public static final String SUBSCRIPTIONS = "subscriptions";
    public static final String USER_SERVICE = "userService";
    public static final String PURCHASE_SERVICE = "purchaseService";

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
    public static final String USER_CREATION_EXCEPTION = "User CREATING failed";
    public static final String USER_EDIT_EXCEPTION = "User editing failed";
    public static final String SUBSCRIPTION_CREATION_EXCEPTION = "Subscription CREATING failed";
    public static final String SUBSCRIPTION_SEARCH_EXCEPTION = "Subscription is not present by id: ";
    public static final String SUBSCRIPTION_EDIT_EXCEPTION = "Subscription editing failed";
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
    * Typed query
    */
    public static final String READ_USERS_QUERY = "SELECT u FROM User u";
    public static final String GET_USER_BY_LOGIN_QUERY = "SELECT u FROM User u WHERE u.login = :login";
    public static final String READ_SUBSCRIPTIONS_QUERY = "SELECT s FROM Subscription s";
    public static final String GET_SUBSCRIPTIONS_BY_CATEGORY_QUERY = "SELECT s FROM Subscription s WHERE s.subscriptionCategory = :category";


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
    public static final String PERSISTENCE_UNIT_NAME = "Fitness-centre-Persistence";
}
