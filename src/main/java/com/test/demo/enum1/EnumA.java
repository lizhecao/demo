package com.test.demo.enum1;

public enum  EnumA implements EnumInterface {
    A(1, "hehe");


    int code;
    String address;

    EnumA(int code, String address) {
        this.code = code;
        this.address = address;
    }

    @Override
    public int code() {
        return 0;
    }

    @Override
    public String address() {
        return null;
    }
}
