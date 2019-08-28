package src;

public class ColorControl {

	private int r, g, b;
	private int rFactor;
	private int gFactor;
	private int bFactor;

	void setRgb(String r, String g, String b) {
		this.r = Integer.parseInt(r);
		this.g = Integer.parseInt(g);
		this.b = Integer.parseInt(b);
	}

	void increaseColorValues() {
		if (r >= 255) {
			this.r = 0;
		}
		if (g >= 255) {
			this.g = 0;
		}
		if (b >= 255) {
			this.b = 0;
		}
		this.r += rFactor;
		this.g += gFactor;
		this.b += bFactor;
	}

	public int getR() {
		return r;
	}

	public int getG() {
		return g;
	}

	public int getB() {
		return b;
	}

	public int getrFactor() {
		return rFactor;
	}

	public void setrFactor(int rFactor) {
		this.rFactor = rFactor;
	}

	public int getgFactor() {
		return gFactor;
	}

	public void setgFactor(int gFactor) {
		this.gFactor = gFactor;
	}

	public int getbFactor() {
		return bFactor;
	}

	public void setbFactor(int bFactor) {
		this.bFactor = bFactor;
	}

}
