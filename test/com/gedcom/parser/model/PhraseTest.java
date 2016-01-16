package com.gedcom.parser.model;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class PhraseTest {

	private Phrase phrase;

	@Test
	public void checkValidInput() throws Exception {
		// Checking the LEVEL TAG & VALUE
		String input = "1 NAME Elizabeth Alexandra Mary /Windsor/";
		phrase = new Phrase(input);
		assertEquals(phrase.getLevel(), 1);
		assertEquals(phrase.getTag(), "name");
		assertEquals(phrase.getValue(), "Elizabeth Alexandra Mary /Windsor/");
		assertEquals(phrase.getId(), null);

		// Checking the LEVEL ID & TAG
		input = "0 @I0001@ INDI";
		phrase = new Phrase(input);
		assertEquals(phrase.getLevel(), 0);
		assertEquals(phrase.getTag(), "indi");
		assertEquals(phrase.getId(), "@I0001@");
		assertEquals(phrase.getValue(), null);

		// Checking the LEVEL & TAG
		input = "1 CHAN";
		phrase = new Phrase(input);
		assertEquals(phrase.getLevel(), 1);
		assertEquals(phrase.getTag(), "chan");
		assertEquals(phrase.getId(), null);
		assertEquals(phrase.getValue(), null);

		// Checking the LEVEL TAG & VALUE
		input = "1 @CHAN XXXX";
		phrase = new Phrase(input);
		assertEquals(phrase.getLevel(), 1);
		assertEquals(phrase.getTag(), "@chan");
		assertEquals(phrase.getId(), null);
		assertEquals(phrase.getValue(), "XXXX");

		// Checking the LEVEL TAG & VALUE
		input = "1 @CHAN@X XXXX";
		phrase = new Phrase(input);
		assertEquals(phrase.getLevel(), 1);
		assertEquals(phrase.getTag(), "@chan@x");
		assertEquals(phrase.getId(), null);
		assertEquals(phrase.getValue(), "XXXX");
	}

	@Test(expected = Exception.class)
	public void checkInValidInputHavingNegativeLevelValue() throws Exception {
		// Checking the LEVEL TAG & VALUE
		String input = "-1 NAME Elizabeth Alexandra Mary /Windsor/";
		phrase = new Phrase(input);
	}

	@Test(expected = Exception.class)
	public void checkInValidInputHavingOnlyLevel() throws Exception {
		// Checking the LEVEL TAG & VALUE
		String input = "0";
		phrase = new Phrase(input);
	}

	@Test(expected = Exception.class)
	public void checkInValidInputHavingCharacterInLevel() throws Exception {
		// Checking the LEVEL TAG & VALUE
		String input = "S";
		phrase = new Phrase(input);
	}
}