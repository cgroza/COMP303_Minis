public class Food
{
    private String foodName;
    private int carbAmount;
    private int fatAmount;
    private int proteinAmount;

    public Food(String name, int carb, int fat, int protein)
    {
        foodName = name;
        carbAmount = carb;
        fatAmount = fat;
        proteinAmount = protein;
    }

    public String getName() { return foodName; }
    public int getCarbs() { return carbAmount; }
    public int getFat() { return fatAmount; }
    public int getProteins() { return proteinAmount; }
}
