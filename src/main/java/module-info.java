module hellofx {
	exports impl.jfxtras.styles.jmetro;
	exports astropad;

	requires java.desktop;
	requires javafx.base;
	requires javafx.controls;
	requires transitive javafx.graphics;
	requires de.saxsys.mvvmfx;
}