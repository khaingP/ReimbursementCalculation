package model;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ReimbursementClaim {
    private  int  dailyAllowance = 15;
    private  double  carMileage = 0.3;
    private LocalDate tripDate;
    private List<String> receipts = new ArrayList<>();
    private Integer numOfDays;
    private Double distance;


    public ReimbursementClaim(int dailyAllowance, double carMileage, LocalDate tripDate, Integer numOfDays, Double distance) {
        setDailyAllowance(dailyAllowance);
        setCarMileage(carMileage);
//        addReceipts(receipt);
        setTripDate(tripDate);
        setNumOfDays(numOfDays);
        setDistance(distance);
    }
    public ReimbursementClaim(LocalDate tripDate, Integer numOfDays, Double distance) {
        setTripDate(tripDate);
        setNumOfDays(numOfDays);
        setDistance(distance);
    }

    public ReimbursementClaim(){

    }

    public int getDailyAllowance() {
        return dailyAllowance;
    }

    public void setDailyAllowance(int dailyAllowance) {
        if(dailyAllowance<0){
            throw new IllegalArgumentException("Daily Allowance can't be negative ");
        }
        this.dailyAllowance = dailyAllowance;
    }

    public double getCarMileage() {
        return carMileage;
    }

    public void setCarMileage(double carMileage) {
        if(carMileage<0){
            throw new IllegalArgumentException("car Mileage can't be negative ");
        }
        this.carMileage = carMileage;
    }

    public LocalDate getTripDate() {
        return tripDate;
    }

    public void setTripDate(LocalDate tripDate) {
        if(tripDate.isAfter(LocalDate.now())){
            throw new IllegalArgumentException("trip date can't be in future");
        }
        this.tripDate = tripDate;
    }

    public List<String> getReceipts() {
        return receipts;
    }

    public void addReceipts(String receipt) {
        if (receipt == null || receipt.trim().equals("")) {
            throw new IllegalArgumentException("receipt cannot be empty");
        }
        this.receipts.add(receipt);
    }
    public void removeReceipts(String  receipt) {
        if (receipts.size()<1) {
            throw new IllegalArgumentException("receipt cannot be empty");
        }
        this.receipts.remove(receipt);
    }

    public Integer getNumOfDays() {
        return numOfDays;
    }

    public void setNumOfDays(Integer numOfDays) {
        if(numOfDays<0){
            throw new IllegalArgumentException("Number of  days can't be negative ");
        }
        this.numOfDays = numOfDays;
    }


    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        if(distance<0){
            throw new IllegalArgumentException("distance can't be negative ");
        }
        this.distance = distance;
    }

    /**  While calculating sum , i didn't add receipts amount
     *  as I wasn't sure about the requirements.
     *  just adding receipts quality or  adding the values of the receipt
     *  and in my opinion just adding receipt quality doesn't make sense in total reimbursement amount
     *  as each receipt will have different cost
     *  That's why I decided to leave it like that */

    public double CalculateTotalAmount(int numOfDays,double distance){
        double total = 0;
        total = dailyAllowance*numOfDays + distance*carMileage;
        return total;
    }
}
