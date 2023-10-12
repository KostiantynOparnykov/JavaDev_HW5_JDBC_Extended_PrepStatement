import dbConfig.DatabasePostgres;
import entities.Client;
import entities.Project;
import entities.ProjectWorker;
import entities.Worker;

import java.sql.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.*;

public class DatabasePopulateService {
    //public static final String SQL_FILE = "src/resources/sql/populate_db.sql";
    public static final String SQL_POPULATE_WORKER = "INSERT INTO worker (name, birthday, level, salary) " +
            "VALUES(?,?,?,?)";
    public static final String SQL_POPULATE_CLIENT = "INSERT INTO client (name) " +
            "VALUES(?)";
    public static final String SQL_POPULATE_PROJECT = "INSERT INTO project (client_id, start_date, finish_date) " +
            "VALUES(?,?,?)";
    public static final String SQL_POPULATE_PROJECT_WORKER = "INSERT INTO project_worker (project_id, worker_id)" +
            "VALUES (?,?)";

    public static void main(String[] args) {
        Connection connection = DatabasePostgres.getInstance().getConnection();
        DatabasePopulateService databasePopulateService = new DatabasePopulateService();

        databasePopulateService.populateWorker(connection);
        databasePopulateService.populateClient(connection);
        databasePopulateService.populateProject(connection);
        databasePopulateService.populateProjectWorker(connection);
    }
    public void populateWorker(Connection connection){
        List<Worker> workers = new ArrayList<>();
        workers.add(new Worker
                ("Tim Cook", LocalDate.of(1960,11,1),"Senior", 99998));
        workers.add(new Worker
                ("Jen Barber", LocalDate.of(1978,1,1),"Middle", 20500));
        workers.add(new Worker
                ("David Tennant", LocalDate.of(1971,4,17),"Senior", 50000));
        workers.add(new Worker
                ("Maurice Moss", LocalDate.of(1977,5,23),"Middle", 15000));
        workers.add(new Worker
                ("J. Fry", LocalDate.of(1999,3,28),"Trainee", 750));
        workers.add(new Worker
                ("Stanley Tweedle", LocalDate.of(1997,4,18),"Junior", 1500));
        workers.add(new Worker
                ("Matthew Smith", LocalDate.of(1982,10,28),"Junior", 1250));
        workers.add(new Worker
                ("Richmond Avenal", LocalDate.of(1973,5,21),"Junior", 1300));
        workers.add(new Worker
                ("Roy Trenneman", LocalDate.of(1979,10,9),"Middle", 18000));
        workers.add(new Worker
                ("Homer Simpson", LocalDate.of(1987,4,19),"Trainee", 800));
        workers.add(new Worker
                ("Fake Cook", LocalDate.of(1960,11,1),"Senior", 99998));

        try {
            PreparedStatement ps = connection.prepareStatement(SQL_POPULATE_WORKER);
            for (Worker worker : workers) {
                ps.setString(1, worker.getName());
                ps.setDate(2, Date.valueOf(worker.getBirthday()));
                ps.setString(3, worker.getLevel());
                ps.setInt(4, worker.getSalary());
                ps.addBatch();
            }
            ps.executeBatch();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void populateClient (Connection connection){
        List<Client> clients = new ArrayList<>();
        clients.add(new Client("Bender Rodriguez"));
        clients.add(new Client("Peter Capaldi"));
        clients.add(new Client("Whittaker"));
        clients.add(new Client("J. Farnsworth"));
        clients.add(new Client("Turanga Leela"));

        try {
            PreparedStatement ps = connection.prepareStatement(SQL_POPULATE_CLIENT);
            for(Client client: clients){
                ps.setString(1, client.getName());
                ps.addBatch();
            }
            ps.executeBatch();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void populateProject(Connection connection){
        List<Project> projects = new ArrayList<>();
        projects.add(new Project(1,
                LocalDate.of(1999,3,28),
                LocalDate.of(1999,11,14)));
        projects.add(new Project(1,
                LocalDate.of(2001,12,1),
                LocalDate.of(2002,12,8)));
        projects.add(new Project(1,
                LocalDate.of(2008,3,23),
                LocalDate.of(2009,8,30)));
        projects.add(new Project(2,
                LocalDate.of(2008,11,21),
                LocalDate.of(2016,5,14)));
        projects.add(new Project(3,
                LocalDate.of(2009,4,8),
                LocalDate.of(2012,6,19)));
        projects.add(new Project(3,
                LocalDate.of(2010,7,1),
                LocalDate.of(2015,11,26)));
        projects.add(new Project(4,
                LocalDate.of(2010,6,24),
                LocalDate.of(2013,9,4)));
        projects.add(new Project(5,
                LocalDate.of(2013,2,1),
                LocalDate.of(2014,2,20)));
        projects.add(new Project(5,
                LocalDate.of(2020,3,15),
                LocalDate.of(2021,9,4)));
        projects.add(new Project(5,
                LocalDate.of(2023,6,24),
                LocalDate.of(2023,9,25)));

        try {
            PreparedStatement ps = connection.prepareStatement(SQL_POPULATE_PROJECT);
            for(Project project: projects){
                ps.setInt(1, project.getClientId());
                ps.setDate(2, Date.valueOf(project.getStartDate()));
                ps.setDate(3, Date.valueOf(project.getEndDate()));
                ps.addBatch();
            }
            ps.executeBatch();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public void populateProjectWorker(Connection connection){
        List<ProjectWorker> projectWorkers = new ArrayList<>();
        projectWorkers.add(new ProjectWorker(1,1));
        projectWorkers.add(new ProjectWorker(1,6));
        projectWorkers.add(new ProjectWorker(2,1));
        projectWorkers.add(new ProjectWorker(3,2));
        projectWorkers.add(new ProjectWorker(3,3));
        projectWorkers.add(new ProjectWorker(4,3));
        projectWorkers.add(new ProjectWorker(4,4));
        projectWorkers.add(new ProjectWorker(4,8));
        projectWorkers.add(new ProjectWorker(4,10));
        projectWorkers.add(new ProjectWorker(4,9));
        projectWorkers.add(new ProjectWorker(5,3));
        projectWorkers.add(new ProjectWorker(5,1));
        projectWorkers.add(new ProjectWorker(5,2));
        projectWorkers.add(new ProjectWorker(6,1));
        projectWorkers.add(new ProjectWorker(7,3));
        projectWorkers.add(new ProjectWorker(7,8));
        projectWorkers.add(new ProjectWorker(8,7));
        projectWorkers.add(new ProjectWorker(9,3));
        projectWorkers.add(new ProjectWorker(10,6));
        projectWorkers.add(new ProjectWorker(10,5));

        try {
            PreparedStatement ps = connection.prepareStatement(SQL_POPULATE_PROJECT_WORKER);
            for(ProjectWorker projectWorker: projectWorkers){
                ps.setInt(1, projectWorker.getProjectId());
                ps.setInt(2, projectWorker.getWorkerId());
                ps.addBatch();
            }
            ps.executeBatch();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
