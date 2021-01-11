class Person {
    private float height; // in m
    private float weight; // in kg

    // Setters
    protected void setHeight(float heightIn) {
        height = heightIn;
    }

    protected void setWeight(float weightIn) {
        weight = weightIn;
    }   

    // Constructors
    Person() {
        height = 0;
        weight = 0;
    }

    Person(float heightIn, float weightIn) {
        this();
        setHeight(heightIn);
        setWeight(weightIn);
    }

    public float CalcBMI() {
        return weight / (height * height);
    }
}

class EnglishPerson extends Person {
    // Setters
    public void setHeight(float heightIn) {
        super.setHeight(heightIn * (float)0.025); // convert inches to meters
    }

    public void setWeight(float weightIn) {
        super.setWeight(weightIn * (float)0.45); // convert lbs to kg
    }

    // Constructors
    EnglishPerson() {
        super();
    }

    EnglishPerson(float heightIn, float weightIn) {
        setHeight(heightIn);
        setWeight(weightIn);
    }
}

public class BMICalcPlus {
    public static void main(String[] args) {
        System.out.println("Starting BMICalcPlus..."); 

        Person myPerson = new Person(2 /*m*/, 60 /*kg*/);
        System.out.println(myPerson.CalcBMI());

        EnglishPerson myEnglishPerson = new EnglishPerson(72 /*in*/, 200 /*lbs*/);
        System.out.println(myEnglishPerson.CalcBMI());

        EnglishPerson myEnglishPerson02 = new EnglishPerson(72 /*in*/, 180 /*lbs*/);
        System.out.println(myEnglishPerson02.CalcBMI());


    }
}