import org.junit.BeforeClass;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.Assert.assertEquals;

public class AdminFunctionTest {
    private static Admin adminTest ;

    @BeforeClass
    public static void suiteSetup() {
        adminTest = new Admin(0, 20000, "Administrator");
    }

    @Test
    public void testCreateUser(){
        User user = adminTest.createUser("pelle1", "pelle123", 0, 23000,"programmer");
        assertEquals("Failed to create user", 1, adminTest.getArrayUsers().size());
        adminTest.deleteUser(user.getUsername());
    }

    @Test
    public void testDeleteUser(){
        adminTest.createUser("kalle1", "kalle1234", 0, 4000,"tester");
        adminTest.deleteUser("kalle1");
        assertEquals("Failed to delete user", 0, adminTest.getArrayUsers().size());
    }

    @Test
    public void testPrintUserNameCorrectInput(){
        String username = "kalle1";
        adminTest.createUser("kalle1", "kalle1234", 0, 4000,"tester");
        assertEquals("Failed to print user name", "kalle1", adminTest.printUserName(username));
        adminTest.deleteUser(username);
    }

    @Test
    public void printSalaryRequirementGetAnswerYes(){
        User userTest3 = adminTest.createUser("ulf", "ulf1234", 0, 25000, "Engineer");
        userTest3.setRequestedSalary(30000);
        int newSalary = userTest3.getRequestedSalary();

        //get yes
        String input = "y";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertEquals("Failed to approve new salary request - wrong input","y", adminTest.printSalaryRequirementGetAnswer(userTest3, newSalary));
        adminTest.deleteUser(userTest3.getUsername());
    }

    @Test
    public void printSalaryRequirementGetAnswerNo(){
        User userTest3 = adminTest.createUser("ulf", "ulf1234", 0, 25000, "Engineer");
        userTest3.setRequestedSalary(50000);
        int newSalary = userTest3.getRequestedSalary();

        //get no
        String input = "n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertEquals("Failed to dismiss new salary request - wrong input","n", adminTest.printSalaryRequirementGetAnswer(userTest3, newSalary));
        adminTest.deleteUser(userTest3.getUsername());
    }

    @Test
    public void printRoleRequirementGetAnswerYes(){
        User userTest3 = adminTest.createUser("ulf", "ulf1234", 0, 25000, "Engineer");
        userTest3.setRequestedRole("Magician");
        String newRole = userTest3.getRequestedRole();

        //get yes
        String input = "y";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertEquals("Failed to approve new role request - wrong input","y", adminTest.printRoleRequirementGetAnswer(userTest3, newRole));
        adminTest.deleteUser(userTest3.getUsername());
    }
    @Test
    public void printRoleRequirementGetAnswerNo(){
        User userTest3 = adminTest.createUser("ulf", "ulf1234", 0, 25000, "Engineer");
        userTest3.setRequestedRole("Janitor");
        String newRole = userTest3.getRequestedRole();

        //get no
        String input = "n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertEquals("Failed to dismiss new role request - wrong input","n", adminTest.printRoleRequirementGetAnswer(userTest3, newRole));
        adminTest.deleteUser(userTest3.getUsername());
    }

    @Test
    public void testApproveSalary(){
        User userTest3 = adminTest.createUser("ulf", "ulf1234", 0, 25000, "Engineer");
        userTest3.setRequestedSalary(30000);
        int newSalary = userTest3.getRequestedSalary();

        assertEquals("Failed approve salary request","ulf's salary has been updated!", adminTest.approveDismissSalary(userTest3,newSalary,"y"));
        adminTest.deleteUser(userTest3.getUsername());
    }
    @Test
    public void testDismissSalary(){
        User userTest3 = adminTest.createUser("ulf", "ulf1234", 0, 25000, "Engineer");
        userTest3.setRequestedSalary(30000);
        int newSalary = userTest3.getRequestedSalary();

        assertEquals("Failed approve salary request","ulf's new salary not approved!", adminTest.approveDismissSalary(userTest3,newSalary,"n"));
        adminTest.deleteUser(userTest3.getUsername());
    }
    @Test
    public void testApproveRole(){
        User userTest3 = adminTest.createUser("ulf", "ulf1234", 0, 25000, "Engineer");
        userTest3.setRequestedRole("Janitor");
        String newRole = userTest3.getRequestedRole();

        assertEquals("Failed to approve role request","ulf's role has been updated!", adminTest.approveDismissRole(userTest3,newRole,"y"));
        adminTest.deleteUser(userTest3.getUsername());
    }
    @Test
    public void testDismissRole(){
        User userTest3 = adminTest.createUser("ulf", "ulf1234", 0, 25000, "Engineer");
        userTest3.setRequestedRole("Magician");
        String newRole = userTest3.getRequestedRole();

        assertEquals("Failed to dismiss role request","ulf's new role not approved!", adminTest.approveDismissRole(userTest3,newRole,"n"));
        adminTest.deleteUser(userTest3.getUsername());
    }

    @Test
    public void getAllRequests(){
        User userTest2 = adminTest.createUser("ulf", "ulf1234", 0, 25000, "Engineer");
        userTest2.setRequestedSalary(35000);
        userTest2.setRequestedRole("Project Manager");
        assertEquals(2, adminTest.getAllRequests().size());
        adminTest.deleteUser(userTest2.getUsername());
    }

}
