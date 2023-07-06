package com.github.orionlibs.project_name;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.github.orionlibs.project_name.config.FakeTestingSpringConfiguration;
import com.github.orionlibs.project_name.config.MockController;
import com.github.orionlibs.project_name.NewClass;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ExtendWith(SpringExtension.class)
@ActiveProfiles("testing")
@ContextConfiguration(classes = FakeTestingSpringConfiguration.FakeConfiguration.class)
@WebAppConfiguration
@TestInstance(Lifecycle.PER_CLASS)
public class NewClassTest
{
    private MockMvc mockMvc;


    @BeforeEach
    void setUp()
    {
        NewClassTest.class.getResourceAsStream("/com/github/orionlibs/project-name/configuration/orion-library-name.prop");
        mockMvc = MockMvcBuilders
                        .standaloneSetup(new MockController())
                        .addInterceptors(new NewClass())
                        .build();
    }


    @AfterEach
    public void teardown()
    {

    }


    @Test
    void test_preHandle() throws Exception
    {
        mockMvc.perform(get("/")).andExpect(status().isOk());
        assertTrue(true);
    }
}
