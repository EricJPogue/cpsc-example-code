// [[ Your header information here. ]]

class Person {
    private float height = 0; // in m
    private float weight = 0; // in kg

    // Setters
    protected void setHeight(float heightIn) {
        height = heightIn;
    }

    protected void setWeight(float weightIn) {
        weight = weightIn;
    }

    // Constructors
    Person() // Default Constructor
    {
        height = 0;
        weight = 0;
    }

    Person(float heightIn, float weightIn) {
        this(); // Must be the first line in a constructor.
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
        super.setHeight(heightIn * (float)0.025); // convert inchs to meters
    }

    public void setWeight(float weightIn) { 
        super.setWeight(weightIn * (float)0.45); // Convert lbs to kg
    }

    // Constructors
    EnglishPerson() {
        super(); // Must be the first line in a constructor.
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

        EnglishPerson myEnglishPerson = new EnglishPerson((6*12)+1 /*6'1"*/,200 /*lbs*/); 
        System.out.println(myEnglishPerson.CalcBMI());

        EnglishPerson anotherPerson = new EnglishPerson(80, 190);
        System.out.println(anotherPerson.CalcBMI());
    }
}
