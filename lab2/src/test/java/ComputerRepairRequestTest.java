import model.ComputerRepairRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ComputerRepairRequestTest {

    @Test
    @DisplayName("First test")
    public void testExample(){
        ComputerRepairRequest request = new ComputerRepairRequest(1, "John", "Str. Mihai Viteazu, nr. 1", "0740123456", "Lenovo", "2021-03-01", "The laptop doesn't start");
        assertEquals(1, request.getID());
        assertEquals("John", request.getOwnerName());
        assertEquals("Str. Mihai Viteazu, nr. 1", request.getOwnerAddress());
    }


    @Test
    @DisplayName("Second test")
    public void testExample2(){
        ComputerRepairRequest request = new ComputerRepairRequest(2, "Alice", "Str. Mihai Viteazu, nr. 2", "0740123457", "Dell", "2021-03-02", "The laptop is very slow");
        assertEquals("Alice", request.getOwnerName(), "Numele trebuie sa fie egale");
        assertEquals("Str. Mihai Viteazu, nr. 2", request.getOwnerAddress(), "Adresele trebuie sa fie egale");
    }

      
}
