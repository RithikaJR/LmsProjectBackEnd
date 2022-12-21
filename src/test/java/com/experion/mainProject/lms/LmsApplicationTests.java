package com.experion.mainProject.lms;

import com.experion.mainProject.lms.dao.CourseCategoryRepository;
import com.experion.mainProject.lms.entity.CourseCategory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LmsApplicationTests {

	@Autowired
	 CourseCategoryRepository courseCategoryRepository;

	@Test
	void contextLoads() {
	}

//	@Test
//	void testCreate(){
//		CourseCategory category=new CourseCategory();
//		category.setCategoryId(100L);
//		category.setCategoryName("TestEntryCategory");
//
//		assert (courseCategoryRepository.existsById("Tst101"));
//	}

}
