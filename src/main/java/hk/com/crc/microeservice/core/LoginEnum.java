package hk.com.crc.microeservice.core;


public enum  LoginEnum {

    ADMIN("1"),CUSTOMER("2"),TOKEN("3");

    private String type;

    private LoginEnum(String type){
        this.type = type;
    }

    @Override
    public  String toString(){
        return this.type.toString();
    }
}
