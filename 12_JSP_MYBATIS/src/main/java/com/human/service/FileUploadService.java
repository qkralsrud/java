package com.human.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.human.dao.MyfileDAO;
import com.human.dto.MyFileDTO;

public class FileUploadService {

	MyfileDAO dao = new MyfileDAO();
	
	public Map<String, String> insertMyfile(MyFileDTO dto) {
		int res = dao.insertMyfile(dto);
		Map<String, String> map = new HashMap<String, String>();
		
		if(res>0) {
			map.put("res", "ok");
			map.put("msg", res + "건 입력 되었습니다.");
		} else {
			map.put("msg", "입력중 예외가 발생 하였습니다. 관리자에게 문의해주세요.");
		}
		
		return map;
	}

	public Map<String, Object> getList() {
		Map<String, Object> map = new HashMap<String, Object>();
		
		List<MyFileDTO> list = dao.getList();
		map.put("list", list);
		// PageDto pageDto = new PageDto(0, 0, 0);
		return map;
	}

}
