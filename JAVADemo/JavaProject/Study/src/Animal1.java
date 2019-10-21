//π∑¿‡ DogFactor.java
class DogFactory implements Factory1 {
	@Override
	public Animal createAnimal() {
		return new Dog();
	}
}

//√®¿‡ CatFactor.java
class CatFactory implements Factory1  {
	@Override
	public Animal createAnimal() {
		return new Cat();
	}
}
