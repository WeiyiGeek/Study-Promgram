//���� DogFactor.java
class DogFactory implements Factory1 {
	@Override
	public Animal createAnimal() {
		return new Dog();
	}
}

//è�� CatFactor.java
class CatFactory implements Factory1  {
	@Override
	public Animal createAnimal() {
		return new Cat();
	}
}
