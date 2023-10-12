import entities.*;
import dbConfig.DatabasePostgres;
import sqlReader.SqlReader;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DatabaseQueryService {
    public static final String FIND_MAX_SALARY_WORKER_QUERY = "src/main/resources/sql/find_max_salary_worker.sql";
    public static final String FIND_MAX_PROJECT_CLIENT_QUERY = "src/main/resources/sql/find_max_projects_client.sql";
    public static final String FIND_LONGEST_PROJECT_QUERY = "src/main/resources/sql/find_longest_project.sql";
    public static final String FIND_YOUNGEST_ELDEST_WORKER_QUERY = "src/main/resources/sql/find_youngest_eldest_workers.sql";
    public static final String PRINT_PROJECT_PRICES_QUERY = "src/main/resources/sql/print_project_prices.sql";
    Connection connection;

    public DatabaseQueryService() {
        this.connection = DatabasePostgres.getInstance().getConnection();
    }

    public static void main(String[] args) {
        DatabaseQueryService databaseQueryService = new DatabaseQueryService();

        databaseQueryService.findMaxSalaryWorker().forEach(System.out::println);
        System.out.println("\n");
        databaseQueryService.findMaxProjectsClient().forEach(System.out::println);
        System.out.println("\n");
        databaseQueryService.findLongestProject().forEach(System.out::println);
        System.out.println("\n");
        databaseQueryService.findYoungestEldestWorkers().forEach(System.out::println);
        System.out.println("\n");
        databaseQueryService.findProjectPrices().forEach(System.out::println);
    }

    public List<MaxSalaryWorker> findMaxSalaryWorker() {
        List<MaxSalaryWorker> maxSalaryWorkerList = new ArrayList<>();
        try (Statement statement = connection.createStatement()) {
            String query = new SqlReader().read(FIND_MAX_SALARY_WORKER_QUERY);
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()){
                maxSalaryWorkerList.add(new MaxSalaryWorker(resultSet.getString(1),
                        resultSet.getInt(2)));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return maxSalaryWorkerList;
    }

    public List<MaxProjectCountClient> findMaxProjectsClient() {
        List<MaxProjectCountClient> maxProjectCountClientList = new ArrayList<>();
        try (Statement statement = connection.createStatement()) {
            String query = new SqlReader().read(FIND_MAX_PROJECT_CLIENT_QUERY);
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                maxProjectCountClientList.add(new MaxProjectCountClient(resultSet.getString(1),
                        resultSet.getInt(2)));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return maxProjectCountClientList;
    }

    public List<LongestProject> findLongestProject() {
        List<LongestProject> longestProjectList = new ArrayList<>();
        try (Statement statement = connection.createStatement()) {
            String query = new SqlReader().read(FIND_LONGEST_PROJECT_QUERY);
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                longestProjectList.add(new LongestProject(resultSet.getInt(1),
                        resultSet.getInt(2)));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return longestProjectList;
    }

    public List<YoungestEldestWorkers> findYoungestEldestWorkers(){
        List<YoungestEldestWorkers> youngestEldestWorkersList = new ArrayList<>();
        try(Statement statement = connection.createStatement()){
            String query = new SqlReader().read(FIND_YOUNGEST_ELDEST_WORKER_QUERY);
            ResultSet resultSet = statement.executeQuery(query);

            while(resultSet.next()) {
                youngestEldestWorkersList.add(new YoungestEldestWorkers(resultSet.getString(1),
                        resultSet.getString(2), resultSet.getString(3)));
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return youngestEldestWorkersList;
    }

    public List<ProjectPrices> findProjectPrices(){
        List<ProjectPrices> projectPricesList = new ArrayList<>();

        try (Statement statement = connection.createStatement()){
            String query = new SqlReader().read(PRINT_PROJECT_PRICES_QUERY);
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()){
                projectPricesList.add(new ProjectPrices(resultSet.getInt(1),
                        resultSet.getInt(2)));
            }
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
        return projectPricesList;
    }
}

