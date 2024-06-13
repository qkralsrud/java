package ex001;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.ex001.config.MvcConfiguration;
import com.spring.ex001.dto.BookDTO;
import com.spring.ex001.dto.CriteriaDTO;
import com.spring.ex001.dto.MemberDTO;
import com.spring.ex001.dto.PageDto;
import com.spring.ex001.mapper.BookMapper;
import com.spring.ex001.mapper.MemberMapper;
import com.spring.ex001.service.BookService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = MvcConfiguration.class)
public class BookMapperTest {
	@Autowired
	BookService service;
	
	@Autowired
	BookMapper mapper;
	
	@Test
	public void testService() {
		Map<String, Object> map = service.getBookList(new CriteriaDTO());
		List<BookDTO> list = (List<BookDTO>)map.get("list");
		PageDto pageDto = (PageDto)map.get("pageDto");
		System.out.println(list);
		System.out.println(pageDto);
	}
	
	@Test
	public void getTotalCnt() {
		int cnt = mapper.getTotalCnt1(new CriteriaDTO());
		System.out.println(cnt);
		assertEquals(1088, cnt);
	}
	
	@Test
	public void getBookList() {
		List<BookDTO> list =  mapper.getBookList(new CriteriaDTO());
		System.out.println(list);
		assertNotNull(list);
		
	}
	
	@Test
	public void select() {
		String sysdate = mapper.select();
		System.out.println(sysdate);
		
		LocalDate now = LocalDate.now();
		System.out.println(now.toString());
		System.out.println( sysdate.substring(0,11) );
		//assertNotNull(sysdate);
		
		// 실행결과와 예상값이 일치 하는지 확인
		assertEquals(sysdate.substring(0,11), sysdate.substring(0,11).toString());
	}
}


















