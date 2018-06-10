/*
import api.Application;
import api.controller.MainController;
import api.entity.User;
import api.repository.UserRepository;
import api.service.impl.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;


@RunWith(SpringRunner.class)
@ContextConfiguration(classes = Application.class)
@SpringBootTest

public class MainControllerTest {


    @Mock
    private UserRepository mockRepo;

    @InjectMocks
    private UserServiceImpl userService;


    @Test
    public void testIndexPage() throws Exception {

        MainController controller = new MainController(userService);
        MockMvc mockMvc = standaloneSetup(controller).build();

        mockMvc.perform(get("/")).andExpect(view().name("index"));
    }

    @Test
    public void testProfilePage() throws Exception {
        MainController controller = new MainController(userService);
        MockMvc mockMvc = standaloneSetup(controller).build();

        mockMvc.perform(get("/profile")).andExpect(view().name("profile"));

    }

    @Test
    public void testRegistrationPage() throws Exception {
        MainController controller = new MainController(userService);
        MockMvc mockMvc = standaloneSetup(controller).build();

        mockMvc.perform(get("/register")).andExpect(view().name("registerForm"));

    }

    @Test
    public void shouldProcessRegistration() throws Exception {

        User unsaved = new User();
        unsaved.setFirstName("Test");
        unsaved.setLastName("Test");
        unsaved.setEmail("test1@test.com");
        unsaved.setEnabled(true);
        unsaved.setPassword("123456");
        unsaved.setPhone("+7921");


        User saved = new User();
        saved.setId(24L);
        unsaved.setFirstName("Test");
        unsaved.setLastName("Test");
        saved.setEmail("test1@test.com");
        saved.setEnabled(true);
        saved.setPassword("123456");
        saved.setPhone("+7921");

        when(mockRepo.save(unsaved)).thenReturn(saved);

        MainController controller = new MainController(userService);

        MockMvc mockMvc = standaloneSetup(controller).build();

        mockMvc.perform(post("/register")

                .param("password", "123456")
                .param("phone", "+7921")
                .param("email", "test1@test.com"))
                .andExpect(redirectedUrl("/"));


        verify(mockRepo, atLeastOnce()).save(unsaved);
    }


}

*/
