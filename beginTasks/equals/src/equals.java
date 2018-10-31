public class equals {
    public static void main(String[] args) {
        ComplexNumber complex = new ComplexNumber(4,8);
        ComplexNumber complex2 = new ComplexNumber(4,7);// создание конструктора
        System.out.println("верность этого утверждения: " + complex.equals(complex2));


    }
    public static class ComplexNumber {
        private final double re;
        private final double im;

        public ComplexNumber(double re, double im) {
            this.re = re;
            this.im = im;
        }

        public double getRe() {
            return re;
        }

        public double getIm() {
            return im;
        }


        public boolean equals(Object pau) {

            if (this == pau) {
                return true;
            }
            if (pau == null)
                return false;
            if (getClass() != pau.getClass()) // Методы getClass(), notify(), notifyAll(), wait() являются финальными и их нельзя переопределять.
                return false;
            ComplexNumber other = (ComplexNumber) pau; // тут приведение типа к объекту ComplexNumber
            if (getRe()!=other.re) { // сравниваем re из первого слагаемого со слагаемым из other
                return false;
            }
            if (getIm()!=other.im) {
                return false;
            }
            return true;



        }
        public int hashCode() { //http://www.seostella.com/ru/article/2012/10/04/kak-sgenerirovat-hashcode-v-java.html
            int result = 14;
            long longBits = Double.doubleToLongBits(re+im);
            result = 37 * result + (int)(longBits - (longBits >>> 32));
            return result;
        }
    }
}

