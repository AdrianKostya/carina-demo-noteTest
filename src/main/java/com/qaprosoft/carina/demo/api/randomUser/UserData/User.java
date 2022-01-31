package com.qaprosoft.carina.demo.api.randomUser.UserData;

public class User {
        private String first;
        private String last;
        private String gender;
        private String id;
        private String middleName;

        public User(String first, String last,String gender, String id){
                this.first=first;
                this.last=last;
                this.gender=gender;
                this.id=id;
        }

        public User(String first, String last,String middle){
                this.first=first;
                this.last=last;
                this.middleName=middle;
        }

        public User(String first, String last){
                this.first=first;
                this.last=last;
        }

        public String getMiddleName() {
                return middleName;
        }

        public void setMiddleName(String middleName) {
                this.middleName = middleName;
        }

        public User(){

        }

        public void setFirst(String first) {
                this.first = first;
        }

        public void setLast(String last) {
                this.last = last;
        }

        public void setGender(String gender){
                this.gender=gender;
        }

        public void setId(String id){
                this.id=id;
        }

        public String getFirst(){
                return first;
        }

        public String getLast(){
            return last;
        }

        public String getGender(){
                return this.gender;
        }

        public String getId(){
                return id;
        }

        @Override
        public String toString() {
                return "User{" +
                        "first='" + first + '\'' +
                        ", last='" + last + '\'' +
                        ", gender='" + gender + '\'' +
                        ", id='" + id + '\'' +
                        '}';
        }
}
