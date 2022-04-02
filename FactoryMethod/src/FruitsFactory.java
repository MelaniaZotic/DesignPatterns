public class FruitsFactory {
    public Fruits chooseFruit(String choice)
    {
        if(choice == null || choice.isEmpty())
            return null;
        switch(choice)
        {
            case "Apple":
                return new Apple();
            case "Mango":
                return new Mango();
            case "Melon":
                return new Melon();
            default:
                throw new IllegalArgumentException("Unknown choice " + choice);
        }
    }
}
