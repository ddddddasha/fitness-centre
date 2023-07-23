package app.servlets.fitness.repositories;

import app.servlets.fitness.entities.Subscription;
import app.servlets.fitness.entities.enums.SubscriptionCategory;
import app.servlets.fitness.mappers.SubscriptionMapper;
import app.servlets.fitness.util.ConnectionManager;
import lombok.Builder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static app.servlets.fitness.util.Constants.*;

@Builder
public class SubscriptionRepositoryImpl implements SubscriptionRepository{

    private final SubscriptionMapper subscriptionMapper;

    @Override
    public Subscription createSubscription(Subscription subscription) {
        try (Connection connection = ConnectionManager.open()) {
            PreparedStatement statement =
                    connection.prepareStatement(INSERT_INTO_SUBSCRIPTION_TABLE);
            statement.setString(1, subscription.getSubscriptionCategory().getName());
            statement.setString(2, subscription.getSubscriptionName());
            statement.setLong(3, subscription.getSubscriptionPrice());
            statement.setLong(4, subscription.getSubscriptionDaysNumber());
            statement.setLong(5, subscription.getNumberSubscriptionStopDays());
            statement.setInt(6, subscription.getNumberGuestVisitDays());
            statement.setString(7, subscription.getDescription());
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return subscription;
    }

    @Override
    public List<Subscription> readSubscriptions() {
        List<Subscription> subscriptions = new ArrayList<>();
        try (Connection connection = ConnectionManager.open()) {
            PreparedStatement statement = connection.prepareStatement(SELECT_FROM_SUBSCRIPTION);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                long id = resultSet.getLong(ID);
                String subscriptionName = resultSet.getString(SUBSCRIPTION_NAME_DB);
                int subscriptionPrice = Integer.parseInt(resultSet.getString(SUBSCRIPTION_PRICE_DB));
                int subscriptionPeriod = resultSet.getInt(SUBSCRIPTION_PERIOD_DB);
                int numberGuestVisitDays = resultSet.getInt(NUMBER_OF_GUEST_VISITS_DB);
                int numberSubscriptionStopDays = resultSet.getInt(MAX_SUBSCRIPTION_STOP_DB);
                String description = resultSet.getString(DESCRIPTION);
                Subscription subscription = subscriptionMapper.buildSubscription(id, subscriptionName, subscriptionPrice, subscriptionPeriod,
                        numberGuestVisitDays, numberSubscriptionStopDays, description);
                subscriptions.add(subscription);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return subscriptions;
    }

    @Override
    public List<Subscription> findBySubscriptionCategory(SubscriptionCategory subscriptionCategory) {
        List<Subscription> subscriptions = new ArrayList<>();
        try (Connection connection = ConnectionManager.open()) {
            PreparedStatement statement = connection.prepareStatement(SELECT_FROM_SUBSCRIPTION_BY_SUBSCRIPTION_CATEGORY);
            statement.setString(1, String.valueOf(subscriptionCategory));
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String subscriptionName = resultSet.getString(SUBSCRIPTION_NAME_DB);
                int subscriptionPrice = Integer.parseInt(resultSet.getString(SUBSCRIPTION_PRICE_DB));
                int subscriptionPeriod = resultSet.getInt(SUBSCRIPTION_PERIOD_DB);
                int numberGuestVisitDays = resultSet.getInt(NUMBER_OF_GUEST_VISITS_DB);
                int numberSubscriptionStopDays = resultSet.getInt(MAX_SUBSCRIPTION_STOP_DB);
                String description = resultSet.getString(DESCRIPTION);
                Subscription subscription = subscriptionMapper.buildSubscriptionForSearch(subscriptionCategory, subscriptionName, subscriptionPrice, subscriptionPeriod,
                        numberGuestVisitDays, numberSubscriptionStopDays, description);
                subscriptions.add(subscription);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return subscriptions;
    }

    @Override
    public Subscription getById(long id) {
        try (Connection connection = ConnectionManager.open()) {
            PreparedStatement statement = connection.prepareStatement(SELECT_DATA_FROM_SUBSCRIPTION_BY_ID);
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String subscriptionName = resultSet.getString(SUBSCRIPTION_NAME_DB);
                int subscriptionPrice = resultSet.getInt(SUBSCRIPTION_PRICE_DB);
                int subscriptionPeriod = resultSet.getInt(SUBSCRIPTION_PERIOD_DB);
                int numberGuestVisitDays = resultSet.getInt(NUMBER_OF_GUEST_VISITS_DB);
                int numberSubscriptionStopDays = resultSet.getInt(MAX_SUBSCRIPTION_STOP_DB);
                String description = resultSet.getString(DESCRIPTION);
                return subscriptionMapper.buildSubscription(id, subscriptionName, subscriptionPrice, subscriptionPeriod,
                        numberGuestVisitDays, numberSubscriptionStopDays, description);

            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return null;
    }

    @Override
    public boolean deleteById(long id) {
        try (Connection connection = ConnectionManager.open()) {
            PreparedStatement statement = connection.prepareStatement(DELETE_FROM_SUBSCRIPTION_BY_ID);
            statement.setLong(1, id);
            return statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public Subscription updateSubscription(Subscription subscription) {
        try (Connection connection = ConnectionManager.open()) {
            PreparedStatement statement = connection.prepareStatement(UPDATE_SUBSCRIPTION_BY_ID);
            statement.setString(1, subscription.getSubscriptionName());
            statement.setInt(2, subscription.getSubscriptionPrice());
            statement.setInt(3, subscription.getSubscriptionDaysNumber());
            statement.setInt(4, subscription.getNumberGuestVisitDays());
            statement.setInt(5, subscription.getNumberSubscriptionStopDays());
            statement.setString(6, subscription.getDescription());
            statement.setLong(7, subscription.getId());
            statement.executeUpdate();
            return subscription;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return subscription;
    }

    public SubscriptionCategory determineSubscriptionCategory(String category) {
        for (SubscriptionCategory subscriptionCategory : SubscriptionCategory.values()) {
            if (subscriptionCategory.getName().equals(category)) {
                return subscriptionCategory;
            }
        }
        return null;
    }
}
