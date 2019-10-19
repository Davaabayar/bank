package edu.mum.cs.cs425.labs.bank.serviceimp;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import edu.mum.cs.cs425.labs.bank.serviceimp.AccountServiceImp;

@SpringBootTest
@RunWith(SpringRunner.class)
public class AccountServiceImpTest {
	
	@Autowired
	private AccountServiceImp accountService;

	@Before
	public void setUp() throws Exception {
	}

	@Test
    public void testComputeNetLiquidity() {
        Double actual = accountService.calcNetLiquidity();
        System.out.println(actual);
        Double expected = 197590.95;
        assertEquals(expected, actual, 0.10);
    }

}
