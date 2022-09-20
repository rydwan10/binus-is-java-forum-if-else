import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

class Cart {
    private String itemName;
    private int quantity;
    private double price;

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Cart(String itemName, int quantity, double price) {
        this.itemName = itemName;
        this.quantity = quantity;
        this.price = price;
    }


}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isProgramRunning = true;
        List<Cart> customerCart = new ArrayList<>();
        while(isProgramRunning) {
            System.out.print("Nama Item : ");
            String namaItem = scanner.nextLine();
            System.out.print("Jumlah : ");
            int jumlahItem = Integer.parseInt(scanner.nextLine());
            System.out.print("Harga : ");
            double harga = Double.parseDouble(scanner.nextLine());

            customerCart.add(new Cart(namaItem, jumlahItem, harga));
            System.out.println("Jumlah item : " + customerCart.stream().count());
            System.out.println("Tambah lagi ? y/n");
            String userInput = scanner.nextLine();

            if(userInput.toLowerCase(Locale.ROOT).equals("n")) {
                double total = 0;
                System.out.println("Item Anda => ");
                for(Cart item : customerCart){
                    System.out.println("[" + item.getItemName() +"]" + " " + "Jumlah : " + item.getQuantity() + " | Harga : " + item.getPrice() + " | Total : " + item.getPrice() * item.getQuantity());
                    total += item.getPrice() * item.getQuantity();
                }

                System.out.println("Total Belanja Rp. " + total);
                if(total > 100_000) {
                    System.out.println("SELAMAT ANDA BERHAK MENDAPATKAN HADIAH!");
                }
                return;
            }
        }
    }

}

