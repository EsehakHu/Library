package com.galvanize.tmo.paspringstarter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.galvanize.tmo.paspringstarter.controllers.LibraryController;
import com.galvanize.tmo.paspringstarter.model.Book;
import com.galvanize.tmo.paspringstarter.service.LibraryService;
import org.junit.jupiter.api.Test;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureMockMvc
class PaSpringStarterApplicationTests {

  @InjectMocks LibraryController controller;

  @Autowired MockMvc mockMvc;

  @Mock LibraryService mockService;

  @Test
  void contextLoads() {}

  @Test
  void isHealthy() throws Exception {
    mockMvc.perform(get("/api/books/health")).andExpect(status().isOk());
  }

  @Test
  void testAddBook() throws Exception {
    Book book = new Book(1l, "test", "test", 1934);
    MockHttpServletRequest request = new MockHttpServletRequest();
    RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
    when(mockService.saveBook(any(Book.class))).thenReturn(book);
    //mockMvc.perform(post("/api/books/")).andExpect(status().isOk());
    mockMvc
        .perform(
            MockMvcRequestBuilders.post("/api/books/")
                .content(asJsonString(new Book(1l, "test", "test", 1934)))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isCreated())
        .andExpect(MockMvcResultMatchers.jsonPath("$.id").exists());
  }

  public static String asJsonString(final Object obj) {
    try {
      return new ObjectMapper().writeValueAsString(obj);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}
