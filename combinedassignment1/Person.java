package combinedassignment1;

public class Person implements  Comparable<Person>{
    String mName;
    double mWeight;
    double mheight;
    double mBmi;
    String mRemark;

    public Person(String mName,double mWeight,double mheight,double mBmi,String mRemark){
        this.mName=mName;
        this.mWeight=mWeight;
        this.mheight=mheight;
        this.mBmi=mBmi;
        this.mRemark=mRemark;
    }
    public String toString(){
        return this.mName+"      "+mBmi+"        "+mRemark;
    }
    public int compareTo(Person person){
        if(mBmi==person.mBmi)
            return 0;
        else if(mBmi>person.mBmi)
            return -1;
        else
            return 1;
    }
}
