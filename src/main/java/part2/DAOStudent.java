package part2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAOStudent {

    // 1 - Query
    public List<Student> list() {
        //Prepare list that will return students after consulting the database.
        List<Student> students = new ArrayList<>();

        try (Connection conn = ConnectionFactory.getConnection()) {
            //Prepare SQL query.
            String sql = "SELECT * FROM student";

            //Prepare statement with received parameters (in this function there are no parameters, as it will return all the values in the student table).
            PreparedStatement stmt = conn.prepareStatement(sql);

            //Executes the query and stores the query's return in the "rs" object.
            ResultSet rs = stmt.executeQuery();

            //Create a student object and save it to the student list.
            while(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String state = rs.getString("state");

                students.add(new Student(
                        id,
                        name,
                        age,
                        state
                ));
            }
        } catch (SQLException e) {
            System.out.println("List of students FAILED!");
            e.printStackTrace();
        }

        //Return all students found in the database.
        return students;
    }

    // 1.1 - Query with filter
    public Student getById(int id) {
        //Prepare student object to receive values from the database.
        Student student = new Student();

        try (Connection conn = ConnectionFactory.getConnection()) {
            //Prepare SQL query.
            String sql = "SELECT * FROM student WHERE id = ?";

            //Prepare statement with received parameters.
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);

            //Executes the query and stores the query's return in the "rs" object.
            ResultSet rs = stmt.executeQuery();

            //Save values returned from the student table in the student object.
            if (rs.next()){
                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setAge(rs.getInt("age"));
                student.setState(rs.getString("state"));
            }

        } catch (SQLException e) {
            System.out.println("List of students FAILED!");
            e.printStackTrace();
        }

        //Returns student found in the database.
        return student;
    }

    // 2 - Insertion
    public static void create(Student student) {
        try (Connection conn = ConnectionFactory.getConnection()) {

            //Prepare SQL for entering student data.
            String sql = "INSERT INTO student(name, age, state) VALUES(?, ?, ?)";

            //Prepare statement with received parameters.
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1 , student.getName());
            stmt.setInt(2, student.getAge());
            stmt.setString(3 , student.getState());

            //Performs insertion and stores the number of lines affected.
            int rowsAffected = stmt.executeUpdate();

            System.out.println("SUCCESSFUL insertion ! " + rowsAffected + " added row");
        } catch (SQLException e) {
            System.out.println("Insert FAILED!");
            e.printStackTrace();
        }
    }

    // 3 - Delete
    public static void delete(int id) {
        try (Connection conn = ConnectionFactory.getConnection()) {

            //PPrepare SQL to delete a row.
            String sql = "DELETE FROM student WHERE id = ?";

            //Prepare statement with received parameters.
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1 , id);

            //Performs delete and stores the number of lines affected
            int rowsAffected = stmt.executeUpdate();

            System.out.println("Delete SUCCESSFUL! It was " + rowsAffected + " deleted row");
        } catch (SQLException e) {
            System.out.println("Delete FAILED!");
            e.printStackTrace();
        }
    }

    // 4 - Update
    public void update(Student student) {
        try (Connection conn = ConnectionFactory.getConnection()) {

            //Prepare SQL to update rows.
            String sql = "UPDATE student SET name = ?, age = ?, state = ? WHERE id = ?";

            //Prepare statement with received parameters
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, student.getName());
            stmt.setInt(2, student.getAge());
            stmt.setString(3, student.getState());
            stmt.setInt(4, student.getId());

            //Performs update and stores the number of rows affected:
            int rowsAffected = stmt.executeUpdate();

            System.out.println("Successful update! It has been : " + rowsAffected + " updated row");
        } catch (SQLException e) {
            System.out.println("Update FAILED!");
            e.printStackTrace();
        }
    }
}
