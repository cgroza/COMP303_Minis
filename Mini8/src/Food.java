public class Food {


    private String name;
    private int carbs;
    private int fat;
    private int protein;

    public Food(String name, int carbs, int fat, int prot) {
        this.name = name;
        this.carbs = carbs;
        this.fat = fat;
        this.protein = prot;

    }


    public String getName() {
        return name;
    }

    public int getCarbs() {
        return carbs;
    }

    public int getFat() {
        return fat;
    }

    public int getProtein() {
        return protein;
    }


}
