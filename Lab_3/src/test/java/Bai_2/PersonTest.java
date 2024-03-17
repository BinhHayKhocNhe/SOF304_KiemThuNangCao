package Bai_2;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class PersonTest {

	@Rule
	public ExpectedException exception = ExpectedException.none();

	@Test
	public void testPerson() {
		exception.expect(IllegalArgumentException.class);
//		exception.expectMessage("Invalid age: " + 19);
		Person person = new Person("PS32770", -19);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testPerson1() {
		new Person("PS32770", -17);
	}

	@Test
	public void testPerson2() {
		try {
			new Person("PS32770", 19);
			fail("Không bắt được ngoại lệ");
		} catch (IllegalArgumentException e) {
			System.out.println("Bắt được tình huống ngoại lệ");
		}
	}
}
