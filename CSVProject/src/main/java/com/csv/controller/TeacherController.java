package com.csv.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import com.csv.entity.Teacher;
import com.csv.repository.TeacherRepository;

@RestController
@RequestMapping("/teacher")
public class TeacherController {
	
	@Autowired
	TeacherRepository tr;
	
	@PostMapping
	public void saveTeacher(@RequestBody Teacher teacher) {
		 tr.save(teacher);
	}
	
	
	@GetMapping("/csvteacher")
	public void exportToCsv(HttpServletResponse httpservletResponse) throws IOException {
		httpservletResponse.setContentType("text/csv");
		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=teacher.csv";
		httpservletResponse.setHeader(headerKey, headerValue);
		List<Teacher > list = tr.findAll();
		
		String[] csvheader = {"teacher id","teacher name"," teacher adress","teacher age"};
		String[] nameMapping = {"id","name","adrress","age"};
		
		ICsvBeanWriter csvBeanWriter = new CsvBeanWriter(httpservletResponse.getWriter(), CsvPreference.STANDARD_PREFERENCE);
		csvBeanWriter.writeHeader(csvheader);
		for (Teacher t : list) {
			csvBeanWriter.write(t, nameMapping);
		}
		csvBeanWriter.close();
	
	}

}
