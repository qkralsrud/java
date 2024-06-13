package ex001;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.ex001.config.MvcConfiguration;
import com.spring.ex001.dto.MemberDTO;
import com.spring.ex001.mapper.MemberMapper;
import com.spring.ex001.service.MemberService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = MvcConfiguration.class)
public class MemberMapperTest {
	@Autowired
	MemberMapper mapper;
	
	@Autowired
	MemberService service;
	
	@Test
	public void memberLoginService() {
		MemberDTO dto = new MemberDTO();
		dto.setId("id");
		dto.setPw("pw");
		MemberDTO member = service.login(dto);
		assertEquals(dto.getId(), member.getId());
	}
	
	@Test
	public void memberLogin() {
		System.out.println(mapper);
		MemberDTO dto = new MemberDTO();
		dto.setId("i");
		dto.setPw("pw");
		MemberDTO member = mapper.login(dto);
		// 일치하는 회원이 없는경우 null을 반환
		System.out.println("member : " + member);
		System.out.println("로그인 사용자 : " + member.getId());
		assertEquals(dto.getId(), member.getId());
		
	}
}







