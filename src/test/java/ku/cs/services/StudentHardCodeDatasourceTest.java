package ku.cs.services;

import ku.cs.models.StudentList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StudentHardCodeDatasourceTest {

    @Test
    @DisplayName("ทดสอบการโหลดข้อมูลจาก HardCodeDatasource")
    void testReadData() {
        StudentHardCodeDatasource datasource = new StudentHardCodeDatasource();
        StudentList studentList = datasource.readData();

        // ตรวจสอบขนาดของ list ว่ามี 4 Student
        assertEquals(4, studentList.getStudents().size());

        // ตรวจสอบข้อมูลของ Student ตัวแรก
        assertEquals("6710400001", studentList.getStudents().get(0).getId());
        assertEquals("First", studentList.getStudents().get(0).getName());


        assertEquals("6710400002", studentList.getStudents().get(1).getId());
        assertEquals("Second", studentList.getStudents().get(1).getName());


        assertEquals("6710400003", studentList.getStudents().get(2).getId());
        assertEquals("Third", studentList.getStudents().get(2).getName());


        assertEquals("6710400004", studentList.getStudents().get(3).getId());
        assertEquals("Fourth", studentList.getStudents().get(3).getName());
    }
}
