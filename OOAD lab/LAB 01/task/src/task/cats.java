package task;

public class cats extends Animal {
	@Override
	public String getAnimalSound() {
		super.setAnimalSound("meow");
		return super.getAnimalSound();
	}
}
