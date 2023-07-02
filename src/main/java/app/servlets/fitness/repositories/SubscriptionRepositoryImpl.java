package app.servlets.fitness.repositories;

import app.servlets.fitness.entities.Subscription;
import app.servlets.fitness.mappers.SubscriptionMapper;
import app.servlets.fitness.util.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static app.servlets.fitness.util.Constants.*;

public class SubscriptionRepositoryImpl implements SubscriptionRepository{

    private final SubscriptionMapper mapper = new SubscriptionMapper();

    @Override
    public Subscription createSubscription(Subscription subscription) {
        try (Connection connection = ConnectionManager.open()) {
            PreparedStatement statement =
                    connection.prepareStatement(INSERT_INTO_SUBSCRIPTION_TABLE);
            statement.setString(1, subscription.getId());
            statement.setString(2, subscription.getSubscriptionCategory());
            statement.setString(3, subscription.getSubscriptionName());
            statement.setLong(4, subscription.getSubscriptionPrice());
            statement.setLong(5, subscription.getSubscriptionPeriod());
            statement.setLong(6, subscription.getMaxSubscriptionStop());
            statement.setInt(7, subscription.getNumberOfGuestVisits());
            statement.setString(8, subscription.getDescription());
            statement.execute();
            return subscription;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Subscription> readSubscriptions() {
        List<Subscription> subscriptions = new ArrayList<>();
        try (Connection connection = ConnectionManager.open()) {
            PreparedStatement statement = connection.prepareStatement(SELECT_FROM_SUBSCRIPTION);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String id = resultSet.getString(ID);
                String subscriptionName = resultSet.getString(SUBSCRIPTION_NAME_DB);
                int subscriptionPrice = Integer.parseInt(resultSet.getString(SUBSCRIPTION_PRICE_DB));
                int subscriptionPeriod = resultSet.getInt(SUBSCRIPTION_PERIOD_DB);
                int numberOfGuestVisits = resultSet.getInt(NUMBER_OF_GUEST_VISITS_DB);
                int maxSubscriptionStop = resultSet.getInt(MAX_SUBSCRIPTION_STOP_DB);
                String description = resultSet.getString(DESCRIPTION);
                Subscription subscription = mapper.buildSubscription(id, subscriptionName, subscriptionPrice, subscriptionPeriod,
                        numberOfGuestVisits, maxSubscriptionStop, description);
                subscriptions.add(subscription);
            }
            return subscriptions;
        } catch (SQLException e) {

            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Subscription> findBySubscriptionCategory(String subscriptionCategory) {
        List<Subscription> subscriptions = new ArrayList<>();
        try (Connection connection = ConnectionManager.open()) {
            PreparedStatement statement = connection.prepareStatement(SELECT_FROM_SUBSCRIPTION_BY_SUBSCRIPTION_CATEGORY);
            statement.setString(1, subscriptionCategory);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String subscriptionName = resultSet.getString(SUBSCRIPTION_NAME_DB);
                int subscriptionPrice = Integer.parseInt(resultSet.getString(SUBSCRIPTION_PRICE_DB));
                int subscriptionPeriod = resultSet.getInt(SUBSCRIPTION_PERIOD_DB);
                int numberOfGuestVisits = resultSet.getInt(NUMBER_OF_GUEST_VISITS_DB);
                int maxSubscriptionStop = resultSet.getInt(MAX_SUBSCRIPTION_STOP_DB);
                String description = resultSet.getString(DESCRIPTION);
                Subscription subscription = mapper.buildSubscriptionForSearch(subscriptionCategory, subscriptionName, subscriptionPrice, subscriptionPeriod,
                        numberOfGuestVisits, maxSubscriptionStop, description);
                subscriptions.add(subscription);
            }
            return subscriptions;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Subscription getById(String id) {
        try (Connection connection = ConnectionManager.open()) {
            PreparedStatement statement = connection.prepareStatement(SELECT_DATA_FROM_SUBSCRIPTION_BY_ID);
            statement.setString(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String subscriptionName = resultSet.getString(SUBSCRIPTION_NAME_DB);
                int subscriptionPrice = resultSet.getInt(SUBSCRIPTION_PRICE_DB);
                int subscriptionPeriod = resultSet.getInt(SUBSCRIPTION_PERIOD_DB);
                int numberOfGuestVisits = resultSet.getInt(NUMBER_OF_GUEST_VISITS_DB);
                int maxSubscriptionStop = resultSet.getInt(MAX_SUBSCRIPTION_STOP_DB);
                String description = resultSet.getString(DESCRIPTION);
                return mapper.buildSubscription(id, subscriptionName, subscriptionPrice, subscriptionPeriod,
                        numberOfGuestVisits, maxSubscriptionStop, description);

            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return null;
    }

    @Override
    public boolean deleteById(String id) {
        try (Connection connection = ConnectionManager.open()) {
            PreparedStatement statement = connection.prepareStatement(DELETE_FROM_SUBSCRIPTION_BY_ID);
            statement.setString(1, id);
            return statement.execute();
        } catch (SQLException e) {

            throw new RuntimeException(e.getMessage());

        }
    }

    public Subscription updateSubscription(Subscription subscription) {
        try (Connection connection = ConnectionManager.open()) {
            PreparedStatement statement = connection.prepareStatement(UPDATE_SUBSCRIPTION_BY_ID);
            statement.setString(1, subscription.getSubscriptionName());
            statement.setInt(2, subscription.getSubscriptionPrice());
            statement.setInt(3, subscription.getSubscriptionPeriod());
            statement.setInt(4, subscription.getNumberOfGuestVisits());
            statement.setInt(5, subscription.getMaxSubscriptionStop());
            statement.setString(6, subscription.getDescription());
            statement.setString(7, subscription.getId());
            statement.executeUpdate();
            return subscription;
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    @Override
    public boolean isIdExistsInDatabase(String id) {
        try (Connection connection = ConnectionManager.open()) {
            PreparedStatement statement = connection.prepareStatement(SELECT_COUNT_FROM_SUBSCRIPTION_BY_ID);
            statement.setString(1, id);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            int count = resultSet.getInt(1);
            return count > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
