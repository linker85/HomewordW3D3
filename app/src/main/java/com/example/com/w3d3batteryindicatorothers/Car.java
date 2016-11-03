package com.example.com.w3d3batteryindicatorothers;

/**
 * Created by raul on 02/11/2016.
 */

public class Car {
    private String brand;
    private String licencePlate;

    public Car(MyBuilder myBuilder) {
        this.brand         = myBuilder.brand;
        this.licencePlate  = myBuilder.licencePlate;
    }

    public static class MyBuilder {
        private String brand;
        private String licencePlate;

        public MyBuilder setBrand(String brand) {
            this.brand = brand;
            return this;
        }

        public MyBuilder setLicencePlate(String licencePlate) {
            this.licencePlate = licencePlate;
            return this;
        }

        public Car build() {
            return new Car(this);
        }

    }

}
