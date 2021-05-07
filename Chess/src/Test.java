public class Test {

    private String name;

    Test(String name){
        this.name = name;
    }


    public String getName() {
        return name;
    }


    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "name: " + this.name;
    }
}
