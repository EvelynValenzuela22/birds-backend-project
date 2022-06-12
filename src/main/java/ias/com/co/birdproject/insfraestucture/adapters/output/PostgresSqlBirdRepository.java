package ias.com.co.birdproject.insfraestucture.adapters.output;


import ias.com.co.birdproject.bird.application.domain.Bird;
import ias.com.co.birdproject.bird.application.domain.valueObjs.BirdCommonName;
import ias.com.co.birdproject.bird.application.domain.valueObjs.BirdScientificName;
import ias.com.co.birdproject.bird.application.domain.valueObjs.BirdZoneName;
import ias.com.co.birdproject.bird.application.ports.output.BirdRepository;
import ias.com.co.birdproject.bird.application.domain.valueObjs.BirdId;
import ias.com.co.birdproject.insfraestucture.models.BirdDAO;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

@Repository
public class PostgresSqlBirdRepository implements BirdRepository {
    private final DataSource dataSource;

    public PostgresSqlBirdRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void store(Bird bird) {
        String sql = "INSERT INTO tbl_birds (common_name, scientific_name, zone_name, confirmed_quantity) values (?, ?, ?,?)";

        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, bird.getCommonName().getValue());
            preparedStatement.setString(2, bird.getScientificName().getValue());
            preparedStatement.setString(3, bird.getZoneName().getValue());
            preparedStatement.setInt(4, bird.getConfirmedQuantity().getValue());

            preparedStatement.execute();

        } catch (SQLException exception) {
            System.out.println("Errror DB....: "  + exception.getMessage());
            throw new RuntimeException("Error queryng database", exception);
        }

    }

    @Override
    public void update(Bird bird) {
        String sql = "UPDATE tbl_birds SET common_name = ?, scientific_name = ?, zone_name = ?, confirmed_quantity = ? WHERE id = ?";

        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, bird.getCommonName().getValue());
            preparedStatement.setString(2, bird.getScientificName().getValue());
            preparedStatement.setString(3, bird.getZoneName().getValue());
            preparedStatement.setInt(4, bird.getConfirmedQuantity().getValue());
            preparedStatement.setLong(5, bird.getId().getValue());

            preparedStatement.execute();

        } catch (SQLException exception) {
            System.out.println("Errror DB....: "  + exception.getMessage());
            throw new RuntimeException("Error queryng database", exception);
        }

    }

    @Override
    public Optional<Bird> get(BirdId birdId) {
        String sql = "SELECT* FROM tbl_birds WHERE id = ?";

        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setLong(1, birdId.getValue());

            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()) {
                BirdDAO birdDAO = BirdDAO.fromResultSet(resultSet);
                Bird bird = birdDAO.toDomain();
                return Optional.of(bird);
            } else {
                return Optional.empty();
            }

        } catch (SQLException exception) {
            System.out.println("Errror DB....: "  + exception.getMessage());
            throw new RuntimeException("Error queryng database", exception);
        }

    }

    @Override
    public Boolean delete(BirdId birdId) {
        String sql = "DELETE FROM tbl_birds WHERE id = ?";

        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setLong(1, birdId.getValue());

           return  preparedStatement.execute();

        } catch (SQLException exception) {
            System.out.println("Errror DB....: "  + exception.getMessage());
            throw new RuntimeException("Error queryng database", exception);
        }
    }

    @Override
    public Optional<Bird> getCommonName(BirdCommonName birdCommonName) {
        String sql = "SELECT* FROM tbl_birds WHERE common_name = ?";
        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1,birdCommonName.getValue());
            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()) {
                BirdDAO birdDAO = BirdDAO.fromResultSet(resultSet);
                Bird bird = birdDAO.toDomain();
                return Optional.of(bird);
            } else {
                return Optional.empty();
            }

        } catch (SQLException exception) {
            System.out.println("Errror DB....: "  + exception.getMessage());
            throw new RuntimeException("Error queryng database", exception);
        }
    }

    @Override
    public Optional<Bird> getScientificName(BirdScientificName birdScientificName) {
        String sql = "SELECT* FROM tbl_birds WHERE scientific_name = ?";
        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1,birdScientificName.getValue());
            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()) {
                BirdDAO birdDAO = BirdDAO.fromResultSet(resultSet);
                Bird bird = birdDAO.toDomain();
                return Optional.of(bird);
            } else {
                return Optional.empty();
            }

        } catch (SQLException exception) {
            System.out.println("Errror DB....: "  + exception.getMessage());
            throw new RuntimeException("Error queryng database", exception);
        }
    }

    @Override
    public Optional<Bird> getZoneName(BirdZoneName birdZoneName) {
        String sql = "SELECT* FROM tbl_birds WHERE zone_name = ?";
        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1,birdZoneName.getValue());
            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()) {
                BirdDAO birdDAO = BirdDAO.fromResultSet(resultSet);
                Bird bird = birdDAO.toDomain();
                return Optional.of(bird);
            } else {
                return Optional.empty();
            }

        } catch (SQLException exception) {
            System.out.println("Errror DB....: "  + exception.getMessage());
            throw new RuntimeException("Error queryng database", exception);
        }
    }

}
