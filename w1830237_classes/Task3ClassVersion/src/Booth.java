public class Booth 
{
    public Patient patient;
    public String vaccination;

    public Booth(Patient patientParam, String vaccine) 
    {
        vaccination = vaccine;
        patient = patientParam;
    }

    public void setPatientDetails(String fname, String sname, int ageOfPatient, String cityOfPatient, String nicPassport, String vaccine) 
    {
        patient.firstName = fname;
        patient.surName = sname;
        patient.age=ageOfPatient;
        patient.city=cityOfPatient;
        patient.passportOrNicNumber=nicPassport;
        patient.vaccineRequested=vaccine;
    }

    public String getFirstName()
    {
        return patient.firstName;
    }


    public String getPatientName() 
    {
        return patient.firstName+" "+patient.surName;
    }

    public String getVaccineType() 
    {
        return vaccination;
    }

}
