package com.example.task3.model;

public class DataModel {
    private String[] names =
            {
                    "Sita Kumari", "Hari Bahadur", "Shyam Kumar",
                    "Sita Kumari", "Hari Bahadur", "Shyam Kumar",
                    "Sita Kumari", "Hari Bahadur", "Shyam Kumar",
                    "Sita Kumari", "Hari Bahadur", "Shyam Kumar",
                    "Sita Kumari", "Hari Bahadur", "Shyam Kumar",
            };
    private String[] address =
            {
                    "Kathmandu","Bhaktapur","Lalitpur",
                    "Kathmandu","Bhaktapur","Lalitpur",
                    "Kathmandu","Bhaktapur","Lalitpur",
                    "Kathmandu","Bhaktapur","Lalitpur",
                    "Kathmandu","Bhaktapur","Lalitpur"
            };
    private String[] faculty =
            {
                    "Kathmandu","Bhaktapur","Lalitpur",
                    "Kathmandu","Bhaktapur","Lalitpur",
                    "Kathmandu","Bhaktapur","Lalitpur",
                    "Kathmandu","Bhaktapur","Lalitpur",
                    "Kathmandu","Bhaktapur","Lalitpur"
            };
    private int[] semester =
            {
                  3,4,5,3,4,5,3,4,5,3,4,5,3,4,5
            };
    public String[] getNames() {
        return names;
    }

    public String[] getAddress() {
        return address;
    }
    public String[] getFaculty(){
        return faculty;
    }

    public int[] getSemester() {
        return semester;
    }
}
