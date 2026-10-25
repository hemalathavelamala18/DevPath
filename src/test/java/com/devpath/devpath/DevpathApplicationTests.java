
package com.devpath.devpath;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@SpringBootTest
@AutoConfigureMockMvc
class DevpathApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void contextLoads() {
    }

    @Test
    void homepageLoads() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(content().string(
                        org.hamcrest.Matchers.containsString("DevPath")));
    }

    @Test
    void coursesPageShowsAllCourses() throws Exception {
        mockMvc.perform(get("/courses"))
                .andExpect(status().isOk())
                .andExpect(content().string(
                        org.hamcrest.Matchers.containsString("Java Programming")))
                .andExpect(content().string(
                        org.hamcrest.Matchers.containsString("Python Programming")))
                .andExpect(content().string(
                        org.hamcrest.Matchers.containsString("Web Development")));
    }

    @Test
    void practicePageLoadsQuestions() throws Exception {
        mockMvc.perform(get("/practice"))
                .andExpect(status().isOk())
                .andExpect(content().string(
                        org.hamcrest.Matchers.containsString("Check Answer")));
    }

    @Test
    void correctPracticeAnswerShowsSuccess() throws Exception {
        mockMvc.perform(get("/practice/check").param("answer", "5"))
                .andExpect(status().isOk())
                .andExpect(content().string(
                        org.hamcrest.Matchers.containsString("Correct!")));
    }

    @Test
    void incorrectPracticeAnswerShowsRetryMessage() throws Exception {
        mockMvc.perform(get("/practice/check").param("answer", "4"))
                .andExpect(status().isOk())
                .andExpect(content().string(
                        org.hamcrest.Matchers.containsString("Not quite")));
    }

    @Test
    void placementsPageLoads() throws Exception {
        mockMvc.perform(get("/placements"))
                .andExpect(status().isOk())
                .andExpect(content().string(
                        org.hamcrest.Matchers.containsString("Placement Preparation Centre")));
    }

    @Test
    void roadmapPageLoads() throws Exception {
        mockMvc.perform(get("/roadmap"))
                .andExpect(status().isOk())
                .andExpect(content().string(
                        org.hamcrest.Matchers.containsString("Your Learning Roadmap")));
    }
}
