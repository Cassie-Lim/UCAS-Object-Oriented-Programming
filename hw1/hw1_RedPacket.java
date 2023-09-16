import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RedPacket {

    public static List<Double> splitRedPacket(double totalAmount, int num) {
        List<Double> amounts = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < num - 1; i++) {
            // Keep last 2 digits
            double nextAmount = Math.round((random.nextDouble() * (totalAmount / (num - i))) * 100.0) / 100.0;
            totalAmount -= nextAmount;

            // Ensure every red packet has at least 0.01 yuan
            while (nextAmount < 0.01) {
                nextAmount = Math.round((random.nextDouble() * (totalAmount / (num - i))) * 100.0) / 100.0;
                totalAmount -= nextAmount;
            }
            
            amounts.add(nextAmount);
        }
        // Last one has all the remained money
        amounts.add(Math.round(totalAmount * 100.0) / 100.0);

        return amounts;
    }

    public static void main(String[] args) {
        List<Double> redPackets = splitRedPacket(100.00, 5);
        for (double amount : redPackets) {
            System.out.println(amount + " yuan");
        }
    }
}
