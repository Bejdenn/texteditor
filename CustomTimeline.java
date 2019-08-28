package src;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.util.Duration;

public class CustomTimeline {

	private float duration;
	private Timeline repeater;

	public void play() {
	}

	public void stop() {
		repeater.stop();
	}

	public void createTimeLine() {
		repeater = new Timeline(new KeyFrame(Duration.seconds(duration), new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				ColorCycle.getRoot().run();
			}
		}));
		repeater.setCycleCount(Timeline.INDEFINITE);
		repeater.play();
	}

	public float getDuration() {
		return duration;
	}

	public void setDuration(float duration) {
		this.duration = duration;
	}
}
