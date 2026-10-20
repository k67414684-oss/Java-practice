public class class6 {
    public static void main(String[] args) {
        double num = 5.67;
        double number = Math.round(num);
        double numberUp = Math.ceil(num);
        double numberDown = Math.floor(num);

        System.out.println(number);
        System.out.println(numberUp);
        System.out.println(numberDown);
        System.out.println("==================================================");

        double negNum = -5.67;
        double negNumber = Math.round(negNum);
        double negNumberUp = Math.ceil(negNum);
        double negNumberDown = Math.floor(negNum);

        System.out.println(negNumber);
        System.out.println(negNumberUp);
        System.out.println(negNumberDown);


    }
}
