public class Restaurant {
    private String Id;
    private String name;
    private String phoneNumber;
    private Address address;
    private RestaurantMenu restaurantMenu;
    private int capacityPerHour;

    public Restaurant(String id, String name, String phoneNumber, Address address, int capacityPerHour) {
        Id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.capacityPerHour = capacityPerHour;
        restaurantMenu = new RestaurantMenu(id);
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public RestaurantMenu getRestaurantMenu() {
        return restaurantMenu;
    }

    public void setRestaurantMenu(RestaurantMenu restaurantMenu) {
        this.restaurantMenu = restaurantMenu;
    }

    public int getCapacityPerHour() {
        return capacityPerHour;
    }

    public void setCapacityPerHour(int capacityPerHour) {
        this.capacityPerHour = capacityPerHour;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "Id='" + Id + '\'' +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address=" + address +
                ", restaurantMenu=" + restaurantMenu +
                ", capacityPerHour=" + capacityPerHour +
                '}';
    }
}
