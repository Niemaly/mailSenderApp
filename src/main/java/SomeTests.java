public class SomeTests {
    public static void main(String[] args) {

        Boolean a = null;

        SomeTests someTests = new SomeTests();
        someTests.getClass();

        try {

            if(a){

            }

        }catch (NullPointerException e){
            System.out.println("not on my watch monsterTrucker");
        }
    }
}
