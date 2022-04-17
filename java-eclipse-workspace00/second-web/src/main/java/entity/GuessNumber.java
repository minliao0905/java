package entity;

import java.util.Random;

public class GuessNumber {
	public int number = 0;

	public int getNumber() {
		return this.number;
	}

	public void setNumber(int max) {
		Random random = new Random();
		this.number = random.nextInt(max) + 1;
	}

	public int Compare(int num) {

		if (num < this.number)
			return -1;
		else if (num > this.number) {
			return 1;
		}
		return 0;
	}

}
