package codingon.spring_boot_default.dto_vo;

import java.util.Objects;

public final class AddressVO {
    private final String city;
    private final String street;
    private final int zipcode;

    public AddressVO(String city, String street, int zipcode) {
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }

    public String getCity() {
        return city;
    }
    public String getStreet() {
        return street;
    }
    public int getZipcode() {
        return zipcode;
    }

    @Override
    public String toString() {
        return city + ", street " + street + "(" + zipcode + ')';
    }

    @Override
    public boolean equals(Object obj) {
        if (this==obj) return true;

        if (obj==null || this.getClass() != obj.getClass()) return false;

        AddressVO vo = (AddressVO) obj;
        return city==vo.city && street==vo.street && zipcode==vo.zipcode;
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, street, zipcode);
    }
}

class AddressMain{
    public static void main(String[] args) {
        AddressVO vo1 = new AddressVO("Seoul","Gangnam-daero",06236);
        AddressVO vo2 = new AddressVO("Seoul","Gangnam-daero",06236);
        AddressVO vo3 = new AddressVO("Seoul","Mapo-daero",06452);

        System.out.println(vo1);
        System.out.println(vo2);
        System.out.println(vo1.equals(vo2)? "두 주소는 같습니다.\n" : "두 주소는 다릅니다.\n");
        System.out.println(vo1);
        System.out.println(vo3);
        System.out.println(vo1.equals(vo3)? "두 주소는 같습니다." : "두 주소는 다릅니다.");
    }
}
