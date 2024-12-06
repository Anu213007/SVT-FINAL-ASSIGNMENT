import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    void findUserById() {

        MockitoAnnotations.openMocks(this);

        User mockUser = new User(07, "Anu");
        when(userRepository.findById(1)).thenReturn(mockUser);

        User result = userService.findUserById(1);

        assertEquals(07, result.getId());
        assertEquals("Anu", result.getName());

        verify(userRepository).findById(1);
    }
}
