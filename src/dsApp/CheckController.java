package dsApp;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class CheckController {

	private ArrayList<Integer> data;

	public CheckController() {
		data = new ArrayList<Integer>();
		for (int x = 0; x < 10; x++) {
			data.add(0);
		}
	}

	public CheckController(double sum) {
		data = new ArrayList<Integer>();
		for (int x = 0; x < 10; x++) {
			data.add(0);
		}
		this.calcChange(sum);
	}

	public ArrayList<Integer> getMoneyDenom() {
		return data;
	}

	public void calcChange(double sum) {
		data = getChangeK(sum, data);
	}

	private double roundTo2(double d) {
		DecimalFormat df = new DecimalFormat("#.##");
		df.setRoundingMode(RoundingMode.HALF_UP);

		return Double.parseDouble(df.format(d));
	}

	private ArrayList<Integer> getChangeK(Double sum, ArrayList<Integer> data) {

		if (sum < 0.01)
			return data;

		if (sum >= 100) {
			data.set(0, (int) (sum / 100));
			sum = roundTo2(sum % 100);
		} else if (sum >= 50) {
			data.set(1, (int) (sum / 50));
			sum = roundTo2(sum % 50);
		} else if (sum >= 20) {
			data.set(2, (int) (sum / 20));
			sum = roundTo2(sum % 20);
		} else if (sum >= 10) {
			data.set(3, (int) (sum / 10));
			sum = roundTo2(sum % 10);
		} else if (sum >= 5) {
			data.set(4, (int) (sum / 5));
			sum = roundTo2(sum % 5);
		} else if (sum >= 1) {
			data.set(5, (int) (sum / 1));
			sum = roundTo2(sum % 1);
		} else if (sum >= 0.25) {
			data.set(6, (int) (sum / 0.25));
			sum = roundTo2(sum % 0.25);
		} else if (sum >= 0.10) {
			data.set(7, (int) (sum / 0.10));
			sum = roundTo2(sum % 0.10);
		} else if (sum >= 0.05) {
			data.set(8, (int) (sum / 0.05));
			sum = roundTo2(sum % 0.05);
		} else if (sum >= 0.01) {
			data.set(9, (int) (sum / 0.01));
			sum = sum % 0.01;
		}
		return getChangeK(sum, data);
	}
}
