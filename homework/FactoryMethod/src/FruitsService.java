public class FruitsService {
    public static void main(String[] args)
    {
        FruitsFactory fruitsFactory = new FruitsFactory();
        Fruits fruits = fruitsFactory.chooseFruit("Melon");
        fruits.fruitEaten();
    }
}
//test