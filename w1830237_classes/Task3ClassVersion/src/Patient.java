public class Patient 
{
    public String firstName;
    public String surName;
    public  int age;
    public String city;
    public  String passportOrNicNumber;
    public  String vaccineRequested;

    public Patient(String fname, String sname, int ageOfPatient, String cityOfPatient, String passportNicNumber,
            String vaccine) 
    {
        firstName = fname;
        surName = sname;
        age = ageOfPatient;
        city = cityOfPatient;
        passportOrNicNumber = passportNicNumber;
        vaccineRequested = vaccine;
    }

    public  String getFirstName() 
    {
        return firstName;
    }

    public  String getSurName() 
    {
        return surName;
    }

    public  int getAge() 
    {
        return age;
    }

    public  String getCity() 
    {
        return city;
    }

    public  String getNICOrPassportNumber() 
    {
        return passportOrNicNumber;
    }

    public  String getVaccineRequested() 
    {
        return vaccineRequested;
    }

}
