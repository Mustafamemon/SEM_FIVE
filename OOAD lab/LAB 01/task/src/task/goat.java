package task;

public class goat extends Animal{
	@Override
	public String getAnimalSound() {
		super.setAnimalSound("maaa");
		return super.getAnimalSound();
	}
}
