package com.github.orionlibs.project_name;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.github.orionlibs.project_name.config.ConfigurationService;
import com.github.orionlibs.project_name.config.FakeTestingSpringConfiguration;
import com.github.orionlibs.project_name.config.MockController;
import com.github.orionlibs.project_name.log.ListLogHandler;
import java.io.IOException;
import java.util.logging.LogManager;
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
    private ListLogHandler listLogHandler;
    private MockMvc mockMvc;


    @BeforeEach
    void setUp()
    {
        try
        {
            listLogHandler = new ListLogHandler();
            LogManager.getLogManager().readConfiguration(NewClassTest.class.getResourceAsStream("/com/github/orionlibs/project-name/configuration/orion-project-name.prop"));
            NewClass.addLogHandler(listLogHandler);
            mockMvc = MockMvcBuilders
                            .standaloneSetup(new MockController())
                            .build();
        }
        catch(IOException e)
        {
            System.err.println("Could not setup logger configuration for Orion project-name: " + e.toString());
        }
    }


    @AfterEach
    public void teardown()
    {
        NewClass.removeLogHandler(listLogHandler);
    }


    @Test
    void test_method1() throws Exception
    {
        ConfigurationService.updateProp("orionlibs.prop", "false");
        mockMvc.perform(get("/")).andExpect(status().isOk());
        assertTrue(listLogHandler.getLogRecords().stream()
                        .anyMatch(record -> record.getMessage().contains("IP: 127.0.0.1, URI: GET /")));
        ConfigurationService.updateProp("orionlibs.prop", "true");
    }
}
