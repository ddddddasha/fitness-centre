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


    /**
     * errors
     */
    public static final String ERROR_MESSAGE_EMAIL_ALREADY_EXISTS = "errorMessageEmailAlreadyExists";
    public static final String EMAIL_ALREADY_EXISTS = "Пользователь с таким логином уже существует";
    public static final String ERROR_MESSAGE_EMAIL = "errorMessageEmail";
    public static final String INCORRECT_EMAIL = "Неверный формат логина (email)";

    public static final String ERROR_MESSAGE = "errorMessage";
    public static final String ERROR_LOGIN_MESSAGE = "Неверное имя пользователя или пароль";
    public static final String USER_DELETE_EXCEPTION = "The user has not been deleted";
    public static final String USER_SEARCH_EXCEPTION = "The user not found";
    public static final String USER_EDIT_EXCEPTION = "User editing failed";
    public static final String SUBSCRIPTION_DELETE_EXCEPTION = "Subscription not deleted";
    public static final String SUBSCRIPTION_SEARCH_EXCEPTION = "The subscription not found";
    public static final String SUBSCRIPTION_EDIT_EXCEPTION = "Subscription editing failed";

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
     *
     */
    public static final String ERROR_LOADING_THE_JDBC_DRIVER = "Ошибка при загрузке драйвера JDBC";
    public static final String CLASS_NAME_MYSQL = "com.mysql.cj.jdbc.Driver";
    public static final String URL_KEY = "db.url";
    public static final String USERNAME_KEY = "db.username";
    public static final String PASSWORD_KEY = "db.password";

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
    public final static String DATE_BIRTHDAY_DB = "date_birthday";
    public final static String SUBSCRIPTION_CATEGORY_DB = "subscription_category";
    public final static String SUBSCRIPTION_NAME_DB = "subscription_name";
    public final static String SUBSCRIPTION_PRICE_DB = "subscription_price";
    public final static String SUBSCRIPTION_DAYS_NUMBER_DB = "subscription_days_number";
    public final static String NUMBER_GUEST_VISIT_DAYS_DB = "number_guest_visit_days";
    public final static String NUMBER_SUBSCRIPTION_STOP_DAYS_DB = "number_subscription_stop_days";
    public static final String CATEGORY_COLUMN = "category";
    public static final String FIRST_NAME = "firstName";
    public static final String LAST_NAME = "lastName";
    public static final String AGE = "age";
    public static final String LOGIN = "login";
    public static final String PASSWORD = "password";
    public static final String USER = "user";
    public static final String ROLE = "role";
    public static final String USERS = "users";
    public static final String FIRST_NAME_DB = "first_name";
    public static final String LAST_NAME_DB = "last_name";

    public static final String PERSISTENCE_UNIT_NAME = "Fitness-centre-Persistence";
}
