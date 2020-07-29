/*
 *  This class to hold rooms' datas. It has rooms' features like type of room,
 *  price, bed numbers, if it has view or not, if it is empty, if it got booked and got checked in.
 *  And it includes these data member's getters and setters and a toString method.
 *
 */

public class Room {
    protected int type, price, roomNo, bedNum;
    protected String name;
    protected boolean isEmpty, view, checkIn, isBooked;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(int roomNo) {
        this.roomNo = roomNo;
    }

    public boolean isCheckIn() {
        return checkIn;
    }

    public void setCheckIn(boolean checkIn) {
        this.checkIn = checkIn;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public void setBooked(boolean booked) {
        isBooked = booked;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getBedNum() {
        return bedNum;
    }

    public void setBedNum(int bedNum) {
        this.bedNum = bedNum;
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    public void setEmpty(boolean empty) {
        isEmpty = empty;
    }

    public boolean isView() {
        return view;
    }

    public void setView(boolean view) {
        this.view = view;
    }

    public String toString(){
        return String.format("%d,%d,%d,%d,%b,%b,%b,%s,%b\n", roomNo, type, bedNum, price, view,isEmpty,isBooked,name,checkIn);
    }
}
