package goet;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.goet.helper.output.CsvOutputGenerator;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class AppTest {

	@Autowired
	CsvOutputGenerator csvOutputGenerator;
	
	@Test
	public void testCsvFileGeneration(){
		csvOutputGenerator.generateOutput("Berlin"); 
	}
}
