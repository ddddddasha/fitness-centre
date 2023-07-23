package app.servlets.fitness.util;

public class Constants {

    public static final String EMAIL_REGEX = "[A-Za-z0-9]+@[A-Za-z0-9]+\\.[A-Za-z]{2,4}";

    public static final String LOGIN_URL = "/login";
    public static final String ADMIN_READ_USERS_URL = "/admin/users";
    public static final String SUBSCRIPTIONS_URL = "/subscription";


    public static final String USER_REGISTRATION_PAGE = "/pages/user/user-registration.jsp";
    public static final String INDEX_PAGE = "/index.jsp";
    public static final String EDIT_SUBSCRIPTION_PAGE = "/pages/subscriptions/editSub.jsp";
    public static final String ALL_SUBSCRIPTIONS_PAGE = "/pages/subscriptions/subscriptions.jsp";
    public static final String EDIT_USER_PAGE = "/pages/user/editUser.jsp";
    public static final String ALL_USERS_PAGE = "/pages/admin/read-all-users.jsp";
    public static final String SIGN_IN_PAGE = "/pages/user/user-sign-in.jsp";
    public static final String CLIENT_HOME_PAGE = "/pages/client/client-home.jsp";
    public static final String FIND_SUBS_PAGE = "/pages/subscriptions/findSubs.jsp";


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
    public static final String SUBSCRIPTION_DTO_MAPPER = "subscriptionDtoMapper";
    public static final String SUBSCRIPTION_TYPE = "subscriptionType";
    public static final String SUBSCRIPTION_NAME_DB = "subscription_name";
    public static final String SUBSCRIPTION_PRICE_DB = "subscription_price";
    public static final String SUBSCRIPTION_PERIOD_DB = "subscription_period";
    public static final String NUMBER_OF_GUEST_VISITS_DB = "number_of_guest_visits";
    public static final String MAX_SUBSCRIPTION_STOP_DB = "max_subscription_stop";

    public static final String SUBSCRIPTION_MAPPER = "subscriptionMapper";

    public static final String USER_DTO_MAPPER = "userDtoMapper";
    public static final String USER_SERVICE = "userService";
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


    public static final String ERROR_MESSAGE_EMAIL_ALREADY_EXISTS = "errorMessageEmailAlreadyExists";
    public static final String EMAIL_ALREADY_EXISTS = "Пользователь с таким логином уже существует";
    public static final String ERROR_MESSAGE_EMAIL = "errorMessageEmail";
    public static final String INCORRECT_EMAIL = "Неверный формат логина (email)";
    public static final String ERROR_MESSAGE = "errorMessage";
    public static final String ERROR_LOGIN_MESSAGE = "Неверное имя пользователя или пароль";
    public static final String ERROR_USER_DELETE = "Ошибка при удалении пользователя";


    public static final String ALGORITHM_PBKDF2 = "PBKDF2WithHmacSHA256";
    public static final String SPLIT_FOR_PBKDF2 = ":";
    public static final int ZERO = 0;
    public static final int ONE = 1;
    public static final int SALT_LENGTH = 16;
    public static final int ITERATIONS = 100000;
    public static final int KEY_LENGTH = 256;


    public static final String ERROR_LOADING_THE_JDBC_DRIVER = "Ошибка при загрузке драйвера JDBC";
    public static final String CLASS_NAME_MYSQL = "com.mysql.cj.jdbc.Driver";
    public static final String URL_KEY = "db.url";
    public static final String USERNAME_KEY = "db.username";
    public static final String PASSWORD_KEY = "db.password";


    public static final String INSERT_INTO_PERSON_TABLE = "INSERT INTO person (first_name, last_name, age, login, password, role) VALUES (?,?,?,?,?,?)";
    public static final String SELECT_FROM_PERSON_TABLE = "SELECT * FROM person";
    public static final String SELECT_DATA_FROM_PERSON_BY_LOGIN = "SELECT first_name, last_name, age, password, role FROM person WHERE login=?";
    public static final String DELETE_FROM_PERSON_BY_ID = "DELETE FROM person WHERE id=?";
    public static final String SELECT_DATA_FROM_PERSON_BY_ID = "SELECT first_name, last_name, age, login, password FROM person WHERE id=?";
    public static final String UPDATE_PERSON_BY_ID = "UPDATE person SET first_name=?, last_name=?, age=?, login=? WHERE id=?";
    public static final String SELECT_COUNT_FROM_PERSON_BY_ID = "SELECT COUNT(*) FROM person WHERE id = ?";
    public static final String INSERT_INTO_SUBSCRIPTION_TABLE = "INSERT INTO subscription (subscription_category, subscription_name, subscription_price, subscription_period,\n" +
            "                                             number_of_guest_visits, max_subscription_stop, description) VALUES (?,?,?,?,?,?,?)";
    public static final String SELECT_FROM_SUBSCRIPTION = "SELECT * FROM subscription";
    public static final String SELECT_FROM_SUBSCRIPTION_BY_SUBSCRIPTION_CATEGORY = "SELECT * FROM subscription WHERE subscription_category=?";
    public static final String SELECT_DATA_FROM_SUBSCRIPTION_BY_ID = "SELECT subscription_name, subscription_price, subscription_period,\n" +
            "number_of_guest_visits, max_subscription_stop, description FROM subscription WHERE id=?";
    public static final String DELETE_FROM_SUBSCRIPTION_BY_ID = "DELETE FROM subscription WHERE id=?";
    public static final String UPDATE_SUBSCRIPTION_BY_ID = "UPDATE subscription SET subscription_name=?, subscription_price=?, subscription_period=?, number_of_guest_visits=?, max_subscription_stop=?, description=? WHERE id=?";
    public static final String SELECT_COUNT_FROM_SUBSCRIPTION_BY_ID = "SELECT COUNT(*) FROM subscription WHERE id = ?";
}
