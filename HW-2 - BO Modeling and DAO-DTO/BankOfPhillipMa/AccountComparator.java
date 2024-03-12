package BankOfPhillipMa;

import java.util.Comparator;

public class AccountComparator implements Comparator<Account> {
    @Override
    public int compare(Account acct1, Account acct2) {
        // First compare creation dates
        int dateResult = acct1.getCreatedAt().compareTo(acct2.getCreatedAt());
        if (dateResult != 0) {
            return dateResult; // Creation date differs, prioritize by that
        }

        // If dates are the same, prioritize by balance (descending)
        return Double.compare(acct2.getBalance(), acct1.getBalance());
    }
}
