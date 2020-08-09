package com.example.test.data;

public class Experience {

    public String job;
    public String title;
    public String start_date;
    public String end_date;
    public String city;

    public Experience(String job,String title,String start_date,String end_date,String city) {

        this.job=job;
        this.title=title;
        this.start_date=start_date;
        this.end_date=end_date;
        this.city=city;
    }

    public String getjob(){return job;}

    public String getTitle(){return title;}

    public String getStart_date(){return start_date;}

    public String getEnd_date(){return end_date;}

    public String getCity(){return city;}

}
