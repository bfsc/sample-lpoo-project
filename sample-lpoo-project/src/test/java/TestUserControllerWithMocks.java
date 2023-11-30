import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.edu.ifpe.paulista.sample.business.BusinessException;
import br.edu.ifpe.paulista.sample.business.UserController;
import br.edu.ifpe.paulista.sample.data.Repository;

@ExtendWith(MockitoExtension.class)
public class TestUserControllerWithMocks {

	// TODO FAZER TESTE DE INDISPONIBILIDADE NO BD <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
	
	@Test
	public void testCreateUserSuccess(@Mock Repository repositoryMock) {
		UserController controller = new UserController();
		controller.setRepository(repositoryMock);
		
		controller.createUser("test", "12345678", "12345678");
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
	public void testCreateUserFailExistentUser(@Mock Repository repositoryMock) {
		when(repositoryMock.hasUser("test")).thenReturn(true);
		
		UserController controller = new UserController();
		controller.setRepository(repositoryMock);
		
		Assertions.assertThrows(BusinessException.class, 
				() -> {controller.createUser("test", "12345678", "12345678");});
		
	}
	
}
