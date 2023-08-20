import static org.junit.Assert.*;

import model.ReimbursementClaim;
import org.junit.Test;
public class ClaimTest {
    @Test
    public void testCalculateTotalAmount() {
        ReimbursementClaim claim = new ReimbursementClaim();
        claim.setNumOfDays(1);
        claim.setDistance(1.0);
        double expectedTotalAmount =15.3 ;
        double actualTotalAmount = claim.CalculateTotalAmount(claim.getNumOfDays(), claim.getDistance());
        assertEquals(expectedTotalAmount, actualTotalAmount, 0.001);
    }

    @Test
    public void  testEditReceipt(){
        ReimbursementClaim claim = new ReimbursementClaim();
        claim.addReceipts("taxi");
        claim.addReceipts("book");
        assertEquals(2,claim.getReceipts().size());
        claim.removeReceipts("taxi");
        assertEquals(1,claim.getReceipts().size());
    }

    @Test
    public void testUpdateDailyAllowance(){
        ReimbursementClaim claim = new ReimbursementClaim();
        claim.setDailyAllowance(23);
        assertEquals(23,claim.getDailyAllowance());
    }

}
