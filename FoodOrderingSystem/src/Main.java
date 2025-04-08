//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        MenuItem menuItem = new MenuItem("Chicken Biryani", "Chicken Biryani description", 300.00, 100, "image", "Biryanis");
        MenuItem menuItem1 = new MenuItem("Mutton Biryani", "Chicken Biryani description", 300.00, 100, "image", "Biryanis");
        MenuItem menuItem2 = new MenuItem("Veg Biryani", "Chicken Biryani description", 300.00, 100, "image", "Biryanis");
        MenuItem menuItem3 = new MenuItem("Pizza", "Pizza description", 300.00, 100, "image", "Italian");
        MenuItem menuItem4 = new MenuItem("Pasta", "Pasta description", 300.00, 100, "image", "Italian");

        Address address = new Address("1", UserType.RESTAURANT, "Kalyan Nagar", "44.32", "77.32", "Bengaluru", "KA");

        Restaurant restaurant = new Restaurant("1", "Spicy Restaurant", "11234567899", address, 300);
        RestaurantMenu restaurantMenu = restaurant.getRestaurantMenu();

        RestaurantService restaurantService = new RestaurantService();
        restaurantService.addRestaurant(restaurant);
        restaurantService.addMenu(restaurant.getId(), menuItem);
        restaurantService.addMenu(restaurant.getId(), menuItem1);
        restaurantService.addMenu(restaurant.getId(), menuItem2);

        restaurantService.showRestaurants();
        restaurantService.showRestaurantMenu(restaurant.getId());
    }
}