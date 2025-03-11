package co.simplon.atm.bankservice;

public class AccountInfoResponse {
    private final boolean isAvailable;
    private final boolean allowWithdraw;
    private final long balance;

    public AccountInfoResponse(boolean isAvailable, Boolean allowWithdraw, Long balance) {
        this.isAvailable = isAvailable;
        this.allowWithdraw = allowWithdraw;
        this.balance = balance;
    }

    public boolean bankAvailable() {
        return isAvailable;
    }

    public boolean getAllowWithdraw() {
        return allowWithdraw;
    }

    public long getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "AccountInfoResponse{" +
                "isAvailable=" + isAvailable +
                ", allowWithdraw=" + allowWithdraw +
                ", balance=" + balance +
                '}';
    }
}
