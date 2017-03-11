import org.junit.Assert;
import org.junit.Test;

public class TestPodmassiva {
    @Test
    public void testEquals2Metoda() {
        int mass_n = 20;
        int skok_raz_test = 15;
        int max_random_cifra = 50;

        for (int prohod=0; prohod < skok_raz_test; prohod++) {
            int[] inpMass = new int[mass_n];
            for (int i=0; i<mass_n; i++)
                inpMass[i] = (int) ((Math.random() * (max_random_cifra*2)) - max_random_cifra);
            MyPodmassiv testoviy = new MyPodmassiv(inpMass);

            int [] otvetOtF1 = testoviy.recurrentSearch();
            int [] otvetOtF2 = testoviy.poiskVlob();

            Assert.assertArrayEquals(otvetOtF1, otvetOtF2);
        }
    }
}
