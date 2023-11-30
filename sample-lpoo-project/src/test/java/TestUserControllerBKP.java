import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import br.edu.ifpe.paulista.model.User;
import br.edu.ifpe.paulista.sample.business.BusinessException;
import br.edu.ifpe.paulista.sample.business.UserController;

public class TestUserControllerBKP {

	@Test
	public void testCreateUserSuccess() {
		UserController controller = new UserController();

		controller.createUser("test", "12345678", "12345678");

		User user = controller.searchUserByLogin("test");
		Assertions.assertNotNull(user);
		Assertions.assertEquals("test", user.getLogin());
		Assertions.assertEquals("12345678", user.getPassword());
		
		controller.deleteUser("test");
	}
	
	@Test
	public void testCreateUserFailEmptyLogin() {
		UserController controller = new UserController();
		Assertions.assertThrows(BusinessException.class, 
				() -> {controller.createUser("", "12345678", "12345678");});
	}
	
	@Test
	public void testCreateUserFailBlankLogin() {
		UserController controller = new UserController();
		Assertions.assertThrows(BusinessException.class, 
				() -> {controller.createUser("        ", "12345678", "12345678");});
	}
	
	@Test
	public void testCreateUserFailEmptyPassword() {
		UserController controller = new UserController();
		Assertions.assertThrows(BusinessException.class, 
				() -> {controller.createUser("test", "", "12345678");});
	}
	
	@Test
	public void testCreateUserFailPasswordMismatchConfirmation() {
		UserController controller = new UserController();
		Assertions.assertThrows(BusinessException.class, 
				() -> {controller.createUser("test", "12345678", "");});
	}

	@Test
	public void testCreateUserFailPasswordTooSmall() {
		UserController controller = new UserController();
		Assertions.assertThrows(BusinessException.class, 
				() -> {controller.createUser("test", "12345", "12345");});
	}
	
	@Test
	public void testCreateUserFailExistentUser() {
		UserController controller = new UserController();
		
		controller.createUser("test", "12345678", "12345678");
		
		Assertions.assertThrows(BusinessException.class, 
				() -> {controller.createUser("test", "12345678", "12345678");});
		
		controller.deleteUser("test");		
	}
	
}
