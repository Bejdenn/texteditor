package src;

public class EditButton extends FuncButton {

	private String function;

	public EditButton(String text) {
		super(text);
		this.setOnAction(e -> {
			switch (function) {
//			case "+":
//				StartButton.getTimeline().increase();
//				break;
//			case "-":
//				StartButton.getTimeline().decrease();
//				break;
//			case ">":
//				CBackground.getColorControl().increment();
//				break;
//			case "<":
//				CBackground.getColorControl().decrement();
//				break;

			}
		});
	}
}
