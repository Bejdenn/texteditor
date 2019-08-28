package src;

public class StartButton extends DefaultButton {

	private CustomTimeline repeater;

	public StartButton(WindowPanel b) {
		super("START");
		repeater = new CustomTimeline();
		this.setOnAction(e -> {
			switch (this.getText()) {
			case "START":
				try {
					b.saveInput();
					this.setText("STOP");
					b.setRestricted(true);
					repeater.createTimeLine();
				} catch (NumberFormatException ex) {
					WindowPanel.writeToConsole("Only digits are allowed for input!");
					new java.util.Timer().schedule(new java.util.TimerTask() {
						@Override
						public void run() {
							WindowPanel.writeToConsole("");
						}
					}, 5000);
					return;
				}
				break;
			case "STOP":
				this.setText("START");
				b.setRestricted(false);
				repeater.stop();
				break;
			}
		});
	}

	public CustomTimeline getTimeline() {
		return repeater;
	}
}
