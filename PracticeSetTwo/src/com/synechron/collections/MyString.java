package com.synechron.collections;

final public class MyString {
	private char[] characters;
	private int length;
	private final int DEFAULT_SIZE = 5;

	public MyString() {
		length = DEFAULT_SIZE;
		characters = new char[length];
	}

	public MyString(char ch) {
		length = 1;
		characters = new char[length];
		characters[0] = ch;
	}

	public MyString(char ch[]) {
		length = ch.length;
		characters = new char[length];
		for (int i = 0; i < length; i++)
			characters[i] = ch[i];
	}

	/**
	 * Initializes a newly created MyString object so that it represents the same
	 * string as otherMyString.
	 */
	public MyString(MyString otherMyString) {
		length = otherMyString.myLength();
		characters = new char[length];
		for (int i = 0; i < length; i++)
			characters[i] = otherMyString.myCharAt(i);
	}

	public boolean equals(Object o) {
		MyString other;
		if (!(o instanceof MyString))
			return false;
		else
			other = (MyString) o;
		if (this.length != other.length)
			return false;

		int i = 0;
		while (i < this.length) {
			if (this.characters[i] != other.characters[i])
				return false;
			i++;
		}
		return true;
	}

	/**
	 * Returns the char at location index, where the first character is at location
	 * 0, etc. Throws MyStringIndexOutOfBoundsException exception
	 */
	public char myCharAt(int index) {
		// we may talk about exception handling later this semester
		if ((index < 0) || (index >= characters.length))
			throw new MyStringIndexOutOfBoundsException("invalid index");
		return characters[index];
	}

	/**
	 * Returns this MyString object if otherMyString is the empty string, and
	 * otherwise returns a new MyString which represents the concatenation of this
	 * string with the other string following it.
	 */
	public MyString myConcat(MyString otherMyString) {
		int length = this.characters.length + otherMyString.characters.length;

		char[] temp = new char[length];

		for (int i = 0; i < this.characters.length; i++)
			temp[i] = this.characters[i];

		for (int i = 0; i < otherMyString.characters.length; i++)
			temp[this.characters.length + i] = otherMyString.characters[i];

		return new MyString(temp);
	}

	/**
	 * Displays the sequence of char to the screen
	 */
	public void myLineDisplay() {
		for (int i = 0; i < this.characters.length; i++) {
			if (characters[i] == '\n') {
				break;
			} else {
				System.out.format("%c", characters[i]);
			}
		}
		System.out.println("");
	}

	/**
	 * returns -1 if ch does not occur in this string, and otherwise returns the
	 * smallest location of ch in this string
	 * 
	 */
	public int myIndexOf(char ch) {
		int fromIndex = 0;
		if (fromIndex < 0)
			fromIndex = 0;
		else if (fromIndex >= length)
			return -1;

		for (int i = fromIndex; i < length; i++)
			if (characters[i] == ch)
				return i;
		return -1;
	}

	/**
	 * Returns the length of this string.
	 */
	public int myLength() {
		return length;
	}

	/**
	 * Returns a new MyString representing the substring of this string from
	 * location low up through location high - 1. If (low == high) returns the empty
	 * string. Throws MyStringIndexOutOfBoundsException exception
	 */
	public MyString mySubString(int low, int high) {
		if (low < 0)
			throw new MyStringIndexOutOfBoundsException("low value invalid");
		if (high > length)
			throw new MyStringIndexOutOfBoundsException("high value invalid");
		if (low > high)
			throw new StringIndexOutOfBoundsException("check low and high value");

		MyString result = new MyString();
		result.length = high - low + 1;
		result.characters = new char[result.length];

		for (int i = 0; i < result.length; i++)
			result.characters[i] = this.characters[low + i];

		return result;
	}

	public static void main(String[] args) {

		String str = new String("abc");
		str.charAt(2);
		
		char[] test = { 'a', 'b', 'c', 'p', 'q' };
		MyString str1 = new MyString(test);
		str1.myLineDisplay();

		MyString str2 = new MyString('A');
		str2.myLineDisplay();

		// Calling MyCharAt()
		MyString str3 = new MyString(str2);
		System.out.println(str2.myCharAt(0));
		str2.myLineDisplay();
		System.out.println(str2.myLength());

		// Calling myConcat()
		str3 = str3.myConcat(str2);
		str3.myLineDisplay();
		System.out.println(str3.myLength());

		MyString substr = str1.mySubString(2, 4);
		substr.myLineDisplay();
	}
}



