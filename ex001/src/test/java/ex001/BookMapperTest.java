package ex001;

import static org.junit.Assert.assertNotNull;

import java.time.LocalDate;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.ex001.config.MvcConfiguration;
import com.spring.ex001.dto.BookDTO;
import com.spring.ex001.mapper.BookMapper;

//테스
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = MvcConfiguration.class)
public class BookMapperTest {
	
	@Autowired
	BookMapper mapper;
	
	@Test
	public void getBookList() {
		List<BookDTO> list = mapper.getBookList();
		System.out.println(list);
		assertNotNull(list);
	}
	
	@Test
	public void select() {
		String sysdate = mapper.select();
		System.out.println(sysdate);
		
		LocalDate now = LocalDate.now();
		System.out.println(now.toString());
		sysdate.substring(0,11);
		assertNotNull(sysdate);
	}
}
