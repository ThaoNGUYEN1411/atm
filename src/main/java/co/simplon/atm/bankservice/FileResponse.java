package co.simplon.atm.bankservice;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileResponse {
    private AccountInfoResponse accountInfoResponse;

    public FileResponse(String filePath) {
        loadFromFile(filePath);
    }

    private AccountInfoResponse loadFromFile(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            StringBuilder jsonContent = new StringBuilder();
            String line;

            // Read the JSON content
            while ((line = reader.readLine()) != null) {
                jsonContent.append(line);
            }

            // Remove extra characters and parse key-value pairs
            String json = jsonContent.toString().trim().replaceAll("[{}\"]", "");
            String[] pairs = json.split(",");

            boolean isAvailable = false;
            boolean allowWithDraw = false;
            long balance = 0;

            for (String pair : pairs) {
                String[] keyValue = pair.split(":");
                String key = keyValue[0].trim();
                String value = keyValue[1].trim();

                switch (key) {
                    case "isAvailable":
                        isAvailable = Boolean.parseBoolean(value);
                        break;
                    case "allowWithDraw":
                        allowWithDraw = Boolean.parseBoolean(value);
                        break;
                    case "balance":
                        balance = Long.parseLong(value);
                        break;
                }
            }

            // Create a BankResponse object
            AccountInfoResponse response = new AccountInfoResponse(isAvailable, allowWithDraw, balance);

            // Assign the response to the class field
            this.accountInfoResponse = response;

            return response;
        } catch (IOException e) {
            System.err.println("Error reading JSON file: " + e.getMessage());
        }
        return null;
    }

    public AccountInfoResponse getAccountInfoResponse() {
        return accountInfoResponse;
    }
}
