import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class CarsDBRepository implements CarRepository{

    private JdbcUtils dbUtils;



    private static final Logger logger= LogManager.getLogger();

    public CarsDBRepository(Properties props) {
        logger.info("Initializing CarsDBRepository with properties: {} ",props);
        dbUtils=new JdbcUtils(props);
    }

    @Override
    public List<Car> findByManufacturer(String manufacturerN) {
        Connection con=dbUtils.getConnection();
        List<Car> cars=new ArrayList<>();
        try(PreparedStatement preStmt=con.prepareStatement("select * from masini where manufacturer=?")) {
            preStmt.setString(1, manufacturerN);
            try (ResultSet result = preStmt.executeQuery()) {
                while (result.next()) {
                    Integer id = result.getInt("id");
                    String manufacturer = result.getString("manufacturer");
                    String model = result.getString("model");
                    Integer year = result.getInt("year");
                }
            }
        }catch (SQLException ex) {
                logger.error(ex);
                System.out.println("Error DB " + ex);
        }
        return cars;
    }

    @Override
    public List<Car> findBetweenYears(int min, int max) {
	//to do
        return null;
    }

    @Override
    public void add(Car elem) {
        logger.traceEntry("saving task {}", elem);
        Connection con=dbUtils.getConnection();
        try(PreparedStatement preStmt=con.prepareStatement("insert into masini (manufacturer,model,year) values (?,?,?)")) {
            preStmt.setString(1, elem.getManufacturer());
            preStmt.setString(2, elem.getModel());
            preStmt.setInt(3, elem.getYear());
            int result = preStmt.executeUpdate();
            logger.trace("Saved {} instances", result);
        }catch(SQLException ex){
            logger.error(ex);
            System.out.println("Error DB "+ex);
        }
        logger.traceExit();
    }

    @Override
    public void update(Integer integer, Car elem) {
      //to do
    }

    @Override
    public Iterable<Car> findAll() {
        logger.traceEntry();
        Connection con = dbUtils.getConnection();
        List<Car> cars = new ArrayList<>();
        try (PreparedStatement preStmt = con.prepareStatement("select * from masini")) {
            try (ResultSet result = preStmt.executeQuery()) {
                while (result.next()) {
                    Integer id = result.getInt("id");
                    String manufacturer = result.getString("manufacturer");
                    String model = result.getString("model");
                    Integer year = result.getInt("year");
                }
            }
        } catch (SQLException ex) {
                logger.error(ex);
                System.out.println("Error DB " + ex);
        }
        logger.traceExit(cars);
        return cars;

    }
}
