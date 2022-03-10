package IAS.training.TrainingIAS.infrastructure.gateways;

import IAS.training.TrainingIAS.core.domain.MaintenanceService;
import IAS.training.TrainingIAS.core.domain.MaintenanceServiceId;
import IAS.training.TrainingIAS.core.gateways.MaintenanceServiceRepository;
import IAS.training.TrainingIAS.infrastructure.gateways.models.MaintenanceServiceDBO;
import IAS.training.TrainingIAS.shared.domain.PageQuery;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class SqlProductsRepository implements MaintenanceServiceRepository {
    private final DataSource dataSource;

    public SqlProductsRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<MaintenanceService> query(PageQuery pageQuery) {
        String sql = " SELECT * FROM maintenance_service LIMIT ? OFFSET ?";
        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)){

            preparedStatement.setInt( 1, pageQuery.getLimit().getValue());
            preparedStatement.setInt( 2, pageQuery.getSkip().getValue());


            ResultSet resultSet = preparedStatement.executeQuery();
            List<MaintenanceService> result = new ArrayList<>();

            while(resultSet.next()){
                MaintenanceServiceDBO dbo = new MaintenanceServiceDBO();
                dbo.setId(resultSet.getString("maintenance_service_id"));
                dbo.setStartDate(resultSet.getString("maintenance_service_start_date"));
                dbo.setFinalDate(resultSet.getString("maintenance_service_final_date"));
                dbo.setDescription(resultSet.getString("maintenance_service_description"));
                MaintenanceService domainMaintenceService = dbo.toDomain();
                result.add(domainMaintenceService);
            }

            resultSet.close();

            return result;
        } catch (SQLException exception) {
            throw new RuntimeException("Error querying database", exception);
        }
    }

    @Override
    public Optional<MaintenanceService> get(MaintenanceServiceId maintenanceServiceId) {
        return Optional.empty();
    }

    @Override
    public void store(MaintenanceService service) {

    }
}
