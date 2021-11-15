package com.db.assignment.assignment;

import com.db.assignment.assignment.exception.NaceNotFoundException;
import com.db.assignment.assignment.repository.FileUploadRepository;
import com.db.assignment.assignment.service.FileUploadServiceImpl;
import com.db.assignment.assignment.vo.OrderVO;
import lombok.SneakyThrows;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.util.AssertionErrors;
import org.springframework.web.bind.annotation.ExceptionHandler;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
class AssignmentApplicationTests {

	@Test
	void contextLoads() {
	}
	@Mock
	private FileUploadServiceImpl fileUploadService;
	@MockBean
	private FileUploadRepository fileUploadRepositoryMock;


	@Test
	void whenCallingGetNaceDetails_thenReturnNaceExc() throws NaceNotFoundException {

			Mockito.when(fileUploadService.fetchNaceDetails(398482L))
					.thenThrow(new NaceNotFoundException("Record Not found"));

	}
	@Test
	void whenCallingGetNaceDetails_thenReturnNace() throws NaceNotFoundException {

		Mockito.when(fileUploadService.fetchNaceDetails(398481L))
				.thenReturn(new OrderVO());

	}



}
