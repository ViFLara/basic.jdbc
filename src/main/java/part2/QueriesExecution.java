package part2;

import java.util.List;

public class QueriesExecution {

    public static void main(String[] args) {

        DAOStudent daoStudent = new DAOStudent();

        // =========================== 1 - Query =================================================
        List<Student> students = daoStudent.list();

        //daoStudent.list().forEach(System.out::println);


        // ======================= 1.1 - Query with filter ========================================
        Student studentForConsultation = daoStudent.getById(1);

        //System.out.println(studentForConsultation);


        // =========================== 2 - Insert =================================================
        Student studentToInsert = new Student(
                "Matheus",
                43,
                "SP"
        );

        //DAOStudent.create(studentToInsert);


        // =========================== 3 - Delete ===================================================
        daoStudent.list().forEach(System.out::println);

        DAOStudent.delete(4);

        daoStudent.list().forEach(System.out::println);


        // =========================== 4 - Update ================================================
        //daoStudent.list().forEach(System.out::println);

        Student studentForUpdate = daoStudent.getById(3);
        studentForUpdate.setName("Joaquim");
        studentForUpdate.setAge(18);
        studentForUpdate.setState("RS");

        //DAOStudent.update(StudentForUpdate);
        //daoStudent.list().forEach(System.out::println);
    }
}
