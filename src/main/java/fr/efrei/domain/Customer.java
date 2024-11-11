package fr.efrei.domain;

public class Customer {
    private String lastname;
    private String firstname;
    private int ID;
    private String email;

    @Override
    public String toString() {
        return "Customer{" +
                "lastname='" + lastname + '\'' +
                ", firstname='" + firstname + '\'' +
                ", ID=" + ID +
                ", email='" + email + '\'' +
                '}';
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private Customer(Builder builder) {
        this.firstname= builder.firstname;
        this.lastname= builder.lastname;
        this.ID= builder.ID;
        this.email= builder.email;
    }
    public static class Builder {
        private String lastname;
        private String firstname;
        private int ID;
        private String email;

        public Builder setLastname(String lastname) {
            this.lastname = lastname;
            return this;
        }

        public Builder setFirstname(String firstname) {
            this.firstname = firstname;
            return this;
        }

        public Builder setID(int ID) {
            this.ID = ID;
            return this;

        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Customer build() {
            return new Customer(this);
        }
    }
}
